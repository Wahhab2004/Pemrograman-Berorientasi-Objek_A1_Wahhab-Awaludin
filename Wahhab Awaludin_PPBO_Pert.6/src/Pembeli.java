import java.util.LinkedList;
import java.util.Queue;

public class Pembeli {
    Queue<Barang> antrian = new LinkedList<>();

    // Method untuk menambah pembeli ke dalam antrian
    public void tambahPembeli (Barang barang) {
        antrian.add(barang);
        System.out.println("Pembeli " + barang.nama + " ditambahkan ke dalam antrian.") ;
    }

    // Method untuk mengecek list antrian saat ini
    public void cekAntrian(){
        System.out.println("Antrian pembeli saat ini:");
        for (Barang barang : antrian) {
            System.out.println(barang.nama);
        }
    }

}