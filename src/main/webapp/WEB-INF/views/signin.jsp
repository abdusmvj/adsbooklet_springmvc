<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/jquery2.2.4.js"></script>

<!--        for through the username and  password incorrect message-->
       
    <div>   
        <% String login_msg = (String)session.getAttribute("logininvalid-flashmsg"); %>
      <% if(login_msg!= null){ %>
        <div class="alert alert-danger disappear">
            <strong>Error!</strong> <%=login_msg %>
        </div>
        <% session.removeAttribute("logininvalid-flashmsg"); } %>
</div> 
    
 <div>   
      <% String msg1 = (String)session.getAttribute("logout-msg"); %>
      <% if(msg1!= null){ %>
        <div class="alert alert-success disappear">
            <strong>Success!</strong> <%= msg1 %>
        </div>
        <% session.removeAttribute("logout-msg"); } %>
</div> 
    
    <h2 class="text-center">Sign In</h2>
	
<div class="col-lg-8">
	<div class="form">
	  <form:form method="post" action="userauth" class="login-form">
	    <div class="form-group">
            <label>Username & Email Address</label>
            <form:input path="username" cssClass="form-control"/>
                       
        </div>
	    <div class="form-group">
            <label>Password</label>
            <form:password path="password" cssClass="form-control"/>
                       
        </div>
	    <div class="form-group"><button type="submit" class="btn btn-primary btn-block">Login</button></div>
	     <div class="row">
            <!--<div class="col-md-3"></div>-->
            <div class="text-center" style="padding: 10px 0px;">
                <label class="label label-info">Can't remember your password? </label><a href="forgotPassword"><i class="glyphicon glyphicon-question-sign"></i> Click here!</a>
                <label class="label label-success">Create new account </label> <a href="register"><i class="glyphicon glyphicon-user"></i> here!</a>
            </div>
        </div>
	  </form:form>
	</div>
</div>
