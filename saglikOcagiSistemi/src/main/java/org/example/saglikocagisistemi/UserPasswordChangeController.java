package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserPasswordChangeController {

    @FXML
    TextField eskiSifre;
    @FXML
    TextField yeniSifre;
    @FXML
    TextField yeniOnay;


    switchScene s = new switchScene();

    database db = new database();


    @FXML
    public void changePassword(){
        db.connect();

        db.userUpdatePassword(yeniOnay.getText());

        eskiSifre.setText("");
        yeniSifre.setText("");
        yeniOnay.setText("");

        s.switchSceneFMXL("user-info.fxml");

    }

    @FXML
    public void back(){

        s.switchSceneFMXL("user-info.fxml");
    }
}
