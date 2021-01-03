import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumMain {

	AlbumDao dao = new AlbumDao();
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 스캐너 대신 공백 포함 입력

	AlbumMain() throws IOException {
//		System.out.println("AlbumMain");
		init();
	}

	private void init() throws IOException { // 예외처리 떠넘김③
		while (true) {
			System.out.println("\n======메뉴 선택하기======");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.가격 범위조건 검색(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.정렬");
			System.out.println("8.프로그램 종료");
			System.out.print(">> 메뉴 선택: ");

			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				ArrayList<AlbumBean> list = dao.getAllAlbums();
				showAlbums(list);
				break;
			case 2: // 조건 검색
				getAlbumBySearch();
				break;
			case 3: // 가격 범위조건 검색(가격:내림차순, 가수:오름차순)
				getAlbumByRange();
				break;
			case 4: // 앨범 수정
				updateData();
				break;
			case 5: // 앨범 삭제
				deleteData();
				break;
			case 6: // 앨범 추가
				insertData(); // 예외처리 떠넘김②
				break;
			case 7: // 정렬
				align();
				break;
			case 8:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~8 사이 번호만 입력 가능합니다.");
				break;

			} // switch

		} // while

	} // init

	private void align() {
		String column = null, way = null;

		System.out.println("정렬할 항목을 선택하세요.");
		System.out.print("번호:1\t노래제목:2\t가수명:3\t번호입력>> ");
		int align_num = sc.nextInt();

		switch (align_num) {
		case 1:
			column = "num";
			break;
		case 2:
			column = "song";
			break;
		case 3:
			column = "singer";
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			return; // 1~3 사이 번호가 없으면 밑으로 못빠져나가고 메서드 호출한 곳으로 다시 돌아가도록 설정

		} // switch

		System.out.println("정렬할 방법을 선택하세요.");
		System.out.print("오름차순:1\t내림차순:2\t번호입력>> ");
		int align_way = sc.nextInt();
		switch (align_way) {
		case 1:
			way = "asc";
			break;
		case 2:
			way = "desc";
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			return; // 1~3 사이 번호가 없으면 밑으로 못빠져나가고 메서드 호출한 곳으로 다시 돌아가도록 설정

		} // switch

		ArrayList<AlbumBean> align_list = dao.align(column, way);
		showAlbums(align_list);

	} // getAlbumOrder

	private void getAlbumByRange() {
		int from, to;

		System.out.print("시작 등수 입력 : ");
		from = sc.nextInt();
		System.out.print("끝 등수 입력 : ");
		to = sc.nextInt();

		ArrayList<AlbumBean> list = dao.getAlbumByRange(from, to);
		showAlbums(list);

	} // getAlbumByPrice

	private void getAlbumBySearch() {
		String column = null;

		System.out.println("제목검색:1\t가수검색:2\t회사검색:3");
		System.out.print("검색할 항목을 선택 >> ");
		int search_num = sc.nextInt();

		switch (search_num) {
		case 1:
			System.out.print("검색할 제목 입력 : ");
			column = "song";
			break;
		case 2:
			System.out.print("검색할 가수 입력 : ");
			column = "singer";
			break;
		case 3:
			System.out.print("검색할 회사 입력 : ");
			column = "company";
			break;
		default:
			System.out.println("1~3사이의 번호만 입력가능 !");
			return; // 밑에있는 문장 못만나게 하기 위해/밑에 있는 문장 출력 못하도록 하기위해

		} // switch

		String search_word = sc.next(); // 조건 입력하기

		ArrayList<AlbumBean> find_lists = dao.getAlbumBySearch(column, search_word);

		if (find_lists.size() == 0) {
			System.out.println("해당 단어 존재 안함");
		} else {
			showAlbums(find_lists);
		}

	} // getAlbumBySearch

	private void deleteData() {
		System.out.print("삭제할 번호 입력: ");
		int num = sc.nextInt();

		int count = dao.deleteData(num);
		if (count > 0) {
			System.out.println("삭제 성공");
		} else if (count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		} else {
			System.out.println("삭제 실패");
		}
	} // deleteData

	private void updateData() {
		int num, price;
		String song, singer, company, pub_day;

		System.out.print("수정할 번호 입력 :");
		num = sc.nextInt();
		System.out.print("노래제목 입력 : ");
		song = sc.next();
		System.out.print("가수명 입력 : ");
		singer = sc.next();
		System.out.print("회사 입력 : ");
		company = sc.next();
		System.out.print("가격 입력 : ");
		price = sc.nextInt();
		System.out.print("입고 일자 입력 : ");
		pub_day = sc.next();

		AlbumBean bean = new AlbumBean();
		bean.setNum(num);
		bean.setSong(song);
		bean.setSinger(singer);
		bean.setCompany(company);
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

	}

	private void insertData() throws IOException {
		// 여기서 예외처리 안하고 insertData 호출한 곳에서 예외처리 떠넘겼기 때문에 호출한 쪽에서 예외처리하게함
		int price;
		String song, singer, company, pub_day;

		System.out.println("번호는 시퀀스로 입력됩니다(생략)");
		System.out.print("노래제목 입력 : ");
//		song = sc.next();
		song = br.readLine(); // 광화문 연가 - 띄어쓰기 가능 (IOException 예외처리①)

		System.out.print("가수명 입력 : ");
//		singer = sc.next();
		singer = br.readLine();

		System.out.print("회사 입력 : ");
//		company = sc.next();
		company = br.readLine();

		do {
			try {
				System.out.print("가격 입력 : ");
//				price = sc.nextInt();
				price = Integer.parseInt(br.readLine()); // Integer.parseInt ("3000") => 3000
				break;
			} catch (NumberFormatException e) {
				System.out.println("가격은 숫자로 입력하세요.");
			}
		} while (true);

		System.out.print("입고 일자 입력 : ");
//		pub_day = sc.next();
		pub_day = br.readLine();

		AlbumBean bean = new AlbumBean(0, song, singer, company, price, pub_day);

		int count = dao.insertData(bean);
		if (count < 0) {
			System.out.println("삽입 실패");
		} else {
			System.out.println("삽입 성공");
		}

	} // insertData

	private void showAlbums(ArrayList<AlbumBean> list) {
		String title = "번호\t" + "노래제목\t" + "가수\t" + "회사\t" + "가격\t" + "발매일\t";
		System.out.println(title);

		// 서식문자 이용 (d: 숫자, s: 문자열 ) -5: 마이너스는 앞에 문자/숫자가 오고 뒤에 공백오도록 칸수 설정
//		for (AlbumBean album : list) {
//			System.out.printf("%-5d\t %-8s\t %-5s\t %-6s\t %-5d\t %-10s\n",
//					album.getNum(), album.getSong(),
//					album.getSinger(), album.getCompany(),
//					album.getPrice(), album.getPub_day());
//		} // for

		for (int i = 0; i < list.size(); i++) {
			AlbumBean bean = list.get(i);
			String result = bean.getNum() + "\t" + bean.getSong() + "\t" + bean.getSinger() + "\t" + bean.getCompany()
					+ "\t" + bean.getPrice() + "\t" + bean.getPub_day();
			System.out.println(result);

		} // for

	} // showAlbums

	public static void main(String[] args) throws IOException { // 계속 떠넘겨서 최종적으로 예외처리④
		new AlbumMain();
	} // main

} // AlbumMain
