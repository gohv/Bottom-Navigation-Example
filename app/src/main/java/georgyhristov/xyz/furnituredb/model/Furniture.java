package georgyhristov.xyz.furnituredb.model;


public class Furniture {
    private String type;
    private String price;
    private String storeName;
    private String link;

    public Furniture() {
    }

    public Furniture(String type, String price, String storeName, String link) {
        this.type = type;
        this.price = price;
        this.storeName = storeName;
        this.link = link;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", storeName='" + storeName + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
