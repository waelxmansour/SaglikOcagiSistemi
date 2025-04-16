package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSginupController implements Initializable {
    @FXML
    TextField UserFullName;
    @FXML
    TextField UserTC;
    @FXML
    TextField UserDOB;
    @FXML
    TextField UserPhoneNumber;
    @FXML
    TextField UserGender;
    @FXML
    TextField UserPassword;
    @FXML
    TextField UserVerifyPassword;
    @FXML
    TextField UserEmail;


    switchScene s = new switchScene();
    database db = new database();

    @FXML
    public void back(){
        s.switchSceneFMXL("user-login-sginup.fxml");
    }

    @FXML
    public void sginup(){
        db.createAccount(
                UserFullName.getText(),
                UserTC.getText(),
                UserDOB.getText(),
                UserPhoneNumber.getText(),
                UserGender.getText(),
                UserPassword.getText(),
                UserEmail.getText()
        );
        s.switchSceneFMXL("user-login.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db.connect();
    }
}
