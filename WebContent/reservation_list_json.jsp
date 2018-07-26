<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<ArrayList<String>> reservationList = (ArrayList<ArrayList<String>>)request.getAttribute("LIST");
%>
{
	"reservationList":[
		<% for(int i=0; i<reservationList.size(); i++){ %>
		{
			"storeName":"<%= reservationList.get(i).get(0) %>",
			"reservationDate":"<%= reservationList.get(i).get(1) %>"
		}<% if(i != (reservationList.size()-1)){ %>,<% } %>
		<% } %>
	]
}