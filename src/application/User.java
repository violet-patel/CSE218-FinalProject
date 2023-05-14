package application;

import java.io.Serializable;
import java.util.TreeSet;


public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1286902404953208095L;
	private String username;
	private String password;
	private String pfp;
	private TreeSet<String> following;
	private TreeSet<String> followers;
	
	public User(String user, String pass) {
		username = user;
		password = pass;
		following = new TreeSet<String>();
		followers = new TreeSet<String>();
		pfp = "https://cdn.discordapp.com/attachments/816386280170061894/1053056050435203173/avatar.png";
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPfp() {
		return pfp;
	}
	
	public void setPfp(String pfp) {
		this.pfp = pfp;
	}
	
	public TreeSet<String> getFollowing() {
		return following;
	}
	
	public TreeSet<String> getFollowers() {
		return followers;
	}
	
	public void addFollowing(String user) {
		following.add(user);
	}
	
	public void addFollower(String user) {
		followers.add(user);
	}
	
	public boolean isFollowing(String user) {
		return following.contains(user);
	}
	
	public void unfollow(String user) {
		following.remove(user);
	}
	
	public void removeFollower(String user) {
		followers.remove(user);
	}
}
