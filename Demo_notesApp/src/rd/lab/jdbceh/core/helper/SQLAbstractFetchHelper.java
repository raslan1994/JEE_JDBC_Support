package rd.lab.jdbceh.core.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rd.lab.jdbceh.core.SQLParameterFactory;
import rd.lab.jdbceh.util.BasicObjectIO;
import rd.lab.jdbceh.util.SQLConnectionPool;

/**
 *
 * @author Raslan Rauff
 */
public abstract class SQLAbstractFetchHelper extends BasicObjectIO{
    private SQLConnectionPool connectionPool = SQLConnectionPool.getInstance();
	
    public SQLAbstractFetchHelper(Object ioObject) {
        super(ioObject);
    }
    
    public abstract void bindData(ResultSet rs) throws SQLException;
    
    public void fetch(String query,Object[] parameters){
        Connection con = connectionPool.getConnection();
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            
            //set parameters
            if(parameters != null)
                SQLParameterFactory.bindParameters(stmt, parameters);
            
            ResultSet rs = stmt.executeQuery();
            
            //bind data
            while(rs.next()){
                bindData(rs);
            }
            //close
            if(rs != null)
                rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(con != null)
                try{con.close();}catch(SQLException ex){ex.printStackTrace();}
        }
    }
}
