import java.util.ArrayList;
import java.util.Scanner;

//console 창에서 하는 작업 :  출력, 입력 등
public class ProductMain {

	ProductDao dao = new ProductDao(); // 객체 생성
	Scanner sc = new Scanner(System.in);

	// 생성자
	ProductMain() {
//		System.out.println("ProductMain");
		init();
	} // 생성자

	private void init() {

		while (true) {

			System.out.println("\n===메뉴 선택하기===");
			System.out.println("1. 모든 상품 조회");
			System.out.println("2. 특정 상품 조회(아이디 이용)");
			System.out.println("3. 특정 상품 조회(카테고리 이용)");
			System.out.println("4. 상품 수정");
			System.out.println("5. 상품 삭제");
			System.out.println("6. 상품 추가");
			System.out.println("7. 프로그램 종료");
			System.out.print(">> 메뉴 번호 입력: ");

			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				ArrayList<ProductBean> list = dao.getAllProduct();
				displayProduct(list);
				break;
			case 2:
				getProductById();
				break;
			case 3:
				getProductByCategory();
				break;
			case 4:
				updateData();
				break;
			case 5:
				deleteData();
				break;
			case 6:
				insertData();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~7 사이의 번호만 입력 가능합니다.");
				break;

			} // switch

		} // while

	} // init

	private void deleteData() {
		System.out.print("삭제할 번호 입력: ");
		int id = sc.nextInt();

		int count = dao.deleteData(id);
		if (count > 0) {
			System.out.println("삭제 성공");
		} else if (count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		} else { // 음수
			System.out.println("삭제 실패");
		}

	} // deleteData

	private void updateData() {
		int id, stock, price ;
		String category, name, inputdate ;
		
		System.out.print("수정할 번호 입력: ");
		id = sc.nextInt();
		
		System.out.print("수정할 이름 입력: ");
		name = sc.next();
		
		System.out.print("수정할 재고 입력: ");
		stock = sc.nextInt();
		
		System.out.print("수정할 가격 입력: ");
		price = sc.nextInt();
		
		System.out.print("수정할 카테고리 입력: ");
		category = sc.next();
		
		System.out.print("수정할 입고일 입력: ");
		inputdate = sc.next();

		ProductBean bean = new ProductBean(id, name, stock, price, category, inputdate);
		int count = dao.updateData(bean);
		if (count > 0) {
			System.out.println("수정 성공");
		} else if (count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		} else { // 음수
			System.out.println("수정 실패");
		}

	} // updateData

	private void insertData() {
//		int id, stock, price ;
//		String category, name, inputdate ;
		
		System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		System.out.print("상품명 입력: ");
		String name = sc.next();
		
		System.out.print("재고 입력: ");
		int stock = sc.nextInt();
		
		System.out.print("가격 입력: ");
		int price = sc.nextInt();
		
		System.out.print("카테고리 입력: ");
		String category = sc.next();
		
		System.out.print("입고일 입력: ");
		String inputdate = sc.next();

//		방법①  생성자 통해서 주입 - 6개 항목을 매개변수로 받는 생성자
//		ProductBean bean1 = new ProductBean(0, name, stock, price, category, inputdate);
		// ★bean 변수의 자료형(type): 5가지가 한묶음으로 담긴 PersonBean
		// 0: 생성자에서 첫번째자리(int id) 시퀀스에 대한것 받아주기 위해 의미없는 숫자 0으로 넣어줌
		
//		방법②  setter,getter 통해서 주입
		ProductBean bean = new ProductBean();
		bean.setName(name);
		bean.setStock(stock);
		bean.setPrice(price);
		bean.setCategory(category);
		bean.setInputdate(inputdate);
		
		int count = dao.insertData(bean);
		if (count < 0) {
			System.out.println("삽입 실패");
		} else {
			System.out.println("삽입 성공");
		}

	} // insertData

	public void getProductByCategory() {
		System.out.print("찾으려는 CATEGORY 입력: ");
		String category = sc.next();

		ArrayList<ProductBean> list = dao.getProductBycategory(category);

		if(list.size() == 0) {
			System.out.println("해당 카테고리는 존재하지 않습니다.");
		}
		else {
			displayProduct(list);
		}
		
//		내가한것
//		if (category.equals("KJ") || category.equals("IT")) {
//			displayProduct(list);
//		} else {
//			System.out.println("해당 카테고리는 존재하지 않습니다.");
//		}

	} // getProductByCategory

	public void getProductById() { // 2번 호출
		System.out.print("찾으려는 ID 입력: ");
		int id = sc.nextInt();

		ArrayList<ProductBean> list = dao.getProductById(id);
		if(list.size() == 0) {
			System.out.println("해당 아이디를 찾을 수 없습니다.");
		}
//			★ 다시해보기
//		else {
//			String title = "번호\t" + "이름\t" + "재고\t" + "가격\t" + "카테코리\t" + "입고일\t";
//			System.out.println(title);
//			String result = list.getId() + "\t" + list.getName() + "\t" + list.getStock() + "\t" + list.getPrice()
//			+ "\t" + list.getCategory() + "\t" + list.getInputdate();
//			System.out.println(result);
			
//		}
		displayProduct(list);

	} // getProductById

	public void displayProduct(ArrayList<ProductBean> list) {

		String title = "번호\t" + "이름\t" + "재고\t" + "가격\t" + "카테코리\t" + "입고일\t";
		System.out.println(title);

		for (int i = 0; i < list.size(); i++) {
			ProductBean bean = list.get(i);
			String result = bean.getId() + "\t" + bean.getName() + "\t" + bean.getStock() + "\t" + bean.getPrice()
					+ "\t" + bean.getCategory() + "\t" + bean.getInputdate();
			System.out.println(result);

		} // for

	} // displayProduct

	public static void main(String[] args) {

		new ProductMain();
	} // main

} // ProductMain
