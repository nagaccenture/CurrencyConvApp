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

 
	<div class="logout" align="right">
         ${sessionScope.user.username} <a class="links" href="logout" >Logout</a>
        </div>
    <form:form method="POST" action="${contextPath}/currency-converter" modelAttribute="exchangeRateRequest" class="form-signin">
     <h2 class="form-heading" align="center">Currency Conversion</h2>
    <table align="center">
    <tr><td>
    <spring:bind path="amt">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <span class="currency-title"> Amount</span><form:input type="text" path="amt" placeholder="Amount"/>
                  <form:errors path="amt"></form:errors>
            </div>
        </spring:bind>
       </td></tr>
       <tr><td>
        <spring:bind path="from">
            <div class="form-group">
                <span class="currency-title"> From</span><form:select path="from" items="${currencies}"/>
            </div>
        </spring:bind>
        </td></tr>
        <tr><td>
        <spring:bind path="to">
            <div class="form-group">
                <span class="currency-title"> To</span><form:select path="to" items="${currencies}"/>
            </div>
        </spring:bind>
        </td></tr>
        <tr><td>
        <spring:bind path="historyDate">
           <div class="form-group ${status.error ? 'has-error' : ''}">
                <span class="currency-title"> Date</span><form:input type="date" path="historyDate" />
                 <form:errors path="historyDate"></form:errors>
            </div>
        </spring:bind>
        </td></tr>
		<tr><td>
        <button id="getRate" class="btn btn-lg btn-primary" type="submit">Get Rate</button>
        </td></tr>
        </table>
    </form:form>

    <c:if test="${!empty presentCurrencyExchanges}">
        <center>
            <table align="center">
                <tr>
                    <th>From</th>
                    <th>To</th>
                    <th>Rate</th>
                    <th>Amount </th>
                    <th>Exchange Date</th>
                     
                </tr>

                <c:forEach items="${presentCurrencyExchanges}" var="currencyExchange">
                    <tr id="${currencyExchange.id}" >
                        <td><c:out value="${currencyExchange.fromCode}"/></td>
                        <td><c:out value="${currencyExchange.toCode}"/></td>
                        <td><c:out value="${currencyExchange.displayRate}"/></td>
                          <td><c:out value="${currencyExchange.conAmt}"/></td>
                        <td><c:out value="${currencyExchange.displayExchangeDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
            </center>
    </c:if>
    
   <form:form method="GET" action="${contextPath}/history" class="form-signin">
       
		<div align="center">
            <button class="btn btn-lg btn-primary btn-block" type="submit">View History</button>
           
        </div>

    </form:form>
   
    <h2 class="form-heading">
   <%--  <center><c:out value="${nohistory}"/>
    </center> --%>
    <span>${nohistory}</span></h2>
    
    <c:if test="${!empty lastCurrencyExchanges}">
        <center>
         <h2 class="form-heading">History of Currency Conversions</h2>
            <table align="center">
                <tr>
                    <th>From</th>
                    <th>To</th>
                    <th>Rate</th>
                     <th>Amount </th>
                    <th>Exchange Date</th>
                </tr>

                <c:forEach items="${lastCurrencyExchanges}" var="currencyExchange">
                    <tr id="${currencyExchange.id}">
                        <td><c:out value="${currencyExchange.fromCode}"/></td>
                        <td><c:out value="${currencyExchange.toCode}"/></td>
                        <td><c:out value="${currencyExchange.displayRate}"/></td>
                        <td><c:out value="${currencyExchange.conAmt}"/></td>
                        <td><c:out value="${currencyExchange.displayExchangeDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
            </center>
    </c:if>
</div>
<!-- /container -->
 </body>
</html>
