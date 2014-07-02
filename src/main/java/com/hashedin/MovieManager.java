package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class MovieManager {

	public Map<String, Movie> getMovieMap(InputStream movieStream, Map<Integer, Genre> genreMap) throws IOException {
		Map<String, Movie> movieMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> movies = IOUtils.readLines(movieStream);
		for (String movie : movies) {
			Movie mv = parseMovieDataFile(movie, genreMap);
			movieMap.put(mv.getMovieId(), mv);
			//System.out.println(mv);
		}
		return movieMap;
	}
	private Movie parseMovieDataFile(String movie, Map<Integer, Genre> genreMap) {
		StringTokenizer token = new StringTokenizer(movie, "|");
		List<String> list = new ArrayList<String>();
		//String genre;
		Movie mov = new Movie();
		mov.setMovieId(token.nextToken());
		mov.setTitle(token.nextToken());
		mov.setReleaseDate(token.nextToken());
		mov.setUrl(token.nextToken());
		for(int i=0; i<=18; i++) {
			if(token.nextToken().equals("1"))
			{
				Genre value =  (Genre) genreMap.get(i);
				list.add(value.getGenreName());
			}	
			if(!token.hasMoreTokens())
			{
			  break;
			}
		}
		mov.setGenre(list);
		return mov;
	}

	
	public Map<String, User> getUserMap(InputStream userStream) throws IOException {
		Map<String, User> userMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> users = IOUtils.readLines(userStream);
		for (String user : users) {
			User u = parseUserDataFile(user);
			userMap.put(u.getUserId(), u);
			//System.out.println(u);
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

	
	public List<Rating> getRatingList(InputStream ratingStream) throws IOException {
		List<Rating> ratingList = new ArrayList<Rating>();
		@SuppressWarnings("unchecked")
		List<String> ratings = IOUtils.readLines(ratingStream);
		for (String rating : ratings) {
			Rating r = parseRatingDataFile(rating);
			ratingList.add(r);
			//System.out.println(r);
		}
		return ratingList;
	}
	private Rating parseRatingDataFile(String rating) {
		rating = rating.replaceAll(" ", "|");
		rating = rating.replaceAll("\t", "|");
		StringTokenizer token = new StringTokenizer(rating, "|");
		Rating r = new Rating();
		r.setRatingUserId(token.nextToken());
		r.setRatingMovieId(token.nextToken());
		r.setRatingScore(Integer.parseInt(token.nextToken()));
		r.setRatingTimeStamp(token.nextToken());
		return r;
	}
	
	
	public Map<Integer, Genre> getGenreMap(InputStream genreStream) throws IOException {
		Map<Integer, Genre> genreMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<String> genres = IOUtils.readLines(genreStream);
		for (String genre : genres) {
			Genre g = parseGenreDataFile(genre);
			genreMap.put(g.getGenreIndex(), g);
			//System.out.println(g);
		}
		return genreMap;
	}
	private Genre parseGenreDataFile(String genre) {
		StringTokenizer token = new StringTokenizer(genre, "|");
		Genre g = new Genre();
		g.setGenreName(token.nextToken());
		g.setGenreIndex(Integer.parseInt(token.nextToken()));
		return g;
	}


}