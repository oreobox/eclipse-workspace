class Car extends Object {

	String color = "white";
	int door = 4;

	void drive() {
		System.out.println("drive~");
	}

	void stop() {
		System.out.println("stop!");
	}

} // Car

class FireEngine extends Car {
	int door = 6;
	int wheel = 10;

	void drive() {
		System.out.println("FireEngine drive~~");
	}

	void water() {
		System.out.println("water!");
	}

} // FireEngine

public class P_Ex08_다형성 {

	public static void main(String[] args) {
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = (Car)fe; // 업캐스팅(자식타입 -> 부모타입) 자동 형변환됨 // (Car)fe생략되어있음
		System.out.println(car.door);
		System.out.println(car.color);
//		System.out.println(car.wheel); // 부모는 자식꺼에서 데려와 쓸 수 없음
		
		System.out.println(fe.door);
		System.out.println(fe.wheel);
		System.out.println(fe.color); // 자식꺼에는 없지만, 부모꺼에서 데려와 쓸 수 있음
		
		System.out.println();
		
		car.drive();
//		car.water(); // 자식에 물려준 값이 없기때문에 출력안됨
		
		fe.water();
		fe.stop();
		
		fe2 = (FireEngine)car; // 다운 캐스팅 (부모타입->자식타입)은 자동x - 형변환 해줘야함
		fe2.water();
		fe2.drive();
		fe2.stop();
		

	} // main

} // class
