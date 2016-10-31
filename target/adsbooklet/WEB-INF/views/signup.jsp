
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script type="text/javascript" src="<c:url value="/resources/js/application.js"/>"></script>
<div style="width: 600px;" >
    <h3><b>Sign Up Here</b></h3>
    <form action="addRegister"  method="post">
        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="fullname" class="form-control" />
           
        </div>
        <div class="form-group">
            <label>Mobile</label>
            <input type="text" name="mob" class="form-control" />
                      
        </div>
        <div  class="form-group">
            <label>Gender</label>
                <input type="radio" name="gender" value="male" /> Male
               <input type="radio"  name="gender" value="female"/> Female              
        </div>
        <div class="form-group">
            <label>Nationality</label>
            <select name="nationality" class="form-control">
                <option value="">choose nationality</option>
                <option value="indian">Indian</option>
                <option value="others">Others</option>
            </select>
        
        </div>
        <div class="form-group">
            <label>Username or Email Address</label>
            <input type="text" name="username" class="form-control"/>
                       
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="password" name="password"  class="form-control"/>                      
        </div>
        
        <div class="form-group">
            <label>Date of Birth:</label>
            <input type="Date" name="dob" class="form-control"/>        
        </div>
        <div class="form-group">
            <label>Address:</label>
            <textarea name="address" rows="5" cols="25" class="form-control"></textarea>
                      
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
                <div  class="form-group" >
                    <select  name="districtid" id="districtid"  class="form-control">
                        <option value="">--Select District--</option>
                    </select>
                       <!--  <div style="color: red;"><html:errors property="districtid"/></div>  -->           
                </div>
               
        <div class="form-group">
            <label>Pincode</label>
            <input type="text" name="pincode"  class="form-control"/>
                   
        </div>
                   
       
        
       <div class="form-group">      		
        		<input type="submit" value="Sign Up" class="btn-btn info">       
       </div>
    </form>        
</div>


        
