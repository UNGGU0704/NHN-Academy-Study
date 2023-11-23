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
<a href="hello">Hello Servlet</a>

<br>

<h1><%= "Now Time!" %>
</h1>
<br/>
<a href="now">nowTime</a>

<h1><%= "Multi!" %>
</h1>
<br/>
<a href="multi">mulit</a>

<h1><%= "Counter" %>
    </h1>
<br/>
<a href="counter">counter</a>

<form method="post" action="beautify" >
    <textarea name="html" rows="10" cols="200"></textarea>
    <p>
        <button type="submit">전송</button>
    </p>
</form>
</body>
</html>