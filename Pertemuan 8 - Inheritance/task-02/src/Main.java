import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> listItem = new ArrayList<>() {{
            add("SWORD");
            add("SHIELD");
            add("POTION");
        }};


        Player P1 = new Player(50, 10, "Wahhab");
        Merchant merchant1 = new Merchant(20, 20, listItem);
        Zombie zombie1 = new Zombie(30, 5, TypeZombie.MELEE);
        Zombie zombie2 = new Zombie(15, 5, TypeZombie.RANGED);

        System.out.println("TES INFO OBJEK");
        P1.entityInfo();
        merchant1.entityInfo();
        zombie1.entityInfo();
        zombie2.entityInfo();

        System.out.println("===========================\n");

        System.out.println("TES INTERAKSI MERCHANT");
        P1.interact(merchant1);
        System.out.println("===========================\n");

        System.out.println("TES SERANG MERCHANT");
        P1.attack(merchant1);
        P1.attack(merchant1);
        P1.interact(merchant1);
        System.out.println("===========================\n");


        System.out.println("TES SERANG ZOMBIE");
        P1.attack(zombie1);
        P1.attack(zombie1);
        P1.attack(zombie1);
        zombie1.attack(P1);
        System.out.println("===========================\n");


        System.out.println("TES SERANG PLAYER");
        zombie2.attack(P1);
        zombie2.attack(P1);
        zombie2.attack(P1);
        zombie2.attack(P1);
        P1.interact(merchant1);
        P1.attack(zombie1);


    }
}