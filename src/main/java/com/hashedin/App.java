package com.hashedin;

import java.io.IOException;


public class App {
    public static void main( String[] args ) throws IOException {
    	MovieFreak freak = new MovieFreak();
    	
		MovieManager manager1 = new MovieManager();
		freak.setFreakGenreMap(manager1.getGenreMap(manager1.getClass().getClassLoader().getResourceAsStream("genre.data")));
		freak.setFreakMovieMap(manager1.getMovieMap(manager1.getClass().getClassLoader().getResourceAsStream("movie.data"), freak.getFreakGenreMap()));
		freak.setFreakUserMap(manager1.getUserMap(manager1.getClass().getClassLoader().getResourceAsStream("user.data")));
		freak.setFreakRatingList(manager1.getRatingList(manager1.getClass().getClassLoader().getResourceAsStream("ratings.data")));
		
		
        freak.getMostActiveUser();
        freak.getMostWatchedMovie();
        freak.getTopMovieByGenre();
    }
}
