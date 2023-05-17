<%--
  Created by IntelliJ IDEA.
  User: andrewchu
  Date: 5/17/23
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>

<body>

<h1>Welcome To The Site!</h1>


<%  int x = 5; %>
<% System.out.println(x);%>



<%


    if (request.getMethod().equalsIgnoreCase("post")) {


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (username.equals("admin") && password.equals("password")) {

            response.sendRedirect("/profile.jsp");


        }
    }




%>


<form method="post">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
</form>


</body>
</html>
