import java.util.ArrayList;
import java.util.Scanner;

public class MusicalMain {

	MusicalDao dao = new MusicalDao();
	Scanner sc = new Scanner(System.in);

	MusicalMain() {
//		System.out.println("Musical Main");
		init();
	}

	private void init() {

		while (true) {
			System.out.println("\n <뮤지컬 맨오브 라만차> ");
			System.out.println("=====메뉴 선택=====");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.배우 검색"); // 1.
			System.out.println("3.요일별 검색(날짜:내림차순, 시간:오름차순)");
			System.out.println("4.캐스팅정보 추가");
			System.out.println("5.캐스팅정보 수정");
			System.out.println("6.캐스팅정보 삭제");
			System.out.println("7.프로그램 종료");
			System.out.print(">> 메뉴 선택: ");

			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				ArrayList<MusicalBean> list = dao.getAllCasting();
				showMusical(list);
				break;
			case 2: // 조건 검색
				getMusicalBySearch();
				break;
			case 3: // 요일별 검색(날짜:내림차순, 시간:오름차순)
				getSearchByDay();
				break;
			case 4: // 캐스팅정보 추가
				insertData();
				break;
			case 5: // 캐스팅정보 수정
				updateData();
				break;
			case 6: // 캐스팅정보 삭제
				deleteData();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 사이 숫자만 입력 가능");
				break;

			} // switch

		} // while

	} // init

	private void getMusicalBySearch() {
		System.out.print("배우 검색: ");
		String search = sc.next();

		ArrayList<MusicalBean> find_lists = dao.getMusicalBySearch(search);

		if (find_lists.size() == 0) {
			System.out.println("해당 배우는 캐스팅되지 않았습니다.");
		} else {
			showMusical(find_lists);
		}

	} // getMusicalBySearch

	private void getSearchByDay() {
		System.out.print("검색할 요일 입력 : ");
		String search_day = sc.next();

		ArrayList<MusicalBean> list = dao.getSearchByDay(search_day);

		if (list.size() == 0) {
			System.out.println("해당 요일에는 공연이 없습니다.");
		} else {
			showMusical(list);
			System.out.println("조회한 요일은 '" + search_day + "요일' 입니다.");
		}

	} // getSearchByDay

	private void deleteData() {
		System.out.print("삭제할 번호 입력 : ");
		int no = sc.nextInt();

		int count = dao.deleteData(no);
		if (count < 0) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}

	}

	private void updateData() {
		int no, time, price;
		String actor, mus_date, mus_day;

		System.out.print("수정할 번호 입력 : ");
		no = sc.nextInt();

		System.out.print("수정할 배우 입력(이름#이름 형태로 입력) : ");
		actor = sc.next();

		System.out.print("수정할 공연일자 입력 : ");
		mus_date = sc.next();

		System.out.print("수정할 요일 입력 : ");
		mus_day = sc.next();

		System.out.print("수정할 시간 입력 : ");
		time = sc.nextInt();

		System.out.print("수정할 가격 입력 : ");
		price = sc.nextInt();

		MusicalBean bean = new MusicalBean();
		bean.setNo(no);
		bean.setActor(actor);
		bean.setMus_date(mus_date);
		bean.setMus_day(mus_day);
		bean.setTime(time);
		bean.setPrice(price);

		int count = dao.updateData(bean);
		if (count < 0) {
			System.out.println("수정 실패");
		} else {
			System.out.println("수정 성공");
		}

	} // updateData

	private void insertData() {
		int time, price;
		String actor, mus_date, mus_day;

		System.out.println("번호는 시퀀스로 입력됩니다(생략)");
		System.out.print("배우 입력(이름#이름 형태로 입력) : ");
		actor = sc.next();

		System.out.print("공연일자 입력 : ");
		mus_date = sc.next();

		System.out.print("요일 입력 : ");
		mus_day = sc.next();

		System.out.print("시간 입력 : ");
		time = sc.nextInt();

		System.out.print("가격 입력 : ");
		price = sc.nextInt();

		MusicalBean bean = new MusicalBean(0, actor, mus_date, mus_day, time, price);

		int count = dao.insertData(bean);
		if (count < 0) {
			System.out.println("삽입 실패");
		} else {
			System.out.println("삽입 성공");
		}

	} // insertData

	private void showMusical(ArrayList<MusicalBean> list) {
		String title = "번호\t" + "배우\t\t" + "공연일자\t\t" + "요일\t" + "시간(시)\t" + "가격\t";
		System.out.println(title);

		for (int i = 0; i < list.size(); i++) {
			MusicalBean bean = list.get(i);
			String result = bean.getNo() + "\t" + bean.getActor() + "\t" + bean.getMus_date() + "\t" + bean.getMus_day()
					+ "\t" + bean.getTime() + "\t" + bean.getPrice();
			System.out.println(result);
		} // for

	} // showMusical

	public static void main(String[] args) {

		new MusicalMain();

	} // main

} // MusicalMain
