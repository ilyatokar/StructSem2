package sample;

import com.google.gson.Gson;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sample.json.flights.Datum;
import sample.json.flights.Flights;
import sample.map.MapWindow;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.logging.SimpleFormatter;

public class Controller {
    @FXML
    private TableView<FlyModel> FlyTableView;
    @FXML
    private TextField SearchTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField timePciker;

    @FXML
    public void onCLickSearchBtn(){
        Flights data = GetFlights();
        if(data.result.response.item.current != 0){
            RenderTable(data);
        }else{
            AlertErrorSearch();
        }
    }

    @FXML
    public void onClickBuildWay() throws IOException {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (FlyTableView.getSelectionModel().getSelectedItem() != null &&
            datePicker.getValue() != null &&
            !timePciker.getText().equals("")){
            String date = datePicker.getValue().format(formatters)+"T"+timePciker.getText();
            System.out.println(date);
            MapWindow mapWindow = new MapWindow(
                    FlyTableView.getSelectionModel().getSelectedItem().getFlightId(),
                    FlyTableView.getSelectionModel().getSelectedItem().getUTC().toString(),
                    date
            );
        }else
            AlertErrorInput();

    }


    public Flights GetFlights (){
        String search = SearchTextField.getText();
        String url = "https://api.flightradar24.com/common/v1/flight/list.json?&fetchBy=flight&query="+search;
        OkHttpClient client = new OkHttpClient();
        Flights data = null;
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:21.0) Gecko/20100101 Firefox/21.0";
        try{
            Request request = new Request.Builder()
                    .url(url)
                    .header("User-Agent", userAgent)
                    .build();
            Response response = client.newCall(request).execute();
            String jsonStr = response.body().string();
            System.out.println(jsonStr);
            if(response.code() != 400){
                Gson gson = new Gson();
                data = gson.fromJson(jsonStr, Flights.class);
            }else{
                AlertErrorInput();
            }
        }catch (IOException ex){
            System.out.println(ex);
        }

        return data;
    }

    public void RenderTable(Flights data){

        ObservableList<FlyModel> flys = FXCollections.observableArrayList();
        for(Datum item : data.result.response.data){
            if(item.status.generic.status.color.equals("green")){
                SimpleDateFormat format = new SimpleDateFormat("s");
                String time = item.status.generic.eventTime.utc.toString();
                FlyModel test = new FlyModel(
                        new SimpleStringProperty((format.parse(time, new ParsePosition(0))).toString()),
                        new SimpleStringProperty(item.status.generic.status.text),
                        new SimpleStringProperty(item.airport.origin.name),
                        Double.valueOf(item.airport.origin.position.latitude),
                        Double.valueOf(item.airport.origin.position.longitude),
                        new SimpleStringProperty(item.airport.destination.name),
                        Double.valueOf(item.airport.destination.position.latitude),
                        Double.valueOf(item.airport.destination.position.longitude),
                        item.identification.id,
                        item.status.generic.eventTime.utc
                );
                flys.add(test);
            }
        }
        FlyTableView.getItems().clear();
        FlyTableView.getColumns().clear();
        FlyTableView.setItems(flys);

        TableColumn<FlyModel, String> DateColumn = new TableColumn<FlyModel, String>("DateFlightEnd");
        DateColumn.setCellValueFactory(new PropertyValueFactory<FlyModel, String>("DateFlight"));
        FlyTableView.getColumns().add(DateColumn);

        TableColumn<FlyModel, String> StatusColumn = new TableColumn<FlyModel, String>("Status");
        StatusColumn.setCellValueFactory(new PropertyValueFactory<FlyModel, String>("Status"));
        FlyTableView.getColumns().add(StatusColumn);

        TableColumn<FlyModel, String> TownFromColumn = new TableColumn<FlyModel, String>("TownFrom");
        TownFromColumn.setCellValueFactory(new PropertyValueFactory<FlyModel, String>("TownFrom"));
        FlyTableView.getColumns().add(TownFromColumn);

        TableColumn<FlyModel, String> TownToColumn = new TableColumn<FlyModel, String>("TownTo");
        TownToColumn.setCellValueFactory(new PropertyValueFactory<FlyModel, String>("TownTo"));
        FlyTableView.getColumns().add(TownToColumn);
    }

    public void AlertErrorSearch(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка поиска самолета");
        alert.setHeaderText(null);
        alert.setContentText("Данный самолет не найдет или в течение 25 дней он не совершал полетов");
        alert.showAndWait();
    }

    public void AlertErrorInput(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода данных");
        alert.setHeaderText(null);
        alert.setContentText("Вы ввели не правельные данные");
        alert.showAndWait();
    }

    public void AlertNoSelectedItem(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка выбора данных");
        alert.setHeaderText(null);
        alert.setContentText("Вы не выбрали рейс");
        alert.showAndWait();
    }

}
