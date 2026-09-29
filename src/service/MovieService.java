package service;

import model.Movie;
import model.MovieType;

public class MovieService {

    // Array of Movie objects
    private Movie[] movies;

    // Constructor
    public MovieService() {

        movies = new Movie[5];

        movies[0] = new Movie(
                1,
                "Avengers: Endgame",
                MovieType.ACTION,
                200.0,
                50
        );

        movies[1] = new Movie(
                2,
                "Interstellar",
                MovieType.SCI_FI,
                180.0,
                40
        );

        movies[2] = new Movie(
                3,
                "3 Idiots",
                MovieType.COMEDY,
                150.0,
                60
        );

        movies[3] = new Movie(
                4,
                "The Conjuring",
                MovieType.HORROR,
                170.0,
                30
        );

        movies[4] = new Movie(
                5,
                "Taare Zameen Par",
                MovieType.DRAMA,
                130.0,
                45
        );
    }

    // Display all movies
    public void displayMovies() {

        System.out.println(
                "\n================ AVAILABLE MOVIES ================"
        );

        System.out.printf(
                "%-5s %-25s %-12s %-12s %-10s%n",
                "ID",
                "Movie",
                "Genre",
                "Price",
                "Seats"
        );

        System.out.println(
                "---------------------------------------------------"
        );

        // Loop through array
        for (Movie movie : movies) {

            if (movie == null) {
                continue;
            }

            movie.displayMovie();
        }

        System.out.println(
                "==================================================="
        );
    }

    // Find a movie using its ID
    public Movie findMovie(int id) {

        for (Movie movie : movies) {

            if (movie != null && movie.getMovieId() == id) {
                return movie;
            }
        }

        return null;
    }
}