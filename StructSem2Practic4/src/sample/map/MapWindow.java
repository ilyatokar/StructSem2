package sample.map;

import com.google.gson.Gson;
import freemarker.template.TemplateException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sample.json.flightstrajectory.FlightsTrajectory;

import java.io.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MapWindow {
    private Stage window;
    private WebView webView;

    public MapWindow(String FlightId, String UTC, String date){
        Map<String, Object>  data = GetData(FlightId,UTC, date);
        String html = RenderPage(data);
        InitBrowser(html);

        window = new Stage();
        VBox root = new VBox();
        root.getChildren().add(webView);
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void InitBrowser(String html) {
        System.out.println(html);
        webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.loadContent(html);
    }

    public Map<String, Object>  GetData(String FlightId, String UTC, String date){
        LocalDateTime selectedDate = LocalDateTime.parse(date);
        Date selectedDateStart = Date.from(selectedDate.toInstant(ZoneOffset.UTC).minusSeconds(10800));
        Date selectedDateEnd = Date.from(selectedDate.toInstant(ZoneOffset.UTC).minusSeconds(10740));
        System.out.println(selectedDateStart);
        System.out.println(selectedDateEnd);
        String url = "https://api.flightradar24.com/common/v1/flight-playback.json?flightId="+FlightId+"&timestamp="+UTC;
        System.out.println(url);
        OkHttpClient client = new OkHttpClient();
        FlightsTrajectory data = null;
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
                data = gson.fromJson(jsonStr, FlightsTrajectory.class);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка ввода данных");
                alert.setHeaderText(null);
                alert.setContentText("Вы ввели не правельные данные");
                alert.showAndWait();
            }
        }catch (IOException ex){
            System.out.println(ex);
        }


        List<PositionDot> positionDots = new LinkedList<>();
        List<PositionDot> positionDotsSelected = new LinkedList<>();
        Double centerMapX = 0.0;
        Double centerMapY = 0.0;
        int sizeArray = data.result.response.data.flight.track.size();
        for (int i = 0; i < sizeArray; i++){
            centerMapX += data.result.response.data.flight.track.get(i).latitude;
            centerMapY += data.result.response.data.flight.track.get(i).longitude;

            positionDots.add(new PositionDot(
                    data.result.response.data.flight.track.get(i).timestamp.toString(),
                    data.result.response.data.flight.track.get(i).latitude.toString().replace(",","."),
                    data.result.response.data.flight.track.get(i).longitude.toString().replace(",",".")
            ));
        }

        for (int i = 0; i < sizeArray; i++){
            SimpleDateFormat format = new SimpleDateFormat("s");
            String time = data.result.response.data.flight.track.get(i).timestamp.toString();
            Date test = format.parse(time, new ParsePosition(0));

            System.out.println(test);

            if(selectedDateStart.before(test) && selectedDateEnd.after(test)){
                positionDotsSelected.add(new PositionDot(
                        data.result.response.data.flight.track.get(i).timestamp.toString(),
                        data.result.response.data.flight.track.get(i).latitude.toString().replace(",","."),
                        data.result.response.data.flight.track.get(i).longitude.toString().replace(",",".")
                ));
            }
        }
        Map<String, Object> root = new HashMap<String, Object>();

        if(positionDotsSelected.size()==0){
            AlertErrorInputDateTime();
        }
        centerMapX /= data.result.response.data.flight.track.size();
        centerMapY /= data.result.response.data.flight.track.size();

        root.put( "positions", positionDots );
        root.put("centerMapX", centerMapX.toString().replace(",","."));
        root.put("centerMapY", centerMapY.toString().replace(",","."));
        root.put("startX", data.result.response.data.flight.track.get(0).latitude.toString().replace(",","."));
        root.put("startY",data.result.response.data.flight.track.get(0).longitude.toString().replace(",","."));
        root.put("endX", data.result.response.data.flight.track.get(sizeArray-1).latitude.toString().replace(",","."));
        root.put("endY",data.result.response.data.flight.track.get(sizeArray-1).longitude.toString().replace(",","."));

        if(positionDotsSelected.size()!=0){
            root.put("positionDotsSelected",positionDotsSelected);
            root.put("positionDotsSelectedSize", positionDotsSelected.size());
            root.put("positionStartX", positionDotsSelected.get(0).latitude.replace(",","."));
            root.put("positionStartY", positionDotsSelected.get(0).longitude.replace(",","."));
            root.put("positionEndX", positionDotsSelected.get(positionDotsSelected.size()-1).latitude.replace(",","."));
            root.put("positionEndY", positionDotsSelected.get(positionDotsSelected.size()-1).longitude.replace(",","."));
        }
        return root;
    }

    public String RenderPage(Map<String, Object> data){
        String path = "/Users/cobolt/IdeaProjects/StructSem2Practic4/out/production/StructSem2Practic4/sample/map/template";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

        try {
            cfg.setDirectoryForTemplateLoading(new File(path));
            cfg.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Template temp = null;
        try {
            temp = cfg.getTemplate("test.ftlh");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer out = new StringWriter();

        try {
            temp.process(data, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }

    public void AlertErrorInputDateTime(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода данных");
        alert.setHeaderText(null);
        alert.setContentText("Введенные время и дата не соотвествуют данному полету," +
                " поэтому построить поэтим данным маршурут не возможно");
        alert.showAndWait();
    }

}
