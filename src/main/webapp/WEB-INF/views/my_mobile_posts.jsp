<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dataTables.bootstrap.css"/>">
 <div>
 <%-- <h3>Mobile Posted Details...</h3>
<ul>
     <c:forEach var="post" items="${myposts}">
 	      <b>Mobile brand:</b>   <li>${post.mobibrand}</li>
 	      <b>Mobile Model:</b>   <li>${post.mobimodel}</li>
 	      <b>Your Mobile OS System</b>   <li>${post.mobiOS}</li>
 	      <b>Mobile Description:</b>   <li>${post.mobidescription}</li>
 	       <b>posting Date:</b>   <li>${post.post_date}</li>
 	      
 </c:forEach> 
 
 </ul>   --%>
 </div>
 
<div>

		<table id="example" class="table table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th colspan="2" class="text-center">Mobile Phone Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${myposts}" >
			
			<tr>
				<th>Your Name:</th>
				<td>${post.name}</td>
			</tr>
			
			
			<tr>
				<th>Your Email:</th>
				<td>${post.email}</td>
			</tr>
			
			<tr>
				<th>Your Phone No:</th>
				<td>${post.mobileno}</td>
			</tr>
			
			<tr>
				<th>Mobile Model:</th>
				<td>${post.mobimodel}</td>
			</tr>
			<tr>
				<th>Your Mobile OS System</th>
				<td>${post.mobiOS}</td>
			</tr>
			<tr>
				<th>Mobile Description:</th>
				<td>${post.mobidescription}</td>
			</tr>
			<tr>
				<th>Posting Date:</th>
				<td>${post.post_date}</td>
			</tr>
			
			<tr>
				<th>Your Address:</th>
				<td>${post.address}</td>
			</tr>
			
			
			</c:forEach>
		</tbody>
		
		</table>
</div>
<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js"/>"></script> --%>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.js"/>"></script>
<!-- <script type="text/javascript">
$(document).ready(function() {
   $('#example').DataTable();
});
</script> -->