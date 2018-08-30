<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	String[] cardDatas = (String[])request.getAttribute("CARDDATAS");
%>
{
	"cardNo":"<%= cardDatas[0] %>",
	"cardDate":"<%= cardDatas[1] %>",
	"cardName":"<%= cardDatas[2] %>",
	"cardCode":"<%= cardDatas[3] %>"
}