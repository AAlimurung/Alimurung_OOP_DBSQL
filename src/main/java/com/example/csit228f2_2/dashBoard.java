package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dashBoard implements Initializable {
    private static String video;
    private static String prog;

    @FXML
    Button btnAddToList;
    @FXML
    Button btnUpdateList;
    @FXML
    Button btnDeleteFromList;
    @FXML
    Button btnSearchList;
    @FXML
    Button btnLogout;
    @FXML
    Spinner<String> splProg;
    @FXML
    Label lblWelcomeDash;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblWelcomeDash.setText("WELCOME, " + welcomeView.username);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage st = (Stage) btnLogout.getScene().getWindow();
                    st.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome-view.fxml"));
                    Scene sc = new Scene(loader.load());
                    st.setScene(sc);
                    st.show();
                }catch (IOException e){
                    throw new RuntimeException();
                }
            }
        });
    }
}
