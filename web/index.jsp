<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2020/7/29
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>正在跳转</title>
</head>
<body>
<%
  request.getRequestDispatcher("/index").forward(request,response);
%>
</body>
</html>
