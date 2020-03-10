package sample;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date_up = datepickerend.getValue().format(formatters);
        String date_down = datepickerstart.getValue().format(formatters);

        String url = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1="+date_down.toString()+"&date_req2="+date_up.toString()+"&VAL_NM_RQ=R01235";

        ArrayList<RecordItem> record = ParseUrl(url);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Данные");

        for(RecordItem item : record){
            series1.getData().add(new XYChart.Data(item.DateRecord, item.Value));
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("SMA p=10");
        int per = 10;
        SimpleMovingAverage obj = new SimpleMovingAverage(per);
        for (RecordItem item : record) {
            obj.addData(item);
            series2.getData().add(new XYChart.Data(item.DateRecord, obj.getMean()));
        }

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("SMA p=100");
        per = 100;
        SimpleMovingAverage obj2 = new SimpleMovingAverage(per);
        for (RecordItem item : record) {
            obj2.addData(item);
            series3.getData().add(new XYChart.Data(item.DateRecord, obj2.getMean()));
        }

        LineChart.getData().addAll(series1,series2,series3);
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

    public ArrayList<RecordItem> ParseUrl(String url){
        OkHttpClient client = new OkHttpClient();
        ArrayList<RecordItem> recordItems = new ArrayList<RecordItem>();
        try{
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(response.body().string())));
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
            NodeList RecordNodeList = document.getElementsByTagName("Record");

            for(int i = 0; i < RecordNodeList.getLength(); i+=steps){
                if(RecordNodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                    Element item = (Element) RecordNodeList.item(i);

                    RecordItem recordItem = new RecordItem(
                            item.getAttribute("Date"),
                            item.getAttribute("Id"),
                            Integer.valueOf(item.getChildNodes().item(0).getTextContent()),
                            Double.valueOf(item.getChildNodes().item(1).getTextContent().replace(',','.'))
                    );
                    recordItems.add(recordItem);
                }
            }

        }catch (IOException ex){
            System.out.println(ex);
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return recordItems;
    }

    public ArrayList<Double> SMA100(){
        return new ArrayList<>();
    }

    public ArrayList<Double> SMA10(){
        return new ArrayList<>();
    }
}
