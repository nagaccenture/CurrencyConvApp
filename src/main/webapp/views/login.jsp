<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>


    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">

</head>

<body>

<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
     <h2 class="form-heading" align="center">Log in</h2>
     <c:if test="${flag}">
      <h2 class="form-heading" align="center">Registered successfully ,please login </h2>
     </c:if>
<%--        <h2 class="form-heading" align="center"><c:out value="${message}"/></h2>
 --%>        <div class="form-group ${error != null ? 'has-error' : ''} ">
        <table align="center">
        <tr>  <td>  <span>${message}</span> </td></tr>
        <tr>
        <td>
            <input name="username" type="text" class="form-control" placeholder="Email"
                   /></td></tr>
                   <tr><td>
            <input name="password" type="password" class="form-control" placeholder="Password"/></td></tr>
          <tr> <td>  <span>${error}</span> </td></tr>
			
        <tr><td>    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button></td></tr>
        <tr><td>    <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4></td></tr>
            </table>
        </div>

    </form>

</div>
<!-- /container -->
 
 
</body>
</html>
