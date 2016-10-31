<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<html>  
<head>  
    <title>Spring mvc Tiles Contact Form </title>  
</head>  
<body>  
<h2>Contact Manager</h2>  
<form:form method="post" action="addContact">  
  
    <table>  
    <tr>  
        <td>First Name</td>  
        <td><form:input path="firstname" /></td>   
    </tr>  
    <tr>  
        <td>Last Name</td>  
        <td><form:input path="lastname" /></td>  
    </tr>  
    <tr>  
        <td>Email</td>  
        <td><form:input path="email" /></td>  
    </tr>  
    <tr>  
        <td>Telephone</td>  
        <td><form:input path="telephone" /></td>  
    </tr>  
    
    <tr>  
        <td></td>
        <td></td>   
    </tr> 
    <tr>  
        <td colspan="2">  
            <input type="submit" value="Add Contact"/>  
        </td>  
    </tr>  
</table>    
      
</form:form>  
</body>  
</html>  