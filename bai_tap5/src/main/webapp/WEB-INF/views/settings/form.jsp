<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Email Settings</title>
</head>
<body>
<h2>Settings</h2>

<form:form modelAttribute="setting" action="/settings" method="post">
  <table>
    <tr>
      <td>Languages:</td>
      <td>
        <form:select path="language">
          <form:options items="${languages}"/>
        </form:select>
      </td>
    </tr>

    <tr>
      <td>Page Size:</td>
      <td>
        Show <form:select path="pageSize">
        <form:options items="${pageSizes}"/>
      </form:select> emails per page
      </td>
    </tr>

    <tr>
      <td>Spams filter:</td>
      <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
    </tr>

    <tr>
      <td>Signature:</td>
      <td><form:textarea path="signature" rows="3" cols="30"/></td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="Update"/>
        <input type="reset" value="Cancel"/>
      </td>
    </tr>
  </table>
</form:form>

</body>
</html>
