<%-- 
    Document   : list
    Created on : Jun 19, 2011, 2:24:14 PM
    Author     : Andrej Kuročenko <kurochenko@mail.muni.cz>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="department">
<tr>
    <th><spring:message code="label.source.name"/></th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:set var="parity" value="0" />
<c:forEach items="${sourceList}" var="source">
    <c:choose>
        <c:when test="${(parity % 2) == 0}">
            <c:set var="rowClass" value="even" />
        </c:when>
        <c:otherwise>
            <c:set var="rowClass" value="odd" />
        </c:otherwise>
    </c:choose>
    <c:set var="parity" value="${parity + 1}" />
    <tr class="${rowClass}">
        <td>${source.name} </td>
        <td class="action">
            <a href="source/save/${source.id}" class="update">
                <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.update"/>' title='<spring:message code="label.update"/>' class='update'/>
            </a>
        </td>
        <td class="action">
            <a href="source/delete/${source.id}" class="remove">
                <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.delete"/>' title='<spring:message code="label.delete"/>' class='remove'/>
            </a>
        </td>
    </tr>
</c:forEach>
    <tr>
        <td>&nbsp;</td>
        <td colspan="2" class="action">
            <a href="source/save" class="add">
                <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.add"/>' title='<spring:message code="label.add"/>' class='add'/>
            </a>
        </td>
    </tr>
</table>