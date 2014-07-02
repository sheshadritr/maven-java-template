package com.hashedin;

public class Rating {
	private String ratingUserId;
	private String ratingMovieId;
	private int ratingScore;
	private String ratingTimeStamp;
	
	public String getRatingUserId() {
		return ratingUserId;
	}
	public void setRatingUserId(String ratingUserId) {
		this.ratingUserId = ratingUserId;
	}
	public String getRatingMovieId() {
		return ratingMovieId;
	}
	public void setRatingMovieId(String ratingMovieId) {
		this.ratingMovieId = ratingMovieId;
	}
	
	public int getRatingScore() {
		return ratingScore;
	}
	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	public String getRatingTimeStamp() {
		return ratingTimeStamp;
	}
	public void setRatingTimeStamp(String ratingTimeStamp) {
		this.ratingTimeStamp = ratingTimeStamp;
	}
	@Override
	public String toString() {
		return "Rating [ratingUserId=" + ratingUserId + ", ratingMovieId="
				+ ratingMovieId + ", ratingScore=" + ratingScore
				+ ", ratingTimeStamp=" + ratingTimeStamp + "]";
	}
	
	public Rating() {
		super();
		this.ratingUserId = "";
		this.ratingMovieId = "";
		this.ratingScore = 0;
		this.ratingTimeStamp = "";
	}
	
}
