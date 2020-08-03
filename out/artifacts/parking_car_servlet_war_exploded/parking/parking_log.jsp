<%@ page import="java.util.List" %>
<%@ page import="parking.CarBean" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<center>

    <table border="1">
        <tr align="center">
            <td width="150" height="50">차 번호</td>
            <td width="150" height="50">입차 시간</td>
            <td width="150" height="50">출차 시간</td>
        </tr>
        <c:forEach var="log" items="${car_log}">
            <tr align="center">
                <td width="150" height="50">${log.car_number}</td>
                <td width="150" height="50">${log.in_time}</td>
                <td width="150" height="50">${log.out_time}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
