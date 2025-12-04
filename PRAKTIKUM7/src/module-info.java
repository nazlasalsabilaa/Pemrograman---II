module toko_buku {
    
    requires java.sql;
    requires mysql.connector.j; 
    requires java.naming;
    requires transitive javafx.base; 
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    
    opens application to javafx.graphics, javafx.fxml; 
    opens controller to javafx.fxml;
    opens model to javafx.base; 

    exports application;
    exports controller;
    exports model;
    exports service;
    exports DAO;
}