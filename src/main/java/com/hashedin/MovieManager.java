package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class MovieManager {

	public Map<String, Movie> getMovies(InputStream movieStream) throws IOException {
		Map<String, Movie> movieMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> movies = IOUtils.readLines(movieStream);
		for (String movie : movies) {
			Movie mv = parseMovieDataFile(movie);
			movieMap.put(mv.getMovieId(), mv);
			System.out.println(mv);
		}
		return movieMap;
	}
	private Movie parseMovieDataFile(String movie) {
		StringTokenizer token = new StringTokenizer(movie, "|");
		Movie mov = new Movie();
		mov.setMovieId(token.nextToken());
		mov.setTitle(token.nextToken());
		mov.setReleaseDate(token.nextToken());
		mov.setUrl(token.nextToken());
		return mov;
	}

	
	public Map<String, User> getUsers(InputStream userStream) throws IOException {
		Map<String, User> userMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> users = IOUtils.readLines(userStream);
		for (String user : users) {
			User u = parseUserDataFile(user);
			userMap.put(u.getUserId(), u);
			System.out.println(u);
		}
		return userMap;
	}

	private User parseUserDataFile(String user) {
		StringTokenizer token = new StringTokenizer(user, "|");
		User u = new User();
		u.setUserId(token.nextToken());
		u.setAge(token.nextToken());
		u.setGender(token.nextToken());
		u.setOccupation(token.nextToken());
		u.setZipcode(token.nextToken());
		return u;
	}

	
	public Map<String, Rating> getRatings(InputStream ratingStream) throws IOException {
		Map<String, Rating> ratingMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> ratings = IOUtils.readLines(ratingStream);
		for (String rating : ratings) {
			Rating r = parseRatingDataFile(rating);
			ratingMap.put(r.getrUserId(), r);
			System.out.println(r);
		}
		return ratingMap;
	}

	private Rating parseRatingDataFile(String rating) {
		rating = rating.replaceAll(" ", "|");
		rating = rating.replaceAll("\t", "|");
		StringTokenizer token = new StringTokenizer(rating, "|");
		Rating r = new Rating();
		r.setrUserId(token.nextToken());
		r.setrMovieId(token.nextToken());
		r.setRating(token.nextToken());
		r.setTimeStamp(token.nextToken());
		return r;
	}
	
	
	public static void main(String[] args) throws IOException {
		MovieManager mg = new MovieManager();
//		Map<String, Movie> movieMap = mg.getMovies(mg.getClass().getClassLoader().getResourceAsStream("movie.data"));
//		Map<String, User> userMap = mg.getUsers(mg.getClass().getClassLoader().getResourceAsStream("user.data"));
		Map<String, Rating> ratingMap = mg.getRatings(mg.getClass().getClassLoader().getResourceAsStream("ratings.data"));
		
	}
}