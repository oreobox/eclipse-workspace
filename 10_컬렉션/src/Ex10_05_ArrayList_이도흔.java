import java.util.ArrayList;
import java.util.Scanner;

// 명함 관리 프로그램
class Card extends Object {

	private String name;
	private String tel;

	Card(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String toString() {
		return name + "\t" + tel;
	}

} // Card

public class Ex10_05_ArrayList_이도흔 {

	public static void main(String[] args) {

		ArrayList<Card> list = new ArrayList<Card>();
		Scanner sc = new Scanner(System.in);

		종료: while (true) {

			System.out.print("1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료 : ");
			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				System.out.print("이름을 입력하세요: ");
				String name = sc.next();
				System.out.print("전화번호를 입력하세요: ");
				String tel = sc.next();

				Card cd = new Card(name, tel); // Card 묶음 객체 만들기
				list.add(cd); // cd라는 이름으로 관리하고있는  Card 객체를 ArrayList에 넣어라 
				break;

			case 2:
				System.out.print("이름을 입력하세요: ");
				name = sc.next();
				for (int i = 0; i < list.size(); i++) { // ArrayList 요소 갯수 구할 땐 .size()
					Card cd1 = list.get(i);
					if (cd1.getName().equals(name)) {
						list.remove(i);
						System.out.println("삭제되었습니다.");
					} 
					else {
						System.out.println("잘못 입력하였습니다.");
					}

				}
				break;

			case 3:
				System.out.print("이름을 입력하세요: ");
				name = sc.next();

				for (int i = 0; i < list.size(); i++) {
					Card cd3 = list.get(i);
					if (cd3.getName().equals(name)) {
						System.out.println("수정하실 전화번호는: ");
						tel = sc.next();
						cd3.setTel(tel);
						System.out.println("수정되었습니다.");

					} // if문
					else {
						System.out.println("잘못입력하였습니다.");
					}
				} // for문
				break;

//				if (list.equals(name) == true) {
//						System.out.println("수정하실 전화번호는 : ");
//						tel = sc.next();
//						System.out.println("수정되었습니다.");
//						
//						Card cd3 = new Card(name,tel);
//						list.add(cd3);

			case 4:
				System.out.println("이름\t전화번호");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}

				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				break 종료;

//			default:
//				System.out.println("잘못입력하였습니다.");

			} // switch
			System.out.println();
		} // while

	} // main

} // class
