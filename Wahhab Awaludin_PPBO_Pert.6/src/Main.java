import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Gudang {
    private HashMap<gudang.bahan, Integer> stokBahan = new HashMap<>();
    private HashMap<toko.tipeBarang, Integer> stokBarang = new HashMap<>();

    Gudang() {
        // Inisialisasi stok bahan
        stokBahan.put(gudang.bahan.KAYU, 0);
        stokBahan.put(gudang.bahan.BAUT, 0);
        stokBahan.put(gudang.bahan.CAT, 0);

        // Inisialisasi stok barang
        stokBarang.put(toko.tipeBarang.KURSI, 0);
        stokBarang.put(toko.tipeBarang.MEJA, 0);
        stokBarang.put(toko.tipeBarang.LEMARI, 0);
    }

    void tambahBahan(gudang.bahan jenisBahan, int jumlah) {
        stokBahan.put(jenisBahan, stokBahan.getOrDefault(jenisBahan, 0) + jumlah);
    }

    void kurangiBahan(gudang.bahan jenisBahan, int jumlah) {
        stokBahan.put(jenisBahan, Math.max(0, stokBahan.getOrDefault(jenisBahan, 0) - jumlah));
    }

    void buatBarang(toko.tipeBarang jenisBarang, int jumlah) {
        int kayuDiperlukan = 0, bautDiperlukan = 0, catDiperlukan = 0;

        switch (jenisBarang) {
            case KURSI:
                kayuDiperlukan = 2 * jumlah;
                bautDiperlukan = 10 * jumlah;
                catDiperlukan = jumlah;
                break;
            case MEJA:
                kayuDiperlukan = 3 * jumlah;
                bautDiperlukan = 20 * jumlah;
                catDiperlukan = 2 * jumlah;
                break;
            case LEMARI:
                kayuDiperlukan = 5 * jumlah;
                bautDiperlukan = 30 * jumlah;
                catDiperlukan = 3 * jumlah;
                break;
        }

        // Cek apakah bahan mencukupi
        if (stokBahan.getOrDefault(gudang.bahan.KAYU, 0) >= kayuDiperlukan &&
                stokBahan.getOrDefault(gudang.bahan.BAUT, 0) >= bautDiperlukan &&
                stokBahan.getOrDefault(gudang.bahan.CAT, 0) >= catDiperlukan) {

            // Kurangi stok bahan
            kurangiBahan(gudang.bahan.KAYU, kayuDiperlukan);
            kurangiBahan(gudang.bahan.BAUT, bautDiperlukan);
            kurangiBahan(gudang.bahan.CAT, catDiperlukan);

            // Tambah stok barang
            stokBarang.put(jenisBarang, stokBarang.getOrDefault(jenisBarang, 0) + jumlah);
            System.out.println("Barang " + jenisBarang + " sebanyak " + jumlah + " berhasil dibuat.");
        } else {
            System.out.println("Stok bahan tidak mencukupi untuk membuat barang " + jenisBarang);
        }
    }

    void cekStokBahan() {
        System.out.println("Stok bahan saat ini:");
        for (gudang.bahan jenisBahan : gudang.bahan.values()) {
            System.out.println(jenisBahan + ": " + stokBahan.getOrDefault(jenisBahan, 0));
        }
    }

    void cekIsiGudang() {
        System.out.println("Stok barang di gudang saat ini:");
        for (toko.tipeBarang jenisBarang : toko.tipeBarang.values()) {
            System.out.println(jenisBarang + ": " + stokBarang.getOrDefault(jenisBarang, 0));
        }
    }
}

class toko {
    enum tipeBarang {
        KURSI,
        MEJA,
        LEMARI
    }

    private Queue<pembeli> antrian = new LinkedList<>();
    private Gudang gudangBarang = new Gudang();

    Gudang getGudangBarang() {
        return gudangBarang;
    }

    void tambahAntrian(pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("Pembeli " + pembeli.nama + " ditambahkan ke dalam antrian.");
    }

    void cekIsiAntrian() {
        System.out.println("Antrian saat ini:");
        for (pembeli pembeli : antrian) {
            System.out.println("Nama: " + pembeli.nama + ", Barang: " + pembeli.jenisBarang + ", Jumlah: " + pembeli.jumlah);
        }
    }

    void selesaikanAntrian() {
        while (!antrian.isEmpty()) {
            pembeli currPembeli = antrian.poll();
            if (gudangBarang.getStokBarang().getOrDefault(currPembeli.jenisBarang, 0) >= currPembeli.jumlah) {
                gudangBarang.getStokBarang().put(currPembeli.jenisBarang,
                        gudangBarang.getStokBarang().get(currPembeli.jenisBarang) - currPembeli.jumlah);
                System.out.println("Pembeli " + currPembeli.nama + " telah selesai membeli " + currPembeli.jumlah + " " + currPembeli.jenisBarang);
            } else {
                System.out.println("Stok barang " + currPembeli.jenisBarang + " tidak mencukupi untuk pembeli " + currPembeli.nama);
            }
        }
    }
}

class pembeli {
    String nama;
    toko.tipeBarang jenisBarang;
    int jumlah;

    pembeli(String nama, toko.tipeBarang jenisBarang, int jumlah) {
        this.nama = nama;
        this.jenisBarang = jenisBarang;
        this.jumlah = jumlah;
    }
}

public class Main {
    public static void main(String[] args) {
        toko mebel1 = new toko();
        mebel1.getGudangBarang().tambahBahan(gudang.bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(gudang.bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(gudang.bahan.CAT, 15);
        mebel1.getGudangBarang().buatBarang(toko.tipeBarang.K
