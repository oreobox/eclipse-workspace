import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex11_08_Review {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); // 메뉴선택 - 키보드 입력 읽어들임
		int num;
		String input, searchWord, line;
		boolean flag = false;

		while (true) {
			System.out.print("1.단어입력 2.단어검색 3.종료 >>");
			num = sc.nextInt();

			switch (num) {
			case 1:
				// 1바이트를 2바이트로 변경, 버퍼의 도움을 받아 입력받겠다. // 입력(키보드) 스트림 형성
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("단어/뜻 입력>> ");
				input = br.readLine(); // (throws IOException 예외처리해주기-메소드를 호출하는 메인메소드로 떠넘김) 한줄 입력한 것 읽어드리고,
										// input 선언:desk 등 문자들어감

				BufferedWriter bw = new BufferedWriter(new FileWriter // bw라는 연결고리를 타고 파일에 쓰기 위해 사용
				("c:\\sun\\voca.txt", true)); // 한글도 쓸꺼니까 FileWriter 사용 // c:\\sun 까진 폴더가 있어야하고, voda.txt는 자동으로 생성됨
				// ,false 기본으로 들어가있는데 false면 기존꺼 지우고 다시 쓰기 ,true라고 쓰면 기존꺼 남기고 계속 추가 쓰기

				bw.write(input); // 파일에 출력
				bw.newLine(); // 한줄 띄어쓰기
				bw.flush(); // 또는 bw.close(); // Buffer를 다 채우지 않았어도 내보내기

				break;

			case 2:
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("검색 단어 입력>>");
				searchWord = br2.readLine(); // 한줄입력 // searchWord에는 검색할 단어 들어감 (Blue Sky)
				// voca.txt에 단어 들어가있는데 그것을 읽어드려야함.

				BufferedReader br3 = new BufferedReader(new FileReader("c:\\sun\\voca.txt"));

				while ((line = br3.readLine()) != null) { // br3에서 한줄씩 읽기
					// line : blue sky/파란하늘
					String[] tokens = line.split("/"); // String 배열 리턴
					if (tokens[0].equalsIgnoreCase(searchWord)) { // 대소문자 무시하고 입력한 값 받아오기 // tokens 쪼개진 묶음 : 총 2개
						System.out.println("단어>> " + tokens[0]); // 0번 방에 단어있고,
						System.out.println("뜻>> " + tokens[1]); // 1번방에 뜻 있음

						flag = true; // 찾는 단어를 찾았다는 뜻 : ture
					}
//					else { // else 사용 불가
//						
//					}

				} // while

				if (flag == false) { // false면 찾는단어 못찾았다는 뜻
					System.out.println("찾는 단어 없음");
				}

				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				sc.close(); // Scanner 닫아줌 // 생략가능
				System.exit(0); // 정상이 아니면 빠져나감 // 종료함 - 1 써도 크게 상관없음

			default: // 1~3번 이외의 숫자 입력 시
				System.out.println("1~3사이의 번호만 입력 가능");

			} // switch

		} // while

	} // main

} // class
