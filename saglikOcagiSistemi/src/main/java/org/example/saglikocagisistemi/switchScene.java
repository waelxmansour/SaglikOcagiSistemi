package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class switchScene {
    private static Stage stage;

    public void setMainStage(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("worker-user.fxml"));
            this.stage = stage;
            this.stage.setScene(new Scene(loader.load(),800,600));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchSceneFMXL(String FMXL){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FMXL));
            stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
