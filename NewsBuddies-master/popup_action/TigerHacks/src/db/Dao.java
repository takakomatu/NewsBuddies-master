package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection cn;
	{
	try {
		cn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/sys",
			"Oliver", "NewsBuddies");	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createUrl(Data urlToSave) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call create_url(?)}");
			stmt.setString(1,urlToSave.getUrl());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int n = 1;
				urlToSave.setUrlID(r.getInt(n++));
				urlToSave.setUrl(r.getString(n++));
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void createRating(Data ratingToSave) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call create_rating(?,?,?,?,?,?)}");
			int n = 1;
			stmt.setInt(n++, ratingToSave.getUserID());
			stmt.setInt(n++, ratingToSave.getUrlID());
			stmt.setInt(n++, ratingToSave.getBrating());
			stmt.setInt(n++, ratingToSave.getQrating());
			stmt.setInt(n++, ratingToSave.getRelvrating());
			stmt.setInt(n++, ratingToSave.getRelyrating());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int x = 1;
				ratingToSave.setRatingID(r.getInt(x++));
				ratingToSave.setUrlID(r.getInt(x++));
				ratingToSave.setUserID(r.getInt(x++));
				ratingToSave.setBrating(r.getInt(x++));
				ratingToSave.setQrating(r.getInt(x++));
				ratingToSave.setRelvrating(r.getInt(x++));
				ratingToSave.setRelyrating(r.getInt(x++));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void createUser (Data userToSave) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call create_user(?,?,?)}");
			int n = 1;
			stmt.setString(n++, userToSave.getUsername());
			stmt.setInt(n++, userToSave.getPassword());
			stmt.setString(n++, userToSave.getEmail());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int x = 1;
				userToSave.setUserID(r.getInt(x++));
				userToSave.setUsername(r.getString(x++));
				userToSave.setPassword(r.getString(x++));
				userToSave.setEmail(r.getString(x++));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void updateUrl (Data urlToUpdate) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call update_url(?,?)}");
			int n = 1;
			stmt.setInt(n++, urlToUpdate.getUrlID());
			stmt.setString(n++, urlToUpdate.getUrl());
			stmt.executeQuery();
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void updateRating (Data ratingToUpdate) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call update_rating(?,?,?,?,?,?,?)}");
			int n = 1;
			stmt.setInt(n++, ratingToUpdate.getRatingID());
			stmt.setInt(n++, ratingToUpdate.getUrlID());
			stmt.setInt(n++, ratingToUpdate.getUserID());
			stmt.setInt(n++, ratingToUpdate.getBrating());
			stmt.setInt(n++, ratingToUpdate.getQrating());
			stmt.setInt(n++, ratingToUpdate.getRelvrating());
			stmt.setInt(n++, ratingToUpdate.getRelyrating());
			stmt.executeQuery();
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void updateUser (Data userToUpdate) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call update_user(?,?,?,?)}");
			int n = 1;
			stmt.setInt(n++, userToUpdate.getUserID());
			stmt.setString(n++, userToUpdate.getUsername());
			stmt.setInt(n++, userToUpdate.getPassword());
			stmt.setString(n++, userToUpdate.getEmail());
			stmt.executeQuery();
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void loadUrl (Data urlToLoad) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call load_url(?)}");
			stmt.setInt(1,urlToLoad.getUrlID());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int n = 1;
				urlToLoad.setUrlID(r.getInt(n++));
				urlToLoad.setUrl(r.getString(n++));
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void loadRating (Data ratingToLoad) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call load_rating(?)}");
			stmt.setInt(1, ratingToLoad.getRatingID());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int x = 1;
				ratingToLoad.setRatingID(r.getInt(x++));
				ratingToLoad.setUrlID(r.getInt(x++));
				ratingToLoad.setUserID(r.getInt(x++));
				ratingToLoad.setBrating(r.getInt(x++));
				ratingToLoad.setQrating(r.getInt(x++));
				ratingToLoad.setRelvrating(r.getInt(x++));
				ratingToLoad.setRelyrating(r.getInt(x++));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void loadUser (Data userToLoad) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call load_user(?)}");
			stmt.setInt(1, userToLoad.getUserID());
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				int x = 1;
				userToLoad.setUserID(r.getInt(x++));
				userToLoad.setUsername(r.getString(x++));
				userToLoad.setPassword(r.getString(x++));
				userToLoad.setEmail(r.getString(x++));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void deleteUrl (Data urlToDelete) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call delete_url(?)}");
			stmt.setInt(1, urlToDelete.getUrlID());
			stmt.executeQuery();
		
			urlToDelete.setUrlID(0);
			urlToDelete.setUrl("");
	
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void deleteRating (Data ratingToDelete) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call delete_rating(?)}");
			stmt.setInt(1, ratingToDelete.getRatingID());
			stmt.executeQuery();
			
			ratingToDelete.setRatingID(0);
			ratingToDelete.setUrlID(0);
			ratingToDelete.setUserID(0);
			ratingToDelete.setBrating(0);
			ratingToDelete.setQrating(0);
			ratingToDelete.setRelvrating(0);
			ratingToDelete.setRelyrating(0);
				
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public void deleteUser (Data userToDelete) {
		try {
			CallableStatement stmt;
			stmt = cn.prepareCall("{call delete_user(?)}");
			stmt.setInt(1, userToDelete.getUserID());
			stmt.executeQuery();
			userToDelete.setUserID(0);
			userToDelete.setUsername("");
			userToDelete.setPassword("");
			userToDelete.setEmail("");
			} catch (SQLException e) {
			e.printStackTrace();
			}
		
	
		
	}
}
	/*try {
	CallableStatement stmt;
	stmt = cn.prepareCall("{call addURL(?)}");
	stmt.setString(0, pUrl);
	ResultSet r = stmt.executeQuery();
	} catch (SQLException e) {
	e.printStackTrace();
	}*/
