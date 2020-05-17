package pao.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.lang.management.CompilationMXBean;

public class AlertBox {
    public static void display(String errMessage) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR (invalid data format)");

        window.setMinWidth(100);
        window.setMaxWidth(500);
        window.setMinHeight(100);
        window.setMaxHeight(100);

        VBox vbox = new VBox();
        Label error = new Label(errMessage);
        vbox.getChildren().add(error);

        Scene scene = new Scene(vbox, 300, 100);
        window.setScene(scene);
        window.show();
    }
}
