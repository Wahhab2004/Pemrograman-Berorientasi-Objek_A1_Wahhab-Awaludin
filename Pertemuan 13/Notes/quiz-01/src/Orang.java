enum JENIS_KELAMIN {
    LAKI_LAKI,
    PEREMPUAN
}

class Orang {
    protected String nama;
    protected String tanggalLahir;
    protected JENIS_KELAMIN jenisKelamin;

    public Orang(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public JENIS_KELAMIN getJenisKelamin() {
        return jenisKelamin;
    }
}