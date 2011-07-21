<%-- 
    Document   : form
    Created on : Jun 21, 2011, 1:56:41 PM
    Author     : Andrej Kuročenko <kurochenko@gmail.com>
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<form:form method="post" action="${pageContext.request.contextPath}/author/save" modelAttribute="author">
<form:hidden path="id" />
 
    <table>
    <tr>
        <td>
            <form:label path="name">
                <spring:message code="label.author.name"/>
            </form:label>
        </td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td>
            <form:label path="surname">
                <spring:message code="label.author.surname"/>
            </form:label>
        </td>
        <td><form:input path="surname" /></td>
    </tr>
    <tr>
        <td>
            <form:label path="meId">
                <spring:message code="label.author.meid"/>
            </form:label>
        </td>
        <td><form:input path="meId" /></td>
    </tr>
    <tr>
        <td>
            <form:label path="departments">
                <spring:message code="label.author.department"/>
            </form:label>
        </td>
        <td>
            <form:select path="departments" items="${departmentList}" multiple="true" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="sources">
                <spring:message code="label.author.source"/>
            </form:label>
        </td>
        <td>
            <form:select path="sources" items="${sourceList}" multiple="true" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="note">
                <spring:message code="label.author.note"/>
            </form:label>
        </td>
        <td><form:textarea path="note" cols="64" rows="12" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <c:choose>
                <c:when test="${empty author.id}">
                    <input type="submit" value="<spring:message code="label.add"/>"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="<spring:message code="label.update"/>"/>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
</form:form>