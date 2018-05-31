<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexnar
  Date: 31.05.18
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:forEach items="${movies}" var="movie">
  <h2>${movie.title} - ${movie.director}, ${movie.durationMin}</h2>
  ${movie.description}
  <br>
  Продолжительность: ${movie.durationMin} мин.
  <hr>
</c:forEach>
</body>
</html>
