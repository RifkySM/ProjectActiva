module main.projecactiva {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports App;
    opens App to javafx.fxml;

    exports Controllers;
    opens Controllers to javafx.fxml;

    opens Controllers.Club to javafx.fxml;
}
