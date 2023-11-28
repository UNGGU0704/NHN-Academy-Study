<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-test">Hello Servlet</a> <br>

<a href ="counter">counter</a>
<a href ="student">student-list</a>
<form action="/student-delete" method="post">
    ID: <input type="text" name="id"><br>
    <input type="submit" value="Delete">
</form>
</body>
</html>