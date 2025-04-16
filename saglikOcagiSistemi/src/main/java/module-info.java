module org.example.saglikocagisistemi {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires javafx.graphics;

    opens org.example.saglikocagisistemi to javafx.fxml;
    exports org.example.saglikocagisistemi;
}