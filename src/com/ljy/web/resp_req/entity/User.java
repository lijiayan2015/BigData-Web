package com.ljy.web.resp_req.entity;

import java.util.Arrays;

public class User {
	private String user;
	private String pwd;
	private String sex;
	private String[] hobby;
	private String area;

	public User() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", pwd=" + pwd + ", sex=" + sex + ", hobby=" + Arrays.toString(hobby) + ", area="
				+ area + "]";
	}

}
