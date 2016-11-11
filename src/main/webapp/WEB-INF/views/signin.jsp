<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css" />">
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-validator.js"/>"></script>
<style>
@import url(http://fonts.googleapis.com/css?family=Montserrat);
		.error {
  					color: red;
			}
</style>

<!-- <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/jquery2.2.4.js"></script> -->

<!--        for through the username and  password incorrect message-->
       
    <div>   
        <% String login_msg = (String)session.getAttribute("logininvalid-flashmsg"); %>
      <% if(login_msg!= null){ %>
        <div class="alert alert-danger disappear">
            <strong>Error!</strong> <%=login_msg %>
        </div>
        <% session.removeAttribute("logininvalid-flashmsg"); } %>
</div> 
   <!--  This for logout msg to user -->
 <div>   
      <% String msg1 = (String)session.getAttribute("logout-msg"); %>
      <% if(msg1!= null){ %>
        <div class="alert alert-success disappear">
            <strong>Success!</strong> <%= msg1 %>
        </div>
        <% session.removeAttribute("logout-msg"); } %>
</div> 
 <div>   
      <% String user_msg = (String)session.getAttribute("fls-msg-user"); %>
      <% if(user_msg!= null){ %>
        <div class="alert alert-warning disappear">
            <strong>Warning!</strong> <%= user_msg %>
        </div>
        <% session.removeAttribute("fls-msg-user"); } %>
</div>


    
    <h2 class="text-center" style="color:purple;">Sign In</h2>
	
<div class="col-lg-8">
	<div class="form">
	  <form:form method="post" action="userauth"  name="form-signin" id="form-signin" class="login-form">
	    <div class="form-group">
            <label>Username or Email Address</label>
            <form:input path="username" name="username" cssClass="form-control"/>
                       
        </div>
	    <div class="form-group">
            <label>Password</label>
            <form:password path="password" name="username" cssClass="form-control"/>
                       
        </div>
	    <div class="form-group"><button type="submit" class="btn btn-primary btn-block">Login</button></div>
	     <div class="row">
            <!--<div class="col-md-3"></div>-->
            <div class="text-center" style="padding: 20px 0px;">
                <label class="label label-info">Can't remember your password? </label><a href="forgotPassword"><i class="glyphicon glyphicon-question-sign"></i> Click here!</a>
                <label class="label label-success">Not Register </label> <a href="register"><i class="glyphicon glyphicon-user"></i> Click here!</a>
            </div>
        </div>
	  </form:form>
	</div>
</div>

<!-- jquery validation for login page --> 
<script>
$.validator.addMethod("exactlength", function(value, element, param) {
	return this.optional(element) || value.length == param;
}, "Please enter exact no of characters specified");

// Setup form validation on the #register-form element
$("#form-signin").validate({
	
  // Specify the validation rules
	rules: {
		
		
		
		
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
		username: 
		{
			required: "Email is required",
			username: "Please enter a valid email"
		},
		password: {
			required: "Password is required",
			minlength: "Password must be minimum 6 characters length",
			maxlength: "Password must be maximum 20 characters length"
		},
		
		
	}
});
</script>


