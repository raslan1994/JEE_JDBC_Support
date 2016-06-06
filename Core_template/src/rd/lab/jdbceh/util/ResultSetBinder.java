package rd.lab.jdbceh.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetBinder {
	public void bind(ResultSet rs) throws SQLException;
}
