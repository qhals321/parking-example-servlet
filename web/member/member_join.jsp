<%--
  Created by IntelliJ IDEA.
  User: bomin
  Date: 2020/07/27
  Time: 6:00 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="member_join.do" method="post">
    <center>
    <table width="400" border="1">
        <tr align="center">
            <td width="150" height="50">차 번호</td>
            <td><input type="text" name="car_number"></td>
        </tr>
        <tr align="center">
            <td width="150" height="50">이름</td>
            <td><input type="text" name="owner_name"></td>
        </tr>
        <tr align="center">
            <td>시작일</td>
            <td><input type="date" name="start_date"></td>
        </tr>
        <tr align="center">
            <td>만료일</td>
            <td><input type="date" name="end_date"></td>
        </tr>
        <tr align="center">
            <td width="150" height="50">관리자 비밀번호</td>
            <td><input type="password" name="admin_pw"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="번호 등록"> &nbsp &nbsp
                            <input type="button" onclick="window.location.href='../admin/adminHome.jsp'" value="취소"></input></td>
        </tr>
    </table>
    </center>
</form>
</body>
</html>
