<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css" />">
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>





<h2 class="text-center">Forgot Password</h2>

<div class="container-well" style="width:550px;">	
	  <form  action="forgotpasswordAction" method="post">
	  <div class="form-group">
	  <label>Enter Username or Email</label>
	       <input type="email" name="username" id="username" class="form-comtrol"  placeholder="Enter email Address"/>
	    </div>
	    <div class="form-group">
	    <label>Enter new Password</label>
	       <input type="password" name="password" id="password" class="form-comtrol" placeholder="Enter New Password"/> 
	    </div> 
	    
	    <input type="submit" value="Submit" class="btn btn-primary btn-block">
      </form>
	</div>


