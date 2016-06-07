package rd.lab.jdbceh.datahelper;

import java.sql.ResultSet;
import java.sql.SQLException;

import rd.lab.jdbceh.binder.GenericResultSetBinder;
import rd.lab.jdbceh.core.helper.SQLBindingFetchHelper;
import rd.lab.jdbceh.core.helper.SQLQueryHelper;
import rd.lab.jdbceh.datahelper.obj.Note;
import rd.lab.jdbceh.util.ResultSetBinder;

public class NoteDataHelper {
	//singleton
	private volatile static NoteDataHelper singletonObj = new NoteDataHelper();
	public static NoteDataHelper getInstance(){
		return singletonObj;
	}
	
	private NoteDataHelper(){
		
	}
	
	public void createNote(Note note){
		//objects declaration
		SQLQueryHelper sqlHelper = new SQLQueryHelper();
		String query = "insert into notes(title,note) VALUES (?,?);";
		
		//create
		sqlHelper.executeQuery(query, new Object[]{
				note.getTitle(),
				note.getNote()
			});
		
		//clean
		sqlHelper = null;
		query = null;
	}
	
	public void updateNote(Note note){
		//objects declaration
		SQLQueryHelper sqlHelper = new SQLQueryHelper();
		String query = "update notes set title=?,note =? where note_id = ?";
		
		//update
		sqlHelper.executeQuery(query, new Object[]{
				note.getTitle(),
				note.getNote(),
				note.getNoteId()
			}); 
		
		//clean
		sqlHelper = null;
		query = null;
	}
	
	public void deleteNode(int id){
		//objects declaration
		SQLQueryHelper sqlHelper = new SQLQueryHelper();
		String query = "delete from notes where note_id = ?";
				
		//delete
		sqlHelper.executeQuery(query, new Object[]{id});
		
		//clean
		sqlHelper = null;
		query = null;
	}
	
	public Note getNote(int id){
		//declaration
		Note data = new Note();
		String query = "select note_id, title, note from notes where note_id = ?";
		GenericResultSetBinder<Note> binder = new GenericResultSetBinder<Note>(data) {
			@Override
			public void bind(ResultSet rs) throws SQLException {
				//binding
				getBinderObject().setNoteId(rs.getInt("note_id"));
				getBinderObject().setTitle(rs.getString("title"));
				getBinderObject().setNote(rs.getString("note"));
			}
		};
		SQLBindingFetchHelper fetchHelper = new SQLBindingFetchHelper(binder, null);
		
		//fetch
		fetchHelper.fetch(query, new Object[]{id});
		
		//clean
		query = null;
		fetchHelper = null;
		
		//return
		return data;
	}
	
	public void bindNotes(ResultSetBinder binder){
		//objects declaration
		SQLBindingFetchHelper fetchHelper = new SQLBindingFetchHelper(binder, null);
		String query = "select note_id,title,note from notes";
		
		//fetch
		fetchHelper.fetch(query, null);
		
		//clean
		query = null;
		fetchHelper = null;
	}
}
