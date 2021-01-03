import java.util.ArrayList;
import java.util.Scanner;

class Music {
	private String title;
	private String singer;
	private int price;

	// 생성자
	Music(String title, String singer, int price) {
		this.title = title;
		this.singer = singer;
		this.price = price;
	} // 생성자

	public void setName(String title) {
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

	public String toString() {
		return title + "/" + singer + "/" + price;
	}

} // Music

public class Z_Ex10_04_ArrayList_이도흔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Music> list = new ArrayList<Music>();

		while (true) {

			System.out.print("제목: ");
			String title = sc.next();
			System.out.print("가수: ");
			String singer = sc.next();
			System.out.print("가격: ");
			int price = sc.nextInt();

			Music ms = new Music(title, singer, price); // 입력한 것들 객체로 만들어줌
			list.add(ms);

			System.out.print("계속?");
			String retry = sc.next();

			if (!retry.equals("y")) {
				break;

			} // if
		} // while
		System.out.println(list);

		while (true) {
			boolean flag = false;
			System.out.print("찾는제목 입력: ");
			String searchTitle = sc.next();

			for (int i = 0; i < list.size(); i++) {
				Music ms = list.get(i);
				if (ms.getTitle().equals(searchTitle)) {
					System.out.println(searchTitle + "의 가수명은 " + ms.getSinger());
					flag = true;
					
				} // if
			} // for

				if(flag == false) {
					System.out.println("찾는 제목이 없습니다.");
				} // if

			System.out.println("계속 하시겠습니까?");
			String retry = sc.next();
			 if(!retry.equals("y")) {
				 System.out.println("프로그램을 종료하겠습니다.");
				 break;
			 } // if
		} // while

	} // main

} // class
