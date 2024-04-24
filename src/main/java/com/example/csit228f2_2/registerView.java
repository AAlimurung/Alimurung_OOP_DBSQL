package com.example.csit228f2_2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class registerView implements Initializable {
    private static String username;
    private static String userID;

    @FXML
    Button btnBackToLogin;
    @FXML
    Button btnSignUp;
    @FXML
    Button btnShow;
    @FXML
    TextField tfUsernameUp;
    @FXML
    PasswordField pfPassSignUp;
    @FXML
    HBox hboxPass;
    @FXML
    Label lblPrompt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField tfPassword = new TextField();
        tfPassword.setVisible(false);

        //for showing password (without hashing)
        btnShow.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent actionEvent) {
                tfPassword.setText(pfPassSignUp.getText());
                tfPassword.setVisible(true);
//                pfPassword.setVisible(false);
                hboxPass.getChildren().add(tfPassword);
                hboxPass.getChildren().remove(pfPassSignUp);
            }
        });

        btnShow.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hboxPass.getChildren().add(pfPassSignUp);
                hboxPass.getChildren().remove(tfPassword);
            }
        });

        btnSignUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                username = tfUsernameUp.getText();
                String password = pfPassSignUp.getText();

                //if na-double click
                if(mouseEvent.getClickCount() == 2){
                    SQLMethods.doubleChecker(username, password);
                    if(SQLMethods.doubleChecker(username, password) > 0){
                        lblPrompt.setText("Registered already");
                    } else if(SQLMethods.nullField(username, password) > 0){ //if null ang fields
                        lblPrompt.setText("Empty fields!");
                    }
                    else {
                        SQLMethods.insertData(username, password);
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashBoard.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                            System.out.println("Entered homepage");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        btnBackToLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Stage stage = (Stage) btnSignUp.getScene().getWindow();
                    stage.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome-view.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
