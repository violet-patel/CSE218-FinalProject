package application;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PostSceneController {
	@FXML
	private TextField tfSearch;
	@FXML
	private ImageView imgLogo;
	@FXML
	private Button btnSearch;
	@FXML
	private ImageView btnProfile;
	@FXML
	private ImageView btnPost;
	@FXML
	private ImageView btnHome;
	@FXML
	private ImageView btnOptions;
	@FXML
	private TextArea taPost;
	@FXML
	private ImageView imgPfp;
	@FXML
	private Label lblUsername;
	@FXML
	private Button btnPostnow;
	@FXML
	private ImageView btnLogout;
	@FXML
	private TextArea taSpellCheck;

	private DataCenter dc;
	private String currentUser;
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void setInstance(DataCenter dc, String currentUser, Parent root, Stage stage, Scene scene) {
		this.dc = dc;
		this.currentUser = currentUser;
		this.root = root;
		this.stage = stage;
		this.scene = scene;
		lblUsername.setText(currentUser);
		Image img = new Image(dc.getUser(currentUser).getPfp());
		btnProfile.setImage(img);
		imgPfp.setImage(img);
	}

	// Event Listener on Button[#btnSearch].onAction
	@FXML
	public void goToSearch(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchScene.fxml"));
		root = loader.load();
		scene = new Scene(root);
		SearchSceneController ssc = loader.getController();
		ssc.setInstance(dc, currentUser, root, stage, scene, tfSearch.getText());
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on ImageView[#btnProfile].onMouseClicked
	@FXML
	public void goToProfile(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileScene.fxml"));
		root = loader.load();
		scene = new Scene(root);
		ProfileSceneController psc = loader.getController();
		psc.setInstance(dc, currentUser, root, stage, scene, currentUser);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on ImageView[#btnHome].onMouseClicked
	@FXML
	public void goToHome(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
		root = loader.load();
		scene = new Scene(root);
		HomeSceneController hsc = loader.getController();
		hsc.setInstance(dc, currentUser, root, stage, scene);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on ImageView[#btnOptions].onMouseClicked
	@FXML
	public void goToOptions(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FXMLLoader loader = new FXMLLoader(getClass().getResource("OptionsScene.fxml"));
		root = loader.load();
		scene = new Scene(root);
		OptionsSceneController osc = loader.getController();
		osc.setInstance(dc, currentUser, root, stage, scene);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on TextArea[#taPost].onKeyTyped
	@FXML
	public void spellCheck(KeyEvent event) {
		// TODO Autogenerated
		taSpellCheck.setText("");
		String[] words = taPost.getText().split("\s+");
		LinkedList<String> misspelledWords = new LinkedList<String>();
        for (String word : words) {
        	if (!dc.containsWord(word)) {
        		misspelledWords.add(word);
            }
        }
        Iterator<String> iterator = misspelledWords.iterator();
        while (iterator.hasNext()) {
        	taSpellCheck.setText(taSpellCheck.getText() + iterator.next() + "\n");
        }
	}
	// Event Listener on Button[#btnPostnow].onAction
		@FXML
		public void doPost(ActionEvent event) throws IOException {
			// TODO Autogenerated
			Alert alert = new Alert(AlertType.INFORMATION);
			if (taPost.getText().isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("Post cannot be blank");
				alert.setHeaderText("Post Creation Unsuccessful");
				alert.showAndWait();
			}
			else {
				Post post = new Post(taPost.getText(), currentUser, dc.getPostBagSize(), false);
				dc.addPost(post);
				alert.setContentText("Post was made successfully!");
				alert.setHeaderText("Post Creation Successful");
				alert.showAndWait();
				taPost.clear();
				taSpellCheck.clear();
			}
		}
		// Event Listener on ImageView[#btnLogout].onMouseClicked
		@FXML
		public void goToLogin(MouseEvent event) throws IOException {
			// TODO Autogenerated
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
			root = loader.load();
			scene = new Scene(root);
			currentUser = "";
			LoginSceneController lsc = loader.getController();
			lsc.setInstance(dc, currentUser, root, stage, scene);
			stage.setScene(scene);
			stage.show();
		}
	}