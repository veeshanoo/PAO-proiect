package pao.database.csv;

import pao.entities.*;
import pao.services.Discount;
import pao.services.DiscountByPercent;
import pao.services.DiscountByValue;

import java.io.*;
import java.util.*;

public class ReceiptIO {
    static private final ReceiptIO instance = new ReceiptIO();

    private ReceiptIO() {
    }

    public static ReceiptIO getInstance() {
        return instance;
    }

    public TreeMap<Integer, Receipt> loadData(String fileName) throws IOException {
        TreeMap<Integer, Receipt> receipts = new TreeMap<>();

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        while (line != null) {
            if (line.equals("")) {
                line = reader.readLine();
                continue;
            }

            String[] splitData = line.split(",");

            Receipt receipt = new Receipt();
            int ptr = 0;
            receipt.setReceiptId(Integer.parseInt(splitData[ptr++]));
            int nrProducts = Integer.parseInt(splitData[ptr++]);
            for (int i = 0; i < nrProducts; i++) {
//                ReceiptProduct receiptProduct = new ReceiptProduct(
//                        Integer.parseInt(splitData[ptr++]),
//                        splitData[ptr++],
//                        Double.parseDouble(splitData[ptr++]),
//                        Double.parseDouble(splitData[ptr++]),
//                        Integer.parseInt(splitData[ptr++]),
//                        receiptProductId, receiptId, discountType(splitData[ptr++], Double.parseDouble(splitData[ptr++])),
//                        vatType(splitData[ptr++])
//                );
                receipt.addProduct(null);
            }

            receipt.prepareReceiptForSale();
//            System.out.println(receipt);

            receipts.put(receipt.getReceiptId(), receipt);
            line = reader.readLine();
        }

        return receipts;
    }

    public void updateData(String fileName, TreeMap<Integer, Receipt> receipts) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (Map.Entry<Integer, Receipt> entry : receipts.entrySet()) {
            writer.write(formatted(entry.getValue()));
        }
        writer.close();
    }

    private String formatted(Receipt receipt) {
        StringBuilder str = new StringBuilder();
        str.append(receipt.getReceiptId());
        str.append(",");
        str.append(receipt.getProducts().size());
        List<ReceiptProduct> products = receipt.getProducts();
        for (ReceiptProduct product : products) {
            str.append(",");
            str.append(product.getProductId());
            str.append(",");
            str.append(product.getName());
            str.append(",");
            str.append(product.getQuantity());
            str.append(",");
            str.append(product.getPrice());
            str.append(",");
            str.append(product.getDepartmentId());
            str.append(",");
            str.append(product.getDiscount().identify());
            str.append(",");
            str.append(product.getDiscount().getValue());
            str.append(",");
            str.append(product.getVat().identify());
        }
        str.append("\n");

        return str.toString();
    }

    private Discount discountType(String ch, Double value) {
        if (ch.equals("V")) {
            return new DiscountByValue(value);
        } else if (ch.equals("P")) {
            return new DiscountByPercent(value);
        } else {
            return null;
        }
    }

    private VAT vatType(String ch) {
        if (ch.equals("A")) {
            return new TaxA();
        } else if (ch.equals("B")) {
            return new TaxB();
        } else {
            return null;
        }
    }
}
