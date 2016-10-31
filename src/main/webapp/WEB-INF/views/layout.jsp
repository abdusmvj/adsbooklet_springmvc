<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<script type="text/javascript" src="<c:url value="/resources/js/jquery2.2.4.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>


</head>  
<body>  

  <table border="1"  cellspacing="2" align="center">
	<tr>
		<td height="30" width="1200" colspan="2" bgcolor="#FFA07A">
			<tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr>
		<td height="07" width="1200" colspan="2" bgcolor="#999999">
			<tiles:insertAttribute name="titlebar" />
		</td>
	</tr>

	<tr >
			<td width="150" height="550" valign="top" bgcolor="#00FFFF">
					<tiles:insertAttribute name="menu" />
			</td>
			<td width="750" height="550" valign="middle" align="center">
					<tiles:insertAttribute name="body" />
			</td>
	</tr>
	<tr>
		<td height="60" width="1200" colspan="2" bgcolor="#999999" >
			<tiles:insertAttribute name="footer" />

		</td>
	</tr>
</table>
</body>  
</html>