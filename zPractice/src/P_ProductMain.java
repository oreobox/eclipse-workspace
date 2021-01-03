import java.util.Scanner;

public class P_ProductMain {
	P_ProductDao dao = new P_ProductDao();
	Scanner sc = new Scanner(System.in);

	// 생성자
	P_ProductMain() {
		System.out.println("ProductMain 생성자");
		init(); // 함수 호출
	}

	public void init() {
//		System.out.println("init");

		while (true) {
			System.out.println("\n === 메뉴 선택하기 ===");
			System.out.println("1. 전체 정보 조회");
			System.out.println("2. 성별로 조회");
			System.out.println("3. 정보 수정");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 정보 추가");
			System.out.println("6. 프로그램 종료");
			System.out.print(">> 메뉴 번호 입력: ");

			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				System.out.println(1);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~6 사이의 번호만 입력 가능");

			} // switch

		} // while

	} // init

	public static void main(String[] args) {
		System.out.println("main");
		new P_ProductMain(); // 생성자의 객체

	}

}
