public  class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp(); // Class 1
        // Menambahkan beberapa film dapat di customize
        Film avenger = new Film ("Avengers: Endgame", "Action", 180, 50); // Class 2
        Film moana = new Film ("Moana", "Adventure", 240, 60); // Class 2
        movieApp.addFilm(avenger);
        movieApp.addFilm(moana);

        // Menampilan seluruh list film
        movieApp.displayAllFilms(); // Masuk Class MovieApp

        // Mencari film
        movieApp.searchFilm("Moana");
        movieApp.searchFilm("Avengers: Endgame");
        movieApp.searchFilm("Wahhab Hebat");

        // Membuat pesanan
        movieApp.bookFilm("Moana", 100);
        movieApp.bookFilm("Avengers: Endgame", 3 );

        //Memeriksa pesanan bybookingid
        //Booking Id digenerate secara random, maka untuk mencari booking id dapat disesuaikan dengan booking id masing masing
        movieApp.searchBooking(1);
        movieApp.searchBooking(4);


    }
}