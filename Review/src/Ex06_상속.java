class Human {
	private String name;
	private int age;

	// 생성자
	// Human() {
	//
	// }
	Human(String name, int age) {
		this.name = name;
		this.age = age;

	}

	void display() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
	}

} // Human

class Employee extends Human {
	// private String name;
	// private int age;
	private String workplace;
	private String part;

	// 생성자
	Employee(String name, int age, String workplace, String part) {
		super(name, age);
		// this.name = name; // 부모의 private 클래스에 접근할 수 없음
		// this.age = age;
		this.workplace = workplace;
		this.part = part;
	}

	void display() {
		super.display();
		System.out.println("workplace: " + workplace);
		System.out.println("part: " + part);
	}

} // Employee

class Teacher extends Employee { // extends Human, Employee 오류남 - extensds 옆에는 하나의 class만 쓸 수 있음
	// private String name;
	// private int age;
	// private String workplace;
	// private String part;
	private String subject;

	// 생성자
	Teacher(String name, int age, String workplace, String part, String subject) {
		super(name, age, workplace, part);
		this.subject = subject;
	}

	void display() {
		super.display();
		System.out.println("subject: " + subject);
	}
} // Teacher

public class Ex06_상속 {

	public static void main(String[] args) {

		Human h = new Human("써니", 30);
		Employee e = new Employee("웬디", 20, "삼성", "홍복부");
		Teacher t = new Teacher("슬기", 40, "중앙고", "생활지도부", "음악");

		h.display();
		System.out.println();
		e.display();
		System.out.println();
		t.display();

		System.out.println("-------------------");

		Human[] hm = { new Employee("웬디", 20, "삼성", "홍복부"), new Teacher("슬기", 40, "중앙고", "생활지도부", "음악") };

		for (int i = 0; i < hm.length; i++) {
			hm[i].display();

		} // for문

	}// main

} // Ex06_상속
