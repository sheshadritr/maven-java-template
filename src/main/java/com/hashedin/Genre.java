package com.hashedin;

public class Genre {
	private String gName;
	private String gIndex;
	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgIndex() {
		return gIndex;
	}
	public void setgIndex(String gIndex) {
		this.gIndex = gIndex;
	}
	@Override
	public String toString() {
		return "Genre [gName=" + gName + ", gIndex=" + gIndex + "]";
	}
	
}
