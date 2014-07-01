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
			movieMap.put(mv.getId(), mv);
			System.out.println(mv);
		}
		return movieMap;
	}

	private Movie parseMovieDataFile(String movie) {
		StringTokenizer token = new StringTokenizer(movie, "|");
		Movie mov = new Movie();
		mov.setId(token.nextToken());
		mov.setTitle(token.nextToken());
		mov.setReleaseDate(token.nextToken());
		mov.setUrl(token.nextToken());
		return mov;
	}

	public Map<String, User> getUsers(InputStream movieStream) throws IOException {

		Map<String, User> movieMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> users = IOUtils.readLines(movieStream);

		for (String movie : users) {
			User mv = parseUserDataFile(movie);
			movieMap.put(mv.getId(), mv);
			System.out.println(mv);
		}
		return movieMap;
	}

	private Movie parseUserDataFile(String movie) {
		StringTokenizer token = new StringTokenizer(movie, "|");
		Movie mov = new Movie();
		mov.setId(token.nextToken());
		mov.setTitle(token.nextToken());
		mov.setReleaseDate(token.nextToken());
		mov.setUrl(token.nextToken());
		return mov;
	}

	public static void main(String[] args) throws IOException {
		MovieManager mg = new MovieManager();
		Map<String, Movie> movieMap = mg.getMovies(mg.getClass().getClassLoader().getResourceAsStream("movie.data"));
		
	}
}