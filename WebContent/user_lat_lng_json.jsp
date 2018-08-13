<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<% String[] result = (String[]) request.getAttribute("result"); %>
{
	"lat" : "<%= result[0] %>",
	"lng" : "<%= result[1] %>"
}