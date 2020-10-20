package com.UI.UIFramework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/UIv4.fxml"));
        AnchorPane pane=loader.load();
        Scene scene=new Scene(pane);
        //scene.getStylesheets().addAll(getClass().getResource("styleDark.css").toExternalForm());
        primaryStage.setTitle("Framework");
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}

