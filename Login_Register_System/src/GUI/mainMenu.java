package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class mainMenu extends JFrame{
	
	//Dektop
	JDesktopPane desktop = new JDesktopPane();
	
	//Menu
	JMenu profile, edit;
	JMenuBar menuBar;
	
	JLabel title;
	JPanel centerPanel = new JPanel(new BorderLayout());
	
	
	public mainMenu() {		
		String titleName = "Welcome to Hextech Project (Login Success..)";
		
		title = new JLabel(titleName, SwingConstants.CENTER);
		title.setFont(new Font(null, Font.BOLD, 25));
		centerPanel.add(title);
		centerPanel.setBackground(Color.yellow);
				
//Init menubar
		
	//Menu add
		//Profile
		profile = new JMenu("Profile");
		
		//Transaction		
		edit = new JMenu("Edit");
		
	//Menu Bar
		menuBar = new JMenuBar();
		menuBar.add(profile);
		menuBar.add(edit);

		
// Frame 
		setTitle("Login Test");
		setSize(1280,720);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		add(centerPanel);
		setJMenuBar(menuBar);				
	}
	
}