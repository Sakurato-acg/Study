package com.mysql_.数据库CRUD最终版;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbutils.DbUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {

	/**
	 * 使用Druid数据库连接池技术
	 */
	private static DataSource source;
	static{
		try {
			Properties pros = new Properties();
			
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/mysql_/数据库连接池/druid.properties");
			
			pros.load(is);

			source = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		
		Connection conn = source.getConnection();
		return conn;
	}
	
	
//	/**
//	 *
//	 * @Description 关闭连接和Statement的操作
//	 * @author shkstart
//	 * @date 上午9:12:40
//	 * @param conn
//	 * @param ps
//	 */
//	public static void closeResource(Connection conn,Statement ps){
//		try {
//			if(ps != null)
//				ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	/**
//	 *
//	 * @Description 关闭资源操作
//	 * @author shkstart
//	 * @date 上午10:21:15
//	 * @param conn
//	 * @param ps
//	 * @param rs
//	 */
//	public static void closeResource(Connection conn,Statement ps,ResultSet rs){
//		try {
//			if(ps != null)
//				ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if(conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if(rs != null)
//				rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 
	 * @Description 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
	 * @author shkstart
	 * @date 下午4:53:09
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource_(Connection conn,Statement ps,ResultSet rs){
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(rs);
	}
}
