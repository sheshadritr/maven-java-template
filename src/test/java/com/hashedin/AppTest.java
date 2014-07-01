package com.hashedin;

import java.io.IOException;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException {
    	MovieManager mm = new MovieManager();
    	Map<String, Movie> movieMap = mm.getMovies(mm.getClass().getClassLoader().getResourceAsStream("test_movie.data"));
    	assertEquals(movieMap.size(),6);
    	
    	Map<String, User> userMap = mm.getUsers(mm.getClass().getClassLoader().getResourceAsStream("test_user.data"));
    	assertEquals(userMap.size(),3);
    	
    	Map<String, Rating> ratingMap = mm.getRatings(mm.getClass().getClassLoader().getResourceAsStream("test_ratings.data"));
    	assertEquals(ratingMap.size(),6);
    	
    	Map<String, Genre> genreMap = mm.getGenres(mm.getClass().getClassLoader().getResourceAsStream("test_genre.data"));
    	assertEquals(genreMap.size(),19);
    }
}
