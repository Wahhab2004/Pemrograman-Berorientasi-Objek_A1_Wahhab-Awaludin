import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produk barang1 = new Produk("Beras", 40000, 2);
        Produk barang2 = new Produk("Sabun", 20000, 1);
        Produk barang3 = new Produk("Susu", 5000, 2);
        Produk barang4 = new Produk("Le Mineral", 7000, 1);


        Keranjang keranjang1 = new Keranjang();
        keranjang1.tambahBarang(barang1);
        keranjang1.tambahBarang(barang2);
        keranjang1.tambahBarang(barang3);
        keranjang1.tambahBarang(barang4);

        System.out.println("\n ======================= \n");

        keranjang1.printHasil();

    }

}