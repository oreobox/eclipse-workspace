import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex11_08_이도흔 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = null;
		종료: while (true) {

			System.out.print("1.단어입력 2.단어검색 3.종료 >>");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.print("단어/뜻 입력>> ");
				FileWriter fw = new FileWriter("c:\\sun\\voca.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				while ((str = br.readLine()) != null) {
					bw.write(str);
//					bw.newLine();
					break;
				}

			case 2:
				System.out.print("검색 단어 입력>>");

				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");

				break 종료;

			} // switch

		} // while

	} // main

} // class
