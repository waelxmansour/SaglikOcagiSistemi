package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkerSystemController {

    @FXML
    TableColumn hastaAdi;
    @FXML
    TableColumn hastaTC;
    @FXML
    TableColumn hastaYas;


    switchScene s = new switchScene();


    @FXML
    public void randevular(){
        s.switchSceneFMXL("worker-hasta-islemleri.fxml");
    }


    @FXML
    public void hastlar(){
        s.switchSceneFMXL("worker-hasta.fxml");
    }


}
