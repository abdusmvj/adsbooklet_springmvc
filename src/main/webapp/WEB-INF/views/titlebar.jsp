<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
 
<div>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ADSBOOKLET</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/home" />">Home</a></li>
            <li style="background-color:aqua; width: 120px;"><a href="<c:url value="/postads" />"><b>Post Ads</b></a></li>
            <li><a href="contactus">Contact Us</a></li>
        </ul>

        <!-- <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
            <li><a href="signin"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>
        </ul> -->
        
        <ul class="nav navbar-nav navbar-right">
         
    <%  if(session.getAttribute("username") != null) { %>
  	    <li>
          <p class="navbar-text" style="color: white"> Hello, <strong><%=session.getAttribute("username")%></strong>
              <i class="fa fa-sign-in" aria-hidden="true"></i>
          </p>
      </li>
      
		<li><a href="<c:url value="/logout"/>"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
    <% } else { %>
      <li><a href="register" style="color: #fff"><i class="fa fa-user-plus" aria-hidden="true"></i> Sign Up</a></li>
    <li><a href="signin" style="color: #fff"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</a></li>
    <% } %>
    </ul>
    </div>
</nav>

</div>



   
