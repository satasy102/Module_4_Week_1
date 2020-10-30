<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${mailSettings.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${mailSettings}">
        <tr>
            <td>
                <c:out value="${c.language}"/>
            </td>
            <td>
                <c:out value="${c.pageSize}"/>
            </td>
            <td>
                <c:out value="${c.spamFilter}"/>
            </td>
            <td>
                <c:out value="${c.signature}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>