<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<ArrayList<String>> reservationList = (ArrayList<ArrayList<String>>)request.getAttribute("LIST");
%>
{
	"reservationList":<%= reservationList %>
}