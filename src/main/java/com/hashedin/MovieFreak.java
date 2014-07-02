package com.hashedin;

import java.io.IOException;
import java.util.List;
import java.util.Map;


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
	public void getmostActiveUser() {
		int i=0;
		InputStream ratingline = 
		List<String> rating = IOUtils.readLines(ratingline);
		Integer[] rat = new Integer[rating.size()];
		for(String item : rating){
			Rating mrt = parseRatingDataFile(item);
		    rat[i++] = mrt.getRatingUserId();
		}
		int max = maxelement(rat);
		System.out.println("The most Active user is"+ max);
		
	}
	
	
/*	@SuppressWarnings("unchecked")
	
	private int maxelement(Integer[] rat) {
		int count = 1, tempCount;
		int popular = rat[0];
		int temp = 0;
		for (int i = 0; i < (rat.length - 1); i++) {
			temp = rat[i];
			tempCount = 0;
			for (int j = 1; j < rat.length; j++) {
				if (temp == rat[j])
					tempCount++;
			}
			if (tempCount > count) {
			    popular = temp;
			    count = tempCount;
			}
		}
		return popular;
	}
*/
}
