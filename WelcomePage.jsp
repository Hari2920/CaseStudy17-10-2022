<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="performRecharge" method="get">
<h4>
Enter Mobile Number: <input type="text" name="mobileNumber"/>
<br/>
Select Plans from below: 
<table border="2">
<tr style="background-color:orange; color: blue;">    
<th>Plan id</th>
    <th>Days</th>
    <th>Talktime</th>
    <th>Data</th>
    <th>Price</th>
    <th>Select</th>
    </tr>
    <c:forEach  items="${offerList}" var="offer">
   <tr style="background-color: yellow; color: blue;">
      
      <td>${offer.id}</td>
      <td>${offer.days}</td>
      <td>${offer.talkTime}</td>
      <td>${offer.data} GB</td>
      <td>${offer.price}</td>
      <td><input type="radio" name="offerId" value="${offer.id}"/> 
      </tr>
     </c:forEach>
</table>
</h4>
<input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>