<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.sql.*" %>


<%
 
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
 
      try
      {
    	  String dbURL = "jdbc:mysql://localhost:3306/member?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
          String dbID = "root";
          String dbPassword = "Ykk159357";
          Class.forName("org.mariadb.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
          Statement st = conn.createStatement();
			
            String sql = "SELECT * FROM memberInfo;";
            rs = st.executeQuery(sql);
           	sql = "DELETE FROM memberInfo";
           	st.execute(sql);
           	sql = "SELECT * FROM memberInfo;";
           	rs = st.executeQuery(sql);
            
            
%>

 

<html>
<head><title>���̺� ��ü ����</title></head>
<body>
      members ���̺��� ���ڵ带 ��ü �����߽��ϴ�.
</body>
</html>
<%
                 
      }catch(Exception e){
            e.printStackTrace();
      }finally{
            if(rs != null) try { rs.close(); 
            } catch(SQLException sqle) {
            	
            }
            if(pstmt != null) try { pstmt.close(); 
            } catch(SQLException sqle) {
            	
            }
            if(conn != null ) try { conn.close(); 
            } catch(SQLException sqle) {
            	
            }
      }
%>