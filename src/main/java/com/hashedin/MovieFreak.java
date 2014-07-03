package com.hashedin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MovieFreak {
	
	private Map<String, Movie> freakMovieMap;
	private Map<String, User> freakUserMap;
	private List<Rating> freakRatingList;
	private Map<Integer, Genre> freakGenreMap;
	
	public Map<String, Movie> getFreakMovieMap() {
		return freakMovieMap;
	}
	public void setFreakMovieMap(Map<String, Movie> freakMovieMap) {
		this.freakMovieMap = freakMovieMap;
	}

	public Map<String, User> getFreakUserMap() {
		return freakUserMap;
	}
	public void setFreakUserMap(Map<String, User> freakUserMap) {
		this.freakUserMap = freakUserMap;
	}
	
	public List<Rating> getFreakRatingList() {
		return freakRatingList;
	}
	public void setFreakRatingList(List<Rating> freakRatingList) {
		this.freakRatingList = freakRatingList;
	}

	public Map<Integer, Genre> getFreakGenreMap() {
		return freakGenreMap;
	}
	public void setFreakGenreMap(Map<Integer, Genre> freakGenreMap) {
		this.freakGenreMap = freakGenreMap;
	}

	public MovieFreak(Map<String, Movie> movieMap, Map<String, User> userMap,
			List<Rating> ratingList, Map<Integer, Genre> genreMap) {
		super();
		this.freakMovieMap = movieMap;
		this.freakUserMap = userMap;
		this.freakRatingList = ratingList;
		this.freakGenreMap = genreMap;
	}
	
	public MovieFreak() {
		super();
		this.freakMovieMap = null;
		this.freakUserMap = null;
		this.freakRatingList = null;
		this.freakGenreMap = null;
	}
	/*
	 * 
	 * Updation Functions
	 * 
	 */
	public void updateUserActivity() {
		int i=0;
		String userid;
		
		while (i < this.freakRatingList.size()) {
			userid = this.freakRatingList.get(i).getRatingUserId();
			this.freakUserMap.get(userid).addActivity();
			i++;
		}
	}
	
	public void updateMovieRatings() {
		int i=0, ratingValue=0;
		String movieid;
		
		while (i < this.freakRatingList.size()) {
			movieid = this.freakRatingList.get(i).getRatingMovieId();
			ratingValue = this.freakRatingList.get(i).getRatingScore();
			this.freakMovieMap.get(movieid).updateRatings(ratingValue);
			i++;
		}
		
		Map<String,Movie> map = this.freakMovieMap;
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
		
		Map<String,User> map = this.freakUserMap;
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
		
		Map<String,Movie> map = this.freakMovieMap;
		for (Map.Entry<String,Movie> entry : map.entrySet()) {
		    tempNoOfRatings = entry.getValue().getNoOfRatings();
		    tempMovieId = entry.getValue().getTitle();
		    if (maxNoOfRatings < tempNoOfRatings) {
		    	popMovieId = tempMovieId;
				maxNoOfRatings = tempNoOfRatings;
		    }
		}
		System.out.println("The most watched movie is "+ popMovieId);
	}

	public void getTopRankedMovie(Map<String,Movie> movieMap) {
		String tempMovie, topMovie="None";
		float tempAvgRating=0, maxAvgRating=0;
		//this.updateMovieRatings();
		
		Map<String,Movie> map = movieMap;
		for (Map.Entry<String,Movie> entry : map.entrySet()) {
		    tempAvgRating = entry.getValue().getAverageRating();
		    tempMovie = entry.getValue().getTitle();
		    //System.out.println("gTRM checked " + tempMovie + " with rating " + tempAvgRating);
		    if (maxAvgRating < tempAvgRating) {
		    	topMovie = tempMovie;
		    	maxAvgRating = tempAvgRating;
		    }
		}
		System.out.println("The top movie for above selection is " + topMovie + " with rating of " + maxAvgRating + ".");	
	}
	
	public Map<String, Movie> getMovieByGenre(String genreName, Map<String, Movie> selectedmap) {
		String tempMovieId, tempGenreValue;
		Movie tempMovieValue;
		
		Map<String, Movie> innermap = this.freakMovieMap;
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
		
		Map<Integer, Genre> map = this.freakGenreMap;
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
