<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="myPackage.Store"%>
<%
	// 자바파일이 필요하므로 위 코드처럼 임포트합니다.
%>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	//로그인 요청인지 회원가입 요청인지를 구분하여 메서드를 실행하도록합니다.
	//싱글톤 방식으로 자바 클래스를 불러옵니다.
	//Store connectDB = Store.getInstance();
	//String returns = connectDB.getList();
	//out.print("접속");
	if(type.equals("getList")) {
		Store connectDB = Store.getInstance();
		String returns = connectDB.getList();
		out.print(returns);
	}
%>