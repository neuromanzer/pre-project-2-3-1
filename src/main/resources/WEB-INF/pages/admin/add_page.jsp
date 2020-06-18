<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New User</title>
</head>
<body>
<div align="center">
    <h2>Add New User</h2>
    <form:form action="add" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Login: </td>
                <td><form:input path="login" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td>Occupation: </td>
                <td><form:input path="occupation" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add"></td>
            </tr>
        </table>
    </form:form>
</div>
<div align="center">
    <h4><a href="/admin">Admin Page</a></h4>
</div>
</body>
</html>