<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<Female> female = (ArrayList<Female>)request.getAttribute("female");
	ArrayList<Male> male = (ArrayList<Male>)request.getAttribute("male");
%>
{

	"femaleName":<%=female.get(0).getName() %>,
	"femaleBirthday":<%=female.get(0).getBirthday() %>,
	"femalePassword":<%=female.get(0).getPassword() %>,
	"cardNumber":<%=female.get(0).getCardNumber() %>,
	"cardExpirationDate":<%=female.get(0).getCardExpirationDate() %>,
	"cardSecurityCode":<%=female.get(0).getCardSecurityCode() %>,
	"cardNominee":<%=female.get(0).getCardNominee() %>,
	"pointLatitude":<%=female.get(0).getPointLatitude() %>,
	"pointLongitude":<%=female.get(0).getPointLongitude() %>,

	"maleID":<%=male.get(0).getId() %>,
	"maleName":<%=male.get(0).getName() %>,
	"mail":<%=male.get(0).getMail() %>,
	"MalePassword:"<%=male.get(0).getPassword() %>,
	"MaleBirthday":<%=male.get(0).getBirthday() %>,
	"height":<%=male.get(0).getHeight() %>,
	"weight":<%=male.get(0).getWeight() %>,
	"profession":<%=male.get(0).getProfession() %>
}