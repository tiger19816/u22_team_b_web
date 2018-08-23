<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<String> reservationData = (ArrayList<String>)request.getAttribute("DATA");
%>
{
	"reservationId":"<%=reservationData.get(0) %>",
	"shopId":"<%=reservationData.get(1) %>",
	"menuNo":"<%=reservationData.get(2) %>",
	"dateTime":"<%=reservationData.get(3) %>",
	"shopName":"<%=reservationData.get(4) %>",
	"message":"<%=reservationData.get(5) %>"
}