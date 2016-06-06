package rd.lab.jdbceh.core.helper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import rd.lab.jdbceh.core.SQLParameterFactory;
import rd.lab.jdbceh.util.SQLConnectionPool;

/**
 *
 * @author Raslan Rauff
 */
public class SQLQueryHelper {
    private Connection con;
    private SQLConnectionPool connectionPool = SQLConnectionPool.getInstance();
    
    public int executeUpdate(String query,Object[] parameters){
    	//declare
    	int data = 0;
    	
    	//get connection
    	con = connectionPool.getConnection();
    	
    	try{
    		PreparedStatement stmt = con.prepareStatement(query);
    		
            //bind parameters
            if(parameters != null)
                SQLParameterFactory.bindParameters(stmt, parameters);
            
            //execute
            data = stmt.executeUpdate();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		if(con!=null)try{con.close();}catch(SQLException ex){ex.printStackTrace();}
    	}
    	
    	//return
    	return data;
    }
    
    public void executeQuery(String query,Object[] parameters){
    	//get connection
    	Connection con = connectionPool.getConnection();
       
    	try{
    		PreparedStatement stmt = con.prepareStatement(query);
           
            //bind parameters
            if(parameters != null)
                SQLParameterFactory.bindParameters(stmt, parameters);
           
            //execute
            stmt.execute();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		if(con!=null)try{con.close();}catch(SQLException ex){ex.printStackTrace();}
    	}
    }
   
    public void executeProcedure(String procedure,Object[] parameters){
    	//get connection
    	Connection con = connectionPool.getConnection();
       
    	try{
    		CallableStatement stmt = con.prepareCall(procedure);
           
            //bind parameters
            if(parameters != null)
                SQLParameterFactory.bindParameters(stmt, parameters);
           
            //execute
            stmt.execute();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		if(con!=null)try{con.close();}catch(SQLException ex){ex.printStackTrace();}
    	}
    }
}
