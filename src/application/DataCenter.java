package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DataCenter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9025997061358749157L;
	private UserBag userBag;
	private PostBag postBag;
	private HashSet<String> dictionary;
	
	public DataCenter() throws IOException {
		File dataCenter = new File("src\\application\\data.dat");
		if (dataCenter.length()==0) {
			userBag = new UserBag();
			postBag = new PostBag();
			dictionary = new HashSet<String>();
			try (BufferedReader reader = new BufferedReader(new FileReader("res\\dictionary.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                dictionary.add(line.trim());
	            }
	        }
			this.save();
		}
		try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataCenter))) {
			DataCenter dc = (DataCenter)(ois.readObject());
			userBag = dc.userBag;
			postBag = dc.postBag;
			dictionary = dc.dictionary;
		}
		catch (IOException | ClassNotFoundException ie) {
			ie.printStackTrace();
		} 
	}
	
	public Set<String> getListofUsers() {
		return userBag.getListofUsers();
	}
	
	public void addUser(User user) {
		userBag.addUser(user);
		this.save();
	}
	
	public void addPost(Post post) {
		postBag.addPost(post);
		this.save();
	}
	
	public User getUser(String key) {
		return userBag.getUser(key);
	}
	
	public Post getPost(int key) {
		return postBag.getPost(key);
	}
	
	public PostBag getPostBag() {
		return postBag;
	}
	
	public void save() {
		File dataCenter = new File("src\\application\\data.dat");
		try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataCenter))) {
			oos.writeObject(this);
		}
		catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public int getPostBagSize() {
		return this.postBag.getSize();
	}
	
	public boolean containsWord(String word) {
		return dictionary.contains(word);
	}
}
