class Product {
	private String code;
	private String company;

	// 생성자
	Product(String code, String company) {
		this.code = code;
		this.company = company;
	}

	// 메소드
	void show() {
		System.out.println("code:" + code);
		System.out.println("company:" + company);
	}
}

class Computer extends Product {
	String version;
	int giga;

	// 생성자
	Computer(String code, String company, String version, int giga) {
		super(code, company);
		this.version = version;
		this.giga = giga;
	}

	void show() {
		super.show();
		System.out.println("version:" + version);
		System.out.println("giga:" + giga);
	}

}

public class P_Ex07_상속 {

	public static void main(String[] args) {

		Product p = new Product("P01", "중앙"); // code, company
		Computer c = new Computer("C01", "삼성", "window10", 64);

		p.show();
		System.out.println();
		c.show();

		System.out.println("-------------------");

		Product[] pd = { (new Product("P01", "중앙")), (new Computer("C01", "삼성", "window10", 64)) };
		for (int i = 0; i < pd.length; i++) {
			pd[i].show();

		}

	} // main

}
// class
