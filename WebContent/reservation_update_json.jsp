<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
	Boolean reservationData = (Boolean)request.getAttribute("RESULT");
%>
{
	"result":"<%=reservationData %>"
}