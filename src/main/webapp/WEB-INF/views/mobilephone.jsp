 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="container well" style="width: 600px;">
    <blockquote align="center">Post details about the Mobile below</blockquote>
   
    <form action="postmobile_phoneads" method="post">
    
     <div class="form-group">
            <label>Add Image</label>
            <input type="text" name="imageid" id="imageid"  class="form-control" placeholder="Enter image id" />            
        </div>
        <div class="form-group">
            <label>Title for Ad</label>
            <input type="text" name="mobileadTitle"  class="form-control" placeholder="Enter title of your Ad"  />            
        </div>

        <div class="form-group">
         <label>Type of Ad </label>
           
                <input type="radio" name="typeofAd" id="typeofAd"  value="sale"/>&nbsp; Sale
                <input type="radio" name="typeofAd" id="typeofAd"  value="buy"/>&nbsp; Buy
                      
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
        <div class="form-group">
            <label>Brand Name </label>
            <select name="mobibrand" id="mobibrand"  class="form-control">
                <option value="">Select Brand Name</option>
                <c:forEach items="${listbrand}" var="brandobj">
                	 <option value="${brandobj.mobbrand_id}">${brandobj.mobbrand_name}</option> 
                	<%-- <option value="<c:out  value="${brandobj.mobbrand_id}"/>"><c:out value="${brandobj.mobbrand_name}"/></option> --%>
                </c:forEach> 
            </select>           
        </div>
        <div class="form-group">
            <label>Model </label>
             <input type="text" name="mobimodel" id="mobimodel" placeholder="Enter your model number" class="form-control"/>
                       
        </div>
        <div class="form-group">
            <label>Operating System </label>
            <select name="mobiOS" id="mobiOS" onfocus="fetchMobiOSList()" class="form-control">
                <option value="" selected>Select OS</option>
                <option value="android_os">Android OS</option>
                <option value="windows_os">Windows OS</option>
                <option value="apple_os">Apple iOS</option>
                <option value="blackberry_os">Blackberry OS</option>
                <option value="other">Other</option>
            </select>
                       
        </div>
        <div class="form-group">
            <label>Sim card supported </label>
            <select name="mobisimNo" id="mobisimNo" onfocus="fetchMobiSimNoList()" class="form-control">
                <option value="" selected>Phone Simcard Supported</option>
                <option value="single sim">Single Sim</option>
                <option value="dual sim">Dual Sim</option>
            </select>
                       
        </div>
        <!-- <div class="form-group">
            <label>Includes </label>
            <input type="checkbox" name="includesid" value="1"/>&nbsp;Charger
            <input type="checkbox" name="includesid" value="2"/>&nbsp;USB Cable
            <input type="checkbox" name="includesid" value="3"/>&nbsp;Headphone
        </div> -->
        
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