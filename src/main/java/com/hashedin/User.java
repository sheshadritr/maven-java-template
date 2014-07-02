package com.hashedin;

public class User {
	private String userId;
	private String age;
	private String gender;
	private String occupation;
	private String zipcode;
	private int activity;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", age=" + age + ", gender=" + gender
				+ ", occupation=" + occupation + ", zipcode=" + zipcode
				+ ", activity=" + activity + "]";
	}

	public User() {
		super();
		this.userId = "";
		this.age = "";
		this.gender = "";
		this.occupation = "";
		this.zipcode = "";
		this.activity = 0;
	}
	
	public void addActivity() {
		this.activity++;
	}
}