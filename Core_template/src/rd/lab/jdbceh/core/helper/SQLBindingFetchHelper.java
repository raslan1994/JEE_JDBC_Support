package rd.lab.jdbceh.core.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import rd.lab.jdbceh.util.ResultSetBinder;

public class SQLBindingFetchHelper {
	ResultSetBinder binder;
	SQLAbstractFetchHelper helper;
	
	public SQLBindingFetchHelper(ResultSetBinder binder, Object ioObject){
		this.binder = binder;
		helper = new SQLAbstractFetchHelper(ioObject) {
			@Override
			public void bindData(ResultSet rs) throws SQLException {
				bindDataWithBinder(rs);
			}
		};
	}
	
	public void bindDataWithBinder(ResultSet rs) throws SQLException{
		this.binder.bind(rs);
	}
	
	public SQLAbstractFetchHelper getHelper(){
		return helper;
	}
	
	public void fetch(String query,Object[] parameters){
		this.helper.fetch(query, parameters);
	}
}
