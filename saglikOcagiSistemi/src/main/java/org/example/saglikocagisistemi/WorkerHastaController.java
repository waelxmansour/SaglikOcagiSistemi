package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class WorkerHastaController {

    @FXML
    TableColumn hastaAdi;
    @FXML
    TableColumn hastaTC;
    @FXML
    TableColumn hastaYas;

    switchScene s = new switchScene();

    @FXML
    public void back(){
        s.switchSceneFMXL("worker-system.fxml");
    }
}
