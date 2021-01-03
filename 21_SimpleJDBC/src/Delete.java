import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jspid";
		String pw = "jsppw";
		Connection conn = null; // 값 초기화
		PreparedStatement ps = null; // delete문 분석 정보를 담을 수 있는 변수

		try {
			// 1. 드라이버로드
			Class.forName(driver);

			// 2. 계정 접속
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속 성공");

			// 3. sql문 분석
			String sql = "delete from simple where num = 8";
			ps = conn.prepareStatement(sql);
			System.out.println("명령 분석");

			// 4. sql문 실행
			int count = ps.executeUpdate();
			System.out.println("count: " + count);
			if (count == 0)
				System.out.println("삭제 실패"); // 없는 번호 넣었을 때 실패는 아니고 사실 조건에 맞는 번호가 없다고 해야하는게 맞지만 쉽게이해하기위해 실패라고 씀
			else
				System.out.println("삭제 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) { // 나중에 사용한것 부터 닫기
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if ps
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if conn

		} // finally

	}

}
