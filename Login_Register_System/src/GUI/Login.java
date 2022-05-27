package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connector.Connect;
import Controller.userController;


public class Login extends JFrame implements ActionListener{

	
	//Component Panel and Layout
	JPanel mainPanel, csPanel, northPanel;	
	JPanel usernamePanel, passwordPanel, textPanel, showPanel, btnPanel, uPanel, pPanel;
	
	//Components
	JLabel title, usernameLbl, passwordLbl;
	JTextField usernameTxt;
	JPasswordField passwordFd;
	JButton loginBtn;
	
	//CheckBox
	JCheckBox show;
	
	//Connector
	private Connect con = Connect.getInstance();
	
	void frame() {
		// Frame 
		setTitle("HP01 - Simple Login");
		setSize(400,250);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);				
		add(mainPanel);
		
	}
		
	public Login() {
	
//North and Center
		//Components
		title = new JLabel("Welcome and Hola People !");
		title.setFont((new Font("Monaco", Font.BOLD, 14)));
		
		usernameLbl = new JLabel("Username :");
		passwordLbl = new JLabel("Password :");
		
		usernameTxt = new JTextField();
		usernameTxt.setPreferredSize(new Dimension (270,20));
		passwordFd = new JPasswordField();
		passwordFd.setPreferredSize(new Dimension (270,20));
		
		uPanel = new JPanel();
		uPanel.add(usernameTxt);
		pPanel = new JPanel();
		pPanel.add(passwordFd);
				
		//Panel Comps
		usernamePanel = new JPanel(new FlowLayout());
		usernamePanel.add(usernameLbl);
		usernamePanel.add(uPanel);
		passwordPanel = new JPanel(new FlowLayout());
		passwordPanel.add(passwordLbl);
		passwordPanel.add(pPanel);
		
		//Panel
		textPanel = new JPanel(new GridLayout(2,1));
		textPanel.add(usernamePanel);
		textPanel.add(passwordPanel);

	//Panel
		northPanel = new JPanel(new BorderLayout(0,7));
		northPanel.add(title, BorderLayout.NORTH);
		northPanel.add(textPanel, BorderLayout.WEST);
		northPanel.setBorder(new EmptyBorder(10,5,10,5));
		

//Center and South
		
		//Components
		loginBtn = new JButton("Login");		
		btnPanel = new JPanel();
		btnPanel.add(loginBtn);
		
		//CheckBox
		show = new JCheckBox("Show Password");
		showPanel = new JPanel();
		showPanel.add(show);
		
		//Panel
		csPanel = new JPanel(new GridLayout(2,1));
		csPanel.add(showPanel);
		csPanel.add(btnPanel);
						
		
//Main
		//Init Panel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(csPanel, BorderLayout.CENTER);
		mainPanel.setBorder(new EmptyBorder(0,5,0,5));
		
		
		//Action Listener
		loginBtn.addActionListener(this);
		show.addActionListener(this);
		
		
		frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object click = e.getSource();
		
		if(click == loginBtn) {
			String username = usernameTxt.getText(),
					password = passwordFd.getText();			
	
			if(username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Username / Password must be filled","Login", JOptionPane.WARNING_MESSAGE);
			}			
			else {
				userController.getInstance().login(username, password);
			}				
		}
		
		
		else if (click == show) {
			if(show.isSelected()) {
				passwordFd.setEchoChar((char)0);
			}
			else {
				passwordFd.setEchoChar('*');
			}
		}		
	}

}
