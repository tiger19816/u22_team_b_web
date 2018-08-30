<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<String> userDatas = (ArrayList<String>)request.getAttribute("USERDATAS");
%>
{
	"userId":"<%=userDatas.get(0) %>",
	"userSex":"<%=userDatas.get(1) %>",
	"userName":"<%=userDatas.get(4) %>"
}