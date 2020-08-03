<%--
  Created by IntelliJ IDEA.
  User: bomin
  Date: 2020/08/03
  Time: 7:16 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<center>
    <table border="1">
        <c:forEach var="member" items="${members}">
            <tr align="center">
                <td width="150" height="50">차 번호</td>
                <td>${member.car_number}</td>
            </tr>
            <tr align="center">
                <td width="150" height="50">이름</td>
                <td>${member.owner_name}</td>
            </tr>
            <tr align="center">
                <td width="150" height="50">시작일</td>
                <td>${member.start_date}</td>
            </tr>
            <tr align="center">
                <td width="150" height="50">만료일</td>
                <td>${member.end_date}</td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
