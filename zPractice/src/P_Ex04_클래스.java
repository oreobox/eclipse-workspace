class Person {
	private String name;
	int age;
	double height;
	static String nation;
	
	Person() {
		System.out.println("Person 생성자");
	}

	Person(String name, int age, double height) {
		System.out.println("Person 생성자");
		this.name = name;
		this.age = age;
		this.height = height;
		
	}

	public void setName(String n) {
		name = n;
	}

	String getName() {
		return name;
	}

}

public class P_Ex04_클래스 {

	public static void main(String[] args) {
		int a;
		a = 11;
		Person p1 = new Person();
		p1.age = 25;
		p1.height = 149.8;
		Person.nation = "대한민국";
		p1.setName("홍길동");
		System.out.println(p1.getName());
		
		Person p2 = new Person();
		p2.age = 35;
		p2.height = 178.7;
		
		System.out.println(p2.nation);
		System.out.println(p2.age);
		
		

	} // main

} // class
