module com.kitis.deanery {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;

    opens com.kitis.deanery to javafx.fxml;
    exports com.kitis.deanery;
    exports com.kitis.deanery.controller;
    exports com.kitis.deanery.util;
    exports com.kitis.deanery.model;
    opens com.kitis.deanery.controller to javafx.fxml;
}