//
package com.vti.FinalExam.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.vti.FinalExam.form.LoginForm;
import com.vti.FinalExam.view.UserView;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Apr 12, 2020
 */
public class Loginrepository implements ILoginrepository {

	private Connection getDatabase() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties propertiesFile = new Properties();
		propertiesFile.load(new FileInputStream("src/main/resource/database.properties"));

		String url = propertiesFile.getProperty("connectionString");
		String user = propertiesFile.getProperty("username");
		String password = propertiesFile.getProperty("password");
		String driver = propertiesFile.getProperty("driverSQLName");

		Class.forName(driver);

		// B1: get a Database Connection
		return DriverManager.getConnection(url, user, password);
	}

	/*
	 * @see
	 * com.vti.FinalExam.repository.ILoginrepository#login(com.vti.FinalExam.form.
	 * LoginForm)
	 */
	public UserView login(LoginForm input) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		Connection connect = getDatabase();
		
		String sqlStatemnet = "Seclect Email, Password from `user`";
		Statement sql = connect.createStatement();
		ResultSet rs = sql.executeQuery(sqlStatemnet);
		
		while(rs.next()){
	         
	       return new UserView().setEmail(rs.getString("Email")).setPass(rs.getString("Password"));

	      }
		
		return null;
	}

}
