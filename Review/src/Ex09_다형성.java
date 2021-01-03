class Robot {

} // Robot

class DanceRobot extends Robot { // Robot 값 아무것도 없지만 우선 상속받음
	void dance() {
		System.out.println("춤을 춥니다.");
	}

} // DanceRobot

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
} // SingRobot

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
} // DrawRobot

public class Ex09_다형성 { // 다형성 : 서로 다른 타입을 관리 가능

	public static void main(String[] args) {
		DanceRobot dc = new DanceRobot();
		dc.dance();

		SingRobot sr = new SingRobot();
		sr.sing();

		Robot dc2 = (Robot) new DanceRobot(); // 업캐스팅  // 상속받으면 자식공간을 부모타입의 변수로 관리할 수 있다
		// dr2.dance(); // 오류 - 부모가 가지고 있지 않으니까 자식공간을 받아 쓸 수 없음

		Robot sr2 = new SingRobot();
		Robot dr2 = new DrawRobot();

		// int a,b,c; //같은 타입이 여러개 있으면 배열로 만들어 쓸 수 있음
		// int[] x = new int[3];

		Robot[] arr = { new DanceRobot(), // 서로 다른 클래스 임에도 배열로 묶을 수 있는 이유는 부모 클래스(Robot)로 묶어줬기 때문
						new SingRobot(),
						new DrawRobot() };
		// arr[0].dance(); // 오류 - 부모가 가지고 있지 않으니까 자식공간을 받아 쓸 수 없음

		for (int i = 0; i < arr.length; i++) {	// for(int i=0;i<3;i++) {로 써도됨
			action(arr[i]); // 위에서 Robot을 배열로 묶어준 것을 다 나타냄

		} // for문

	} // main

	static void action(Robot r) { // r변수에 3가지 new 타입 객체 받아줌 //  부모타입(Robot)이기 때문에 다 받을 수 있음
//		 Robot r = (Robot) new DanceRobot() // 업캐스팅됨
//		 Robot r = (Robot) new SingRobot() // 부모가 자식을 관리할 수 있다는 다형성
//		 Robot r = (Robot) new DrawRobot()

		// r.dance()
		if (r instanceof DanceRobot) { // true // instanceof의 연산결과가 true이면, 해당 타입으로 형변환이 가능
//			r.dance() // 안됨
			DanceRobot dr = (DanceRobot) r; // 다운캐스팅 할 수 있는 이유는 업캐스팅이 됐기 때문(L55~57)
			dr.dance();

		} else if (r instanceof SingRobot) {
			SingRobot sr = (SingRobot) r;
			sr.sing();

		} else if (r instanceof DrawRobot) {
			DrawRobot dw = (DrawRobot) r;
			dw.draw();

		}
	}

} // Ex09_다형성
