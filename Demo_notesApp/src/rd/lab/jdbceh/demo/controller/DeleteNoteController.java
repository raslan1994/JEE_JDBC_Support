package rd.lab.jdbceh.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rd.lab.jdbceh.demo.model.NoteModel;
import rd.lab.jdbceh.demo.util.ValidationSupport;

public class DeleteNoteController extends HttpServlet{

	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gather parameters
		String strNoteId = ValidationSupport.getValidParameter(request, "nid","0");
		
		int noteId = Integer.parseInt(strNoteId);
		
		//preparing required objects
		NoteModel model = new NoteModel();
		
		//update
		model.deleteNote(noteId);
		
		//clean
		model = null;
		
		//redirect
		response.sendRedirect("index.jsp");
		return;
	}
}
