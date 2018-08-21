<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String strResult = (String)request.getAttribute("result");
	String strId = (String)request.getAttribute("id");
%>
{
	"result":<%= strResult %>,
	"id":<%= strId %>

}