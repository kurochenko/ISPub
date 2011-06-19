<%-- 
    Document   : list
    Created on : Jun 19, 2011, 2:24:14 PM
    Author     : Andrej Kuročenko <kurochenko@mail.muni.cz>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<h3>Departments</h3>
<c:if  test="${!empty departmentList}">
<table class="data">
<tr>
    <th>Name</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${departmentList}" var="department">
    <tr>
        <td>${department.name} </td>
        <td><a href="department/delete/${department.iddepartment}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

