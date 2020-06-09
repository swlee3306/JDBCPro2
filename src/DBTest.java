import java.io.IOException; // 예외타입
import java.sql.Connection; // DB 연동 객체
import java.sql.DriverManager; // JDBC driver 검색
import java.sql.SQLException; // 쿼리문 예외타입

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class HelloServlet
 */
@WebServlet("/DB")

public class DBTest extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBTest() {
		super(); // 부모 생성자 실행
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		Connection conn = null; // DB 연동할 객체 생성
 
		try { // jdbc connect j 라이브러리 로딩 예외 처리
			Class.forName("org.mariadb.jdbc.Driver"); // 해당 클래스가 메모리에 로드 및 실행
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} 

		try { // drive 클래스를 이용해 커넥션 객체에 localhost:3306/DB 와 연동 및 예외처리
			String url = "jdbc:mysql://localhost:3306/member?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			
			conn = DriverManager.getConnection(url, "root", "Ykk159357"); // DB 로그인 정보로 연동
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} finally {
			response.getWriter().append(conn.toString() + "<br/>");
			response.getWriter().append("localhost:3306/member (DateBase 연동 성공)");
	
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
