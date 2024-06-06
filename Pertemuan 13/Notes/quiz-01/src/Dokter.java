class Dokter extends Orang {
    private String nomorSTR;
    private String spesialis;

    public Dokter(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String nomorSTR, String spesialis) {
        super(nama, tanggalLahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialis = spesialis;
    }

    public String getNomorRegistrasi() {
        return nomorSTR;
    }

    public String getSpesialis() {
        return spesialis;
    }
}
