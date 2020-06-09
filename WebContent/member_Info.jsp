<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	<caption>회원 정보</caption>
	<table width="100%" border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>전공</th>
				<th>성별</th>
				<th>생일</th>
				<th>자기소개</th>
			</tr>
		</thead>
		<tbody>
		
		
		
	<%
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         
        try{
        	
        	String dbURL = "jdbc:mysql://localhost:3306/member?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
            String dbID = "root";
            String dbPassword = "Ykk159357";
            
        	Class.forName("org.mariadb.jdbc.Driver");
	        conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
             
            pstmt = conn.prepareStatement("select * from memberInfo");
             
            rs = pstmt.executeQuery();
             
            while(rs.next()){
    %>
			<tr>
				<td><%= rs.getString("id") %></td>
				<td><%= rs.getString("name") %></td>
				<td><%= rs.getString("tel") %></td>
				<td><%= rs.getString("email") %></td>
				<td><%= rs.getString("dept") %></td>
				<td><%= rs.getString("gender") %></td>
				<td><%= rs.getString("birth") %></td>
				<td><%= rs.getString("introduce") %></td>
			</tr>
			<%
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }
    %>
		</tbody>
	</table>
</body>
</html>

