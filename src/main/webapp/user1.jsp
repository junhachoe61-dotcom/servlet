<%@ page import="com.korai.servletstudy2.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = new User(1, "user1", "1q2w3e4r!","김준일");

%>




<html>
  <head>
    <title>user</title>
  </head>
  <body>
    <h1><%=user.getId()%></h1>
    <h1><%=user.getUsername()%></h1>
    <h1><%=user.getPassword()%></h1>
  </body>
</html>
