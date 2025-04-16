package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WorkLoginController {

    @FXML
    TextField workerPassword;
    @FXML
    TextField workerTC;

    switchScene s = new switchScene();

    database db = new database();


    @FXML
    public void login(){
        db.connect();

        if(db.workerLogin(workerTC.getText(), workerPassword.getText()))
            s.switchSceneFMXL("worker-system.fxml");

    }

    @FXML
    public void back(){
        s.switchSceneFMXL("worker-user.fxml");
    }
}
