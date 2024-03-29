import java.util.LinkedList;
import java.util.Queue;

public class Toko {
    private Gudang gudang;
    public Gudang getGudangBarang() {
        return gudang;
    }

    private Queue<Pembeli> antrian;

    public Toko() {
        gudang = new Gudang();
        antrian = new LinkedList<>();
    }



    public void tambahAntrian(Pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("berhasil menambah antrian");
    }

    // Perlu diperbaiki
    public void cekIsiAntrian() {
        System.out.println("\nLIST ANTRIAN : ");
        int i = 1;
        for (Pembeli pembeli : antrian) {
            System.out.println("antrian ke " + i + ", nama : " + pembeli.getNama() + ", barang di beli " + pembeli.getBarangDibeli() +
                    ", jumlah barang di beli : " + pembeli.getJumlah());
            i++;
        }
    }

    public void selesaikanAntrian() {
        int i = 1;
        while (!antrian.isEmpty()) {
            Pembeli pembeli = antrian.poll();
            Barang barang = pembeli.getBarangDibeli();
            int jumlah = pembeli.getJumlah();
            if (gudang.getStokBarang().getOrDefault(barang, 0) >= jumlah) {
                gudang.getStokBarang().put(barang, gudang.getStokBarang().get(barang) - jumlah);
                System.out.println("\n" + jumlah + " " + barang + " berhasil dikeluarkan dari gudang");
                System.out.println("Antrian ke-" + i + " berhasil diselesaikan");
            } else {
                System.out.println("Sisa antrian gagal diselesaikan");
                antrian.add(pembeli);
                break;

            }
            i++;
        }

        if (!antrian.isEmpty()) {
            System.out.println("\nDaftar antrian yang belum terpenuhi:");

        }
    }



}
