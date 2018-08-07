<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<ArrayList<String>> historyList = (ArrayList<ArrayList<String>>)request.getAttribute("LIST");
%>
{
	"historyList":[
		<% for(int i=0; i<historyList.size(); i++){ %>
		{
			"storeName":"<%= historyList.get(i).get(0) %>",
			"historyPrice":"<%= historyList.get(i).get(1) %>",
			"historyDate":"<%= historyList.get(i).get(2) %>",
			"storeId":"<%= historyList.get(i).get(3) %>"
		}<% if(i != (historyList.size()-1)){ %>,<% } %>
		<% } %>
	]
}