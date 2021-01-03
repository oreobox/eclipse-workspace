// <기본구조>
//import java.sql.*; // sql 모든 패키지 사용
//여기서 사용한 모든 클래스와 인터페이스는 java.sql 패키지에 들어가있음
import java.sql.Connection; //java.sql : 패키지 , Connection : 클래스 or 인터페이스 이름
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	public static void main(String[] args) {
		try {
			// <JDBC 프로그래밍 단계>
			// 0. jar파일 가져오기 - 프로젝트 당 하나만 하면됨
			// 프로젝트 이름-오른쪽 마우스 클릭-Properties-Java Build Path-library-Add External JARs
			// C:\Oracle\product\12.2.0\dbhome_1\jdbc\lib\ojdbc8.jar 선택

			// 1. 오라클 드라이버 로드하는 작업
			Class.forName("oracle.jdbc.driver.OracleDriver"); // forName : 메서드
			// ClassNotFoundException 발생
			// oracle.jdbc.driver라는 패키지 안에 있는 OracleDriver라는 이름의 클래스를 사용하겠다는 뜻

			System.out.println("드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // localhost : '내 컴퓨터' 의미 or 내 IP 주소 써도됨
			String user = "jspid"; // 내가만든 user가 없거나 오타 났을때 SQLException 발생
			String pw = "jsppw"; // 우리가 접속하려는 계정 여기다 쓰기

			System.out.println("DB와의 연결을 시도합니다.");

			// 2. 계정에 접속
			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("conn:" + conn); // 접속 됐다는 정보가 들어가있음 = 접속 객체가 만들어짐
			System.out.println("DB와의 연결 성공");
			// 내가 로드한 드라이버 정보가 DriverManager라는 클래스 들어옴 - Connection 객체를 리턴
			// getConnection(메소드): Connection 객체를 리턴
			// Connection(인터페이스)
			// conn 변수 : url, user, pw에 접속한 정보가 들어옴
			

			
			// 이곳에서 insert, update, delete 등  많은 작업 가능
			
			
			System.out.println("DB와 연결끊기 시도합니다.");

			// 3. 연결 끊기(자원반납) (마지막 단계)
			conn.close(); // exit
			System.out.println("DB와 연결 끊기 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			// Class.forName에서 발생하는 문제
			// jar파일(자료파일) 포함 안되어있거나, 문자 오타 났을 때 ClassNotFoundException 오류 발생

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQLException 발생");
			// DriverManager.getConnection() : 내가만든 user가 없거나 오타 났을때 SQLException 발생
			// conn.prepareStatement()
			// conn.close() : 접속 안했는데 접속 끊을때 SQLException 발생
		}

	}

}
