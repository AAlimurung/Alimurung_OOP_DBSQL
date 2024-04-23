package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class welcomeView extends HelloApplication implements Initializable {
    @FXML
    Button btnShow;
    @FXML
    Button btnToSignUp;
    @FXML
    Button btnSignIn;
    @FXML
    PasswordField pfPassword;
    @FXML
    TextField tfUsername;
    @FXML
    AnchorPane pnMain;
    @FXML
    HBox hboxPass;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField tfPassword = new TextField();
        tfPassword.setVisible(false);
        btnShow.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                tfPassword.setText(pfPassword.getText());
                tfPassword.setVisible(true);
//                pfPassword.setVisible(false);
                hboxPass.getChildren().add(tfPassword);
                hboxPass.getChildren().remove(pfPassword);
//                grid.add(new Button("Hello"), 4,4);
            }
        });

        btnShow.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                tfPassword.setVisible(false);
//                pfPassword.setVisible(true);
                hboxPass.getChildren().add(pfPassword);
                hboxPass.getChildren().remove(tfPassword);
            }
        });

        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = tfUsername.getText();
                String password = pfPassword.getText();

                if(SQLMethods.ifValid(username, password)>0){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                    try {
                        Scene scene = new Scene(loader.load());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
