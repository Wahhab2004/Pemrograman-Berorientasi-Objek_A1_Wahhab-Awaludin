public class Truk extends Vechile {
    private int cargoCapacity;

    // Menginisasi nilai discountcargo, discountotal, dan finalprice
    private Double discountCargo = 0.0;
    private Double discountTotal = 0.0;
    private Double finalPrice = 0.0;


    // Construktor
    public Truk(String brand, int year, Double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }


    // Setter & Getter
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }


    // Metode diskon untuk truk dgn kapasitas kargo > 2000kg
    public void cargoCapacity(int cargoCapacity) {
        if(cargoCapacity > 2000) {
            discountCargo = getRentalPrice() * 0.1;
            discountTotal = discountCargo + getDiscount();
            finalPrice = getRentalPrice() - discountTotal;
        }
    }


    // Metode untuk menampilkan Detail Truk
    public void displayInfo(){
        System.out.println("Detail Truk: ");
        System.out.println("Merk: " + getBrand());
        System.out.println("Tahun: " + getYear());
        System.out.println("Harga Sewa: " + getRentalPrice());
        finalPrice(getYear());
        cargoCapacity(cargoCapacity);
        System.out.println("Kapasitas Kargo: " + cargoCapacity);
        System.out.println("Total diskon: " + discountTotal);
        System.out.println("Harga sewa setelah diskon: " + finalPrice);
        System.out.println("--------------------------------------------------------------");

    }
}
