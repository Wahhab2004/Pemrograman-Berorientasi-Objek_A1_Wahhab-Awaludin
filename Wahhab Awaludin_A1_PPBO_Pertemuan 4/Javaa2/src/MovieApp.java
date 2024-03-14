import java.util.ArrayList;
public class MovieApp {

    private static ArrayList<Film> listMovie = new ArrayList<>();
    private static int bookingCounter = 1;

    // Menambah Film ke listMovie
    public void addFilm(Film newFilm) {
        listMovie.add(newFilm);
    }

    // Mencari film
    public static void searchFilm(String title) {
        boolean found = false;

        for (Film film : listMovie) {
            if(film.title.equalsIgnoreCase(title)) {
                System.out.println("Film tersedia");
                found = true;
                break;
            }
        } if(!found){

            System.out.println("Film tidak tersedia");

        }
    }


    // Book Film
    public static void bookFilm(String title, int numbersOfTicket){
        System.out.println();
        boolean found = false;
        for (Film film : listMovie) {
            if(film.title.equalsIgnoreCase(title)){
                found = true;
                if(film.availableSeats >= numbersOfTicket) {

                    film.availableSeats -= numbersOfTicket;
                    int bookingID = generateBookingID(); // ini belum tau
                    film.setBookingID(bookingID); // Set bookingiD pada Film
                    System.out.println("Pesanan berhasil dengan detail pesanan: ");
                    System.out.println("Film " + title);
                    System.out.println("Jumlah ticket: " + numbersOfTicket);
                    System.out.println("Booking ID: " + bookingID);
                    film.bookingID = bookingID;

            } else {
                    System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
                }
                break;
            }
        }

        if(!found) {
            System.out.println("Film tidak ditemukan.");
            System.out.println();
        }
        System.out.println();
    }


    private  static int generateBookingID() {
        return bookingCounter++;
    }

    // Mencari Book ID
    public static void searchBooking(int bookingID) {
        boolean found = false;
        for (Film film : listMovie) {

            // Mengecek pada film terhadap no bookingID
            if(film.bookingID == bookingID) {
                found = true;
                System.out.println("Pesanan ditemukan");
                break;
            }
        }
        if(!found) {
            System.out.println("Pesanan tidak ditemukan");
        }
    }


    // Menampilkan seluruh list film
    public void displayAllFilms(){
        System.out.println("List of Films: ");
        for (Film film : listMovie) {
            System.out.println(film.title + " - " + "genre: " + film.genre + "Durations: " + film.duration + " mins" + " - " + "Availabe Seats: " + film.availableSeats);

        }
        System.out.println();
    }
}
