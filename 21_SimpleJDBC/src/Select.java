import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jspid";
		String pw = "jsppw";
		
		//변수 선언은 밖에다 하기
		Connection conn = null; // 값 초기화
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//1. 드라이버 로드
			Class.forName(driver); // 예외처리 안하면 오류 발생

			//2. 계정 접속
//			DriverManager.getConnection(url,id,pw); // 예외처리 오류남
			conn = DriverManager.getConnection(url, id, pw);
			// conn: jspid 계정에 접속된 정보가 담김
			System.out.println("접속 성공");

			//3. sql문 분석
			String sql = "select * from simple order by num asc"; // 그냥 글자 적은거임, 실행 X
			ps = conn.prepareStatement(sql);
			// prepareStatement: conn을 실행할 준비작업을 하기 위해 sql에 들어가있는 문장  분석하라는 명령어 - SQLException 예외발생
			// prepareStatement: PreparedStatement 객체를 리턴 
			// ps 변수: sql 문장("select * from simple") 분석한 정보 들어옴
			// String 변수가 sql 이기 때문에 sql로 써줌
			System.out.println("명령 분석");

			//4. 실행 - ps 이용
			rs = ps.executeQuery(); // 괄호 안에 sql 쓰면안됨
			// ps.: PreparedStatement 인터페이스가 가지고 있는 메소드를 사용하겠다는 것
			// executeQuery: select 실행한 문장을 가져오는 명령어 - ResultSet을 리턴함
			// rs : select 한 결과 (executeQuery 실행시킨 결과) 들어가있음
			// 내가 insert한 여러 줄의 레코드들이 ResultSet에 들어감
			while (rs.next()) { // rs에 담겨있는 여러줄의 반복 횟수 알 수 없기 때문에 while 사용
				// rs.next(): boolean값 가져옴 - rs가 관리하는 데이터(레코드)가 있으면 true-while 반복, 없으면 false-빠져나감
				int num = rs.getInt("num"); // int형 리턴 - 한줄 씩 접근해서 가져옴 // "num" : 반드시 컬럼이름 사용
				// rs.getInt : num 컬럼에 있는 정수값 가져오기
				String name = rs.getString("name");
				// rs.getString : name 컬럼에 있는 문자열 가져오기
				String addr = rs.getString(3); // "addr" 대신 몇번째인지 숫자로 써도됨
				System.out.println(num + "," + name + "," + addr);

			} // while

//			//5. 접속 끊기
//			conn.close(); // SQLException 발생할 수 있기 때문에 try 안에 넣어줌
//			System.out.println("연결 종료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Class.forName에서 발생하는 문제
			// jar파일(자료파일) 포함 안되어있거나, 문자 오타 났을 때 ClassNotFoundException 오류 발생
		} catch (SQLException e) {
			// DriverManager.getConnection(): 내가만든 user가 없거나 오타 났을때
			// conn.prepareStatement(): 존재하지 않는 table을 select하겠다고 하거나, 오타 났을 때
			// ps.executeQuery(): select를 실행할 수 없는 상황일 때 오류발생
			// rs.next() 
			// getInt(): 컬럼명 오타날 때
			// getString(): 컬럼명 오타날 때
			// conn.close() : 접속 안했는데 접속 끊을때 SQLException 발생
			e.printStackTrace();

		} finally {

			if (rs != null) { // 나중에 사용한것 부터 닫기
				try {
					rs.close(); // rs : select 한 결과 들어있는 자원  반납처리 - 예외 처리해줌
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} // if rs

			if (ps != null) {
				try {
					ps.close(); // ps : 분석기
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} // if ps

			// 5. 접속 끊기
			if (conn != null) { // null이 아니면 사용했다는 뜻 = 접속 성공했으면 종료하기 
				try {
					conn.close(); // Connection conn = null;
									// The local variable conn may not have been initialized 로컬변수 초기화 오류생김
				} catch (SQLException e) {
					e.printStackTrace();
				} // SQLException 발생할 수 있기 때문에 try 안에 넣어줌
				  // conn 변수 try 안에있기 때문에 main으로 변수 빼서 전체 사용할 수 있도록 해주기
				System.out.println("연결 종료");
			} // if conn
		} // finally

	} // main
} // Select
