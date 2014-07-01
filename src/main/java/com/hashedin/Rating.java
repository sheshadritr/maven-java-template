package com.hashedin;

public class Rating {
	private String rUserId;
	private String rMovieId;
	private String rating;
	private String timeStamp;
	
	
	public String getrUserId() {
		return rUserId;
	}
	public void setrUserId(String rUserId) {
		this.rUserId = rUserId;
	}
	public String getrMovieId() {
		return rMovieId;
	}
	public void setrMovieId(String rMovieId) {
		this.rMovieId = rMovieId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "Rating [rUserId=" + rUserId + ", rMovieId=" + rMovieId
				+ ", rating=" + rating + ", timeStamp=" + timeStamp + "]";
	}
	
}
