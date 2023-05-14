package application;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.TreeSet;

public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 173718805284092028L;
	private String text;
	private String user;
	private String time;
	private int key;
	private LinkedList<Integer> replies;
	private boolean isReply;
	private TreeSet<String> likes;
	
	public Post(String text, String user, int key, boolean isReply) {
		this.text = text;
		this.user = user;
        this.time = new SimpleDateFormat("MM-dd-yyyy HH:mm").format(new Date());
		this.key = key;
		this.isReply = isReply;
		this.replies = new LinkedList<Integer>();
		this.likes = new TreeSet<String>();
	}

	public String getText() {
		return text;
	}

	public String getUser() {
		return user;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getKey() {
		return key;
	}
	
	public boolean isReply() {
		return isReply;
	}
	
	public int getRepliesSize() {
		return replies.size();
	}
	
	public void addReply(int key) {
		replies.add(key);
	}
	
	public int getReply(int index) {
		return replies.get(index);
	}
	
	public boolean containsReply(int key) {
		return replies.contains(key);
	}
	
	public void addLike(String user) {
		likes.add(user);
	}
	
	public void removeLike(String user) {
		likes.remove(user);
	}
	
	public boolean isLiked(String user) {
		return likes.contains(user);
	}
	
	public int likesSize() {
		return likes.size();
	}

}
