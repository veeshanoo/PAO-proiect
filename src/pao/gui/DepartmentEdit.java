package pao.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pao.entities.Department;
import pao.services.DatecsDP25;

public class DepartmentEdit {
    public static void display(Department department) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Department edit");
        window.setMinWidth(350);
        window.setMaxWidth(350);
        window.setMinHeight(140);
        window.setMaxHeight(140);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button closeButton = new Button();
        closeButton.setText("Close");
        GridPane.setConstraints(closeButton, 0, 0);
        closeButton.setOnAction(ev -> {
            window.close();
        });

        Label nameLabel = new Label("Department name");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameField = new TextField();
        if (department.getDepartmentId().equals(-1)) {
            nameField.setPromptText("enter department name...");
        } else {
            nameField.setText(department.getName());
        }
        GridPane.setConstraints(nameField, 1, 1);

        Button saveButton = new Button("Save");
        GridPane.setConstraints(saveButton, 1, 0);
        saveButton.setOnAction(ev -> {
            department.setName(nameField.getText());
            if (department.getDepartmentId().equals(-1)) {
                DatecsDP25.getInstance().createDepartment(department);
                window.close();
            } else {
                DatecsDP25.getInstance().updateDepartment(department);
            }
        });

        grid.getChildren().add(closeButton);
        grid.getChildren().add(saveButton);
        grid.getChildren().add(nameLabel);
        grid.getChildren().add(nameField);

        Scene scene = new Scene(grid, 350, 140);
        window.setScene(scene);
        window.show();
    }
}
