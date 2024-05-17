public class Employee {
    private String name, departemen, kelamin, nip;
    private int gaji = 0;
    private int thr = 0;
    private int totalCuti = 12;
    private String jabatan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
    public String getKelamin() {
        return kelamin;
    }
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
    public String getNip() {
        return nip;
    }
    public int getGaji() {
        return gaji;
    }
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }
    public int getCuti() {
        return totalCuti;
    }
    public void setCuti(int cuti) {
        this.totalCuti += cuti;
    }

    public int getThr() {
        return thr;
    }

    public void setThr(int thr) {
        this.thr = thr;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }


    // Mengatur NIP dengan argumen String
    public void setNip(String nip) {
        this.nip = nip;
        if(nip.charAt(0) == 'P') {
            this.thr = gaji;
        } else if (nip.charAt(0) == 'M') {
            this.thr = gaji * 2;
        }
    }

    // Overloading
    // Mengatur NIP dengan argumen Integer
    public void setNip(int employeeOrder) {
        char employeeType;

        // Menentukan tipe karyawan berdasarkan urutan masuk
        if (employeeOrder % 3 == 1) {
            employeeType = 'P'; // Pegawai
        } else if (employeeOrder % 3 == 2) {
            employeeType = 'P'; // Salesman
        } else {
            employeeType = 'M'; // Manager
        }

        // Mengatur NIP Integer
        this.nip = employeeType + String.format("%04d", employeeOrder);
        if(nip.charAt(0) == 'P') {
            this.thr = gaji;
        } else if (nip.charAt(0) == 'M') {
            this.thr = gaji * 2;
        }

    }


    // Mengatur lama waktu libur
    public void setCuti(String cuti) {
        if(cuti == "pernikahan") {
            this.totalCuti+= 2;
        }

        else if(cuti.contains("persalinan")){
            if(kelamin.equalsIgnoreCase("L")) {
                this.totalCuti += 3;
            }
            else if(kelamin.equalsIgnoreCase("P")) {
                this.totalCuti += 90;

            }
        }
    }


    // Construktor
    public Employee(String name, String departemen, String kelamin) {
        this.name = name;
        this.departemen = departemen;
        this.kelamin = kelamin;

    }

    public Employee(){};


    // Menampilkan Informasi Pegawai
    public void displayInfo(){
        System.out.println("Jabatan : " + getJabatan());
        System.out.println("Nama : " + name);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji : " + gaji);
        System.out.println("THR : " + thr );
        System.out.println("Cuti : " + totalCuti);
        System.out.println("==========================================");
        System.out.println();
    }
}
