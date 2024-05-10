import java.util.ArrayList;

public class Merchant extends Entity{
    public static ArrayList<String> listItem = new ArrayList<>();


    // Kontruktor
    public Merchant(int hp, int level, ArrayList<String> listItem) {
        super(hp, level);
        this.listItem = listItem;
    }


    // Menampilkan Informasi Merchant
    public void entityInfo() {
        System.out.println("# MERCHANT DENGAN LEVEL : " + getLevel());
    }
}
