package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * The Model Class of the Admin Dashboard window which handles the database related functionality and logic.
 */
public class AdminModel {
	/**
	 * Takes an empty ObservableList of type StudentData that will be used to store all of the StudentData entries to display. 
	 * An sql statement is executed to retrieve each row from the students table of the school schema.
	 * Each row of the resulting result set is then added to the ObservableList that was passed in to this method.
	 * 
	 * @param data
	 * @return
	 */
	public ObservableList<StudentData> sqlLoadTable(ObservableList<StudentData> data) {
		Connection conn = null;
		Statement stmt = null;
		//The passed in ObservableList is 
		data = FXCollections.observableArrayList();
		
		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			//select all from the students table of the school schema
			String sqlRetrieve = "SELECT * FROM students";
			//the output from the executed sql query is stored in the result set
			ResultSet rs = stmt.executeQuery(sqlRetrieve);
			//for each row in the result set, store the row as a new StudentData object in the ObservableList data
			while (rs.next()) {
				data.add(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) 
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	/**
	 * Inserts an entry into the students table by using a preparedStatement to input the variables 
	 * that have been passed into the method into the placeholder values of the sql query.
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param dob
	 */
	public void sqlAddStudent(TextField firstName, TextField lastName, TextField email, DatePicker dob){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlInsert = "INSERT INTO students (first_name,last_name,email,DOB) VALUES (?,?,?,?)";
			stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, firstName.getText());
			stmt.setString(2, lastName.getText());
			stmt.setString(3, email.getText());
			stmt.setString(4, dob.getEditor().getText());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Deletes an entry in the students table by executing an sql query on the students table using the value in the ID column of 
	 * the selected row in the TableView to delete any entries in the students table that have the corresponding id value in the ID column.
	 * @param studentTable
	 */
	public void sqlDeleteStudent(TableView<StudentData> studentTable) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ObservableList<StudentData> selectedItem = studentTable.getSelectionModel().getSelectedItems();
		
		try {
			conn = DatabaseConnection.getConnection();
			String sqlDelete = "DELETE FROM students WHERE ID = ?";
			stmt = conn.prepareStatement(sqlDelete);
			stmt.setString(1, selectedItem.get(0).getID());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) 
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Inserts an entry into the login table by using a preparedStatement to input the variables 
	 * that have been passed into the method into the placeholder values of the sql query.
	 * @param adminUsername
	 * @param adminPassword
	 */
	public void sqlAddAdmin(TextField adminUsername, TextField adminPassword) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn= DatabaseConnection.getConnection();
			String sqlInsert = "INSERT INTO login (username, password) VALUES (?,?)";
			stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, adminUsername.getText());
			stmt.setString(2, adminPassword.getText());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) 
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
