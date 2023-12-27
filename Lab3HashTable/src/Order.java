public class Order {
    private String adress;
    private String name;
    private int price;

    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Order(String adress, String name, int price) {
        this.adress = adress;
        this.name = name;
        this.price = price;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
