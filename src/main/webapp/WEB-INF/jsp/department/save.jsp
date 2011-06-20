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
 
    <table>
    <tr>
        <td>
            <form:label path="name">
                <spring:message code="label.department.name"/>
            </form:label>
        </td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.department.button.add"/>"/>
        </td>
    </tr>
</table>
</form:form>
