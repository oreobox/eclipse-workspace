import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 기본 생성자
	ProductDao() {
//		System.out.println("ProductDao 생성자"); // ProductMain에서 객체 만들어야 호출
		// 0. jar 파일 가져오기
		try {
			// 1. 드라이버 로드
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // ProductDao 생성자

	public void getConn() { // 메서드
		// 2. 계정 접속
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("접속 오류");
		}
	} // getConn

	public ArrayList<ProductBean> getAllProduct() {
		// 2. 계정 접속 호출
		getConn();

		ArrayList<ProductBean> list = new ArrayList<ProductBean>();

		String sql = "Select * from products order by id asc";
		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);

			// 4. sql문 실행
			rs = ps.executeQuery();
//			  ID   NAME       STOCK PRICE CATEGORY INPUTDATE
//			  ---- ---------- ----- ----- -------- ---------
//			     1 mp3         20   300 	IT      20/03/04
//			     2 iPhone      40   500 	IT      17/11/04
//			     3 세탁기      	   20   300 	KJ      20/12/23
//			     4 냉장고        	   30   200 	KJ      20/12/23
//			     5 TV          40   500 	KJ      07/09/21
//			     6 Computer    20   300 	IT      20/12/23
//			     7 스타일러      	   50   800 	KJ      06/07/02

			while (rs.next()) { // 한줄씩 꺼내오기
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				// 날짜 가지고 와서 문자열로 바꾸기

				// 방법①  생성자 통해서 주입
				//ProductBean bean = new ProductBean();-생성자가 정의되지 않았기 때문에 오류남 (Bean 쪽에서 괄호안에 내용 없는 생성자는 없기 때문)
//				ProductBean bean = new ProductBean(id, name, stock, price, category, inputdate);
				
				// 방법② setter,getter 통해서 주입
				ProductBean bean = new ProductBean();
				bean.setId(id);
				bean.setName(name);
				bean.setStock(stock);
				bean.setPrice(price);
				bean.setCategory(category);
				bean.setInputdate(inputdate);
				
				list.add(bean);
				
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 접속 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if rs
			if (ps != null) {
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

//		System.out.println("list 갯수:" + list.size());
		return list;

	} // getAllProduct

	public ArrayList<ProductBean> getProductById(int id) {
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();

		// 2. 계정 접속
		getConn(); // get conn 메소드로 가서 다시 접속

		String sql = "select * from products where id = " + id;
		
		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);

			// 4. sql문 실행
			rs = ps.executeQuery();
			
			//조건에 맞는 값이 1개밖에 없기 때문에 while 대신 if문으로 돌려도 됨
			while (rs.next()) {
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				ProductBean bean = new ProductBean(id, name, stock, price, category, inputdate);
				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 연결 끊기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if rs
			if (ps != null) {
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

		return list;

	} // getProductById

	public ArrayList<ProductBean> getProductBycategory(String category) {
		// 2. 계정 접속
		getConn();

		ArrayList<ProductBean> list = new ArrayList<ProductBean>();

//		String sql = "select * from products where category = '" + category + "'" + " order by id asc";
//		String sql = "select * from products where category = ? order by id asc";
		String sql = "select * from products where upper(category) = ? order by id asc"; //컬럼도 대문자 바꿔서 조회
		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);
//			ps.setString(1, category);
			ps.setString(1, category.toUpperCase()); // 내가 입력한 것을 대문자로 바꿔서 조회

			// 4. sql문 실행
			rs = ps.executeQuery();

			while (rs.next()) {
				int id3 = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category3 = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				ProductBean bean = new ProductBean(id3, name, stock, price, category3, inputdate);
				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // if rs
			if (ps != null) {
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

		return list;

	} // getProductBycategory

	public int insertData(ProductBean bean) {

//	insert into products values(prdseq.nextval,name,stock,price,category,inputdate);
		// 2.
		getConn();

		int count = -1;

		String sql = "insert into products(id,name,stock,price,category,inputdate)"
				+ "values(prdseq.nextval,?,?,?,?,?)";
		try {
			// 3.sql문 분석
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getStock());
			ps.setInt(3, bean.getPrice());
			ps.setString(4, bean.getCategory());
			ps.setString(5, bean.getInputdate());

			// 4.sql문 실행
			count = ps.executeUpdate(); // 성공적으로 실행(삽입)된 갯수가 리턴됨
			System.out.println("insert count: " + count);

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
	} // insertData

	public int updateData(ProductBean bean) {
		
		getConn();

		int count = -1;

		String sql = "update products set name=?,stock=?,price=?,category=?,inputdate=? where id=?";

		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getStock());
			ps.setInt(3, bean.getPrice());
			ps.setString(4, bean.getCategory());
			ps.setString(5, bean.getInputdate());
			ps.setInt(6, bean.getId());

			// 4. sql문 실행
			count = ps.executeUpdate();
			System.out.println("update count: " + count);

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

	public int deleteData(int id) {
		int count = -1;
		// 2. 계정 접속
		getConn();
		
//		String sql = "delete from products where id =" + id;
		String sql = "delete from products where id =?";
		try {
			// 3. sql문 분석
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			// 4. 실행
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
	} // deleteData

} // ProductDao
