<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<String> userDatas = (ArrayList<String>)request.getAttribute("USERDATAS");
%>
{
	"maleId":"<%=userDatas.get(0) %>",
	"maleName":"<%=userDatas.get(1) %>",
	"done":"<%=userDatas.get(2) %>"
}