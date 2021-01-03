import java.util.ArrayList;
import java.util.Scanner;

class Music extends Object {
	private String title;
	private String singer;
	private int price;

	Music(String title, String singer, int price) {
		this.title = title;
		this.singer = singer;
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSinger() {
		return singer;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String toString() { // 오버라이딩 - 부모 객체를 안쓰고 Music에 만들어놓은 toString을 쓰겠다는 뜻
		return title + " / " + singer + " / " + price;
	}

} // Music

public class Ex10_04_ArrayList_이도흔 {

	public static void main(String[] args) {

		ArrayList<Music> list = new ArrayList<Music>();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("제목: ");
			String title = sc.next();

			System.out.print("가수: ");
			String singer = sc.next();

			System.out.print("가격: ");
			int price = sc.nextInt();

			Music ms = new Music(title, singer, price);
			list.add(ms); // Music에있는 것들(제목,가수,가격 내용)을 계속 추가하라는 뜻

			System.out.print("계속 하시겠습니까?");
			String retry = sc.next(); // y or n
			if (!retry.equals("y") && !retry.equals("Y")) {
				break;

			} // if문

		} // while문
			// 여기 - break;를 빠져나가면 여기로 옴
		System.out.println(list); // list: 참조변수 뒤에는 항상 .toString()이라는 메소드 생략되어있음

		while (true) {

			boolean flag = false;
			System.out.print("찾는 제목 입력: ");
			String searchTitle = sc.next();

			for (int k = 0; k < list.size(); k++) {
				Music ms = list.get(k);
				if (ms.getTitle().equals(searchTitle)) {
					System.out.println("찾는 가수: " + ms.getSinger());
					flag = true; // 같은 값 찾으면 false가 true로 바뀌고, 못찾으면 false
				} // if문
			} // for문

			// 여기 - for문 끝나면 여기로옴
			if (flag == false) {
				System.out.println("찾는 제목이 없습니다."); // for문이 다 끝난 다음에 찾는 제목 없다는 문구 출력 하기위해 for문 밖에 써줌
			} // if문

			System.out.print("계속 하시겠습니까?");
			String retry = sc.next(); // y or n
			if (!retry.equals("y")) {
				System.out.println("프로그램을 종료합니다");
				break;

			} // if문

		} // while문

	} // main

} // class
