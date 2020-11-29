<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sign In</title>
  </head>
  <body>
  <div>${message}</div>
  <h1>Sign In</h1>
  <form method="get" action="/sign_in">
    Username:&nbsp;<input type="text" name="userName"/><br/>
    Password:&nbsp;<input type="password" name="userPass"/><br/>
    <input type="submit" value="Login"/>
  </form>
  <form action="/sign_up.jsp">
    <button>Sign Up</button>
  </form>
  </body>
</html>
