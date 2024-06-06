class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;
    private boolean terdaftar;

    public Pasien(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String pekerjaan, String domisili) {
        super(nama, tanggalLahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
        this.terdaftar = false;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        rumahSakit.tambahPasien(this, keluhan, namaDokter, tipePasien);
        this.terdaftar = true;
    }

    public void periksa(RumahSakit rumahSakit) {
        if (this.terdaftar) {
            rumahSakit.periksaPasien(this);
            this.terdaftar = false;
        } else {
            System.out.println("Pasien " + this.getNama() + " belum terdaftar untuk pemeriksaan.");
        }
    }
}