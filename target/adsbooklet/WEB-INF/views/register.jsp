<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<c:url value="/resources/js/application.js"/>"></script>
 
<div class="container" ng-app="district-app">
<div class="col-md-9" ng-controller="district-ctrl">
<div style="width: 400px;" >
    <h3><b>Sign Up Here</b></h3>
    <form:form action="addRegister" >
        <div class="form-group">
            <label>Full Name</label>
            <form:input path="fullname" cssClass="form-control" />
           
        </div>
        <div class="form-group">
            <label>Mobile</label>
            <form:input path="mob" cssClass="form-control" />
                      
        </div>
        <div  class="form-group">
            <label>Gender</label>
                <form:radiobutton path="gender" value="male" cssClass="form-control"/> Male
                <form:radiobutton path="gender" value="female" cssClass="form-control"/> Female                
        </div>
        <div class="form-group">
            <label>Nationality</label>
            <form:select path="nationality" cssClass="form-control">
                <form:option value="">choose nationality</form:option>
                <form:option value="indian">Indian</form:option>
                <form:option value="others">Others</form:option>
            </form:select>
        
        </div>
        <div class="form-group">
            <label>Username or Email Address</label>
            <form:input path="username" cssClass="form-control"/>
                       
        </div>
        <div class="form-group">
            <label>Password</label>
            <form:password path="password"  cssClass="form-control"/>                      
        </div>
        <div class="form-group">
            <label>Address</label>
            <form:textarea path="address" cssClass="form-control" />
                      
        </div>
        <div  class="form-group">
            <label>State</label>
           
               
                    <select id="stateid" name="stateid" ng-model="stateid" ng-change="getDistrictData()"  class="form-control">
                        <option value="">--Select State--</option>                        
                        <option value="1" >West Bengal</option>
                        <option value="2" >Assam</option>
                        <option value="3" >Bihar</option>
                        <option value="4" >Karnataka</option>
                        <option value="5" >Orissa</option>
                        
                    </select>
                      
                </div>
                <div  class="form-group" >
                    <select ng-model="districtid" name="districtid" id="districtid"  class="form-control">
                        <option value="">--Select District--</option>
                       <!--  <option ng-repeat="district in districtList" value="{{district.districtid}}">{{district.districtname}}</option> -->
                    </select>
                       <!--  <div style="color: red;"><html:errors property="districtid"/></div>  -->           
                </div>
            
            
            
       
        <div class="form-group">
            <label>Pincode</label>
            <form:input path="pincode"  cssClass="form-control"/>
                   
        </div>
        <div class="form-group">
            <label>Security Question</label>
            <form:select path="secure" cssClass="form-control">
                <form:option value="">--Select your Security Question--</form:option>
                <form:option value="1">what is your first school name?</form:option>                        
                <form:option value="2" >what is your favorite food?</form:option>
                <form:option value="3" >what is your favorite color?</form:option>
                <form:option value="4" >what is your favorite holiday destination?</form:option>
                <form:option value="5" >what is your favorite pet?</form:option>
           </form:select>
         </div>             
       <div class="form-group">
            <label>Answer</label>
            <form:input path="answer" cssClass="form-control"/>
           
           <!--  <div style="color: red;"><html:errors property="ans"/></div>   -->          
        </div>
        
       <div class="form-group">      		
        		<input type="submit" value="Sign Up" cssClass="form-control">       
       </div>
    </form:form>        
</div>
</div>
</div>


        
