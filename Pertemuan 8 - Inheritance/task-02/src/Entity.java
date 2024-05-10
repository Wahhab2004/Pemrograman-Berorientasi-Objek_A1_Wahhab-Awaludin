public class Entity {
    private int hp = 0;
    private int level = 0;


    // Getter & Setter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    // Construktor
    public Entity(){};

    public Entity(int hp, int level) {
        this.hp = hp;
        this.level = level;
    }

    // Getter for Attack
    public int decreaseHp() {
        return hp -=10;
    }

    public int decreaseHpMelee() {
        return hp -=20;
    }

    public int decreaseHpRanged() {
        return hp -= 15;
    }



}
