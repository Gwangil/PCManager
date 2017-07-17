package work.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FactoryDao {

	private DataSource ds;
	private static FactoryDao instance = new FactoryDao();
	
	private FactoryDao(){
		try{
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
		} catch (NamingException e){
			System.out.println("Error : "+ e.getMessage());
		}
	}
	
	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}return null;
	}
	
	public static FactoryDao getInstance(){
		return instance;
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rs ){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn, Statement stmt){
		close(conn,stmt,null);
	}
}