<%-- 
    Document   : layout
    Created on : Jun 16, 2011, 12:57:55 AM
    Author     : Andrej Kuročenko <kurochenko@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css"> 
<title><spring:message code="label.title"/> :: <tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
    <div id="header">
        <h1>
            <spring:message code="label.title"/> :: <tiles:insertAttribute name="title" ignore="true" />
        </h1>
    </div>
    <div id="mainmenu">
        <tiles:insertAttribute name="menu" />
    </div>
    <div id="content">
        <tiles:insertAttribute name="body" />
    </div>
</body>
</html>