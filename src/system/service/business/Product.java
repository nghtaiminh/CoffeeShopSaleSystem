package system.service.business;

public class Product {
    private int productID;
    private String name;
    private String category;
    private int price;
    private int shopID;
    private int quantity;

    public Product(int productID, String name,String category, int price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }
}
