package mainAPP;

import Controller.userController;
import GUI.Login;

public class Main {

	public Main() {
		userController.getInstance().showLogin();
	}

	public static void main(String[] args) {
		new Main();

	}

}
