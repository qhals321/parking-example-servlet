
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<center>
    <table border="1">
        <tr align="center">
            <td width="150" height="50">차 번호</td>
            <td width="150" height="50">이름</td>
            <td width="150" height="50">시작일</td>
            <td width="150" height="50">만료일</td>
        </tr>
        <c:forEach var="member" items="${members}">
            <tr align="center">
                <td width="150" height="50">${member.car_number}</td>
                <td width="150" height="50">${member.owner_name}</td>
                <td width="150" height="50">${member.start_date}</td>
                <td width="150" height="50">${member.end_date}</td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
