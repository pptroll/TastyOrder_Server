<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="myPackage.Menu"%>
<%
	// 자바파일이 필요하므로 위 코드처럼 임포트합니다.
%>
<%
	String test = null;
	String returns = null;
	String type, businessnumber, topcategoryname, categoryname = null;
	
	request.setCharacterEncoding("UTF-8");
	type = request.getParameter("type");
	businessnumber = request.getParameter("businessnumber");
	topcategoryname = request.getParameter("topcategoryname");
	categoryname = request.getParameter("categoryname");
	
	if(type != null){
		if(type.equals("getTopcategory")) {
			Menu connectDB = Menu.getInstance();
			returns = connectDB.getTopcategory(businessnumber);
			out.print(returns);
		}	
		else if(type.equals("getCategory")){
			Menu connectDB = Menu.getInstance();
			returns = connectDB.getCategory(businessnumber, topcategoryname);
			out.print(returns);			
		}
		else if(type.equals("getItem")){
			Menu connectDB = Menu.getInstance();
			returns = connectDB.getItem(businessnumber, topcategoryname, categoryname);
			out.print(returns);			
		}
	}
	else{
	}
%>