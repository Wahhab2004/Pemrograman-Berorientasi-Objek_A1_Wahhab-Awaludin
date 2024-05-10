import java.util.ArrayList;
import java.util.List;

public class Player extends Entity{
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Konstruktor
    public Player(int hp, int level, String name) {
        super(hp, level);
        this.name = name;
    }


    // Metode Menampilkan Informasi Pemain / Player
    public void entityInfo() {
        System.out.println("# PLAYER DENGAN NAMA : " + name + ", DAN Level : " + getLevel());
    }


    // Metode Interaksi dengan Merchant
    public void interact(Merchant merchant){
        if (getHp() > 0) {
            if(merchant.getHp() > 0) {
                System.out.println("Merchant : ");
                System.out.println("Barang yang tersedia hari ini: ");
                if(!Merchant.listItem.isEmpty()) {
                    for (String merchant1 : Merchant.listItem){
                        System.out.println("# " + merchant1);
                    }
                }

            } else {
                System.out.println("# TIDAK BISA BELI MERCHANT NGAMBEK");
            }
        }
        else {
            System.out.println("# PLAYER SUDAH MATI");
        }

    }

    // Attack to Merchant
    public void attack (Merchant merchant) {
        if (getHp() > 0) {
            if (merchant.getHp() > 0) {
                System.out.println("merchant : hey hey, ngapain nyerang");
                merchant.decreaseHp();
                if (merchant.getHp() <= 0)
                    System.out.println("Merchant : Dah lah males jualan");
            }else {
                System.out.println("Merchant : Dah lah males jualan");

            }
        }
        else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }


    // Attack to Zombie
    public void attack (Zombie zombie) {
        if (getHp() > 0) {
            if (zombie.getHp() > 0) {
                System.out.println("zombie : GRAAA!");
                zombie.decreaseHp();
                if(zombie.getHp() <= 0) {
                    System.out.println("# ZOMBIE MATI" );
                }
            }
            else {
                System.out.println("# ZOMBI MATI");
            }
        }
        else {
            System.out.println("# PLAYER SUDAH MATI");
        }

    }



}
