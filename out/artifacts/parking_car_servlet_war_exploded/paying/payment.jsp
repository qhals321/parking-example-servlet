<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<center>
    <table border="1">
        <tr align="center">
            <td width="350" height="50">차 번호</td>
            <td width="350" height="50">입차 시간</td>
            <td width="350" height="50">출차 시간</td>
            <td width="350" height="50">요금</td>
        </tr>
            <tr align="center">
                <td width="350" height="50">${carBean.car_number}</td>
                <td width="350" height="50">${carBean.in_time}</td>
                <td width="350" height="50">${carBean.out_time}</td>
                <td width="350" height="50">${price}</td>
            </tr>
            <br><br>
        <form action="/paying.do" method="post">
            <table border="1">
                <tr>
                    <td>투입 금액</td>
                    <td><input type="text" name="money"></td>
                    <td><input type="submit" value="계산"></td>
                    <td><input type="hidden" name="price" value="${price}"></td>
                    <td><input type="hidden" name="car_number" value="${carBean.car_number}"></td>
                </tr>
            </table>
        </form>
    </table>

</center>

</body>
</html>
