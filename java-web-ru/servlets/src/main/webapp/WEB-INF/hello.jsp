<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Example</title>
    </head>
    <body>
    <div class="container">
        <p><%= request.getAttribute("message") %></p>
    </div>
    </body>
</html>
