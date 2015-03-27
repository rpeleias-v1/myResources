<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Resources System</title>
</head>
<body>

<div>
	<table>
		<tr>
			<td>
				<h1>Users Management</h1>
			</td>
			<td colspan="2" style="float: right;">
				<a href="<c:url value='/cms/users' />" >Users</a>
				<a href="<c:url value='/cms/roles' />" >Roles</a>
				<a href="<c:url value='/logout' />" >Logout</a>
			</td>
		</tr>
	</table>
</div>

<c:url var="addUsers" value="/cms/users/add"></c:url>

<form:form action="${addUsers}" commandName="userResource" > 
	<table>
		<c:if test="${!empty userResource.username}">
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
				<form:label path="username">
					<spring:message text="User Name" />
				</form:label>
			</td>
			<td>
				<form:input path="username"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="password">
					<spring:message text="User Password" />
				</form:label>
			</td>
			<td>
				<form:input path="password"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="email">
					<spring:message text="E-Mail" />
				</form:label>
			</td>
			<td>
				<form:input path="email"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty userResource.username}">
					<input type="submit" value="<spring:message text="Edit User"/>" >
				</c:if>
				<c:if test="${empty userResource.username}">
					<input type="submit" value="<spring:message text="Create New User"/>" >
				</c:if>
			</td>
		</tr>
	</table>
</form:form>

<h3>Users List</h3>
<c:if test="${!empty usersList}">
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>E-mail</th>
		</tr>
		<c:forEach items="${usersList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td><a href="<c:url value='/cms/users/edit/${user.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/cms/users/remove/${user.id}' />" >Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>