<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>학생-조회</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>
<table>
  <tbody>
  <!-- todo view 구현 -->
  <p>ID : ${student.getID()}</p>
  <p>Nmae : ${student.getName()}</p>
  <p>Gender : ${student.getGender()}</p>
  <p>Age : ${student.getAge()}</p>

  </tbody>
</table>
<ul>
  <li><a href="/student">리스트</a></li>
  <li>
    <!-- todo ${update_link} 설정 c:url -->
    <c:url var="updateLink" value="/student-update">
      <c:param name="id" value="${student.getID()}" />
    </c:url>
    <a href="${updateLink}">수정</a>
  </li>
  <li>
    <!-- todo 삭제버튼 구현, method=post
 </li>

</ul>

</body>
</html>