package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSystemController implements Initializable {

    @FXML
    Label userName;

    switchScene s = new switchScene();
    database db = new database();


    @FXML
    public void UserInfo(){
        s.switchSceneFMXL("user-info.fxml");
    }

    @FXML
    public void randevu(){
        s.switchSceneFMXL("randevu.fxml");
    }

    @FXML
    public void randevularim(){
        s.switchSceneFMXL("randevularim.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db.connect();

        userName.setText((String) (db.getUserİnfo()).get("fullName"));
    }
}
