import java.util.HashMap;
import java.util.Map;

public class Gudang {

    Map<String, Integer> bahan = new HashMap<>();
    Map<String, Integer> stokBarang = new HashMap<>();

    int maxKursi = 20;
    int maxMeja = 10;
    int maxLemari = 5;

    public Gudang () {
        // Inisialisasi bahan di gudang
        bahan.put("kayu", 100);
        bahan.put("baut", 500);
        bahan.put("cat", 50);


        // Inisialisasi stok barang di gudang
        stokBarang.put("kursi", 0);
        stokBarang.put("meja", 0);
        stokBarang.put("lemari", 0);
    }

    // Method untuk mengecek ketersediaan bahan
    public boolean cekBahan(Barang barang) {
        return bahan.get("kayu") >= barang.kayu && bahan.get("baut") >= barang.baut && bahan.get("cat") >=barang.cat;


    }

    // Method untuk mengecek ketersediaan stok barang
    public boolean cekStok (Barang barang) {
        if (barang.nama.equals("kursi")){
            return  stokBarang.get("kursi") < maxKursi;
        }else if (barang.nama.equals("meja")) {
            return stokBarang.get("meja") < maxMeja;

        } else if (barang.nama.equals("lemari")) {
            return stokBarang.get("lemari") < maxLemari;


        }
        return false;

    }

    // Method untuk mengecek ketersediaan barang
    public boolean cekKetersediaan (Barang barang) {
        return cekBahan(barang) && cekStok(barang);
    }

    // Method untuk merestok bahan digudang
    public void restokBarang (String namaBahan, int jumlah) {
        if(bahan.containsKey(namaBahan)) {
            bahan.put(namaBahan, bahan.get(namaBahan) + jumlah);
            System.out.println("Bahan " + namaBahan + " berhasil direstok.");
        } else {
            System.out.println("Bahan " + namaBahan + " tidak ditemukan.");
        }
    }

    // Method untuk mengurangi stok bahan di gudang
    public void kurangiBahan(Barang barang) {
        bahan.put("kayu", bahan.get("kayu") - barang.kayu);
        bahan.put("baut", bahan.get("baut") - barang.baut);
        bahan.put("cat", bahan.get("cat") - barang.cat);
    }

    // Method untuk memproduksi barang
    public void produksiBarang(Barang barang) {
        if(cekKetersediaan(barang)) {
            kurangiBahan(barang);
            stokBarang.put(barang.nama, stokBarang.get(barang.nama + 1));
            System.out.println("Berhasil memproduksi " + barang.nama);

        }else {
            System.out.println("Gagal memproduksi " + barang.nama + ". Bahan tidak mencukupi");
        }
    }

    // Method untuk mengecek stok barang di gudang
    public void cekStokBarang() {
        System.out.println("Stok Barang di Gudang: ");
        for(Map.Entry<String, Integer> entry : stokBarang.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
