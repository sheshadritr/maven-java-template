package com.hashedin;

import java.util.List;

public class Movie {
	private String movieId;
	private String title;
	private String releaseDate;
	private String url;
	private int sumOfRatings;
	private int noOfRatings;
	private float averageRating;
	private List<String> genre;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSumOfRatings() {
		return sumOfRatings;
	}
	public void setSumOfRatings(int sumOfRatings) {
		this.sumOfRatings = sumOfRatings;
	}
	public int getNoOfRatings() {
		return noOfRatings;
	}
	public void setNoOfRatings(int noOfRatings) {
		this.noOfRatings = noOfRatings;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	
	public void updateRatings(int ratingvalue) {
		this.noOfRatings++;
		this.sumOfRatings = this.sumOfRatings + ratingvalue;
	}
	public void updateAvgRating() {
		this.averageRating = (float) this.sumOfRatings / this.noOfRatings;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title
				+ ", releaseDate=" + releaseDate + ", url=" + url
				+ ", sumOfRatings=" + sumOfRatings + ", noOfRatings="
				+ noOfRatings + ", genre=" + genre + "]";
	}
	
	public Movie() {
		super();
		this.movieId = "";
		this.title = "";
		this.releaseDate = "";
		this.url = "";
		this.sumOfRatings = 0;
		this.noOfRatings = 0;
		this.averageRating = 0;
		this.genre = null;
	}
	
}
