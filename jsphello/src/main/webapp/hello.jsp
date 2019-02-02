<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 02.02.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<%! int counter=0; %>
<body>
        <p> Dzisiaj jest: <%=LocalDateTime.now().toString()%>
            <% out.print("Licznik odwiedzin:" + counter++); %>
        </p>
</body>
</html>
