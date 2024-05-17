public class Salesman extends Employee {
    private int target, penjualan, totalGaji;

    // Construktor
    public Salesman(String name, String departemen, String kelamin) {
        super(name, departemen, kelamin);
        setJabatan("Pegawai");
    }


    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }


    // Mengatur THR
    public void setTHR(){
        if(penjualan >= target) {
            totalGaji = getGaji() * 2;
            setThr(totalGaji);

        }
        else {
            totalGaji = getGaji();
            setThr(totalGaji);
        }
    }


    // Menampilkan Informasi Pegawai
    public void displayInfo(){
        System.out.println("Jabatan : " + getJabatan());
        System.out.println("Nama : " + getName());
        System.out.println("Departemen : " + getDepartemen());
        System.out.println("NIP : " + getNip());
        System.out.println("Gaji : " + getGaji());
        setTHR();
        System.out.println("THR : " + getThr() );
        System.out.println("Cuti : " + getCuti());
    }
}
