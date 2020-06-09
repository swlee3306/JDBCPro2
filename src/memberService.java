import java.io.IOException;
import java.io.PrintWriter;

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

	public memberService() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter Writer = response.getWriter();

		// Parameter로 넘어온 값들을 dto에 넣어준다.
		dto.setId(request.getParameter("id").trim());
		dto.setPw(request.getParameter("pw").trim());
		dto.setName(request.getParameter("name").trim());
		dto.setTel(request.getParameter("tel").trim());
		dto.setEmail(request.getParameter("email").trim());
		dto.setDept(request.getParameter("dept").trim());
		dto.setGender(request.getParameter("gender").trim());
		dto.setBirth(request.getParameter("birth").trim());
		dto.setIntroduce(request.getParameter("introduce").trim());
		
		
		/* 
		 * 
		 * 주석 처리 된 부분이 업데이트를 검사하는 부분인데요
		 * 이 부분이 코드에 문제가 있는지 계속 DAO 클래스에 있는 SQL 을 실행 시키지 못합니다.
		 * 구현 하려 했던 로직은
		 * 입력한 아이디 이름이 디비에 있는지 먼저 검사 하고 
		 * 그 다음 입력된 패스워드랑 디비에 있는 패스워드랑 같은지 비교한 후
		 * 업데이트를 시키는 로직으로 구현 하려 했습니다.
		 * 반환 방식은 정수형 데이터를 반환해서 각 상황마다 If else 문을 이용하여 구현 하려 했습니다.
		 * 
		 */
		
		
		

//		result = dao.update(dto);
//		
//		if (result == -2) {
//
//			result = dao.register(dto);
//
//			if (result == -1) {
//				System.out.println("저장 실패!");
//				Writer.println("<script>");
//				Writer.println("alert('Fail!')");
//				Writer.println("</script>");
//
//			}
//
//			else {
//				System.out.println("저장 성공!");
//
//				Writer.println("<script>");
//				Writer.println("alert('Sucsess!');");
//				Writer.println("</script>");
//
//				Writer.write("<!DOCTYPE html>");
//				Writer.write("<html>");
//				Writer.write("<head>");
//				Writer.write("<title>가입한 정보</title>");
//				Writer.write("</head>");
//				Writer.write("<body>");
//				Writer.write("아이디 : " + request.getParameter("id"));
//				Writer.write("<br>");
//				Writer.write("이름 : " + request.getParameter("name"));
//				Writer.write("<br>");
//				Writer.write("전화번호 : " + request.getParameter("tel"));
//				Writer.write("<br>");
//				Writer.write("이메일 : " + request.getParameter("email"));
//				Writer.write("<br>");
//				Writer.write("전공 : " + request.getParameter("dept"));
//				Writer.write("<br>");
//				Writer.write("성별 : " + request.getParameter("gender"));
//				Writer.write("<br>");
//				Writer.write("태어난 계절 : " + request.getParameter("birth"));
//				Writer.write("<br>");
//				Writer.write("자기소개 : " + request.getParameter("introduce"));
//				Writer.write("</body>");
//				Writer.write("</html>");
//
//			}
//
//		} else if (result == 2) {
//
//			System.out.println("패스워드 틀림!");
//			Writer.println("<script>");
//			Writer.println("alert('Password error!');");
//			Writer.println("</script>");
//
//		} else {
//			System.out.println("업데이트 성공!");
//
//			Writer.println("<script>");
//			Writer.println("alert('Sucsess!');");
//			Writer.println("</script>");
//
//			Writer.write("<!DOCTYPE html>");
//			Writer.write("<html>");
//			Writer.write("<head>");
//			Writer.write("<title>가입한 정보</title>");
//			Writer.write("</head>");
//			Writer.write("<body>");
//			Writer.write("아이디 : " + request.getParameter("id"));
//			Writer.write("<br>");
//			Writer.write("이름 : " + request.getParameter("name"));
//			Writer.write("<br>");
//			Writer.write("전화번호 : " + request.getParameter("tel"));
//			Writer.write("<br>");
//			Writer.write("이메일 : " + request.getParameter("email"));
//			Writer.write("<br>");
//			Writer.write("전공 : " + request.getParameter("dept"));
//			Writer.write("<br>");
//			Writer.write("성별 : " + request.getParameter("gender"));
//			Writer.write("<br>");
//			Writer.write("태어난 계절 : " + request.getParameter("birth"));
//			Writer.write("<br>");
//			Writer.write("자기소개 : " + request.getParameter("introduce"));
//			Writer.write("</body>");
//		}
//
//	}

		result = dao.register(dto);

		if (result == -1) {
			System.out.println("저장 실패!");
			Writer.println("<script>");
			Writer.println("alert('Fail!')");
			Writer.println("</script>");

		}

		else {
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
