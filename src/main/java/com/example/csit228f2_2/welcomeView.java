//package com.example.csit228f2_2;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class welcomeView extends HelloApplication implements Initializable {
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        btnShow.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent actionEvent) {
//                tfPassword.setText(pfPassword.getText());
//                tfPassword.setVisible(true);
//                pfPassword.setVisible(false);
//                grid.add(new Button("Hello"), 4,4);
//            }
//        });
//
//        btnShow.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                tfPassword.setVisible(false);
//                pfPassword.setVisible(true);
//            }
//        });
//
//        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                String username = tfUsername.getText();
//                String password = pfPassword.getText();
//
//                if(SQLMethods.ifValid(username, password)>0){
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
//                    try {
//                        Scene scene = new Scene(loader.load());
//                        stage.setScene(scene);
//                        stage.show();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//
////-------------INSERT DATA-------------
//        btnSignUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                String username = tfUsername.getText();
//                String password = pfPassword.getText();
//
//                //if na-double click
//                if(mouseEvent.getClickCount() == 2){
//                    SQLMethods.doubleChecker(username, password);
//
//                    if(SQLMethods.doubleChecker(username, password) > 0){
//                        System.out.println("Registered already");
//                    } else {
//                        SQLMethods.insertData(username, password);
//                        actionTarget.setText("Successfully registered");
//                        actionTarget.setOpacity(1);
//                    }
//                } else{
//                    SQLMethods.nullField(username, password);
//                    if(SQLMethods.nullField(username, password) > 0){
//                        System.out.println("Empty Fields");
//                    } else{
//                        SQLMethods.insertData(username, password);
//                        actionTarget.setText("Successfully registered");
//                        actionTarget.setOpacity(1);
//                    }
//                }
//            }
//        });
//    }
//}
