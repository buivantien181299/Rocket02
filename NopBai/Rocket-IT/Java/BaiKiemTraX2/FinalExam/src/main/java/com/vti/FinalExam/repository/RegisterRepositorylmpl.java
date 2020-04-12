//
package com.vti.FinalExam.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.vti.FinalExam.form.RegisterEmployeeInput;
import com.vti.FinalExam.form.RegisterManagerInput;
import com.vti.FinalExam.form.RegisterUserInput;

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
public class RegisterRepositorylmpl implements IRegisterRepositoryUser {

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
	 * com.vti.FinalExam.repository.IRegisterRepositoryUser#registerUser(com.vti.
	 * FinalExam.form.RegisterUserInput)
	 */
	public int registerUser(RegisterUserInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		Connection connection = getDatabase();

		String sqlStatemnet = "INSERT INTO `user` (Email, `Password`, FirstName, LastName, Phone) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlStatemnet);

		preparedStatement.setString(1, input.getEmail());
		preparedStatement.setString(2, input.getPassword());
		preparedStatement.setString(3, input.getFirstName());
		preparedStatement.setString(4, input.getLastName());
		preparedStatement.setString(5, input.getPhone());

		return preparedStatement.executeUpdate();

	}

	/*
	 * @see
	 * com.vti.FinalExam.repository.IRegisterRepositoryUser#registerManager(com.vti.
	 * FinalExam.form.RegisterManagerInput)
	 */
	public int registerManager(RegisterManagerInput input)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		Connection connection = getDatabase();

		String sqlStatemnet = "INSERT INTO Manager (IDUser, ExpInYear) VALUES (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlStatemnet);

		preparedStatement.setInt(1, input.getId());
		preparedStatement.setInt(2, input.getExpInYear());
		return preparedStatement.executeUpdate();
	}

	/*
	 * @see
	 * com.vti.FinalExam.repository.IRegisterRepositoryUser#registerEmployee(com.vti
	 * .FinalExam.form.RegisterEmployeeInput)
	 */
	public int registerEmployee(RegisterEmployeeInput input) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection connection = getDatabase();

		String sqlStatemnet = "INSERT INTO Employee (IDUser, projectName, proSkill) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlStatemnet);

		preparedStatement.setInt(1, input.getId());
		preparedStatement.setString(2, input.getProjectName());
		preparedStatement.setString(3, input.getProSkill());
		
		return preparedStatement.executeUpdate();
		
	}

}
