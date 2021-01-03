import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String name;
	private int kor;
	private int eng;

	// 생성자
	Student(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	} // 생성자

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public String toString() {
		return name + "/" + kor + "/" + eng;
	}

} // Student

public class Test_이도흔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Student> list = new ArrayList<Student>();

		while (true) {
			System.out.print("이름: ");
			String name = sc.next();
			System.out.print("국어: ");
			int kor = sc.nextInt();
			System.out.print("영어: ");
			int eng = sc.nextInt();

			Student st = new Student(name, kor, eng);
			list.add(st);

			System.out.print("계속하시겠습니까?(y/n) : ");
			String retry = sc.next(); // y or n 입력
			if (!retry.equals("y") && !retry.equals("Y")) {
				break;
			} // if

		} // while

		System.out.println(list);
		System.out.println();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println();
		

		while (true) {

			boolean flag = false;
			System.out.print("찾는 이름: ");
			String searchName = sc.next();

			for (int i = 0; i < list.size(); i++) {
				Student st = list.get(i);
				if (st.getName().equals(searchName)) {
					System.out.println("국어: " + st.getKor() + "\n" + "영어: " + st.getEng());
					flag = true;
				} // if
			} // for

			if (flag == false) {
				System.out.println("찾는 이름이 없습니다.");
			} // if

			System.out.print("계속하시겠습니까?(y/n) : ");
			String retry = sc.next();
			if (!retry.equals("y") && !retry.equals("Y")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} // if

		} // while

	} // main

} // class

//youn1223@daum.net 완성해서 메일로 보내기

//이름:kim
//국어:66
//영어:77
//계속?(y/n) : y
//이름:park
//국어:88
//영어:99
//계속?(y/n) : n
//[kim/66/77, park/88/99]
//
//kim/66/77
//park/88/99
//
//찾는 이름 : park
//국어:88
//영어:99
//계속?y
//찾는 이름 : choi
//찾는 이름 없음
//계속?n
//프로그램을 종료합니다.