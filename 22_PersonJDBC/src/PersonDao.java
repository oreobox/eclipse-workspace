import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// DB
public class PersonDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//기본 생성자
	PersonDao() {
		System.out.println("personDao 생성자"); // PersonMain에서 객체 만들어야 호출
		// 0.jar 가져오기

		try {
			// 1. 드라이버 로드
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // PersonDao 생성자

	public void getConn() { // 메서드
		// 2. 계정 접속
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("접속 오류");
		}
	}// getConn

	// 모든 Person레코드를 가지고 오는 메서드 생성
	public ArrayList<PersonBean> getAllPerson() { // void 대신 리스트 타입을 넣어줘야 return에 오류안남
		// 2
		getConn(); // 계정에 접속하기 위해 getConn 호출해서 진짜 계정접속 getConn 메서드 실행되도록함

		// ArrayList는 한번만 밖에 만들어줌
		ArrayList<PersonBean> list = new ArrayList<PersonBean>();

		String sql = "select * from person order by num";
		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);

			// 4. sql문 실행
			rs = ps.executeQuery();
//			 NUM NAME   AGE GENDER BIRTH
//			 ---- ----- ---- ------ --------
//			    1 보라    23 여     92/03/04 → 이 한줄을 Bean으로 만들어서 0번째 ArrayList 안에들어가있음
//			    2 슬기    34 여     77/11/09 → 1번째 ArrayList
//			    3 찬열    17 남     04/12/29 → 2번째 ArrayList
//			    4 백현    57 남     65/02/06 → 3번째 ArrayList

			while (rs.next()) { // rs가 관리하는 곳에 데이터가  몇줄 있는지 모르기 때문에 while - next는 boolean를 리턴함
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
//				String birth = rs.getString("birth"); // 시분초까지 같이 불러옴
				String birth = String.valueOf(rs.getDate("birth")); // 가져온 날짜를 문자열로 변경
				// Integer.parseInt("123"); // "123" -> 123 = 문자->숫자
				// String.valueOf(123); // 123 -> "123" = 숫자 -> 문자

				// 한줄 한줄 콘솔에 출력해보기 - 메인에서 출력할 예정
//				System.out.println(num + "," + name + "," + age + "," + gender + "," + birth);

				// bean이란 이름으로 관리하는 PersonBean 객체 생성 - 다섯가지 칼럼을 한 묶음으로 만듬
				// 하나의 빈에 계속 여러 줄을 넣으면 덮어쓰기가되서 마지막 넣은 한줄만 나오기 때문에 ArrayList로 관리해줌
				// 객체 4번 반복해야하기 때문에 while에 넣음
				PersonBean bean = new PersonBean(num, name, age, gender, birth);

				list.add(bean); // ArrayList에 하나씩 넣는 작업

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally
		System.out.println("list 갯수: " + list.size()); // 총 4개
		return list;

	} // 생성자

	// 성별 별로 묶음을 해줌
	public ArrayList<PersonBean> getPersonByGender(String gender) {
		ArrayList<PersonBean> list = new ArrayList<PersonBean>();

		// 2. 계정 접속
		getConn();

		// 3. sql문 분석
//		select * from person where gender = '남'; - db작업이기 때문에 Dao에서함
		String sql = "select * from person where gender = '" + gender + "'"; // gender: 내가 입력한 값, 공백 띄어쓰기X
		try {
			ps = conn.prepareStatement(sql);

			// 4. sql문 실행
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender2 = rs.getString("gender");
				String birth = String.valueOf(rs.getDate("birth"));

				PersonBean bean = new PersonBean(num, name, age, gender2, birth);
				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 5. 연결끊기
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally

		// 4 return
		System.out.println(gender + ":" + list.size());
		return list;
	}

	public int insertData(PersonBean bean) { // 5개를 한 묶음으로 묶은 PersonBean 넣기
		// 내가 입력한 것 잘 넘어오는지 확인작업(test Code) 해보기
//		System.out.println(bean.getNum());
//		System.out.println(bean.getName());
//		System.out.println(bean.getAge());
//		System.out.println(bean.getGender());
//		System.out.println(bean.getBirth());

		// num 빼고 Dao로 가지고감
		// insert into person values(perseq.nextval,name,age,gender,birth);
		// 2.
		getConn();

		int count = -1; // 지역변수 / 중간에 에러가 났을 경우를 대비해서 초기값은 보통 음수를 많이 넣음, 성공하면 양수가 들어가도록
		String sql = "insert into person (num,name,age,gender,birth)" + "values(perseq.nextval,?,?,?,?)";
		try {
			// 3.sql문 분석
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getAge());
			ps.setString(3, bean.getGender());
			ps.setString(4, bean.getBirth());

			// 4.sql문 실행
			count = ps.executeUpdate(); // 성공적으로 실행(삽입)된 갯수가 리턴됨
//			ps.executeUpdate(); // 몇개 성공했는지 알고 싶지 않으면 그냥 int count 안써도됨
			System.out.println("count: " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		} // finally

		return count;
		// count cannot be resolved to a variable : count가 insertDate 안에서만 정의되어있어서

	} // insertData

	public int updateData(PersonBean bean) {
//		잘 넘어오는지 확인
//		System.out.println(bean.getNum());
//		System.out.println(bean.getName());
//		System.out.println(bean.getAge());
//		System.out.println(bean.getGender());
//		System.out.println(bean.getBirth());

		int count = -1;
//		update person set name = 'a', age = 11, gender '남', birth = '99-4-4' where num=2;
		// 2.
		getConn();

		String sql = "update person set name=?, age=?, gender=?, birth=? where num=?";

		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getAge());
			ps.setNString(3, bean.getGender());
			ps.setNString(4, bean.getBirth());
			ps.setInt(5, bean.getNum());

			// 4. sql문 실행
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		} // finally

		return count;

	} // updateData
	
	public int deleteData(int num) {
		int count = -1; 
		// 2. 계정 접속
		getConn();
		
		// 3. sql문 분석
		String sql = "delete from person where num =" + num; // 변수 하나밖에없으니까 그냥 써주기
		try {
			ps = conn.prepareStatement(sql);
			
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} //finally
			
		return count; // 삭제된 갯수를 리턴
		
	} // deleteData
	

} // PersonDao
