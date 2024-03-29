

public class Pembeli {
    private String nama;
    private Barang barangDibeli;
    private int jumlah;

    public Pembeli(String nama, Barang barangDibeli, int jumlah) {
        this.nama = nama;
        this.barangDibeli = barangDibeli;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public Barang getBarangDibeli() {
        return barangDibeli;
    }

    public int getJumlah() {
        return jumlah;
    }
}
