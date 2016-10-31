<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
      
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 

        
 
  

<div>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ADSBOOKLET</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/home" />">Home</a></li>
            <li style="background-color:aqua; width: 120px;"><a href="postads"><b>Post Ads</b></a></li>
            <li><a href="contactus">Contact Us</a></li>
        </ul>

        <!-- <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
            <li><a href="signin"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>
        </ul> -->
        
        <ul class="nav navbar-nav navbar-right">
         
    <%  if(session.getAttribute("user_id") != null && session.getAttribute("username") != null && session.getAttribute("user_fullname") != null) { %>
  		 <li>
          <p class="navbar-text" style="color: white"> Hello, <strong><%=session.getAttribute("username")%></strong>
              <span  class="glyphicon glyphicon-user" style="color: #fff"></span>
          </p>
      </li>
      
		<li><a href="<c:url value="/logout"/>">Logout</a></li>
    <% }  %>
    </ul>
    </div>
</nav>

</div>



   
