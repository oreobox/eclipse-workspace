import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jspid";
		String pw = "jsppw";

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			//1. 드라이버 로드
			Class.forName(driver);

			//2. 계정 접속
			conn = DriverManager.getConnection(url, id, pw);

			int up_num = 3;
			String up_name = "정국";
			String up_addr = "목포"; 
			

			//3. sql문 분석 -- insert와 다른점 3번 부분만 다름
//			[방법①]
//			String sql = "update simple set name='웬디', addr='광주' where num=7";
			
//			[방법②]
			// up_num 번호를 조건으로 up_name, up_addr 이름과 주소 수정 
//			String sql = "update simple set name='" + up_name + ",'addr='" + up_addr + "' where num = " + up_num;
			
//			[방법③]
			String sql = "update simple set name=?, addr=? where num=?"; // 값 들어가는 자리만 ? 사용 가능
			ps = conn.prepareStatement(sql);

			ps.setString(1, up_name);
			ps.setString(2, up_addr);
			ps.setInt(3, up_num);

			System.out.println("sql문 분석");

			//4. 실행
			int count = ps.executeUpdate();
			// ps.executeUpdate() : update 문장 성공적으로 실행(수정)된 갯수가 리턴됨
			System.out.println("sap문 실행");

			System.out.println("count:" + count);
			if (count == 0)
				System.out.println("수정 실패");
			else
				System.out.println("수정 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// 5. 자원반납
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

	} // main

} // Update
