<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	String result = (String)request.getAttribute("RESULT");
	String shopId = (String)request.getAttribute("SHOPID");
%>
{
	"result":"<%=result %>",
	"shop_id":"<%=shopId %>"
}