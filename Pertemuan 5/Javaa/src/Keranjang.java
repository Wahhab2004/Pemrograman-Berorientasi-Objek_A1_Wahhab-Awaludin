import java.util.ArrayList;

public class Keranjang {

    // Menyimpan Barang
    // 1. List Keranjang -> menyimpan seluruh atribut yang ada di barang
    // 2. List Harga -> just keep the prices of thing.
    private static  ArrayList<Produk> listKeranjang = new ArrayList<>();
    private static ArrayList<Integer> listHarga = new ArrayList<>();


    // Menambah Barang ke listBarang
    public static void tambahBarang(Produk produkBaru) {
        if(totalBarang() < 5) {
            listKeranjang.add(produkBaru);
            listHarga.add(produkBaru.hargaBarang);
            System.out.println("Berhasil memasukkan ke keranjang");
        }
        else {
            System.out.println("Keranjang sudah penuh, jangan dipaksa!!");
        }
    }


    // Menghitung total harga
    public static Integer totalHarga() {
        int total = 0;
        for (int i = 0; i < listKeranjang.size(); i++) {
            total += listKeranjang.get(i).hargaBarang * listKeranjang.get(i).jumlahBarang; // Belum terlalu paham
        }
        return total;
    }


    // Menghitung total barang yang dimasukkan
    public static int totalBarang() {
        int total = 0;
        for (Produk produk : listKeranjang) { //ini belum paham
            total += produk.jumlahBarang;
        }
        return total;
    }


    // Menampilkan hasil
    public void printHasil(){
        System.out.println("Jumlah barang di Keranjang saat ini: " + totalBarang());
        System.out.println("Barang pada Keranjang:");
        for(Produk produk : listKeranjang) {
            System.out.println("# " + produk.namaBarang + ",  Harga " + produk.hargaBarang + ", Jumlah : " + produk.jumlahBarang);
        }
        System.out.println("Total Harga Yang Harus di Bayar: " + totalHarga());
    }
}
