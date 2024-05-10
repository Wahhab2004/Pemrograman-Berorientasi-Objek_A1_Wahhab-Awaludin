public class Vechile {
    private String brand;
    private int year;
    // Menginisiasi nilai rentalprice dan discount dgn nilai 0.0
    // Hal ini agar ketika dioperasi nilainya tidak null
    private Double rentalPrice = 0.0;
    private Double discount = 0.0;


    // Membuat default konstruktor
    public Vechile(){}

    // Membuat konstuktur dengan 3 atribut,
    // bertujuan agar atribut dapat digunakan pada subclass
    public Vechile(String brand, int year, Double rentalPrice){
        this.brand = brand;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    // Setter and Getter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {

        this.discount = discount;
    }


    // Metode diskon 10% untuk produksi kendaaraan < 2010
    public void finalPrice(int year){
        if(year < 2010) {
            discount = rentalPrice * 0.1;
        }
    }

}


