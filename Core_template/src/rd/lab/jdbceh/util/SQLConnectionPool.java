package rd.lab.jdbceh.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SQLConnectionPool {
	private Context initContext;
	private Context envContext;
	private DataSource dataSource;
	
	private static SQLConnectionPool sqlConnectionPool = new SQLConnectionPool();
	public static SQLConnectionPool getInstance(){
		return sqlConnectionPool;
	}
	
	private SQLConnectionPool(){init();}
	
	public void init(){
		try {
			initContext  = new InitialContext();
			envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/appDataSource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public synchronized Connection getConnection(){
		//declare
		Connection connection = null;
		//setup connection
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {e.printStackTrace();}
		//return
		return connection;
	}
}
