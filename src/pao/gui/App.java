package pao.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pao.database.sqlite.dao.DepartmentDao;
import pao.database.sqlite.dao.ProductDao;
import pao.database.sqlite.dao.ReceiptDao;
import pao.entities.Product;
import pao.services.DatecsDP25;

public class App extends Application {
    Stage window;

    public static void main(String []args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Cash register app");

        window.setScene(mainMenuScene());

        window.show();
    }

    public Scene mainMenuScene() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Button productsButton = new Button();
        productsButton.setText("Go to products menu");
        GridPane.setConstraints(productsButton, 0, 0);
        productsButton.setOnAction(e -> {
            window.setScene(productMenuScene());
        });

        Button departmentsButton = new Button();
        departmentsButton.setText("Go to departments button");
        GridPane.setConstraints(departmentsButton, 0, 1);
        departmentsButton.setOnAction(e -> {
            window.setScene(departmentsMenuScene());
        });

        grid.getChildren().addAll(productsButton, departmentsButton);

        return new Scene(grid, 300, 300);
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
        mainMenuButton.setOnAction(e -> {
            window.setScene(mainMenuScene());
        });

        Button newProductButton = new Button();
        newProductButton.setText("New product");
        GridPane.setConstraints(newProductButton, 1, 0);
        newProductButton.setOnAction(e -> {
            ProductEdit.display(new Product(1, "", 0.0, 0.0, 1));
        });

        grid.getChildren().addAll(mainMenuButton, newProductButton);

        return new Scene(grid, 500, 500);
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
        mainMenuButton.setOnAction(e -> {
            window.setScene(mainMenuScene());
        });

        grid.getChildren().addAll(mainMenuButton);

        return new Scene(grid, 500, 500);
    }
}
