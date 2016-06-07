package rd.lab.jdbceh.datahelper.obj;

public class Note {
	private int noteId;
	private String title;
	private String note;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	public Note(){
		this.noteId = 0;
		this.title = "";
		this.note = "";
	}
	
	public Note(int noteId, String title, String note) {
		this.noteId = noteId;
		this.title = title;
		this.note = note;
	}
	
}
