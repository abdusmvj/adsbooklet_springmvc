<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Upload File</h2>

<form method="post" action="<c:url value="/uploadfile"/>" enctype="multipart/form-data">
	<label>Upload Image file</label>
	Select File:<input type="file" name="file">
	<input type="submit" value="submit">
</form>

</body>
</html>
