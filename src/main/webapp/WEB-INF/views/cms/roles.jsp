<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>b
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roles List</title>
</head>
<body>

<div>
	<table>
		<tr>
			<td>
				<h1>Roles Management</h1>
			</td>
			<td colspan="2" style="float: right;">
				<a href="<c:url value='/cms/users' />" >Users</a>
				<a href="<c:url value='/cms/roles' />" >Roles</a>
				<a href="<c:url value='/logout' />" >Logout</a>
			</td>
		</tr>
	</table>
</div>

<c:url var="addRoles" value="/cms/roles/add"></c:url>

<form:form action="${addRoles}" commandName="role" > 
	<table>
		<c:if test="${!empty role.name}">
		<tr>
			<td>
				<form:label path="id">
					<spring:message text="ID" />
				</form:label>
			</td>
			<td>
				<form:input path="id" readonly="true" size="8" disabled="true"/>
				<form:hidden path="id"/>
			</td>
		</tr>			
		</c:if>
		<tr>
			<td>
				<form:label path="name">
					<spring:message text="Role Name" />
				</form:label>
			</td>
			<td>
				<form:input path="name"/>
			</td>
		</tr>		
		<tr>
			<td colspan="2">
				<c:if test="${!empty role.name}">
					<input type="submit" value="<spring:message text="Edit Role"/>" >
				</c:if>
				<c:if test="${empty role.name}">
					<input type="submit" value="<spring:message text="Create New Role"/>" >
				</c:if>
			</td>
		</tr>
	</table>
</form:form>

<h3>Roles List</h3>
<c:if test="${!empty rolesList}">
	<table>
		<tr>
			<th>ID</th>
			<th>Role Name</th>
			<th>E-mail</th>
		</tr>
		<c:forEach items="${rolesList}" var="role">
			<tr>
				<td>${role.id}</td>
				<td>${role.name}</td>				
				<td><a href="<c:url value='/cms/roles/edit/${role.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/cms/roles/remove/${role.id}' />" >Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>