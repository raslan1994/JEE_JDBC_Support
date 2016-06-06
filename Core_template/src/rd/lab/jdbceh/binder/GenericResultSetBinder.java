package rd.lab.jdbceh.binder;

import java.sql.ResultSet;
import java.sql.SQLException;

import rd.lab.jdbceh.util.ResultSetBinder;

public abstract class GenericResultSetBinder<E> implements ResultSetBinder{
	private E binderObject;
	
	public GenericResultSetBinder(E binderObject) {
		this.binderObject = binderObject;
	}
	
	public E getBinderObject(){
		return binderObject;
	}
	
	@Override
	public abstract void bind(ResultSet rs) throws SQLException;
}
