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
//			String url="jdbc:oracle:thin:@10.5.9.62:1521:ORCL";//我本地数据库地址
//			String user="scott";
//			String password="tiger";
			String url="jdbc:oracle:thin:@10.1.45.52:1521:test52";
			String user="lisro";
			String password="lisro";
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
		Connection con=getConnection4Oracle();
//		Connection con=getConnection4MySQL();
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
		String sql="select  * from lacom where  trim(agentcom) = ?";
		
		try {
			System.out.println("开始查询");
			pre=con.prepareStatement(sql);//使用预编译
			//sql参数赋值
			pre.setString(1, "010707050003");
			result = pre.executeQuery();
			while(result.next()){
				String agentcom=result.getString("agentcom");
				String name=result.getString("name");
				System.out.println("agent:"+agentcom+"name:"+ name);
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
	
	/**
	 * insert操作
	 * @param user
	 * @return
	 */
	public int insert(User user) {
//		Connection con=getConnection4Oracle();
		Connection con=getConnection4MySQL();
		int i= 0;
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		//以后要是insert多条记录，在sql结尾加上多个小括号，sql也不要参数了。
		String sql = "insert into user (login_name ,name)  values (? ,? ,?)";
		try {
			System.out.println("开始insert");
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getLoginName());
			pre.setString(2, user.getName());
//			i= pre.executeUpdate(sql);
			i= pre.executeUpdate();
			System.out.println("insert操作结束。共有 插入记录条数 "+ i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre!= null) pre.close();
				if (con!= null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}
	
	/**
	 * update操作
	 * @param u
	 * @return
	 */
	public int update(User user){
//		Connection con=getConnection4Oracle();
		Connection con=getConnection4MySQL();
		int i= 0;
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		String sql = "insert user set login_name = ? and name = ? where id = ?";
		try {
			System.out.println("开始update");
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getLoginName());
			pre.setString(2, user.getName());
			pre.setInt(3, user.getId());
			i= pre.executeUpdate();
			System.out.println("update操作结束。共有更新记录条数 "+ i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre!= null) pre.close();
				if (con!= null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}

	/**
	 * delete操作
	 * @param user
	 * @return
	 */
	private int delete(User user){
//		Connection con=getConnection4Oracle();
		Connection con=getConnection4MySQL();
		int i= 0;
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		String sql = "delete from user  where id = ?";
		try {
			System.out.println("开始delete");
			pre = con.prepareStatement(sql);
			pre.setInt(1, user.getId());
			i= pre.executeUpdate();
			System.out.println("delete操作结束。共有删除记录条数 "+ i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre!= null) pre.close();
				if (con!= null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}
			
	
	
	
}
