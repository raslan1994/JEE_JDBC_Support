package rd.lab.jdbceh.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rd.lab.jdbceh.datahelper.obj.Note;
import rd.lab.jdbceh.demo.model.NoteModel;
import rd.lab.jdbceh.demo.util.ValidationSupport;

public class UpdateNoteController extends HttpServlet{

	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gather parameters
		String strNoteId = ValidationSupport.getValidParameter(request, "nid","0"),
				title = ValidationSupport.getValidParameter(request, "txt_title"),
				note = ValidationSupport.getValidParameter(request, "txt_note");
		
		int noteId = Integer.parseInt(strNoteId);
		
		//preparing required objects
		Note newNote = new Note(noteId, title, note);
		NoteModel model = new NoteModel();
		
		//prepare model
		model.setNote(newNote);
		
		//update
		model.updateNoe();
		
		//clean
		title = null;
		note = null;
		model = null;
		
		//redirect
		response.sendRedirect("index.jsp?nid=" + noteId);
		return;
	}
}
