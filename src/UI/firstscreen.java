package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Functions.*;

import java.io.IOException;
import java.util.List;

import com.sun.javafx.robot.impl.FXRobotHelper;

import Classes.*;

public class firstscreen {
	functions function;
	    @FXML
	    private TableView table;

	    @FXML
	    private TableColumn firstNames;

	    @FXML
	    private TableColumn lastNames;

	    @FXML
	    private TableColumn numbers;

	    @FXML
	    private Button add;

	    
	    @FXML
	    private Button exit;

	    @FXML
	    private TextField first;

	    @FXML
	    private TextField last;

	    @FXML
	    private TextField tel;

	    @FXML
	    private Button delete;

	    @FXML
	    private Button show;

    public firstscreen() {
    	this.function = new functions();
    	function.readGson();
    	
    }
    
    public void add() {
    	String firstName , lastName;
    	int telnum;
    	firstName = first.getText();
    	lastName = last.getText();
    	telnum = Integer.parseInt(tel.getText());
    	try {
			function.addUser(firstName, lastName, telnum);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("User is already registered!");
			alert.showAndWait();
			
		}
    	first.clear();
    	last.clear();
    	tel.clear();
    	show();
    }
    
    public void delete() {
    	String firstName , lastName;
    	firstName = first.getText();
    	lastName = last.getText();
    	try {
			function.deleteUser(firstName, lastName);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("User doesn't excist!");
			alert.showAndWait();
			
		}
    	first.clear();
    	last.clear();
    	tel.clear();
    	show();
    }
    
    public void show() {
    	List <user> userlist = function.userlist;
    	ObservableList<user> list = FXCollections.observableArrayList();
    	firstNames.setCellValueFactory(new PropertyValueFactory("firstName"));
    	lastNames.setCellValueFactory(new PropertyValueFactory("lastName"));
    	numbers.setCellValueFactory(new PropertyValueFactory("tel"));
    	
		for(int i = 0; i < userlist.size();i++) {
    		list.add(new user(userlist.get(i).getFirstName(), userlist.get(i).getLastName(),userlist.get(i).getTel()));
    	}
    	table.setItems(list);
    }
    
    public void exit(ActionEvent e) {
    	function.saveGson();
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
