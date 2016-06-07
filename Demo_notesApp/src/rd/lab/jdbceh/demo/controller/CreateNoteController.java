package rd.lab.jdbceh.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rd.lab.jdbceh.datahelper.obj.Note;
import rd.lab.jdbceh.demo.model.NoteModel;
import rd.lab.jdbceh.demo.util.ValidationSupport;


public class CreateNoteController extends HttpServlet{

	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gather parameters
		String title = ValidationSupport.getValidParameter(request, "txt_title"),
				note = ValidationSupport.getValidParameter(request, "txt_note");
		
		//preparing required objects
		Note newNote = new Note(0, title, note);
		NoteModel model = new NoteModel();
		
		//prepare model
		model.setNote(newNote);
		
		//create
		model.createNote();
		
		//clean
		title = null;
		note = null;
		model = null;
		
		//redirect
		response.sendRedirect("index.jsp");
		return;
	}
}
