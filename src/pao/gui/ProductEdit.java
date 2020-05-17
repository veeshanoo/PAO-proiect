package pao.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pao.entities.Product;
import pao.services.DatecsDP25;

public class ProductEdit {
    public static void display(Product product) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Product edit");

        int width = 350;
        int height = 260;
        window.setWidth(width);
        window.setHeight(height);
        window.setMinWidth(width);
        window.setMaxWidth(width);
        window.setMinHeight(height);
        window.setMaxHeight(height);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button closeButton = new Button("Close");
        GridPane.setConstraints(closeButton, 0, 0);
        closeButton.setOnAction(ev -> {
            window.close();
        });

        Label nameLabel = new Label("Product name:");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameField = new TextField();
        if (product.getProductId().equals(-1)) {
            nameField.setPromptText("enter product name...");
        } else {
            nameField.setText(product.getName());
        }
        GridPane.setConstraints(nameField, 1, 1);

        Label quantityLabel = new Label("Quantity:");
        GridPane.setConstraints(quantityLabel, 0, 2);

        TextField quantityField = new TextField();
        if (product.getProductId().equals(-1)) {
            quantityField.setPromptText("enter quantity...");
        } else {
            quantityField.setText(String.format("%.2f", product.getQuantity()));
        }
        GridPane.setConstraints(quantityField, 1, 2);

        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 3);

        TextField priceField = new TextField();
        if (product.getProductId().equals(-1)) {
            priceField.setPromptText("enter price...");
        } else {
            priceField.setText(String.format("%.2f", product.getPrice()));
        }
        GridPane.setConstraints(priceField, 1, 3);

        Label departmentLabel = new Label("Department id:");
        GridPane.setConstraints(departmentLabel, 0, 4);

        TextField departmentField = new TextField();
        if (product.getProductId().equals(-1)) {
            departmentField.setPromptText("enter department id...");
        } else {
            departmentField.setText(product.getDepartmentId().toString());
        }
        GridPane.setConstraints(departmentField, 1, 4);

        Button saveButton = new Button();
        saveButton.setText("Save");
        GridPane.setConstraints(saveButton, 1, 0);
        saveButton.setOnAction(ev -> {
            Boolean err = false;
            try {
                product.setName(nameField.getText());
                if (nameField.getText().length() == 0) {
                    throw new Exception("Name field cannot be empty");
                }
                product.setQuantity(Double.parseDouble(quantityField.getText()));
                product.setPrice(Double.parseDouble(priceField.getText()));
                product.setDepartmentId(Integer.parseInt(departmentField.getText()));
            } catch (Exception e) {
                AlertBox.display(e.getMessage());
                err = true;
            } finally {
                if (err.equals(false)) {
                    if (product.getProductId().equals(-1)) {
                        DatecsDP25.getInstance().addProduct(product);
                    } else {
                        DatecsDP25.getInstance().updateProduct(product);
                    }
                    window.close();
                    App app = new App();
                    App.setWindowScene(app.productMenuScene());
                }
            }
        });

        grid.getChildren().add(closeButton);
        grid.getChildren().add(saveButton);
        grid.getChildren().add(nameLabel);
        grid.getChildren().add(nameField);
        grid.getChildren().add(quantityLabel);
        grid.getChildren().add(quantityField);
        grid.getChildren().add(priceLabel);
        grid.getChildren().add(priceField);
        grid.getChildren().add(departmentLabel);
        grid.getChildren().add(departmentField);

        Scene scene = new Scene(grid, 500, 300);
        window.setScene(scene);
        window.show();
    }
}
