import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class RumahSakit {
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private List<Dokter> daftarDokter;
    private Map<Pasien, String> antrianPasien;

    public RumahSakit(String nama, String alamat, String nomorTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.daftarDokter = new ArrayList<>();
        this.antrianPasien = new HashMap<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (!daftarDokter.contains(dokter)) {
            daftarDokter.add(dokter);
            System.out.println("SUKSES");
        } else {
            System.out.println("DOKTER SUDAH TERDAFTAR");
        }
    }

    public void cekListDokter() {
        if(!daftarDokter.isEmpty()) {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("============================================");
            int urutAngka = 1;
            for (Dokter dokter : daftarDokter) {
                System.out.println(urutAngka + ". Nama Dokter : " + dokter.getNama() + " spesialis : " + dokter.getSpesialis());
                urutAngka++;
            }

        }else {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        }
    }

    public void tambahPasien(Pasien pasien, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        boolean dokterTersedia = false;
        for (Dokter dokter : daftarDokter) {
            if (dokter.getNama().equals(namaDokter)) {
                dokterTersedia = true;
                break;
            }
        }

        if (dokterTersedia) {
            if (!antrianPasien.containsKey(pasien)) {
                antrianPasien.put(pasien, keluhan + ", Dokter: " + namaDokter + ", Tipe: " + tipePasien);
                System.out.println("SUKSES");
            } else {
                System.out.println("PASIEN SUDAH TERDAFTAR");
            }
        } else {
            System.out.println("DOKTER TERSEBUT TIDAK TERSEDIA");
        }
    }


    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("==============================================");

        // Map untuk menyimpan antrian pasien berdasarkan nama dokter
        Map<String, List<Pasien>> antrianDokter = new HashMap<>();

        // Inisialisasi list antrian untuk setiap dokter
        for (Dokter dokter : daftarDokter) {
            antrianDokter.put(dokter.getNama(), new ArrayList<>());
        }

        // Masukkan pasien ke dalam antrian berdasarkan nama dokter
        for (Map.Entry<Pasien, String> entry : antrianPasien.entrySet()) {
            Pasien pasien = entry.getKey();
            String[] info = entry.getValue().split(", ");
            String namaDokter = info[1].split(": ")[1];

            antrianDokter.get(namaDokter).add(pasien);
        }

        // Tampilkan antrian untuk setiap dokter
        for (Dokter dokter : daftarDokter) {
            System.out.println("DR. " + dokter.getNama());
            List<Pasien> antrian = antrianDokter.get(dokter.getNama());
            if (antrian.isEmpty()) {
                System.out.println("ANTRIAN KOSONG");
            } else {
                for (int i = 0; i < antrian.size(); i++) {
                    Pasien pasien = antrian.get(i);
                    System.out.println("ID ANTRIAN: " + (i + 1) + ", Atas nama: " + pasien.getNama());
                }
            }
            System.out.println("===============");
        }
    }


    public void periksaPasien(Pasien pasien) {
        if (antrianPasien.containsKey(pasien)) {
            System.out.println("Pasien " + pasien.getNama() + " sedang diperiksa.");
            antrianPasien.remove(pasien);
        } else {
            System.out.println("Pasien " + pasien.getNama() + " tidak ada dalam antrian.");
        }
    }
}