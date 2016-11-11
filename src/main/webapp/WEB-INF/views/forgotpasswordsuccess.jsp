<!-- This is forgot message to user -->
<div>   
        <% String forgot_pwmsg = (String)request.getAttribute("fg_msg"); %>
      <% if(forgot_pwmsg!= null){ %>
        <div class="alert alert-success disappear">
            <strong>Success!</strong> <%=forgot_pwmsg %>
        </div>
        <% request.removeAttribute("fg_msg"); } %>
</div> 

<div>

<a href="signin">Click here to Sign In</a>
</div>