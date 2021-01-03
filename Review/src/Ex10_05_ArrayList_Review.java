import java.util.ArrayList;
import java.util.Scanner;

class Card{
	private String name;
	private String tel;
	public Card(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
} // Card

public class Ex10_05_ArrayList_Review {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Card> list = new ArrayList<Card>();
		
		while(true) {
			
			boolean flag = false;
			
			System.out.print("1.명함추가  2.명함삭제  3.명함수정  4.명함보기  5.종료 : ");
			int select = sc.nextInt();
			
			if(select == 5)
				break;
			
			switch(select) {
			case 1: 
				System.out.print("이름을 입력하세요 :");
				String name = sc.next();
				System.out.print("전화번호를 입력하세요 :");
				String tel = sc.next();
				Card input = new Card(name,tel);
				list.add(input);
				break;
				
			case 2: 
				System.out.print("삭제할 이름을 입력하세요 :");
				String delName = sc.next();
				
				for(int i=0;i<list.size();i++) {
					Card delete = list.get(i);
					if(delete.getName().equals(delName)) {
						list.remove(i);
						System.out.println("삭제되었습니다.");
						flag = true;
						break;
					}
//					else { // 여기다 쓰면 안되는 이유 
//						System.out.println("이름 잘못 입력");
//					}
				}
				
				//if(flag == false) {
				if(!flag) {
					System.out.println("이름 잘못 입력하셨음");
				}
				
				break;
				
			case 3: 
				System.out.print("수정할 이름을 입력하세요");
				String modifyName = sc.next();
				for(int i=0;i<list.size();i++) {
					Card edit = list.get(i);
					if(edit.getName().equals(modifyName)) {
						System.out.print("수정할 전화번호는 : ");
						String modifyTel = sc.next();
						//edit.setTel(modifyTel);
						Card c = new Card(modifyName,modifyTel);
						list.set(i, c);
						
						System.out.println("수정되었음");
						flag = true;
					}
				} // for
				
				if(flag == false) {
					System.out.println("이름 잘못 입력하셨음");
				}
				
				break;
			case 4: 
				System.out.println("이름\t\t전화번호");
				//for(int i=0;i<list.size();i++) {
				for(Card one : list) { // 주석 달기 
					//Card one = list.get(i);
					System.out.println(one.getName()+"\t\t"+one.getTel());
				}
				break;
			default : System.out.println("번호 잘못 입력하셨음");

			}
		}
		// 밖에다 해주는 이유 : 그로그램을 종료합니다 라는 메시지가 두번 중복으로 출력됨
		System.out.println("프로그램을 종료합니다.");
	}
}


//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:1
//이름을 입력하세요 : kim
//전화번호를 입력하세요 : 1234
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:1
//이름을 입력하세요 : park
//전화번호를 입력하세요 : 4567
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:4
//이름		전화번호
//kim		1234
//park		4567
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:2
//이름을 입력하세요 : park
//삭제되었습니다.
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:4
//이름		전화번호
//kim		1234
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:2
//이름을 입력하세요 : choi
//이름을 잘못입력하셨습니다.
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:3
//이름을 입력하세요 : park
//이름을 잘못입력하셨습니다.
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:3
//이름을 입력하세요 : kim
//수정하실 전화번호는 : 9876
//수정되었습니다.
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:4
//이름		전화번호
//kim		9876
//
//1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:5
//프로그램을 종료합니다.