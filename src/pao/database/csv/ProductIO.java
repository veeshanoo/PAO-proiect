package pao.database.csv;

import pao.entities.Product;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class ProductIO {
    static private final ProductIO instance = new ProductIO();

    private ProductIO() {
    }

    public static ProductIO getInstance() {
        return instance;
    }

    public TreeMap<Integer, Product> loadData(String fileName) throws IOException {
        TreeMap<Integer, Product> departments = new TreeMap<>();

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        while (line != null) {
            if (line.equals("")) {
                line = reader.readLine();
                continue;
            }

            String[] splitData = line.split(",");
            Product product = new Product(
                    Integer.parseInt(splitData[0]),
                    splitData[1],
                    Double.parseDouble(splitData[2]),
                    Double.parseDouble(splitData[3]),
                    Integer.parseInt(splitData[4])
            );

            departments.put(product.getProductId(), product);
            line = reader.readLine();
        }

        return departments;
    }

    public void updateData(String fileName, TreeMap<Integer, Product> products) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            writer.write(formatted(entry.getValue()));
        }
        writer.close();
    }

    private String formatted(Product product) {
        return product.getProductId() + "," +
                product.getName() + "," +
                product.getQuantity() + "," +
                product.getPrice() + "," +
                product.getDepartmentId() + "\n";
    }
}
