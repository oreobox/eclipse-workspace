import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex11_10_Scanner {

	public static void main(String[] args) throws FileNotFoundException { // 파일 발생하지 못했다는 예외 발생할 수 있기때문에 예외처리해줌
		// Scanner sc = new Scanner(System.in); // 키보드 입력
		// Scanner​(InputStream source)

		Scanner sc = new Scanner(new File("scan.txt"));
		// Scanner​(File source)
		sc.useDelimiter(","); // 쉼표를 구분자로 해서 쉼표 만나면 하나씩 끊어서 읽어낼것이라는 뜻

		int sum = 0, num, cnt = 0;
		while (sc.hasNextInt()) { // 하나라도 불러올 수가 있으면 true
			num = sc.nextInt();
			sum += num;
			cnt++;
		}
		System.out.println("cnt:" + cnt);
		System.out.println("sum:" + sum);
		System.out.println("avg:" + (double) sum / cnt); // 5.5 출력
		System.out.printf("avg2:%.2f", (double) sum / cnt); // 소수점 둘째자리 까지 표시

	} // main

} // class
