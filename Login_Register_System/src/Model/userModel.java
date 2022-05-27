package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Connector.Connect;

public class userModel {

	
	private Connect con = Connect.getInstance();
	private String Id, username, password;
	private String table = "user";
	
	
	
	public userModel() {
		
	}
	
	
	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public userModel(String id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
	}



	public userModel loginByUSandPW() {
		userModel u = null;
		String query = String.format("SELECT * FROM user WHERE username = ? AND password = ?");

		PreparedStatement ps = con.preparedStatement(query);
		
		try {
			ps.setString(1, this.username);
			ps.setString(2, this.password);
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			if(rs.next()) {
				u = new userModel(rs.getString("userID"),
						rs.getString("username"), rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}
	
/*	
	public Vector<userModel> getAll(){
		String query = "SELECT * FROM " + this.table;
		ResultSet rs = con.getData(query);	
		Vector<userModel> userList = new Vector<userModel>();	
		
		 try {
			 
			while(rs.next()) {
			String id = rs.getString("userID"),
				username = rs.getString("userName"),
				password = rs.getString("password");		
			userList.add(new userModel(id, username, password));		
			
			 }
			return userList;			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return null;		
	}
	*/

}
