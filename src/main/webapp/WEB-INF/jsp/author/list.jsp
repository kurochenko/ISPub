<%-- 
    Document   : list
    Created on : Jun 21, 2011, 1:56:27 PM
    Author     : Andrej Kuročenko <kurochenko@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="author">
<tr>
    <th><spring:message code="label.author.name"/></th>
    <th><spring:message code="label.author.surname"/></th>
    <th><spring:message code="label.author.department"/></th>
    <th><spring:message code="label.author.meid"/></th>
    <th><spring:message code="label.author.source"/></th>
    <th><spring:message code="label.author.note"/></th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<c:if test="${ !empty authorList}">

    <c:set var="parity" value="0" />

    <c:forEach items="${authorList}" var="author">
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
            <td>${author.name} </td>
            <td>${author.surname} </td>
            <td>${author.department.name} </td>
            <td>${author.meId} </td>
            <td>
                <c:forEach items="${author.sources}" var="src">
                    ${src}<br />
                </c:forEach>
            </td>
            <td>${author.note} </td>
            <td class='action'>
                <a href="author/save/${author.idAuthor}" class="update">
                    <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.update"/>' title='<spring:message code="label.update"/>' class='update'/>
                </a>
            </td>
            <td class='action'>
                <a href="author/delete/${author.idAuthor}" class="remove">
                    <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.delete"/>' title='<spring:message code="label.delete"/>' class='remove'/>
                </a>
            </td>
        </tr>
    </c:forEach>
</c:if>
    <tr>
        <td colspan="6">&nbsp;</td>
        <td colspan="2" class="action">
            <a href="author/save" class="add">
                <img src='${imgPath}/system/blank.png' alt='<spring:message code="label.add"/>' title='<spring:message code="label.add"/>' class='add'/>

            </a>
        </td>
    </tr>
</table>