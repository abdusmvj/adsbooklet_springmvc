
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script type="text/javascript" src="<c:url value="/resources/js/application.js"/>"></script>

<div class="container well" style="width:600px;">
    <h3><b>Add your Information below</b></h3>
    <form action="mobile_sellerbuyer_info" method="post" >
        <div  class="form-group" >
            <label>You are:</label>
               <input type="radio" name="you_are" value="individual" /> IndividuaL
               <input type="radio"  name="you_are" value="dealer" /> Dealer              
        </div>
        <div class="form-group">
            <label>Your Name:</label>
            <input type="text" name="name" id="name" class="form-control" />
                      
        </div>
        <div  class="form-group">
            <label>Your Email:</label>
            <input type="email" name="email" id="email" class="form-control" />
        </div>
        
         <div  class="form-group">
            <label>Mobile No:</label>
            <input type="text" name="mobileno" id="mobileno" class="form-control" />
        </div>
        <div class="form-group">
            <label>Your Address</label>
            <textarea name="address" id="address" rows="5" cols="25" class="form-control" placeholder="Enter Your Present Address"></textarea>
                      
        </div>
       
       
        
        <div  class="form-group">
            <label>State</label>
           
               
                    <select id="stateid" name="stateid"  onchange="getDistrictData(this.options[this.selectedIndex].value)"  class="form-control">
                        <option value="">--Select State--</option>                        
                        <option value="1">West Bengal</option>
                        <option value="2">Assam</option>
                        <option value="3">Bihar</option>
                        <option value="4">Karnataka</option>
                        <option value="5">Orissa</option>
                        
                    </select>
                      
                </div>
                <label>District</label>
                <div  class="form-group" >
                    <select  name="districtid" id="districtid"  class="form-control">
                        <option value="">--Select District--</option>
                    </select>
                       <!--  <div style="color: red;"><html:errors property="districtid"/></div>  -->           
                </div>
               
        <div class="form-group">
            <label>Pin code:</label>
            <input type="text" name="pincode"  class="form-control"/>                 
        </div>
                    
       
        
       <div class="form-group">      		
        		 <input type="submit" value="Post Ad" class="btn btn-primary btn-block" />       
       </div>
    </form>        
</div>



        
