public class Main {
    public static void main(String[] args) {
        // Buat objek dari masing-masing class
        Potion healthPotion = new Potion("Health Potion", "A", 50, 5, 20, "Heal");
        Potion attackPotion = new Potion("Attack Potion", "A", 50, 5, 15, "Attack");
        Sword sword = new Sword("Excalibur", "S", 300, 50);
        Shield shield = new Shield("Aegis", "S", 200, 30);

        // Menggunakan potion untuk healing
        System.out.println(healthPotion.use());

        // Menggunakan potion untuk attack
        System.out.println(attackPotion.use());

        // Menggunakan sword untuk menyerang
        System.out.println(sword.use());

        // Menggunakan shield untuk bertahan
        System.out.println(shield.use());
    }
}
