package org.example.saglikocagisistemi;

import javafx.fxml.FXML;

public class UserOrWorkerController {
    switchScene s = new switchScene();

    @FXML
    public void isUser(){
        s.switchSceneFMXL("user-login-sginup.fxml");
    }

    @FXML
    public void isWorker(){
        s.switchSceneFMXL("worker-login.fxml");
    }
}
