<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Sub Category  List </h2>
<div>
      <b>Select Category</b>
  <c:if test="${not empty subcatvalue}">
      <ul class="nav nav-pills nav-stacked">
       <c:forEach var="subcategory_list" items="${subcatvalue}" >
  	         <li ><a href="<c:url value=""/>" style="width:180px; background-color:lightgreen;">${subcategory_list.name}</a></li>
  	    </c:forEach>
      </ul>
  </c:if>
  </div> 