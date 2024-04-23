package com.example.csit228f2_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        SQLMethods.createUsers();
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("welcome-view.fxml"));
        try{
            Scene sc = new Scene(loader.load());
            stage.setScene(sc);
            stage.setResizable(false);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
