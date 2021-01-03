class Sports { // Baseball과 Football 중 공통된 name, inwon을 부모클래스로 클래스 생성
	String name;
	int inwon;

	Sports(String name, int inwon) { // 생성자가 생략되어있음 - 매개변수(name,inwon) 있는 생성자
		this.name = name;
		this.inwon = inwon;
	} // 생성자

	void display() { // display 메소드
		System.out.println("종목명: " + name);
		System.out.println("인원수: " + inwon);
	} // display
}

class Baseball extends Sports { // extends : Sports 클래스에 있는 것을 상속받음
	// String name;
	// int inwon;
	double ta;

	// 생성자
	// Baseball(){ // default 생성자
	Baseball(String name, int inwon, double ta) {
		// super(); 가 생략 되어있음 // 부모 생성자 호출하는 코드
		super(name, inwon); // 부모 생성자 호출
		// this.name = name;
		// this.inwon = inwon;
		this.ta = ta;

	}

	void display() { // display 메소드
		// System.out.println("종목명: " + name);
		// System.out.println("인원수: " + inwon);
		super.display(); // 부모의 display 메소드 호출
		System.out.println("타율: " + ta);

	} // display

} // Baseball

class Football extends Sports {
	// String name;
	// int inwon;
	int goal;

	// 생성자
	Football(String name, int inwon, int goal) { // 순서대로 작성
		super(name, inwon); // 부모 생성자 호출
		// this.name = name;
		// this.inwon = inwon;
		this.goal = goal;
	}

	void display() {
		// System.out.println("종목명: " + name);
		// System.out.println("인원수: " + inwon);
		super.display(); // 부모의 display 메소드 호출
		System.out.println("골수: " + goal);
	} // display

} // Football

public class Ex05_상속 {

	public static void main(String[] args) {
//		Sports bb = (Sports)new Baseball("야구", 9, 0.345); // 자식을 부모가 관리할 수 있기 때문에 똑같이 춮력가능
		Baseball bb = new Baseball("야구", 9, 0.345);
		bb.display();

		Football fb = new Football("축구", 11, 6);
		fb.display();

		System.out.println("-------------------");

		Sports[] sp = { new Baseball("야구", 9, 0.345), // 객체 배열
						new Football("축구", 11, 6) };

		for (int i = 0; i < sp.length; i++) {
			sp[i].display(); // 자식의 display가 호출되지만, 부모에도 같은 display있어야함
		} // for문

	} // main

}
// Ex05_상속
