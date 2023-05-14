package application;

import java.io.Serializable;
import java.util.TreeMap;

public class PostBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5408784417563909393L;
	private TreeMap<Integer, Post> posts;
	
	public PostBag() {
		posts = new TreeMap<Integer, Post>();
	}
	
	public Post getPost(int key) {
		return posts.get(key);
	}
	
	public void addPost(Post post) {
		posts.put(post.getKey(), post);
	}
	
	public int getSize() {
		return this.posts.size();
	}
}
