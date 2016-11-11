
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css" />">
<link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-validator.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/application.js"/>"></script>

<style>
@import url(http://fonts.googleapis.com/css?family=Montserrat);
		.error {
  					color: red;
			}
</style>

<div class="container well" style="width: 500px;" >
    <h3><b style="color: purple;">Sign Up Here</b></h3>
    <form action="addRegister" name="form-signup" id="form-signup"  method="post">
        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="fullname" id="fullname" class="form-control" placeholder="Enter Fullname" />
           
        </div>
        <div class="form-group">
            <label>Mobile</label>
            <input type="text" name="mob" id="mob" class="form-control"  placeholder="Enter phone number "/>
                      
        </div>
        <div  class="form-group">
            <label>Gender</label>
                <input type="radio" name="gender" id="gender" value="male" />
                 Male
               <input type="radio"  name="gender" id="gender" value="female"/> Female              
        </div>
        <div class="form-group">
            <label>Nationality</label>
            <select name="nationality" id="nationality" class="form-control">
                <option value="">choose nationality</option>
                <option value="indian">Indian</option>
                <option value="others">Others</option>
            </select>
        
        </div>
        <div class="form-group">
            <label>Username or Email Address</label>
            <input type="email" name="username" id="username" class="form-control" placeholder="Enter username or email" />
                       
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password"/>                      
        </div>
        
        <div class="form-group">
            <label>Date of Birth:</label>
            <input type="text" name="dob" id="dob" class="form-control" placeholder="Select date of birth"/>        
        </div>
        <div class="form-group">
            <label>Address:</label>
            <textarea name="address" id="address" rows="5" cols="25" class="form-control" placeholder="Enter Present Address"></textarea>
                      
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
            <label>Pin code</label>
            <input type="text" name="pincode" id="pincode" class="form-control" placeholder="Enter Pin Code"/>
                   
        </div>
                   
       
        
       <div class="form-group">      		
        		<input type="submit" value="Sign Up" class="btn btn-info btn-block">       
       </div>
    </form>        
</div>
<!-- date picker in jquery -->
<script type="text/javascript">

$('#dob').datepicker({
	dateFormat: "yy-mm-dd",
	//changeYear: true,
	//changeMonth: true,
	//yearRange: '1960:2012',
	//defaultDate: '1960-01-01'
});
</script>
<script>
$.validator.addMethod("exactlength", function(value, element, param) {
	return this.optional(element) || value.length == param;
}, "Please enter exact no of characters specified");

// Setup form validation on the #register-form element
$("#form-signup").validate({
	
  // Specify the validation rules
	rules: {
		fullname:"required",
		
		mob:{
				required:true,
			    exactlength:10
			},
			
			gender:
				{
				    required:true,
				},
			
				dob:
				{
				    required:true,
				},
				nationality:{required:true,},
				address:{required:true,},
				stateid:{required:true,},
				districtid:{required:true,},
				pincode:{required:true,exactlength:6},
		
	     username:{
			required: true,
			username: true
		},
		password: {
			required: true,
			minlength: 6,
			maxlength: 20
		},
		
	},
	
  // Specify the validation error messages
	messages: {
		username: {
			required: "Email is required",
			username: "Please enter a valid email"
		},
		password: {
			required: "Password is required",
			minlength: "Password must be minimum 6 characters",
			maxlength: "Password must be maximum 20 characters"
		},
		mob:{
			reuired:"Phone number is required",
			exactlength:"Mobile number should be 10 digits numeric number"
			
		},
		gender:{
			required:"Please Select Gender"
			
		},
		
		dob:
		{
			required:"Please Enter your Date Of Birth"
		},
		
		nationality:
		{
			required:"Please select nationality"
		},
		address:
		{
			required:"Please Enter your Address"
		},
		stateid:
		{
			required:"Please select one state"
		},
		
		districtid:
		{
			required:"Please select one district"
		},
		
		pincode:
		{
			required:"Pin number is required",
			exactlength:"Pin number should be 6 digits numeric number"
			
		},
		
	}
});
</script>


        
