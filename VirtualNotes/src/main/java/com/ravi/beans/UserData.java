package com.ravi.beans;

public class UserData {
	private int id;
	private String title;
	private String content;
	private UserDetails user;

	public UserData() {
		super();
	}

	public UserData(int id, String title, String content, UserDetails user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", title=" + title + ", content=" + content + ", user=" + user + "]";
	}

}
