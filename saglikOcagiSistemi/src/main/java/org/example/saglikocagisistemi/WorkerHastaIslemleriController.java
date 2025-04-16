package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class WorkerHastaIslemleriController implements Initializable {

    @FXML
    TableColumn hastaAdi;
    @FXML
    TableColumn randevuTarih;
    @FXML
    TableColumn randevuSaat;
    @FXML
    TableColumn deleteButton;

    switchScene s = new switchScene();

    database db = new database();

    @FXML
    public void back(){
        s.switchSceneFMXL("worker-system.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


//        hastaAdi.setCellValueFactory(new PropertyValueFactory<>());
//        randevuTarih.setCellValueFactory(new PropertyValueFactory<>());
//        randevuSaat.setCellValueFactory(new PropertyValueFactory<>());
//        deleteButton.setCellValueFactory(new PropertyValueFactory<>());
    }
}
