package org.example.des;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Cần import những thư viện này của Joup
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//Cần import những thư viện này của gson
import com.google.gson.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import com.google.gson.Gson;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GiaoDien.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("DES");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}