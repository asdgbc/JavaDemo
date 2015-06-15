package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author chenxuex
 *
 */
public class ConnectJDBCDemo {

	// 驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR 包中
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
	//"jdbc:mysql://localhost/"
	public static final String DBURL = "jdbc:mysql://192.168.1.44:3306/";
	// 连接数据库的用户名
	public static final String DBUSER = "root";
	// 连接数据库的密码
	public static final String DBPASS = "123456";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;  //表示数据库的更新操作  
        ResultSet result = null; //表示接收数据库的查询结果  
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = conn.createStatement();
			result = stmt.executeQuery("select id from yuqing.t_article_info");
			while (result.next()){
				System.out.println(result.getInt("id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
