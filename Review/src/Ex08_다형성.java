class Car extends Object { // 클래스는 대문자 // 모든 클래스는 쓰지 않아도 Object 클래스를 상속받음 - extends Object

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

	void drive() { // 오버라이딩
		System.out.println("FireEngine drive~");
	}

	void water() {
		System.out.println("water!");
	}
} // FireEngine

public class Ex08_다형성 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = (Car) fe; // 업캐스팅(자식타입을->부모타입으로 바꾸는 것-형바꿈)은 자동. 생략가능// car변수에 fe를 넣어! fe의 주소랑 같은 주소를 갖게됨
		System.out.println(car.door);
		System.out.println(car.color);
//		System.out.println(car.wheel); // 부모는 자식꺼에서 데려와 쓸 수 없음

		System.out.println(fe.door);
		System.out.println(fe.wheel);
		System.out.println(fe.color); // 자식꺼에는 없지만, 부모꺼에서 데려와 쓸 수 있음

		car.drive(); // 자식 메소드에 접근 - 물려준 값이 있는지 확인되면 출력가능
		// car.water(); // 물려준 값이 없기 때문에 출력 안됨

		fe.drive(); // 자식 메소드에 접근
		fe.water();
		fe.stop(); // 자식은 부모꺼에 값 있으면 가져다 쓸 수 있음

		fe2 = (FireEngine) car; // 다운캐스팅(부모타입->자식타입)은 자동 X - 반드시 캐스팅(형변환) 작업 필요
		fe2.water();
		fe2.drive();

	}

}