<%--
  Created by IntelliJ IDEA.
  User: bomin
  Date: 2020/08/03
  Time: 9:54 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form method="post" action="parking_out.do">
    <center>
        <table>
            <tr align="center">
                <td height="50" width="150">차 번호를 입력해주세요</td>
                <td height="50" width="150"><input type="text" name="car_number"></td>
            </tr>
            <tr align="center">
                <td colspan="2" height="50" width="150"><input type="submit" value="출차">
                    <input type="button" onclick="history.go(-1);" value="취소"></td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
