import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex11_06_InputStreamReader {

	public static void main(String[] args) {

		InputStream is = System.in; // 키보드 입력 - 1바이트 입력
		InputStreamReader isr = new InputStreamReader(is); // 키보드 1바이트 입력을 2바이트 입력 가능하도록 객체생성
		BufferedReader br = new BufferedReader(isr);
		// 위에 세단계 작업을 아래처럼 한단계로 쓸 수 있음
//		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		// 최종적으로 만들어진 객체 : br

//		sc.next()
		try {
			String str = br.readLine(); // readLine 메소드 : 공백 포함해서 한줄(한 라인)의 데이터를 읽어들일 수 있게 함
			System.out.println("str: " + str);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
