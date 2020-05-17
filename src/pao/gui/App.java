package pao.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pao.database.sqlite.dao.DepartmentDao;
import pao.database.sqlite.dao.ProductDao;
import pao.entities.Department;
import pao.entities.Product;
import pao.services.DatecsDP25;

import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class App extends Application {
    Stage window;

    public static void main(String []args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Cash register app");
        resizeWindow(300, 300);

        window.setScene(mainMenuScene());

        window.show();
    }

    public Scene mainMenuScene() {
        VBox vbox = new VBox(10);

        Button productsButton = new Button();
        productsButton.setText("Go to products menu");
        productsButton.setOnAction(ev -> {
            resizeWindow(570, 700);
            window.setScene(productMenuScene());
        });

        Button departmentsButton = new Button();
        departmentsButton.setText("Go to departments menu");
        departmentsButton.setOnAction(ev -> {
            resizeWindow(510, 700);
            window.setScene(departmentsMenuScene());
        });

        Button closeButton = new Button();
        closeButton.setText("Close");
        closeButton.setOnAction(ev -> {
            window.close();
        });

        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(productsButton);
        vbox.getChildren().add(departmentsButton);
        vbox.getChildren().add(closeButton);

        return new Scene(vbox, 300, 300);
    }

    public Scene productMenuScene() {
        // Here we load our products
        DatecsDP25 datecs = DatecsDP25.getInstance();
        try {
            datecs.setProducts(ProductDao.getInstance().loadData());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button mainMenuButton = new Button();
        mainMenuButton.setText("Go to main menu");
        GridPane.setConstraints(mainMenuButton, 0, 0);
        mainMenuButton.setOnAction(ev -> {
            resizeWindow(300, 300);
            window.setScene(mainMenuScene());
        });

        Button newProductButton = new Button();
        newProductButton.setText("New product");
        GridPane.setConstraints(newProductButton, 1, 0);
        newProductButton.setOnAction(e -> {
            ProductEdit.display(new Product(-1, "", 0.0, 0.0, 1));
        });

        Button refreshButton = new Button();
        refreshButton.setText("Refresh");
        GridPane.setConstraints(refreshButton, 2, 0);
        refreshButton.setOnAction(e -> {
            window.setScene(productMenuScene());
        });

        Label idLabel = new Label("Product Id");
        idLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
        GridPane.setConstraints(idLabel, 0, 1);
        Label nameLabel = new Label("Product Name");
        nameLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
        GridPane.setConstraints(nameLabel, 1, 1);
        Label priceLabel = new Label("Product Price");
        priceLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
        GridPane.setConstraints(priceLabel, 2, 1);

        TreeMap<Integer, Product> products = DatecsDP25.getInstance().getProducts();
        Label []productIdLabels = new Label[products.size()];
        Label []productNameLabels = new Label[products.size()];
        Label []productPriceLabels = new Label[products.size()];
        Button []editButtons = new Button[products.size()];
        Button []deleteButtons = new Button[products.size()];

        int cnt = -1;
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            cnt++;
            Product product = entry.getValue();

            productIdLabels[cnt] = new Label();
            productIdLabels[cnt].setText(product.getProductId().toString());
            GridPane.setConstraints(productIdLabels[cnt], 0, cnt + 2);

            productNameLabels[cnt] = new Label();
            productNameLabels[cnt].setText(product.getName());
            GridPane.setConstraints(productNameLabels[cnt], 1, cnt + 2);

            productPriceLabels[cnt] = new Label();
            productPriceLabels[cnt].setText(String.format("%.2f", product.getPrice()));
            GridPane.setConstraints(productPriceLabels[cnt], 2, cnt + 2);

            editButtons[cnt] = new Button();
            editButtons[cnt].setText("Edit");
            GridPane.setConstraints(editButtons[cnt], 3, cnt + 2);
            editButtons[cnt].setOnAction(ev -> {
                ProductEdit.display(product);
            });

            deleteButtons[cnt] = new Button();
            deleteButtons[cnt].setText("Delete");
            GridPane.setConstraints(deleteButtons[cnt], 4, cnt + 2);
            deleteButtons[cnt].setOnAction(ev -> {
                ProductDao.getInstance().delete(product);
            });

            grid.getChildren().add(productIdLabels[cnt]);
            grid.getChildren().add(productNameLabels[cnt]);
            grid.getChildren().add(productPriceLabels[cnt]);
            grid.getChildren().add(editButtons[cnt]);
            grid.getChildren().add(deleteButtons[cnt]);
        }

        grid.getChildren().add(mainMenuButton);
        grid.getChildren().add(newProductButton);
        grid.getChildren().add(refreshButton);
        grid.getChildren().add(idLabel);
        grid.getChildren().add(nameLabel);
        grid.getChildren().add(priceLabel);

        return new Scene(grid, 700, 200);
    }

    public Scene departmentsMenuScene() {
        // Here we load our departments
        DatecsDP25 datecs = DatecsDP25.getInstance();
        try {
            datecs.setDepartments(DepartmentDao.getInstance().loadData());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button mainMenuButton = new Button();
        mainMenuButton.setText("Go to main menu");
        GridPane.setConstraints(mainMenuButton, 0, 0);
        mainMenuButton.setOnAction(ev -> {
            resizeWindow(300, 300);
            window.setScene(mainMenuScene());
        });

        Button newDepartmentButton = new Button();
        newDepartmentButton.setText("New department");
        GridPane.setConstraints(newDepartmentButton, 1, 0);
        newDepartmentButton.setOnAction(e -> {
            DepartmentEdit.display(new Department(-1, ""));
        });

        Button refreshButton = new Button();
        refreshButton.setText("Refresh");
        GridPane.setConstraints(refreshButton, 2, 0);
        refreshButton.setOnAction(e -> {
            window.setScene(departmentsMenuScene());
        });

        Label idLabel = new Label("Department Id");
        idLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
        GridPane.setConstraints(idLabel, 0, 1);
        Label nameLabel = new Label("Department Name");
        nameLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 13));
        GridPane.setConstraints(nameLabel, 1, 1);

        TreeMap<Integer, Department> departments = DatecsDP25.getInstance().getDepartments();
        Label []depIdLabels = new Label[departments.size()];
        Label []depNameLabels = new Label[departments.size()];
        Button []editButtons = new Button[departments.size()];
        Button []deleteButtons = new Button[departments.size()];

        int cnt = -1;
        for (Map.Entry<Integer, Department> entry : departments.entrySet()) {
            cnt++;
            Department department = entry.getValue();

            depIdLabels[cnt] = new Label();
            depIdLabels[cnt].setText(department.getDepartmentId().toString());
            GridPane.setConstraints(depIdLabels[cnt], 0, cnt + 2);

            depNameLabels[cnt] = new Label();
            depNameLabels[cnt].setText(department.getName());
            GridPane.setConstraints(depNameLabels[cnt], 1, cnt + 2);

            editButtons[cnt] = new Button();
            editButtons[cnt].setText("Edit");
            GridPane.setConstraints(editButtons[cnt], 2, cnt + 2);
            editButtons[cnt].setOnAction(ev -> {
                DepartmentEdit.display(department);
            });

            deleteButtons[cnt] = new Button();
            deleteButtons[cnt].setText("Delete");
            GridPane.setConstraints(deleteButtons[cnt], 3, cnt + 2);
            deleteButtons[cnt].setOnAction(ev -> {
                DepartmentDao.getInstance().delete(department);
                window.setScene(departmentsMenuScene());
            });

            grid.getChildren().add(depIdLabels[cnt]);
            grid.getChildren().add(depNameLabels[cnt]);
            grid.getChildren().add(editButtons[cnt]);
            grid.getChildren().add(deleteButtons[cnt]);
        }

        grid.getChildren().add(mainMenuButton);
        grid.getChildren().add(newDepartmentButton);
        grid.getChildren().add(refreshButton);
        grid.getChildren().add(idLabel);
        grid.getChildren().add(nameLabel);

        return new Scene(grid, 500, 500);
    }

    private void resizeWindow(int width, int height) {
        window.setWidth(width);
        window.setHeight(height);
        window.setMinWidth(width);
        window.setMaxWidth(width);
        window.setMinHeight(height);
        window.setMaxHeight(height);
    }
}
