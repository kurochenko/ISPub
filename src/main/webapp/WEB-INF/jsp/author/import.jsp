<%--
  Created by IntelliJ IDEA.
  User: kurochenko
  Date: 7/9/11
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/author/import" enctype="multipart/form-data" modelAttribute="fileUpload">
    <table class="noBorder">
    <tr>
        <th>
            <form:label for="csvFile" path="csvFile">
                <spring:message code="label.author.import.file"/>
            </form:label>
        </th>
        <td>
            <input path="csvFile" type="file" /><form:errors path="csvFile" />
        </td>
        <td>
            <input type="submit" value="<spring:message code="label.author.import.submit"/>"/>
        </td>
    </tr>
</table>
</form:form>