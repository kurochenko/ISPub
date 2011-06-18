<%-- 
    Document   : menu
    Created on : Jun 16, 2011, 12:58:09 AM
    Author     : Andrej Kuročenko <kurochenko@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<ul>
    <li><a href="${pageContext.request.contextPath}/author">
            <spring:message code="label.menu.item.authors"/>
        </a>
    </li>
    <li><a href="${pageContext.request.contextPath}/department">
            <spring:message code="label.menu.item.departments"/>
        </a>
    </li>
</ul>
