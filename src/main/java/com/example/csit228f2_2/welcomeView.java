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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class welcomeView /*extends HelloApplication*/ implements Initializable {
    public static String username;
//    private static String password;
    public static int userID;

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
    @FXML
    Label lblPrompt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField tfPassword = new TextField();
        tfPassword.setVisible(false);

        //for showing password (without hashing)
        btnShow.setOnMousePressed(actionEvent -> {
            tfPassword.setText(pfPassword.getText());
            tfPassword.setVisible(true);
//                pfPassword.setVisible(false);
            hboxPass.getChildren().add(tfPassword);
            hboxPass.getChildren().remove(pfPassword);
        });

        btnShow.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hboxPass.getChildren().add(pfPassword);
                hboxPass.getChildren().remove(tfPassword);
            }
        });

        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                username = tfUsername.getText();
                String password = pfPassword.getText();

                if(SQLMethods.ifValid(username, password)>0){
                    try {
                        Stage stage = (Stage)btnSignIn.getScene().getWindow();
                        stage.close();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashBoard.fxml"));
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    lblPrompt.setText("Wrong credentials");
                }
            }
        });

        btnToSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Stage st = (Stage) btnSignIn.getScene().getWindow();
                    st.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
                    Scene sc = new Scene(loader.load());
                    st.setScene(sc);
                    st.show();
//                    st.close();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
