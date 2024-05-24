abstract class Item {
    private String name;
    private String rank;
    private double price;

    public Item(String name, String rank, double price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public double getPrice() {
        return price;
    }

    public abstract String use();
}
