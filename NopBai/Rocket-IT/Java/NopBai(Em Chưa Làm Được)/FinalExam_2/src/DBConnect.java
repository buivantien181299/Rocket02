import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class DBConnect {
	
	public static Connection openConnection() {
		Connection con = null;
		Properties propertiesFile = new Properties();
		try {
			propertiesFile.load(new FileInputStream("src/main/resources/jdbc.properties"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		String url = propertiesFile.getProperty("connectionString");
		String user = propertiesFile.getProperty("email");
		String password = propertiesFile.getProperty("password");
		String driver = propertiesFile.getProperty("driverSQLName");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return con;
	}

	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param con
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
}
