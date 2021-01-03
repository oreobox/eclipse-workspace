	// 클래스 = 설계도 = 틀
	// 1. 내가 만들어 쓰는 자료형-문자형
	// 2. 정수 및 실수 다 쓸 수 있음 
	// 3. new를 사용해서 객체 만들기 전에는 공간 차지 X
class Person {
	private String name; // 객체변수=인스턴스 변수=멤버변수 // private 사용하면 다른 클래스에서는 사용 불가
	int age;
	double height;
	static String nation; // 공통으로 사용하고 싶은 변수만 static 붙임

	// 생성자
	// 1. 클래스와 이름이 같은 메서드이다. - 앞에 리턴 타입이 없음(앞에 void, String 등 을 써주지 않음)
	// 2. 객체를 만들면 자동으로 호출(생성)된다.
	// 3. 정의하지 않아도 default 생성자(기본 생성자)가 존재한다. () 괄호 안에 아무것도없음
	Person() {
		System.out.println("Person 생성자"); // p1과 p2에서 new로 객체 생성했었음
	}

	Person(String name, int age, double height) { // 매개변수
		System.out.println("Person 생성자"); // p1과 p2에서 new로 객체 생성했었음
		this.name = name; // 멤버변수를 가져옴을 알려주기 위해 자기자신 this. 같이 입력
		this.age = age;
		this.height = height;
	}

	// 메서드
	// 1. 기능을 가지고 있는 작은 프로그램 단위 , 특정한 작업을 수행하도록 독립적으로 작성된 프로그램
	// 2. 프로그램에서 반복적으로 수행되는 부분을 메서드로 작성하여 필요할 때마다 호출하여 사용
	// 3. 어떤 값을 입력받아 처리하고 그 결과를 돌려준다. (입력받은 값이 없을 수도있고 결과를 돌려주지 않을 수도 있다.)
	// 4. 클래스 영역에만 정의할 수 있음
	void setName(String n) { // void - 아무것도 리턴하지 않겠다는 뜻
//		System.out.println("abc");
		name = n; // 'n' 에 들어온 것을 private String name으로 리턴 하겠다는 뜻
	}
	// 리턴
	// 1. 메서드의 종료를 의미
	// 2. 현재 실행 중인 메서드를 종료하고 호출한 메서드로 되돌아간다.
	// 3. 메서드를 끝내기 위해서는 메서드 내의 모든 작업을 완료하던지, 아니면 return문을 만나면서 메서드의 특정 부분에서 작업을 끝내게 된다.
	// 4. 값을 가지고 리턴하면 리턴하는 값의 자료형을, 값을 갖지 않고 리턴	하면 void를 메서드의 선언부에 쓴다.
	String getName() {
		return name;
		
	}

} // Person

public class Ex04_클래스 {
	public static void main(String[] args) {

		int a;
		a = 11;
		// ↓ 내가 만든 자료형의 공간을 만들고 싶을 때 new 사용 - 그 전에는 공간 차지 X
		Person p1 = new Person(); // p1: 참조변수(주소)
//		p1.name = "홍길동"; // private 이기 때문에 다른 class로 못 끌어옴
		p1.age = 25;
		p1.height = 149.8;
		Person.nation = "대한민국";
//		p1.nation = "대한민국";
		p1.setName("홍길동"); // abc(setName) 메서드 호출
//		System.out.println(p1.name); // 그냥 name으로 출력하면 오류 / p1.name : p1에있는 자료를 불러온다는 것을 사용
		System.out.println(p1.getName());

		Person p2 = new Person(); // p2: 참조변수(주소)
//		p2.name = "고길동";
		p2.age = 35;
		p2.height = 175.8;

//		System.out.println(p2.name);
		System.out.println(p2.nation); // p2에는 nation을 지정해주지 않았기 때문에 초기값 null이 표시됨
										// - 변수 앞static지정하면 공통으로 출력

		Person p3 = new Person("승우", 10, 123.4);
		System.out.println(p3.getName());
		System.out.println(p3.age);
		System.out.println(p3.height);

	} // main

} // Ex04_클래스
