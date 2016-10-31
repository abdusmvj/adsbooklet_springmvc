<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Upload File</h2>

<form method="post" action="<c:url value="/uploadFile"/>" enctype="multipart/form-data">
	<label>Upload Image file</label>
	<input type="file" name="file">
	<input type="submit" value="submit">
</form>

</body>
</html>
