package pao.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pao.entities.Product;

public class ProductEdit {
    public static void display(Product product) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Product edit");
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button closeButton = new Button();
        closeButton.setText("Close");
        GridPane.setConstraints(closeButton, 0, 0);
        closeButton.setOnAction(e -> {
            window.close();
        });

        Scene scene = new Scene(grid, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
