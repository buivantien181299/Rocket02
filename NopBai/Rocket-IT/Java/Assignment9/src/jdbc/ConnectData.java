//
package jdbc;
import java.sql.*;
import java.util.Properties;

import utils.Constant;



/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 31, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 31, 2020
 */
public class ConnectData {
	
	
	
	/**
	 * This method  connect data  . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 * @return
	 */
	public static Connection connect() {
		try {
			 Connection connection = null;
			// if connect is null or close then connect again
			if (null == connection || connection.isClosed()) {
				// register the driver class with DriverManager
				Class.forName(Constant.DRIVER_SQL_NAME);

				// set username & password SQL
				Properties properties = new Properties();
				properties.setProperty("user", Constant.DATABASE_USERNAME);
				properties.setProperty("password", Constant.DATABASE_PASSWORD);

				// open connect
				connection = DriverManager.getConnection(Constant.CONNECTION_STRING, properties);
			}
			
		} catch (SQLException e) {
			System.out.println(Constant.ERROR_CONNECT_DATABASE_STR);
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(Constant.ERROR_DRIVER_NAME);
			System.out.println(e);
		}
		return connect();
		
	}

	
	/**
	 * This method is close connect data . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
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
