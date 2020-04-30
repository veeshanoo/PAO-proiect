package pao.entities;

public class Product {
    private Integer productId;
    private String name;
    private Double quantity;
    private Double price;
    private Integer departmentId;

    public Product(Integer productId, String name, Double quantity, Double price, Integer departmentId) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.departmentId = departmentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "Product{" +
                "productId: " + this.productId + ", " +
                "name: '" + this.name + "', " +
                "quantity: " + this.quantity + ", " +
                "price: " + this.price + ", " +
                "departmentId: " + this.departmentId + "}";
    }
}
