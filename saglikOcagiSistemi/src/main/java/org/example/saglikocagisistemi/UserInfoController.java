package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    @FXML
    Label fullName;
    @FXML
    Label TCnumber;
    @FXML
    Label dateOfBirth;
    @FXML
    Label email;
    @FXML
    Label phoneNumber;

    switchScene s = new switchScene();

    database db = new database();


    @FXML
    public void changePassword(){
        s.switchSceneFMXL("user-change-password.fxml");
    }

    @FXML
    public void back(){
        s.switchSceneFMXL("user-system.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db.connect();

        Map map = db.getUserİnfo();

        fullName.setText((String) map.get("fullName"));
        TCnumber.setText((String) map.get("tc"));
        dateOfBirth.setText((String) map.get("dateOfBirth"));
        email.setText((String) map.get("email"));
        phoneNumber.setText((String) map.get("phone"));
    }
}
