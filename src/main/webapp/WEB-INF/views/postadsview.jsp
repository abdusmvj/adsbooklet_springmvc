<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div><h4><b>Select Category</b></h4></div>
<div>
   <ul class="nav nav-pills nav-stacked">
    
      <li><a href="#" style="width:180px; background-color:lightgreen;">Home & Lifestyle</a></li> 
      <li><a href="#" style="width:180px; background-color:lightgreen;">Electronics Appliances</a></li>
      <li><a href="mobiles&tablets" style="width:180px; background-color:lightgreen;">Mobile & Tablets</a></li> 
      <!-- <li><a href="#" style="width:180px; background-color:lightgreen;">Entertainment</a></li>
      <li><a href="#" style="width:180px; background-color:lightgreen;">Car & Bikes</a></li> 
      <li><a href="#" style="width:180px; background-color:lightgreen;">Real Estate</a></li>
      <li><a href="#" style="width:180px; background-color:lightgreen;">Jobs</a></li> 
      <li><a href="#" style="width:180px; background-color:lightgreen;">Education & Learning</a></li>
      <li><a href="#" style="width:180px; background-color:lightgreen;">Community & Events</a></li> 
      <li><a href="#" style="width:180px; background-color:lightgreen;">Matrimonial</a></li>
      <li><a href="#" style="width:180px; background-color:lightgreen;">Pets & Pets care</a></li> 
      <li><a href="#" style="width:180px; background-color:lightgreen;">Other</a></li>  -->
           
  
  </ul>  
  </div>    
  
  <div>
      <h4><b>Select Category</b></h4>
  <c:if test="${not empty cat_list}">
      <ul class="nav nav-pills nav-stacked">
       <c:forEach var="category_value" items="${cat_list}" >
  	         <li ><a href="<c:url value="/show_details/${category_value.category_id}"/>" style="width:180px; background-color:lightgreen;">${category_value.category_name}</a></li>
  	          <%-- <li ><a href="<%=request.getContextPath() %>/show_details/${category_value.category_id}" style="width:180px; background-color:lightgreen;">${category_value.category_name}</a></li> --%>
  	    </c:forEach>
      </ul>
  </c:if>
  </div> 