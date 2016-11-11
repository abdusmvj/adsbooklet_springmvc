 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="container well" style="width: 550px;">
    <blockquote align="center" style="color:purple;">Post details about the Tablets below</blockquote>
   
    <form action="<c:url value="/tablets_form"/>">
         <div class="form-group">
            <label>Type Of Ad </label>
            <input type="radio" name="typeofAd" id="typeofAd"  value="sale"/>&nbsp; Sale
             <input type="radio" name="typeofAd" id="typeofAd"  value="buy"/>&nbsp; Buy
          
        </div>
        <div class="form-group">
            <label>Title for Ad</label>
            <input type="text" name="mobileadTitle"  class="form-control" placeholder="Enter title of your Ad"  />            
        </div>
        
        <div class="form-group">
            <label>Item Condition </label>
          
                <input type="radio" name="mobicondition" id="mobicondition" value="used"/> Used
                <input type="radio" name="mobicondition" id="mobicondition" value="new"/> New                 
        </div>
         <div class="form-group">
            <label>Actual Price </label>
            <input type="text" name="actualprice" id="actualprice" placeholder="Enter your maxmimum expectation price" class="form-control" />
             
        </div>
       <div class="form-group">
            <label>Minimum expected  Price </label>
            <input type="text" name="xpectmobiprice"  id="xpectmobiprice" placeholder="Enter your minimum expectation price"  class="form-control" />
            
        </div>
      <%--  <div class="form-group">
            <label>Brand Name </label>
            <select name="mobibrand" id="mobibrand"  class="form-control">
                <option value="">Select Brand Name</option>
                <c:forEach items="${listbrand}" var="brandobj">
                	 <option value="${brandobj.mobbrand_id}">${brandobj.mobbrand_name}</option> 
                	<option value="<c:out  value="${brandobj.mobbrand_id}"/>"><c:out value="${brandobj.mobbrand_name}"/></option>
                </c:forEach> 
            </select>           
        </div> --%>
         <div class="form-group">
            <label>Positng Date </label>
             <input type="date" name="post_date" id="post_date"  class="form-control"/>
                       
        </div> 
          <div class="form-group">
                <label>Description :</label>
            <textarea name="mobidescription"  rows="4" cols="25" class="form-control" placeholder="Enter description of your Ad"></textarea>
                      
        </div>
        <input type="submit" value="Post Ad" class="btn btn-primary btn-block" />
    </form>
    </div>