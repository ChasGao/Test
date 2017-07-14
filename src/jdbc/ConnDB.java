package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * pls/ql
 * @author gaochao
 *
 */
public class ConnDB {

	
	
	public static void main(String[] args) {
//			new ConnDB().getConnection4MySQL();
		new ConnDB().query();
		
		
	}
	
	/**
	 * 连接oracle
	 * @return
	 */
	private  Connection getConnection4Oracle(){
		Connection con = null;// 创建一个数据库连接
		try {
			System.out.println("开始连接oracle");
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user="";
			String password="";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("连接oracle成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 连接mysql
	 * @return
	 */
	private  Connection getConnection4MySQL(){
		Connection con = null;// 创建一个数据库连接
		try {
			System.out.println("开始连接MySQL");
			Class.forName("com.mysql.jdbc.Driver");// 加载Oracle驱动程序
			String url="jdbc:mysql://127.0.0.1:3306/credit";
			String user="root";
			String password="a123";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("连接MySQL成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}	
	/**
	 * 
	 */
	public void query(){
//		Connection con=getConnection4Oracle();
		Connection con=getConnection4MySQL();
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
	    
		String sql="select  * from user where  id = ?";
		
		try {
			System.out.println("开始查询");
			pre=con.prepareStatement(sql);//使用预编译
			//sql参数赋值
			pre.setInt(1, 1);
			result = pre.executeQuery();
			while(result.next()){
				int id=result.getInt("id");
				String name=result.getString("name");
				System.out.println("name:"+ name);
			}
			System.out.println("查询结束");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源。关闭顺序：最后使用的最先关闭。
			try {
				if(result!=null)	result.close();
				if(pre != null)		pre.close();
				if (con != null)	con.close();
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
		
	}

}
