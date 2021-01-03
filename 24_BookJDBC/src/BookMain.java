import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {

	BookDao dao = new BookDao();
	Scanner sc = new Scanner(System.in);

	// 생성자
	BookMain() {
		System.out.println("BookMain");
		init();
	}

	private void init() {

		while (true) {
			System.out.println("\n===메뉴 선택하기===");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.조건 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				ArrayList<BookBean> list = dao.getAllBook();
				showBook(list);
				break;
			case 2:
				getBookBySearch();
//				getBookSelect();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			case 5:
				insertData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~6 사이의 번호만 입력 가능합니다.");
				break;

			} // switch

		} // while

	} // init

	private void deleteData() {
		System.out.print("삭제할 번호 입력 : ");
		int no = sc.nextInt();

		int count = dao.deleteData(no);
		if (count > 0) {
			System.out.println("삭제 성공");
		} else if (count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		} else { // 음수
			System.out.println("삭제 실패");
		}

	} // deleteData

	private void updateData() {
		int no, price;
		String title, author, publisher, pub_day;

		System.out.print("수정할 번호 입력 : ");
		no = sc.nextInt();

		System.out.print("수정할 책제목 입력 : ");
		title = sc.next();

		System.out.print("수정할 저자 입력 : ");
		author = sc.next();

		System.out.print("수정할 출판사 입력 : ");
		publisher = sc.next();

		System.out.print("수정할 가격 입력 : ");
		price = sc.nextInt();

		System.out.print("수정할 출간일(yyyy/mm/dd 형식으로 입력하세요.) : ");
		pub_day = sc.next();

//		[방법①]
//		BookBean bean = new BookBean(no, title, author, publisher, price, pub_day);
//		[방법②]
		BookBean bean = new BookBean();
		bean.setNo(no);
		bean.setTitle(title);
		bean.setAuthor(author);
		bean.setPublisher(publisher);
		bean.setPrice(price);
		bean.setPub_day(pub_day);

		int count = dao.updateData(bean);
		if (count > 0) {
			System.out.println("수정 성공");
		} else if (count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		} else { // 음수
			System.out.println("수정 실패");
		}

	} // updateData

	private void insertData() {
		int price;
		String title, author, publisher, pub_day;

		System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		System.out.print("책제목 입력 : ");
		title = sc.next();

		System.out.print("저자 입력 : ");
		author = sc.next();

		System.out.print("출판사 입력 : ");
		publisher = sc.next();

		System.out.print("가격 입력 : ");
		price = sc.nextInt();

		System.out.print("출간일(yyyy/mm/dd 형식으로 입력하세요.) : ");
		pub_day = sc.next();

		BookBean bean = new BookBean(0, title, author, publisher, price, pub_day);

		int count = dao.insertData(bean);
		if (count < 0) {
			System.out.println("삽입 실패");
		} else {
			System.out.println("삽입 성공");
		}

	} // insertData

	// 2번 조건 조회
//	private void getBookSelect() {
//		System.out.print("제목:1\t저자:2\t출판사:3\t");
//		System.out.print("번호 입력>> ");
//		int no = sc.nextInt();
//		
//		switch(no) {
//		case 1:
//			System.out.print("조회할 제목 : ");
//			String title = sc.next();
//			sc.nextLine();
//			break;
//		case 2:
//			System.out.print("조회할 저자 : ");
//			String author = sc.next();
//			break;
//		case 3:
//			System.out.print("조회할 출판사 : ");
//			String publisher = sc.next();
//			break;
//		default:
//			break;
//		
//		} // switch
//		
//		ArrayList<BookBean> list = dao.getBookSelect(no);
//		showBook(list);	

//	} // getBookSelect

	// 2번 조건 조회_Riview
	private void getBookBySearch() {

		String column = null;

		System.out.print("제목:1\t저자:2\t출판사:3\t");
		System.out.print("번호 입력>> ");
		int search_num = sc.nextInt();

		switch (search_num) {
		case 1:
			System.out.print("조회할 제목 : ");
			column = "title";
			break;
		case 2:
			System.out.print("조회할 저자 : ");
			column = "author";
			break;
		case 3:
			System.out.print("조회할 출판사 : ");
			column = "publisher";
			break;
		default:
			System.out.println("1~3사이의 번호만 입력가능 !");
			return; // 1~3 사이 번호가 없으면 밑으로 못빠져나가고 메서드 호출한 곳으로 다시 돌아가도록 설정

		} // switch

		String search_word = sc.next(); // '정' 입력

		ArrayList<BookBean> list = dao.getBookBySearch(column, search_word);

		if (list.size() == 0) {
			System.out.println("해당 단어 존재 안함");
		} else {
			showBook(list);
		}

	} // getBookSelect

	public void showBook(ArrayList<BookBean> list) {

		String title = "번호\t" + "책제목\t" + "저자\t" + "출판사\t" + "가격\t" + "출간일\t";
		System.out.println(title);

		for (int i = 0; i < list.size(); i++) {
			BookBean bean = list.get(i);
			String result = bean.getNo() + "\t" + bean.getTitle() + "\t" + bean.getAuthor() + "\t" + bean.getPublisher()
					+ "\t" + bean.getPrice() + "\t" + bean.getPub_day();
			System.out.println(result);

		} // for

		// ★확장포문 다시 확인해보기 (5시 수업)
		// arrayList에 넣어놓은것들 중 하나가 bookbean에 담김
//		for(BookBean book : list) {
//			String result = 
//					book.getNo() + "\t" 	
//		} //for

	}

	public static void main(String[] args) {

		new BookMain();

	} // main

} // BookMain
