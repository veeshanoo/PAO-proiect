package pao.services;

public interface Discount {
    Double calculateDiscount(Double price);
    String identify();
    Double getValue();
}
