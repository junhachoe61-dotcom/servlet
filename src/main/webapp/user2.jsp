<%@ page import="com.korai.servletstudy2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 최준하
  Date: 26. 10. 26.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=(User)request.getAttribute("user")%>
</body>
</html>
