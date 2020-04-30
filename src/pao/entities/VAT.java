package pao.entities;

public abstract class VAT {
    public abstract Double calculateVAT(Double price);
    public abstract Double getVAT();
    public abstract String identify();
}
