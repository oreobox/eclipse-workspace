import java.util.Scanner;

public class P_Ex11_08_내이름 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		while (true) {
			System.out.println("1.단어입력 2.단어검색 3.종료 >>");
			num = sc.nextInt();

			switch (num) {
				case 1:
					
					break;
			
				case 2 :
					
					break;
					
				case 3 :
					System.out.println("종료되었습니다.");
					sc.close();
					System.exit(0);
					break;
					
				default :
					System.out.println("1~3사이의 번호만 입력 가능");
			
			} // switch

		} // while

	} // main

} // class
