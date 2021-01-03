import java.util.ArrayList;
import java.util.Scanner;

class Person { // 생략되어있지만 extends Object는 항상 기본으로 추가되어있다고 생각하면됨
	private String id;
	private String pw;

	Person(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public String toString() {
		return id + ":" + pw;
	}

} // Person

public class Ex10_03_ArrayList {

	public static void main(String[] args) {
		Person p1 = new Person("kim", "1234");
		Person p2 = new Person("park", "5678");
		Person p3 = new Person("choi", "9876");

		System.out.println(p1);
		System.out.println(p1.toString());

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);

		System.out.println("list" + list.toString()); // ArrayList가 물려준 toString

		System.out.println(list.size());

		/*
		 * length: 배열의 길이
		 * length(): 문자열의 길이(갯수)
		 * size(): 컬렉션 안 요소의 갯수
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("ID: ");
			String id = sc.next();

			System.out.print("PW: ");
			String pw = sc.next();

			Person p = new Person(id, pw); // 입력받은 것을 객체로 만듬
			list.add(p);

			System.out.println("계속 하시겠습니까?");
			String retry = sc.next(); // y or n
			if (!retry.equals("y")) { // 문자열은 equals 메소드로 비교해야함
				break;
			} // if문

		} // while문

		System.out.println("list: " + list);

		for (int i = 0; i < list.size(); i++) { // 사이즈 만큼 for문 돌려서 값 나타낼 수 있음
			Person ps = list.get(i);
			System.out.println("ps: " + ps);
		} // for문
		System.out.println("------------------");

		boolean flag = false;
		System.out.print("찾는 ID 입력: ");
		String searchId = sc.next();

		for (int i = 0; i < list.size(); i++) {
			Person ps = list.get(i);
			if (ps.getId().equals(searchId)) {
				System.out.println("찾는 pw: " + ps.getPw());
				flag = true;
			} // if문

//				else {
//				System.out.println("찾는 아이디 없습니다."); // else문 쓰면 찾는 아이디 없다는 문구가 ps 갯수만큼 나옴
//			}

		} // for문

		// 여기
		if (flag == false) {
			System.out.println("찾는 ID가 없습니다.");
		}

	} // main

} // Ex10_03_ArrayList
