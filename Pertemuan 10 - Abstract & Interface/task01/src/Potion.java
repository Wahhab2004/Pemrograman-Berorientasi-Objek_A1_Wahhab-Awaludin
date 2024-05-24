public class Potion extends Item {
    private int duration;
    private int effectPoint;
    private String potionType;

    public Potion(String name, String rank, double price, int duration, int effectPoint, String potionType) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.potionType = potionType;
    }

    @Override
    public String use() {
        if ("Attack".equals(potionType)) {
            return attack();
        } else if ("Heal".equals(potionType)) {
            return heal();
        }
        return "Unknown potion type";
    }
    private String attack() {
        return "Damage dealt by " + effectPoint;
    }
    private String heal() {
        return "Healed by " + effectPoint;
    }
}
