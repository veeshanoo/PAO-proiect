package pao;

public class Product {
    private String name;
    private Double quantity;
    private Double price;
    private Integer departmentId;

    public Product(String name, Double quantity, Double price, Integer departmentId) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void addStock(Double quantity) {
        this.quantity += quantity;
    }

    public void removeStock(Double quantity) {
        this.quantity -= quantity;
    }

    public Double calculatePrice() {
        return quantity * price;
    }
}
