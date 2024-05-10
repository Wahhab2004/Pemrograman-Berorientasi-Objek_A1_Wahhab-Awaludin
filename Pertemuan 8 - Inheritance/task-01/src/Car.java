import java.util.ArrayList;

public class Car extends Vechile {
    private CarType CarType;

    // Menginisiasi nilai cartypediscount, totaldiscount, dan finalprice
    private Double CarTypeDiscount = 0.0;
    private Double totaldiscount = 0.0;
    private Double finalPrice = 0.0;


    // Construktor
    public Car(String brand, int year, Double rentalPrice, CarType carType) {
        super(brand, year, rentalPrice);
        this.CarType = carType;
    }

    // Setter & Getter
    public void setCarType(CarType carType) {
        CarType = carType;
    }

    public CarType getCarType() {
        return CarType;
    }


    // Metode diskon untuk jenis mobil tertentu
    public void CarType(CarType carType){
        if(carType == CarType.FAMILY_CAR) {
            CarTypeDiscount = getRentalPrice() * 0.05;
            totaldiscount = CarTypeDiscount + getDiscount();
            finalPrice = getRentalPrice() - totaldiscount;
        }

        else if(carType == CarType.PREMIUM_CAR) {
            CarTypeDiscount = getRentalPrice() * 0.1;
            totaldiscount = CarTypeDiscount + getDiscount();
            finalPrice = getRentalPrice() - totaldiscount;
        }
    }

    // Metode untuk menampilkan detail mobil
    public void displayInfo(){
        System.out.println("Detail Mobil: ");
        System.out.println("Merk: " + getBrand());
        System.out.println("Tahun: " + getYear());
        System.out.println("Harga Sewa: " + getRentalPrice());
        finalPrice(getYear());
        CarType(CarType);
        System.out.println("Tipe Mobil: " + CarType);
        System.out.println("Total Diskon: " + totaldiscount);
        System.out.println("Harga sewa setelah diskon: " + finalPrice);
        System.out.println("--------------------------------------------------------------");
    }

}


// Membuat Enum dengan nama 'CarType'
enum CarType {
    PREMIUM_CAR,
    FAMILY_CAR,
    CITY_CAR
}