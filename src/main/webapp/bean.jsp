<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: andrewchu
  Date: 5/21/23
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<section>
    <c:forEach items="${quotes}" var="quote">
        <p>"${quote.content}" - ${quote.author.firstName} ${quote.author.lastName}</p>
    </c:forEach>
</section>


</body>
</html>
