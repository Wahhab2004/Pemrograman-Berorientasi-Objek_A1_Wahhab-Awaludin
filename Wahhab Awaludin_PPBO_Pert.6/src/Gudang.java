import java.util.HashMap;
import java.util.Map;


public class Gudang {


    private Map<Bahan, Integer> stokBahan;
    private Map<Barang, Integer> stokBarang;
    private final int MAX_KURSI = 20;
    private final int MAX_MEJA = 10;
    private final int MAX_LEMARI = 5;


    public Map<Barang, Integer> getStokBarang() {
        return stokBarang;
    }

    public void cekStokBahan() {
        System.out.println("\nSTOK BAHAN:");
        for (Map.Entry<Bahan, Integer> entry : stokBahan.entrySet()) {
            System.out.println("jumlah " + entry.getKey() + ", saat ini adalah: " + entry.getValue() + " buah");
        }
        System.out.println();
    }

    public void cekIsiGudang() {
        System.out.println("\nISI GUDANG :");

        // Mendapatkan jumlah barang dari gudang
        int jumlahMeja = stokBarang.getOrDefault(Barang.MEJA, 0);
        int jumlahKursi = stokBarang.getOrDefault(Barang.KURSI, 0);
        int jumlahLemari = stokBarang.getOrDefault(Barang.LEMARI, 0);

        // Mencetak jumlah barang untuk setiap jenis barang
        System.out.println("Jumlah MEJA, saat ini adalah: " + jumlahMeja + " buah");
        System.out.println("Jumlah KURSI, saat ini adalah: " + jumlahKursi + " buah");
        System.out.println("Jumlah LEMARI, saat ini adalah: " + jumlahLemari + " buah");
        System.out.println();
    }

    public Gudang() {
        stokBahan = new HashMap<>();
        stokBarang = new HashMap<>();
    }

    public void tambahBahan(Bahan jenisBahan, int jumlah) {
        stokBahan.put(jenisBahan, stokBahan.getOrDefault(jenisBahan, 0) + jumlah);
    }


    public void buatBarang(Barang jenisBarang, int jumlah) {
        switch (jenisBarang) {
            case KURSI:
                if (stokBahan.getOrDefault(Bahan.KAYU, 0) >= jumlah * 2 &&
                        stokBahan.getOrDefault(Bahan.BAUT, 0) >= jumlah * 10 &&
                        stokBahan.getOrDefault(Bahan.CAT, 0) >= jumlah * 1 &&
                        stokBarang.getOrDefault(Barang.KURSI, 0) + jumlah <= MAX_KURSI) {
                    stokBahan.put(Bahan.KAYU, stokBahan.get(Bahan.KAYU) - jumlah * 2);
                    stokBahan.put(Bahan.BAUT, stokBahan.get(Bahan.BAUT) - jumlah * 10);
                    stokBahan.put(Bahan.CAT, stokBahan.get(Bahan.CAT) - jumlah * 1);
                    stokBarang.put(Barang.KURSI, stokBarang.getOrDefault(Barang.KURSI, 0) + jumlah);
                    System.out.println(jumlah + " KURSI berhasil ditambahkan ke gudang");
                } else {
                    System.out.println("KUSI tidak dapat ditambahkan, bahan tidak cukup");
                }
                break;

            case MEJA:
                if (stokBahan.getOrDefault(Bahan.KAYU, 0) >= jumlah * 3 &&
                        stokBahan.getOrDefault(Bahan.BAUT, 0) >= jumlah * 20 &&
                        stokBahan.getOrDefault(Bahan.CAT, 0) >= jumlah * 2 &&
                        stokBarang.getOrDefault(Barang.MEJA, 0) + jumlah <= MAX_MEJA) {
                    stokBahan.put(Bahan.KAYU, stokBahan.get(Bahan.KAYU) - jumlah * 3);
                    stokBahan.put(Bahan.BAUT, stokBahan.get(Bahan.BAUT) - jumlah * 20);
                    stokBahan.put(Bahan.CAT, stokBahan.get(Bahan.CAT) - jumlah * 2);
                    stokBarang.put(Barang.MEJA, stokBarang.getOrDefault(Barang.MEJA, 0) + jumlah);
                    System.out.println(jumlah + " MEJA berhasil ditambahkan ke gudang");
                } else {
                    System.out.println("MEJA tidak dapat ditambahkan, bahan tidak cukup");
                }
                break;
            case LEMARI:
                if (stokBahan.getOrDefault(Bahan.KAYU, 0) >= jumlah * 5 &&
                        stokBahan.getOrDefault(Bahan.BAUT, 0) >= jumlah * 30 &&
                        stokBahan.getOrDefault(Bahan.CAT, 0) >= jumlah * 3 &&
                        stokBarang.getOrDefault(Barang.LEMARI, 0) + jumlah <= MAX_LEMARI) {
                    stokBahan.put(Bahan.KAYU, stokBahan.get(Bahan.KAYU) - jumlah * 5);
                    stokBahan.put(Bahan.BAUT, stokBahan.get(Bahan.BAUT) - jumlah * 30);
                    stokBahan.put(Bahan.CAT, stokBahan.get(Bahan.CAT) - jumlah * 3);
                    stokBarang.put(Barang.LEMARI, stokBarang.getOrDefault(Barang.LEMARI, 0) + jumlah);
                    System.out.println(jumlah + " LEMARI berhasil ditambahkan ke gudang");
                } else {
                    System.out.println("LEMARI tidak dapat ditambahkan, bahan tidak cukup");
                }
                break;
        }
    }






}

enum Bahan {
    KAYU, BAUT, CAT
}

enum Barang {
    KURSI, MEJA, LEMARI
}
