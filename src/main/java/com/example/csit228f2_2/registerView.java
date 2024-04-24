package com.example.csit228f2_2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class registerView implements Initializable {
    private static String username;
    private static String userID;
//    public static String hc;

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
                        System.out.println("Registered already");
                    } else {
                        SQLMethods.insertData(username, password);
                    }
                } else{
                    SQLMethods.nullField(username, password);
                    if(SQLMethods.nullField(username, password) > 0){
                        System.out.println("Empty Fields");
                    } else{
                        SQLMethods.insertData(username, password);
                    }
                }
            }
        });
    }
}
