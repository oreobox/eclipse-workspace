class Top<T> extends Object { // <관례적으로 미기정 자료형(Type) 앞글자 써줌> // 각기 다른 타입을 써줄 수 있도록 설정
	private T data; // String 타입 대신 T 써줌

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;

	}

} // Top

public class Ex10_01_generic {

	public static void main(String[] args) {
		Top<String> t1 = new Top<String>();
		System.out.println(t1); //
		System.out.println(t1.toString()); // Object 클래스에서 만든것
//		t1.data = "abc"; // data가 private이기 때문에 사용 불가
		t1.setData("Hello");
//		System.out.println(t1.getData()); // getData 받아서 바로 출력
		String str = t1.getData(); // str 변수에 리턴 되는 문자열(String data)을 받고싶을 때
		System.out.println("str:" + str);
		System.out.println("-------------------");

// wrapper 클래스 : 기본 자료형(8가지)을 객체로 만들 수 있는 클래스
// byte : Byte
// short : Short
// int : Integer
// long : Long
// float : Float
// double : Double
// char : Character
// boolean : Boolean 등등 총 8가지

		Top<Integer> t2 = new Top<Integer>(); // int형은 Integer라고 풀네임 써줘야함
		t2.setData(123);
//		Integer it = t2.getData(); ↓ 아래와 같이 사용 가능
		int it = t2.getData(); // 넘어오는 것을 받을 때에는 어차피 정수 값을 받는 것이기 때문에 Integer 대신 int라고 써도 상관없음
		System.out.println("it: " + it);
		System.out.println("-------------------");

		Top t3 = new Top();
//		t3.data = "abc"; // data가 private이기 때문에 사용 불가
		t3.setData("Hello");
//		System.out.println(t3.getData()); // getData 받아서 바로 출력
		String str3 = (String) t3.getData(); // str 변수에 리턴 되는 문자열(String data)을 받고싶을 때 // 다운캐스팅
		System.out.println("str:" + str3);

	}

}
