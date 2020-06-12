import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberService")
public class memberService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// userdao 객체 선언
	private memberDAO dao = new memberDAO();
	// userdto 객체 선언
	private memberDTO dto = new memberDTO();

	int result = 0;

	int change = 0;

	public Connection conn;
	public ResultSet rs;
	public Statement stmt;

	public memberService() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter Writer = response.getWriter();

		// Parameter로 넘어온 값들을 dto에 넣어준다.
		dto.setId(request.getParameter("id").trim());// 빈칸을 신경 쓰지 않기 위해 사용
		dto.setPw(request.getParameter("pw").trim());
		dto.setName(request.getParameter("name").trim());
		dto.setTel(request.getParameter("tel").trim());
		dto.setEmail(request.getParameter("email").trim());
		dto.setDept(request.getParameter("dept").trim());
		dto.setGender(request.getParameter("gender").trim());
		dto.setBirth(request.getParameter("birth").trim());
		dto.setIntroduce(request.getParameter("introduce").trim());


		try {

			String dbURL = "jdbc:mysql://localhost:3306/member?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String dbID = "root";
			String dbPassword = "Ykk159357";
			Class.forName("org.mariadb.jdbc.Driver");

			try {

				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String SQL = "SELECT * FROM memberInfo;";

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				if (rs.getString("id").equals(dto.getId()) && rs.getString("name").equals(dto.getName())
						&& rs.getString("pw").equals(dto.getPw())) {

					Writer.println("<script>");
					Writer.println("alert('update!')");
					Writer.println("</script>");

					change = 1;
					break;

				} else {

					continue;

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (change == 0) {

			result = dao.register(dto);

		} else if (change == 1) {

			result = dao.update(dto);
		}

		if (result == -1) {

			System.out.println("저장 실패!");
			Writer.println("<script>");
			Writer.println("alert('Fail!')");
			Writer.println("</script>");

		} else if (result == -3) {

			System.out.println("업데이트 실패!");
			Writer.println("<script>");
			Writer.println("alert('Fail!')");
			Writer.println("</script>");

		} else {

			System.out.println("저장 성공!");

			Writer.println("<script>");
			Writer.println("alert('Sucsess!');");
			Writer.println("</script>");

			Writer.write("<!DOCTYPE html>");
			Writer.write("<html>");
			Writer.write("<head>");
			Writer.write("<title>가입한 정보</title>");
			Writer.write("</head>");
			Writer.write("<body>");
			Writer.write("아이디 : " + request.getParameter("id"));
			Writer.write("<br>");
			Writer.write("이름 : " + request.getParameter("name"));
			Writer.write("<br>");
			Writer.write("전화번호 : " + request.getParameter("tel"));
			Writer.write("<br>");
			Writer.write("이메일 : " + request.getParameter("email"));
			Writer.write("<br>");
			Writer.write("전공 : " + request.getParameter("dept"));
			Writer.write("<br>");
			Writer.write("성별 : " + request.getParameter("gender"));
			Writer.write("<br>");
			Writer.write("태어난 계절 : " + request.getParameter("birth"));
			Writer.write("<br>");
			Writer.write("자기소개 : " + request.getParameter("introduce"));
			Writer.write("</body>");
			Writer.write("</html>");

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
