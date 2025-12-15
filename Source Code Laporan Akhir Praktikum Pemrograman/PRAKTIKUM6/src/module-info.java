module praktikummm6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml;
    opens model to javafx.base;
}