package rd.lab.jdbceh.demo.model;

import rd.lab.jdbceh.datahelper.NoteDataHelper;
import rd.lab.jdbceh.datahelper.obj.Note;

public class NoteModel {
	private Note note;
	private NoteDataHelper dataHelper = NoteDataHelper.getInstance();

	public void setNote(Note note) {
		this.note = note;
	}
	
	public void createNote(){
		//create note
		dataHelper.createNote(note);
	}
	
	public void updateNoe(){
		//update note
		dataHelper.updateNote(note);
	}
	
	public void deleteNote(int id){
		//delete
		dataHelper.deleteNode(id);
	}
}
