package org.example.saglikocagisistemi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginSginupController {

    switchScene s = new switchScene();

    @FXML
    public void login(){
        s.switchSceneFMXL("user-login.fxml");
    }

    @FXML
    public void sginup(){
        s.switchSceneFMXL("user-sginup.fxml");
    }

}