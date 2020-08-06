<%--
  Created by IntelliJ IDEA.
  User: bomin
  Date: 2020/08/05
  Time: 10:17 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/payingCalculate.do">
    <center>
        <table>
            <tr align="center">
                <td height="50" width="150">차 번호를 입력해주세요</td>
                <td height="50" width="150"><input type="text" name="car_number"></td>
            </tr>
            <tr align="center">
                <td colspan="2" height="50" width="150"><input type="submit" value="정산">
                    <input type="button" onclick="history.go(-1);" value="취소"></td>
            </tr>
        </table>
    </center>
</form>

</table>
</body>
</html>
