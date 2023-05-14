package application;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;

public class UserBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6123247247745002752L;
	private TreeMap<String, User> users;
	
	public UserBag() {
		users = new TreeMap<String, User>();
	}
	
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public User getUser(String key) {
		return users.get(key);
	}
	
	public Set<String> getListofUsers() {
		return users.keySet();
	}
}
