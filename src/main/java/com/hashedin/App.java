package com.hashedin;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
    	MovieFreak freak = new MovieFreak();
        System.out.println( "Hello World!" );
        freak.getMostActiveUser();
        freak.getMostWatchedMovie();
        freak.getTopMovieByGenre();
    }
}
