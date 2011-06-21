<%-- 
    Document   : list
    Created on : Jun 21, 2011, 1:56:27 PM
    Author     : Andrej Kuročenko <kurochenko@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
<tr>
    <th><spring:message code="label.author.name"/></th>
    <th><spring:message code="label.author.surname"/></th>
    <th><spring:message code="label.author.meid"/></th>
    <th><spring:message code="label.author.note"/></th>
    <th><spring:message code="label.author.department"/></th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:if test="${ !empty authorList}">
<c:forEach items="${authorList}" var="author">
    <tr>
        <td>${author.name} </td>
        <td>${author.surname} </td>
        <td>${author.meId} </td>
        <td>${author.note} </td>
        <td>${author.department.name} </td>
        <td>
            <a href="author/save/${author.idAuthor}">
                <spring:message code="label.update"/>
            </a>
        </td>
        <td>
            <a href="author/delete/${author.idAuthor}">
                <spring:message code="label.delete"/>
            </a>
        </td>
    </tr>
</c:forEach>
</c:if>
    <tr>
        <td>&nbsp;</td>
        <td colspan="2">
            <a href="author/save">
                <spring:message code="label.add"/>
            </a>
        </td>
    </tr>
</table>