package com.hashedin;

import java.io.IOException;
import java.util.HashMap;
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
	
	
	/*
	 * 
	 * Updation Functions
	 * 
	 */
	public void updateUserActivity() {
		int i=0;
		String userid;
		
		while (i < this.ratingList.size()) {
			userid = this.ratingList.get(i).getRatingUserId();
			this.userMap.get(userid).addActivity();
			i++;
		}
	}
	
	public void updateMovieRatings() {
		int i=0, ratingValue=0;
		String movieid;
		
		while (i < this.ratingList.size()) {
			movieid = this.ratingList.get(i).getRatingMovieId();
			ratingValue = this.ratingList.get(i).getRatingScore();
			this.movieMap.get(movieid).updateRatings(ratingValue);
			i++;
		}
		
		Map<String,Movie> map = this.movieMap;
		for (Map.Entry<String,Movie> entry : map.entrySet()) {
		    entry.getValue().updateAvgRating();
		}
	}
	
	/*
	 * 
	 * Warmup Functions
	 * 
	 */
	
	public void getMostActiveUser() {
		int maxActivity=0, tempActivity=0;
		String maxUserId="None", tempUserId;
		
		this.updateUserActivity();
		
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
	
	public void getMostWatchedMovie() {
		int tempNoOfRatings=0, maxNoOfRatings=0;
		String tempMovieId, popMovieId="None";
		this.updateMovieRatings();
		
		Map<String,Movie> map = this.movieMap;
		for (Map.Entry<String,Movie> entry : map.entrySet()) {
			tempMovieId = entry.getKey();
		    tempNoOfRatings = entry.getValue().getNoOfRatings();
		    if (maxNoOfRatings < tempNoOfRatings) {
		    	popMovieId = tempMovieId;
				maxNoOfRatings = tempNoOfRatings;
		    }
		}
		System.out.println("The most watched movie id is "+ popMovieId);
	}

	public void getTopRankedMovie(Map<String,Movie> movieMap) {
		String tempMovieId, topMovieId="None";
		int tempAvgRating=0, maxAvgRating=0;
		this.updateMovieRatings();
		
		Map<String,Movie> map = movieMap;
		for (Map.Entry<String,Movie> entry : map.entrySet()) {
			tempMovieId = entry.getKey();
		    tempAvgRating = entry.getValue().getAverageRating();
		    //System.out.println("gTRM checked " + tempMovieId + " with rating " + tempAvgRating);
		    if (maxAvgRating < tempAvgRating) {
		    	topMovieId = tempMovieId;
		    	maxAvgRating = tempAvgRating;
		    }
		}
		System.out.println("The top movie id for above selection is " + topMovieId + " with rating of " + maxAvgRating + ".");	
	}
	
	public Map<String, Movie> getMovieByGenre(String genreName, Map<String, Movie> selectedmap) {
		String tempMovieId, tempGenreValue;
		Movie tempMovieValue;
		
		Map<String, Movie> innermap = this.movieMap;
		for (Map.Entry<String,Movie> innerentry : innermap.entrySet()) {
			tempMovieId = innerentry.getKey();
			tempMovieValue = innerentry.getValue();
			for (int i = 0; i < tempMovieValue.getGenre().size(); i++) {
				tempGenreValue = tempMovieValue.getGenre().get(i);
				//System.out.println("In movie " + tempMovieId + " compared " + genreName + " with " + tempMovieValue.getGenre().get(i));
				if ((genreName).equals(tempGenreValue)) {
				    selectedmap.put(tempMovieId, tempMovieValue);
				}
			}
			
		}
		return selectedmap;
	}
	
	public void getTopMovieByGenre() {
		String genreName;
		
		Map<Integer, Genre> map = this.genreMap;
		for (Map.Entry<Integer, Genre> entry : map.entrySet()) {
			Map<String, Movie> selectedmap = null;
			selectedmap = new HashMap<String, Movie>();
		    genreName = entry.getValue().getGenreName();
			System.out.println("The Selected Genre is: " + genreName + ".");
		    selectedmap = this.getMovieByGenre(genreName, selectedmap);
		    this.getTopRankedMovie(selectedmap);
		}
	}
	
}
