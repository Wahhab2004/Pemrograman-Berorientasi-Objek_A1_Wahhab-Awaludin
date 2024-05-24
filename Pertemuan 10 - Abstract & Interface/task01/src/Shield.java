public class Shield extends Item {
    private int damageBlock;

    public Shield(String name, String rank, double price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }

    @Override
    public String use() {
        return defense();
    }

    private String defense() {
        return "Damage mitigated by " + damageBlock;
    }
}
