package com.wwj.ormsqlite;

@Table("user")
public class User {
	
	@Column("id")
	private int id;
	
	@Column("user_name")
	private String userName;
	
	@Column("sex")
	private byte sex;
	
	@Column("user_email")
	private String userEmail;
	
	@Column("address")
	private String address;
	
	@Column("hobby")
	private String hobby;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	

}
