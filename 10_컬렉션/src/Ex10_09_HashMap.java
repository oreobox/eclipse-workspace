import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
	private String title; // 멤버변수
	private int price; // 멤버변수

	// 생성자
	public Book(String title, int price) {
		super(); // 생략가능
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return title + "/" + price;
	}

}

public class Ex10_09_HashMap {

	public static void main(String[] args) {

		Map<String, Book> hm = new HashMap<String, Book>();
		// hm : key(문자열 하나), value(title,price)

		Book bk1 = new Book("자바", 3000);
		Book bk2 = new Book("오라클", 2000);
		Book bk3 = new Book("JSP", 1000);

		hm.put("교보문고", bk1);
		hm.put("영풍문고", bk2);
		hm.put("yes24", new Book("JSP", 1000)); // 변수 말고 바로 값 입력해도 됨

		System.out.println(hm);

		Scanner sc = new Scanner(System.in);

		System.out.print("서점 입력: ");
		String bookstore = sc.next();
		if (hm.get(bookstore) == null) {
			System.out.println("잘못입력함");
		} else {
			System.out.println(hm.get(bookstore));
		}
		
		System.out.println(hm.size());
		
		hm.clear(); // 전체 삭제하고 싶을 때
		System.out.println(hm.size());

		// System.out.println(bk1.getTitle()); // 자바

	} // main

} // class
