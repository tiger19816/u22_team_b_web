<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
String updateResult = (String)request.getAttribute("RESULT");
%>
{
	"updateResult":"<%= updateResult %>"
}