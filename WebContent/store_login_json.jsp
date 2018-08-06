<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<String> storeDatas = (ArrayList<String>)request.getAttribute("STOREDATA");
	Boolean dataExisted = (Boolean)request.getAttribute("DATAEXISTED");
%>
{
	<% if(dataExisted) { %>
		"dataExisted":"<%= dataExisted %>",
		"storeId":"<%= storeDatas.get(0) %>",
		"storeName":"<%= storeDatas.get(1) %>"
	<% }else{ %>
		"dataExisted":"<%= dataExisted %>"
	<% } %>
}