import java.util.ArrayList;
import java.util.Scanner;

//console 창에서 하는 작업  : 출력,입력 등
public class PersonMain {

	PersonDao dao = new PersonDao(); // 객체 만듬 : PersonDao 생성자로 가서 출력
	Scanner sc = new Scanner(System.in);

	// 생성자
	PersonMain() {
		System.out.println("PersonMain 생성자");
		init(); // init 함수 호출
	} // PersonMain

	public void init() { //init 정의
//		System.out.println("init");

		while (true) {
			System.out.println("\n === 메뉴 선택하기 ===");
			System.out.println("1. 전체 정보 조회");
			System.out.println("2. 성별로 조회");
			System.out.println("3. 정보 수정");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 정보 추가");
			System.out.println("6. 프로그램 종료");
			System.out.print(">> 메뉴 번호 입력: ");

			int menu = sc.nextInt(); //번호 입력받는 작업 - menu : 입력한 숫자 들어옴

			switch (menu) {
			case 1:
				ArrayList<PersonBean> list = dao.getAllPerson(); // Dao에서 리턴한 값  list에 담아서 Main으로 끌고와 출력
				
				// Dao에서 select 한것을 Main에서 출력하기 위해 ArrayList에 담고 return해서 
				// Main으로 끌고와 넘어온 것을 받아서 for문 돌려 출력하는 작업 
//				String title = "번호\t" + "이름\t" + "나이\t" + "성별\t" + "생년월일\t";
//				System.out.println(title);
//				// 레코드 컬럼별로 하나씩 가져와서 출력하기
//				for(int i=0;i<list.size(); i++) {
//					PersonBean bean = list.get(i); → i : 0번째~3번째까지 
//					String result = bean.getNum()+"\t" +
//									bean.getName()+"\t" +
//									bean.getAge()+"\t" +
//									bean.getGender()+"\t" +
//									bean.getBirth();
//					System.out.println(result);
//				}
				
				displayPerson(list); //↑ 위 내용 계속 중복되기 때문에  아래에 메서드 만들어서 호출하는 형태로 만들어줌
				break;
				
			case 2:
				getPersonByGender(); // 앞에 dao.이 없기 때문에 현재 클래스 안에서 getPersonByGender 생성
				break;
				
			case 3: // 정보수정
				updateData();
				break;
				
			case 4:
				deleteData();
				break;
			case 5:
				insertData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); // 프로그램 정상 종료
				break;
			default:
				System.out.println("1~6 사이의 번호만 입력 가능");
			} // switch

		} // while(true)

	} // init
	
	private void deleteData() { // 다른 클래스에서 사용 안하게 하려면 private
		System.out.print("삭제할 번호 입력: ");
		int num = sc.nextInt();
		
		int count = dao.deleteData(num);
		if(count >0) {
			System.out.println("삭제 성공");
		}
		else if(count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		}
		else { // 음수
			System.out.println("삭제 실패");
		}
		
	}
	
	public void updateData() {
		System.out.print("수정할 번호 입력: ");
		int num = sc.nextInt();
		
		System.out.print("수정할 이름입력: ");
		String name = sc.next();
		
		System.out.print("수정할 나이 입력: ");
		int age = sc.nextInt();
		
		System.out.print("수정할 성별 입력: ");
		String gender = sc.next();
		
		System.out.print("수정할 생년월일 입력: ");
		String birth = sc.next();
		

		PersonBean bean = new PersonBean(num,name,age,gender,birth);
		int count = dao.updateData(bean); // bean : (num,name,age,gender,birth)
		if(count >0) {
			System.out.println("수정 성공");
		}
		else if(count == 0) {
			System.out.println("!조건에 맞는 레코드가 없음!");
		}
		else { // 음수
			System.out.println("수정 실패");
		}
		
	} // updateData

	
	public void insertData() {
		System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		System.out.print("이름입력: ");
		String name = sc.next();
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		System.out.print("성별 입력: ");
		String gender = sc.next();
		System.out.print("생년월일 입력: ");
		String birth = sc.next();
		
		PersonBean bean = new PersonBean(0,name,age,gender,birth);
		// ↓ 기존 생성자 재 활용 방법 or PersonBean 에서 생성자 하나 더 만들어도 됨
		// ★bean 변수의 자료형(type): 5가지가 한묶음으로 담긴 PersonBean :(int num, String name, int age, String gender, String birth)
		//0: 생성자에서 첫번째자리(int num) 시퀀스에 대한것 받아주기 위해 의미없는 숫자 0으로 넣어줌
		int count = dao.insertData(bean);
		
		if(count <0) {
			System.out.println("삽입 실패");
		}
		else {
			System.out.println("삽입 성공");
		}
		
	} // insertData
	
	public void getPersonByGender() { // 2번 호출 - 현재 Main 클래스에 있는 메소드는 성별 입력하는 기능
		System.out.println("찾으려는 성별 입력: ");
		String gender = sc.next();
		
		ArrayList<PersonBean> list = dao.getPersonByGender(gender); // dao 메소드는 아래 DB 작업(select)하는 기능 
		//select * from person where gender = '남' or '여'

		displayPerson(list); // 남자 또는 여자 레코드 목록을 list에 보내서 출력
		
	} // getPersonByGender
	
	public void displayPerson(ArrayList<PersonBean> list) { // person 찾은거 for문 반복하는거 메서드로 만들어서 가져오기
		
		String title = "번호\t" + "이름\t" + "나이\t" + "성별\t" + "생년월일\t";
		System.out.println(title);
		// 레코드 컬럼별로 하나씩 가져와서 출력하기
		for(int i=0;i<list.size(); i++) {
			PersonBean bean = list.get(i); // 0번째 줄 가져와라
			String result = bean.getNum()+"\t" +
							bean.getName()+"\t" +
							bean.getAge()+"\t" +
							bean.getGender()+"\t" +
							bean.getBirth();
			System.out.println(result);
		} // for
		
	} // displayPerson

	public static void main(String[] args) {
		new PersonMain(); // 생성자의 객체 - 객체를 만들면 자동으로 호출되는 메서드(=생성자)로 간다.

	} // main

} // PersonMain

// 생성자
//1. 클래스와 이름이 같은 메서드이다.
//2. 객체를 만들면 자동으로 호출되는 메서드로 간다.
//3. 정의하지 않아도 default 생성자(기본 생성자)가 존재한다. () 괄호 안에 아무것도없음