package pao.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String errMessage) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR (invalid data format)");

        window.setMinWidth(500);
        window.setMaxWidth(500);
        window.setMinHeight(100);
        window.setMaxHeight(100);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label error = new Label(errMessage);
        vbox.getChildren().add(error);

        Scene scene = new Scene(vbox, 500, 100);
        window.setScene(scene);
        window.show();
    }
}
