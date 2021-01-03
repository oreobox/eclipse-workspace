class Sports {
	String name;
	int inwon;

	// 생성자
	Sports(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}

	void display() {
		System.out.println("종목명:" + name);
		System.out.println("인원수:" + inwon);
	}
	
}

class Baseball extends Sports {
//	String name;
//	int inwon;
	double ta;

	// 생성자
	Baseball(String name, int inwon, double ta) {
		super(name, inwon); // 부모 생성자 호출
//		this.name = name;
//		this.inwon = inwon;
		this.ta = ta;
	}

	// 메소드
	void display() {
		super.display(); // 부모 display 메소드 호출
//		System.out.println("종목명:" + name);
//		System.out.println("인원수:" + inwon);
		System.out.println("타율" + ta);

	}
}

class Football extends Sports {
//	String name;
//	int inwon;
	int goal;

	// 생성자
	Football(String name, int inwon, int goal) {
		super(name, inwon); // 부모 생성자 호출
//		this.name = name;
//		this.inwon = inwon;
		this.goal = goal;
	}

	void display() {
		super.display(); // 부모 display 메소드 호출
//		System.out.println("종목명:" + name);
//		System.out.println("인원수:" + inwon);
		System.out.println("골수:" + goal);
	}

}

public class P_Ex05_상속 {

	public static void main(String[] args) {

		Baseball bb = new Baseball("야구", 9, 0.345);
		bb.display();

		Football fb = new Football("축구", 11, 6);
		fb.display();
		
		System.out.println("-------------------");
		
		// 배열로 나타내기
		
		Sports[] sp = {new Baseball("야구",9,0.345),
			new Football("축구",11,3)};
		
		for(int i = 0; i< sp.length; i++) {
			sp[i].display();
		} // for문

	} // main

} // class
