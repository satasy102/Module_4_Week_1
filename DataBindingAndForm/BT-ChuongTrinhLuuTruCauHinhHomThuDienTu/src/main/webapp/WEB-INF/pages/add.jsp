<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h2>Settings</h2>

<form:form modelAttribute="mailSetting" action="/mailSettings" method="post">
    <table>
        <tr>
            <td><form:label path="language">Languages:</form:label></td>
            <td>
                <form:select path="language">
                    <form:option value="English">
                        English
                    </form:option>
                    <form:option value="Vietnamese">
                        Vietnamese
                    </form:option>
                    <form:option value="Japanese">
                        Japanese
                    </form:option>
                    <form:option value="Chinese">
                        Chinese
                    </form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size:</form:label></td>
            <td>Show <form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam Filter:</form:label></td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
