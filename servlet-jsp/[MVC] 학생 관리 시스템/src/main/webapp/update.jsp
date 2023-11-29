<%@ page import="com.nhnacademy.study.jsp.Student" %><%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 11/28/23
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 - 수정</title>
</head>
<body>
  <form method="post" action = "/student-update.do">
      <table>
        <tbody>
          <tr>
            <th>ID</th>
            <td><input type="text" name="ID" value="${student.getID()}"></td>
          </tr>
          <tr>
            <th>이름</th>
            <td><input type="text" name = "name" value="${student.getName()}"></td>
          </tr>
          <tr>
            <th>성별</th>
            <td>
              <label><input type="radio" name="gender" value="M" ${"M".equals(student.getGender()) ? "checked" : ""}> 남성</label>
              <label><input type="radio" name="gender" value="F" ${"F".equals(student.getGender()) ? "checked" : ""}> 여성</label>
            </td>
          </tr>
          <tr>
            <th>나이</th>
              <td><input type="text" name = "age" value="${student.getAge()}"></td>
          </tr>
        </tbody>
      </table>
    <p>
      <button type= "submit">수정</button>
    </p>
  </form>
</body>
</html>
