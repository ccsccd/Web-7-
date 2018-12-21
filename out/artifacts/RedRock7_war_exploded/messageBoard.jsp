<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="SQL.LoginDao" %>
<%@ page import="bean.message" %><%--
  Created by IntelliJ IDEA.
  User: ccs
  Date: 2018/12/21
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>留言板</title>
</head>
<body bgcolor="#93B1D5">
<div style="text-align:center;margin-top: 10%">
    <h1>这里是留言板主界面</h1>
    <form action="leaveMessage" method="post">
        <table border="1" style="margin-left: 30%">
            <caption>所有留言信息</caption>
            <tr>
                <th>留言人姓名</th>
                <th>留言时间</th>
                <th>留言标题</th>
                <th>留言内容</th>
            </tr>
            <%
                ArrayList<message> al = new ArrayList<message>();
                al = (ArrayList) session.getAttribute("al");
                if (al != null) {
                    Iterator iter = al.iterator();
                    while (iter.hasNext()) {
                        message ms = (message) iter.next();
            %>
            <tr>
                <td><%= new LoginDao().getName(ms.getId()) %>
                </td>
                <td><%= ms.getTime().toString() %>
                </td>
                <td><%= ms.getTitle() %>
                </td>
                <td><%= ms.getMessage() %>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </form>
    <a href="leaveMessage.html">留言</a>
</div>
</body>
</html>