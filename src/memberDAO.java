import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class memberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

	public memberDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/member?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String dbID = "root";
			String dbPassword = "Ykk159357";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int update(memberDTO dto) {

		try {

			String SQL2 = "update memberInfo set tel=?, email=?, dept=?, gender=?, birth=?, introduce=? where id=?";

			pstmt = conn.prepareStatement(SQL2);
			pstmt.setString(1, dto.getTel());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getDept());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getIntroduce());
			pstmt.setString(7, dto.getId());

			return pstmt.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return -3;

		}

	}

	public int register(memberDTO dto) {

		String SQL = "INSERT INTO memberInfo(id, pw, name, tel, email, dept, gender, birth, introduce) VALUES(?,?,?,?,?,?,?,?,?)";
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getDept());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getBirth());
			pstmt.setString(9, dto.getIntroduce());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // database error
	}

}
