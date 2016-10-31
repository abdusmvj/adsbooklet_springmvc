<h2>Registration Successfully..............</h2>
<div>   
      <% String signup_msg1 = (String)session.getAttribute("signup-msg"); %>
      <% if(signup_msg1!= null){ %>
        <div class="alert alert-success disappear">
            <strong>Success!</strong> <%=signup_msg1 %>
        </div>
        <% session.removeAttribute("signup-msg"); } %>
</div> 