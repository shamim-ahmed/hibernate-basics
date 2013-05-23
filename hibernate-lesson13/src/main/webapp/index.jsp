<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<html>
<head>
  <title>Welcome</title>
</head>
<body>
  <h1>Welcome to user info web app</h1>
  
  <c:set var="webappName" value="${pageContext.servletContext.servletContextName}"/>
  
  <p>
    Please click <a href="/${webappName}/userInfo.do?id=1">here</a> to see user info 
  </p>  
</body>
</html>