package org.tomass.twitch;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

	private List<String> follows;
	private List<String> chatlogs;
	private String user;
	private String message;

	public AppConfig() {
		follows = new ArrayList<>();
		chatlogs = new ArrayList<>();
	}

	public List<String> getFollows() {
		return follows;
	}

	public void setFollows(List<String> follows) {
		this.follows = follows;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getChatlogs() {
		return chatlogs;
	}

	public void setChatlogs(List<String> chatlogs) {
		this.chatlogs = chatlogs;
	}

	@Override
	public String toString() {
		return "AppConfig [follows=" + follows + ", chatlogs=" + chatlogs + ", user=" + user + ", message=" + message
				+ "]";
	}

}
