<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>User Management Application</h2>

    <h3><a href="/admin/add">Add User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th>Occupation</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.occupation}</td>
                <td>
                    <form action="/admin/edit" method="post">
                        <input type="text" hidden name="id" value="${user.id}">
                        <input type="submit" value="Edit">
                    </form>
                    &nbsp;&nbsp;&nbsp;
                    <form action="/admin/delete" method="post">
                        <input type="text" hidden name="id" value="${user.id}">
                        <input type="submit" value="Delete">
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>