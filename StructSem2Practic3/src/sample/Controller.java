package sample;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.chart.LineChart;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private Button btn;
    @FXML
    private DatePicker datepickerstart, datepickerend;
    @FXML
    private LineChart LineChart;
    @FXML
    private ComboBox stepsComboBox;

    @FXML
    public void onClickMethod(){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date_up = datepickerend.getValue().format(formatters);
        String date_down = datepickerstart.getValue().format(formatters);
        String url = "https://api.meteostat.net/v1/history/daily?station=27612&start="+date_down.toString()+"&end="+date_up.toString()+"&key=L23FNnUI";

        Weather data = GetWeather(url);
        System.out.println(data.meta.source);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Данные");
        int steps = 1;
        switch (stepsComboBox.getSelectionModel().getSelectedItem().toString()){
            case "День":
                steps = 1;
                break;
            case "Неделя":
                steps = 7;
                break;
            case "Месяц":
                steps = 30;
                break;
            case "Год":
                steps = 365;
                break;
            default:
                steps = 1;
                break;
        }
        for(int i = 0; i < data.data.size(); i+=steps){
            String date = data.data.get(i).date;
            Float temperature = data.data.get(i).temperature;
            if( date != null && temperature != null)
                series1.getData().add(new XYChart.Data(date, temperature));
        }

        LineChart.getData().addAll(series1);
    }

    @FXML
    public void onClearButton(){
        LineChart.getData().clear();
    }

    @FXML
    public void ShownComboBox(){
        ObservableList<String> steps = FXCollections.observableArrayList(
                "День",
                "Неделя",
                "Месяц",
                "Год"
        );
        stepsComboBox.setItems(steps);
    }

    public Weather GetWeather (String url){
        System.out.println(url);
        OkHttpClient client = new OkHttpClient();
        Weather data = null;
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:21.0) Gecko/20100101 Firefox/21.0";
        try{
            Request request = new Request.Builder()
                    .url(url)
                    .header("User-Agent", userAgent)
                    .build();
            Response response = client.newCall(request).execute();
            String jsonStr = response.body().string();
            System.out.println(jsonStr);
            Gson gson = new Gson();
            data = gson.fromJson(jsonStr, Weather.class);

        }catch (IOException ex){
            System.out.println(ex);
        }

        return data;
    }

}
