<%--
  Created by IntelliJ IDEA.
  User: bomin
  Date: 2020/08/03
  Time: 6:50 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<center>
    <form method="post" action="login.do">
        <table border="1" width="400" align="center">
            <th colspan="2">
                관리자 로그인
            </th>
            <tr align="center">
                <td width="150" height="50">아이디</td>
                <td height="50"><input type="text" name="admin_id"/></td>
            </tr>
            <tr align="center">
                <td width="150" height="50">비밀번호</td>
                <td height="50"><input type="password" name="admin_pw"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="로그인"> &nbsp &nbsp
                    <input type="button" onclick="window.location.href='/parkingCar/'" value="메인화면"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
