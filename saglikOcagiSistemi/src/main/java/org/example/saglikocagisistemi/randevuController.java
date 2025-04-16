package org.example.saglikocagisistemi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class randevuController implements Initializable {

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayListSaat = new ArrayList<>();

    @FXML
    ComboBox bolum;
    @FXML
    ComboBox doktor;

    @FXML
    DatePicker tarih;
    @FXML
    ComboBox saat;


    switchScene s = new switchScene();

    database db = new database();


    @FXML
    public void randevu(){
        db.connect();

        Map map = db.getUserİnfo();

        db.createRandevu(
                (String) map.get("fullName"),
                tarih.getValue().toString(),
                saat.getValue().toString(),
                bolum.getValue().toString(),
                doktor.getValue().toString()
        );

        s.switchSceneFMXL("user-system.fxml");
    }

    @FXML
    public void back(){
        s.switchSceneFMXL("user-system.fxml");
    }

    @FXML
    public void getDoktor(){
        db.connect();
        System.out.println(bolum.getId());

        doktor.getItems().clear();

        ArrayList<Map> arrayList = db.getDoktor(bolum.getValue().toString());

        for (int i = 0; i < arrayList.size(); i++) {
            doktor.getItems().add(arrayList.get(i).get("name"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arrayList.add("Aile Hekimi");
        arrayList.add("Göz doktoru");
        arrayList.add("Diş Hekimi");
        arrayList.add("Çocuk Diş Hekimliği");
        arrayList.add( "Genel Muayene");
        arrayList.add("Tahliller");
        arrayList.add("Sigarayı Bıraktırma Kliniği");

        arrayListSaat.add("8:30");
        arrayListSaat.add("9:00");
        arrayListSaat.add("9:30");
        arrayListSaat.add("10:30");
        arrayListSaat.add("11:00");
        arrayListSaat.add("11:30");
        arrayListSaat.add("12:00");
        arrayListSaat.add("13:30");
        arrayListSaat.add("14:00");
        arrayListSaat.add("15:30");
        arrayListSaat.add("16:00");
        arrayListSaat.add("16:30");

        bolum.getItems().addAll(arrayList);
        saat.getItems().addAll(arrayListSaat);



    }
}
