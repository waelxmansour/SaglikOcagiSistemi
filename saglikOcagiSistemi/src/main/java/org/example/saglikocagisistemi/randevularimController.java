package org.example.saglikocagisistemi;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class randevularimController  implements Initializable {

    @FXML
    TableColumn doktorAdi;
    @FXML
    TableColumn saat;
    @FXML
    TableColumn tarih;
    @FXML
    TableColumn bolum;
    @FXML
    TableView table;



    switchScene s = new switchScene();

    database db =new database();



    @FXML
    public void back(){
        s.switchSceneFMXL("user-system.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        db.connect();

        ArrayList<Map<String,String>> arrayList = db.getRandevular();

        for (int i = 0 ; i < arrayList.size() ; i++){
            int finalI = i;
            doktorAdi.setCellValueFactory(c -> new SimpleStringProperty(arrayList.get(finalI).get("hastaAdi")));
            saat.setCellValueFactory(c -> new SimpleStringProperty(arrayList.get(finalI).get("saat")));
            tarih.setCellValueFactory(c -> new SimpleStringProperty(arrayList.get(finalI).get("tarih")));
            bolum.setCellValueFactory(c -> new SimpleStringProperty(arrayList.get(finalI).get("bolum")));

        }

        table.getItems().addAll(arrayList);

    }
}
