<%-- 
    Document   : add
    Created on : Jun 19, 2011, 2:23:57 PM
    Author     : Andrej Kuročenko <kurochenko@mail.muni.cz>
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<form:form method="post" action="${pageContext.request.contextPath}/department/save" modelAttribute="department">
<form:hidden path="iddepartment" />
 
    <table class="noBorder">
    <tr>
        <th>
            <form:label path="name">
                <spring:message code="label.department.name"/>
            </form:label>
        </th>
        <td><form:input path="name" /><form:errors path="name" /></td>
        <td>
            <c:choose>
                <c:when test="${empty department.iddepartment}">
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
