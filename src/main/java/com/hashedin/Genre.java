package com.hashedin;

public class Genre {
	private int genreIndex;
	private String genreName;
	
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public int getGenreIndex() {
		return genreIndex;
	}
	public void setGenreIndex(int genreIndex) {
		this.genreIndex = genreIndex;
	}
	@Override
	public String toString() {
		return "Genre [genreName=" + genreName + ", genreIndex=" + genreIndex
				+ "]";
	}
	public Genre(String genreName, int genreIndex) {
		super();
		this.genreName = genreName;
		this.genreIndex = genreIndex;
	}
	public Genre() {
		super();
		this.genreName = "";
		this.genreIndex = -1;
	}
	
}
