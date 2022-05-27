package Controller;

import javax.swing.JOptionPane;

import Connector.Connect;
import GUI.Login;
import GUI.mainMenu;
import Model.userModel;

public class userController {

	public static userController instance = null;
	private Connect con = Connect.getInstance();
	private userModel userList;
	private Login login;
	
	
	public static userController getInstance() {
		if(instance == null) instance = new userController();
		return instance;
	}
	
	
	public userController() {
		userList = new userModel();
	}
	
	
	public void login(String username, String password) {
		userList.setUsername(username);
		userList.setPassword(password);
		userModel result = userList.loginByUSandPW();
		
		if(result == null) {
			JOptionPane.showMessageDialog(null, "Invalid Username / Password !", "Login", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			login.dispose();
			new mainMenu();
		}
		
	}
	
	public void showLogin() {
		login = new Login();
	}

}
