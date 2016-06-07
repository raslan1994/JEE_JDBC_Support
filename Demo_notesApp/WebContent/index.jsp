<%@page import="rd.lab.jdbceh.datahelper.obj.Note"%>
<%@page import="rd.lab.jdbceh.demo.util.ValidationSupport"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="rd.lab.jdbceh.binder.JSPResultSetBinder"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="rd.lab.jdbceh.datahelper.NoteDataHelper"%>
<%@page import="rd.lab.jdbceh.util.ResultSetBinder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//referencing
	NoteDataHelper dataHelper = NoteDataHelper.getInstance();
	
	//define root path
	pageContext.setAttribute("appRoot", "http://"+ request.getServerName()+ ":" + request.getServerPort() + 
		request.getContextPath());
		
	//gather request parameters
	String strNoteId = ValidationSupport.getValidParameter(request, "nid","0");
	final int noteId = Integer.parseInt(strNoteId);
	
	//get current note
	Note curNote = dataHelper.getNote(noteId);
	String formAction = noteId != 0 ? "update" : "create";
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- Add style sheets and header components--%>
<%@ include file="/res/header.jsp" %>
<title>Notes App</title>
</head>
<body>

<%-- Contents --%>
<div class="container">
	<div class="col-md-4">
		<div class="list-group">
			<a href="?nid=0" class="list-group-item <%=noteId == 0 ? " active" : ""%>"><span class="glyphicon glyphicon-edit"></span>&nbsp;Create new note</a>
		  <%-- Binding Notes --%>
		  <%
		  	//prepare binding objects
		  	PrintWriter outObj = new PrintWriter(out,false);
		  	ResultSetBinder binder = new JSPResultSetBinder(outObj){
		  		public void bind(ResultSet rs, PrintWriter out) throws SQLException{
		  			int curId = rs.getInt("note_id");
		  			String activeClass = noteId == curId ? " active" : "";
		  			%>
		  			<a href="?nid=<%=curId%>" class="list-group-item <%=activeClass%>"><%=rs.getString("title")%></a>
		  			<%
		  		}
		  	};
		  %>
		  <%-- Fetch Notes --%>
		  <%
		  	//Fetch
		  	dataHelper.bindNotes(binder);
		  %>
		</div>
	</div>
	<div class="col-md-8">
		<%if(noteId != 0){ %>
			<form action="delete" method="post" style="text-align: right;">
				<%-- Hidden input for identify note id --%>
				<input type="hidden" name="nid" value="<%=curNote.getNoteId()%>"/>
						
				<button class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash"></span>&nbsp;Delete <small>Note (<%=curNote.getTitle()%>)</small>
				</button>
			</form>
		<% }%>
		<form action="<%=formAction%>" class=" thumbnail" style="margin-top: 15px;" method="post">
			<%-- Hidden input for identify note id --%>
			<input type="hidden" name="nid" value="<%=curNote.getNoteId()%>"/>
			
			<div class="form-group">
				<label for="title">Note Title</label>
			    <input type="text" value="<%=curNote.getTitle()%>" name="txt_title" required="required" class="form-control" id="title" placeholder="Note Title">
			</div>
			<div class="form-group">
				<label for="note">Note</label>
			    <textarea id="note" name="txt_note" required="required" class="form-control" rows="4"><%=curNote.getNote()%></textarea>
			</div>
			<div>
				<% if(noteId == 0){ %>
					<button class="btn btn-success" type="submit">
						<span class="glyphicon glyphicon-ok"></span>&nbsp;Create <small>Note</small>
					</button>
				<% } %>
				
				<%	if(noteId!= 0) {%>
					<button class="btn btn-warning">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;Update <small>Note</small>
					</button>
				<%	} %>
			</div>
		</form>
		
	</div>
</div>

<%--Add java scripts --%>
<%@ include file="/res/footer.jsp" %>
</body>
</html>