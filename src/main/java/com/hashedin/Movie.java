package com.hashedin;

public class Movie {
	private String movieId;
	private String title;
	private String releaseDate;
	private String url;
	
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
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title
				+ ", releaseDate=" + releaseDate + ", url=" + url + "]";
	}
	
}
