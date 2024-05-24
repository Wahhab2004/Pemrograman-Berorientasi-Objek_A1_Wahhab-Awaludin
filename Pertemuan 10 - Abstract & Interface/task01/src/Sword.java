public class Sword extends Item {
    private int damage;

    public Sword(String name, String rank, double price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    @Override
    public String use() {
        return attack();
    }

    private String attack() {
        return "Damage dealt by " + damage;
    }
}
