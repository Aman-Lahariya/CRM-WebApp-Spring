<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Customer</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="container"">
     <h3>Save Customer</h3>
     <form:form action= "saveCustomer" modelAttribute= "customerFormModelAttribute" method= "POST">
     	<form:hidden path="id"/>
         <table>
             <tbody>
                 <tr>
                     <td><label>First name:</label></td>
                     <td><form:input path= "firstName" /></td>
                 </tr>
                  <tr>
                     <td><label>Last name:</label></td>
                     <td><form:input path= "lastName" /></td>
                 </tr>
                  <tr>
                     <td><label>Email:</label></td>
                     <td><form:input path= "email" /></td>
                 </tr>
                 <tr>
                 	<td><input type="submit" value="Save" class="save" /></td>
                 </tr>
             </tbody>
         </table>
     </form:form>
     
     <a href="${pageContext.request.contextPath}/customer/list">Back to Customer List</a>
    </div>
</body>
</html>