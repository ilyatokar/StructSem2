package sample.map;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class MapController {
    @FXML
    private WebView Browser;


    public void InitBrowser(){
        WebEngine webEngine = Browser.getEngine();
        webEngine.load("https://www.google.com");
        System.out.println("hello, world!");
    }



}
