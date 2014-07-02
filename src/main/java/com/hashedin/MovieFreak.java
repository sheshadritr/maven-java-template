package com.hashedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;


public class MovieFreak {
	
	private Map<String, Movie> movieMap;
	private Map<String, User> userMap;
	private List<Rating> ratingList;
	private Map<Integer, Genre> genreMap;
	
	public Map<String, Movie> getMovieMap() {
		return movieMap;
	}
	public void setMovieMap(Map<String, Movie> movieMap) {
		this.movieMap = movieMap;
	}
	public Map<String, User> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}
	public List<Rating> getRatingMap() {
		return ratingList;
	}
	public void setRatingMap(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	public Map<Integer, Genre> getGenreMap() {
		return genreMap;
	}
	public void setGenreMap(Map<Integer, Genre> genreMap) {
		this.genreMap = genreMap;
	}
	
	
	public MovieFreak(Map<String, Movie> movieMap, Map<String, User> userMap,
			List<Rating> ratingList, Map<Integer, Genre> genreMap) {
		super();
		this.movieMap = movieMap;
		this.userMap = userMap;
		this.ratingList = ratingList;
		this.genreMap = genreMap;
	}
	
	public MovieFreak() throws IOException {
		super();
		MovieManager manager1 = new MovieManager();
		this.genreMap = manager1.getGenreMap(manager1.getClass().getClassLoader().getResourceAsStream("genre.data"));
		this.movieMap = manager1.getMovieMap(manager1.getClass().getClassLoader().getResourceAsStream("movie.data"), this.genreMap);
		this.userMap = manager1.getUserMap(manager1.getClass().getClassLoader().getResourceAsStream("user.data"));
		this.ratingList = manager1.getRatingList(manager1.getClass().getClassLoader().getResourceAsStream("ratings.data"));
		
	}
	

	public void getMostActiveUser() {
		int i=0, maxActivity=0, tempActivity=0;
		String userid, maxUserId="None", tempUserId;
		
		while (i < this.ratingList.size()) {
			userid = this.ratingList.get(i).getRatingUserId();
			this.userMap.get(userid).addActivity();
			i++;
		}
		
		Map<String,User> map = this.userMap;
		for (Map.Entry<String,User> entry : map.entrySet()) {
			tempUserId = entry.getKey();
		    tempActivity = entry.getValue().getActivity();
		    if (maxActivity < tempActivity) {
				maxUserId = tempUserId;
				maxActivity = tempActivity;
		    }
		}
		System.out.println("The most Active user id is "+ maxUserId);
	}
	
	public void getMostPopularMovie() {
		
	}
}
