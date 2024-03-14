public class Film {

    String title, genre;
    int duration, availableSeats, bookingID;

    // Konstruktor
    Film (String title, String genre, int duration, int availableSeats){
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }



}
