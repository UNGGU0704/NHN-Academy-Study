<%@ page import="com.nhnacademy.study.jsp.Student" %><%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 11/28/23
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학생-등록</title>
    <form action ="student-register.do" method="post">
        ID : <input type="text", name="ID"> <br>
        이름 : <input type="text". name="name"> <br>
        성멸 : <input type="radio", name="gender", value="M"> <br>
                <input type="radio", name="gender", value="F"> <br>
        나이 : <input type="text", name="age"> <br>
        <input type="submit", value="등록">
    </form>
</head>
<body>

</body>
</html>
