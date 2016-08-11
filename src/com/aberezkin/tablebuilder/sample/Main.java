package com.aberezkin.tablebuilder.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Table sample");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/aberezkin/tablebuilder/sample/sample.fxml"));
        VBox box = loader.load();
        Scene scene = new Scene(box, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
        Controller controller = loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
