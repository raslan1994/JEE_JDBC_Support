package rd.lab.jdbceh.binder;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import rd.lab.jdbceh.util.BasicObjectIO;
import rd.lab.jdbceh.util.ResultSetBinder;

public abstract class JSPResultSetBinder implements ResultSetBinder {
	private PrintWriter out;
	public JSPResultSetBinder(PrintWriter out) {
		this.out = out;
	}
	
	public void bind(ResultSet rs) throws SQLException{
		bind(rs, out);
	}
	
	public abstract void bind(ResultSet rs, PrintWriter out) throws SQLException;
	
}
