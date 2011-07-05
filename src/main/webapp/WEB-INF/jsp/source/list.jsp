<%-- 
    Document   : list
    Created on : Jun 19, 2011, 2:24:14 PM
    Author     : Andrej Kuročenko <kurochenko@mail.muni.cz>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
<tr>
    <th><spring:message code="label.source.name"/></th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${sourceList}" var="source">
    <tr>
        <td>${source.name} </td>
        <td>
            <a href="source/save/${source.sourceId}">
                <spring:message code="label.update"/>
            </a>
        </td>
        <td>
            <a href="source/delete/${source.sourceId}">
                <spring:message code="label.delete"/>
            </a>
        </td>
    </tr>
</c:forEach>
    <tr>
        <td>&nbsp;</td>
        <td colspan="2">
            <a href="source/save">
                <spring:message code="label.add"/>
            </a>
        </td>
    </tr>
</table>