<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/greppperz/searchData"  modelAttribute="searchForm">
   <table>

    <tr>
        <td><form:label path="location">Chennai</form:label></td>
        <form:radiobutton path="location" value="chennai" />
    </tr>

    <tr>
        <td><form:label path="location">Bangalore</form:label></td>
        <form:radiobutton path="location" value="bangalore" />
    </tr>

    <tr>
        <td><form:label path="location">Kashmir</form:label></td>
        <form:radiobutton path="location" value="kashmir" />
    </tr>

    <tr>
        <td><form:label path="location">No User</form:label></td>
        <form:radiobutton path="location" value="" />
    </tr>

    <tr>
        <td><form:label path="query">Query</form:label></td>
        <td><form:input path="Query" /></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>

