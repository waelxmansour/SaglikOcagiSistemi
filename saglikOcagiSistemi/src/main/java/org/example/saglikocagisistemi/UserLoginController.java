package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserLoginController {

    @FXML
    TextField UserTC;
    @FXML
    TextField UserPassword;

    switchScene s = new switchScene();
    database db = new database();

    @FXML
    public void back(){
        s.switchSceneFMXL("user-login-sginup.fxml");
    }

    @FXML
    public void login(){
        db.connect();

        if (db.login(UserTC.getText(), UserPassword.getText()))
            s.switchSceneFMXL("user-system.fxml");
    }
}
