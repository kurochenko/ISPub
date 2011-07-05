<%-- 
    Document   : add
    Created on : Jun 19, 2011, 2:23:57 PM
    Author     : Andrej Kuročenko <kurochenko@mail.muni.cz>
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<form:form method="post" action="${pageContext.request.contextPath}/source/save" modelAttribute="source">
<form:hidden path="sourceId" />
 
    <table>
    <tr>
        <td>
            <form:label path="name">
                <spring:message code="label.source.name"/>
            </form:label>
        </td>
        <td><form:input path="name" /><form:errors path="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <c:choose>
                <c:when test="${empty source.sourceId}">
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