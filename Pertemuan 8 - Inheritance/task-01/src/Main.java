public class Main {
    public static void main(String[] args) {
        // Membuat objek
        Car innova = new Car("Innova Reborn", 2015, 500.0, CarType.PREMIUM_CAR );
        Car avanza = new Car("Avanza", 2009, 300.0, CarType.FAMILY_CAR );
        Car brio = new Car("Honda Brio", 2012, 300.0, CarType.CITY_CAR );


        // Menampilkan detail mobil dengan memanggil display info
        innova.displayInfo();
        avanza.displayInfo();
        brio.displayInfo();


        // Membuat objek atau instance class truk
        Truk isuzuTruck = new Truk("Isuzu", 2013, 500.0, 1500);
        Truk volvoTruk = new Truk("Volvo", 2013, 650.0, 2500);
        Truk hinoTruk = new Truk("Hino", 2005, 800.0, 4000);
        Truk mitsubishiTruk = new Truk("Mitsubishi", 2010, 850.0, 4000);

        // Memanggil display info dari kelas truk
        isuzuTruck.displayInfo();
        volvoTruk.displayInfo();
        hinoTruk.displayInfo();
        mitsubishiTruk.displayInfo();

    }
}