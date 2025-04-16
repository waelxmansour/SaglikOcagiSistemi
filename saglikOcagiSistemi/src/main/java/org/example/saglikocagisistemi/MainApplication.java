package org.example.saglikocagisistemi;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        switchScene s = new switchScene();
        s.setMainStage(stage);


        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}