<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//define root path
	pageContext.setAttribute("appRoot", "http://"+ request.getServerName()+ ":" + request.getServerPort() + 
		request.getContextPath());%>
<%-- Header variable --%>
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
		  <a href="#" class="list-group-item active">
		    Cras justo odio
		  </a>
		  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
		  <a href="#" class="list-group-item">Morbi leo risus</a>
		  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
		  <a href="#" class="list-group-item">Vestibulum at eros</a>
		</div>
	</div>
	<div class="col-md-8">
		<form>
			<div class="form-group">
				<label for="title">Note Title</label>
			    <input type="text" name="txt_title" class="form-control" id="title" placeholder="Note Title">
			</div>
			<div class="form-group">
				<label for="note">Note</label>
			    <textarea id="note" name="txt_note" class="form-control" rows="4"></textarea>
			</div>
			<div>
				<button class="btn btn-success btn-lg">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;Create <small>Note</small>
				</button>
			
				<button class="btn btn-warning btn-lg">
					<span class="glyphicon glyphicon-pencil"></span>&nbsp;Update <small>Note</small>
				</button>
				
				<button class="btn btn-danger btn-lg">
					<span class="glyphicon glyphicon-trash"></span>&nbsp;Delete <small>Note</small>
				</button>
			</div>
		</form>
	</div>
</div>

<%--Add java scripts --%>
<%@ include file="/res/footer.jsp" %>
</body>
</html>