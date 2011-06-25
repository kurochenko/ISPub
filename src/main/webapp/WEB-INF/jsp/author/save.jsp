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
<form:hidden path="idAuthor" />
 
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
            <form:label path="note">
                <spring:message code="label.author.note"/>
            </form:label>
        </td>
        <td><form:input path="note" /></td>
    </tr>
    <tr>
        <td>
            <form:label path="department.name">
                <spring:message code="label.author.department"/>
            </form:label>
        </td>
        <td>
            <form:select path="department.name">
                <c:choose>
                    <c:when test="${ empty departmentList}">
                        <form:option value="" label="Add any department first" disabled="yes"/> 
                    </c:when>
                    <c:otherwise>
                        <form:options items="${departmentList}" itemValue="iddepartment" />
                    </c:otherwise>
                </c:choose>
            </form:select>
        </td>        
    </tr>
    <tr>
        <td colspan="2">
            <c:choose>
                <c:when test="${empty author.idAuthor}">
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
${departmentList}