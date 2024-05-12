module org.example.des {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.datatransfer;
    requires java.desktop;
    requires org.jsoup;
    requires com.google.gson;

    opens org.example.des to javafx.fxml;
    exports org.example.des;
}