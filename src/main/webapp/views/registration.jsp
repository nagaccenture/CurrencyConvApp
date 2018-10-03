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

    <title>Create an account</title>

  <%--   <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="${contextPath}/resources/css/common.css" rel="stylesheet">  --%>
 <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>-->
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

    <form:form method="POST" action="${contextPath}/registration" modelAttribute="userForm" class="form-signin">
    
        <h2 class="form-signin-heading" align="center">Create your account</h2>
        <table align="center">
        <tr><td>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
		 <tr><td>
		<spring:bind path="firstname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstname" class="form-control" placeholder="firstname"
                            autofocus="true"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
		<tr><td>
		 <spring:bind path="lastname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastname" class="form-control" placeholder="lastname"
                            autofocus="true"></form:input>
                <form:errors path="lastname"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
        <tr><td>
        <spring:bind path="birthDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <span class="currency-title"> Date of Birth</span><form:input type="date" path="birthDate" id="datepicker" />
                 <form:errors path="birthDate"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
        <tr><td>
        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
		<tr><td>
        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
		<tr><td>
        <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </td></tr>
        </table>
    </form:form>

</div>
<!-- /container -->
</body>
</html>
