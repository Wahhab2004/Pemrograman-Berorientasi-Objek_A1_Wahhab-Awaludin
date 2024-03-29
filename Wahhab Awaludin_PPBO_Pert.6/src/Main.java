import java.util.*;

public class Main {
    public static void main(String[] args) {
        Toko mebel1 = new Toko();
        mebel1.getGudangBarang().tambahBahan(Bahan.KAYU, 1000);
        mebel1.getGudangBarang().tambahBahan(Bahan.BAUT, 1000);
        mebel1.getGudangBarang().tambahBahan(Bahan.CAT, 1500);

        mebel1.getGudangBarang().buatBarang(Barang.KURSI, 5);
        mebel1.getGudangBarang().cekStokBahan();

        mebel1.getGudangBarang().buatBarang(Barang.KURSI, 5);
        mebel1.getGudangBarang().buatBarang(Barang.MEJA, 5);
        mebel1.getGudangBarang().buatBarang(Barang.LEMARI, 2);

        mebel1.getGudangBarang().tambahBahan(Bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(Bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(Bahan.CAT, 15);
        mebel1.getGudangBarang().cekStokBahan();

        mebel1.getGudangBarang().buatBarang(Barang.KURSI, 5);

        mebel1.getGudangBarang().cekIsiGudang();

        Pembeli pembeli1 = new Pembeli("hanif", Barang.KURSI, 10);
        Pembeli pembeli2 = new Pembeli("muflih", Barang.MEJA, 5);
        Pembeli pembeli3 = new Pembeli("fabih", Barang.LEMARI, 3);

        // Menambahkan Antrian
        mebel1.tambahAntrian(pembeli1);
        mebel1.tambahAntrian(pembeli2);
        mebel1.tambahAntrian(pembeli3);

        //Cek Isi Antrian
        mebel1.cekIsiAntrian();



        // Menyelesaikan Antrian
        mebel1.selesaikanAntrian();

        mebel1.cekIsiAntrian();
        mebel1.getGudangBarang().cekIsiGudang();


    }

}