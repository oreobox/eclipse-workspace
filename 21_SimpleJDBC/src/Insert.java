import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

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

			//3. sql문 분석
			// 입력받아서 출력하기
			Scanner sc = new Scanner(System.in);
			
			int in_num;
			String in_name;
			String in_addr;

			System.out.print("번호: ");
			in_num = sc.nextInt();

			System.out.print("번호: ");
			in_name = sc.next();

			System.out.print("번호: ");
			in_addr = sc.next();

//			[방법①]
//			String sql = "insert into simple(num,name,addr) values(4,'choi','제주')";
			
//			[방법②]
//			int in_num = 6;
//			String in_name="태연";
//			String in_addr="강릉";
//			String sql = "insert into simple(num,name,addr) values(" + in_num + ",'" + in_name + "','" + in_addr +"')" ;
			// sql문장 작성: 문자열 양쪽으로 작은따옴표 입력 주의, insert 문장을 ();로 끝내면안됨

//			[방법③]
			//in_num, in_name, in_addr 변수 있어야함
			String sql = "insert into simple(num,name,addr) values(?,?,?)"; // ?: 위치홀더 (값 자리에만 ? 사용가능)
			ps = conn.prepareStatement(sql); // sql문장 분석해서 실행시킬 준비하는 명령어 - ps: 분석한 정보 받음

			// set : 물음표자리에 분석한 정보 넣는 setting 할거라 set 사용
			ps.setInt(1, in_num); // 분석한 정보 이용해서 setInt 1번 물음표 자리에 in_num 변수 넣어라
			ps.setString(2, in_name); // setString 2번 물음표 자리에 in_name 변수 넣어라
			ps.setString(3, in_addr);

			//4. 실행 - ps 이용
			int count = ps.executeUpdate();
			// ps.executeUpdate() : insert 문장 성공적으로 실행(삽입)된 갯수가 리턴됨
			System.out.println("count: " + count);
			if (count == 0)
				System.out.println("삽입 실패");
			else
				System.out.println("삽입 성공");

//			conn.commit(); // commit 입력하지 않아도 자동으로 commit됨

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			//5. 자원반납
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

}


//※실행결과:
//접속 성공
//명령 분석
//1,kim,서울
//2,park,부산
//4,choi,제주
//5,윤아,경기
//6,태연,강릉
//연결 종료