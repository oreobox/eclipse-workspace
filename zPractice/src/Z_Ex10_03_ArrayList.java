import java.util.ArrayList;
import java.util.Scanner;

class Info {
	private String id;
	private String pw;

	// 생성자
	Info(String id, String pw) {
		this.id = id;
		this.pw = pw;
	} // 생성자

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

public class Z_Ex10_03_ArrayList {
	public static void main(String[] args) {

		Info p1 = new Info("kim", "1234");
		Info p2 = new Info("park", "5678");
		Info p3 = new Info("choi", "9876");

		System.out.println(p1);
		System.out.println(p1.toString());
		System.out.println(p1.getId() + ":" + p1.getPw());

		ArrayList<Info> list = new ArrayList<Info>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println("list: " + list);
		System.out.println("list size: " + list.size());
		System.out.println();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("ID: ");
			String id = sc.next();
			System.out.print("PW: ");
			String pw = sc.next();

			Info info = new Info(id, pw); // 입력받은 것들을 객체로 만듬
			list.add(info);

			System.out.println("계속 하시겠습니까?");
			String retry = sc.next();
			if (!retry.equals("y")) {
				break;
			}

		} // while
		System.out.println("list: " + list);

		for (int i = 0; i < list.size(); i++) {
			Info ifo = list.get(i);
//			System.out.println("ps: "+list.get(i));
			System.out.println("ps: " + ifo);
		} // for

		boolean flag = false;
		System.out.println("------------------");
		System.out.print("찾는 ID 입력: ");
		String searchId = sc.next();
		
			for(int i=0;i<list.size();i++) {
				Info ifo = list.get(i);
				if(ifo.getId().equals(searchId)) {
					System.out.println("찾는 PW: "+ifo.getPw());
					flag = true;
				} // if
				
			} // for
				if(flag == false) {
					System.out.println("찾는 ID가 없습니다.");
				} // if

	} // main

} // class
