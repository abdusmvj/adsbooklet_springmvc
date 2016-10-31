<h2>Welcome to Home page</h2>


<div>   
      <% String login_success = (String)session.getAttribute("loginsuccess-flashmsg"); %>
      <% if(login_success!= null){ %>
        <div class="alert alert-success disappear">
            <strong>Success!</strong> <%= login_success %>
        </div>
        <% session.removeAttribute("loginsuccess-flashmsg"); } %>
</div> 
    <div>
    
   
     Hello, <%=session.getAttribute("username")%> 
      
    </div>