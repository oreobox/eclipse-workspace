import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex13_03_Client {
	public static void main(String[] args) throws IOException {

		// "127.0.0.1" 또는 "localhost" 이렇게 쓰면 무조건 내 컴퓨터(내 ip주소)를 의미
		// 어느 컴퓨터와 연결할 것인지 선택 후 포트 번호 작성
//		Socket cs = new Socket("localhost",5555); // client 쪽에 달아놓은 소켓 // 예외처리해줌(2가지)
		//UnknownHostException의 부모 = IOException 이기 때문에 예외처리는 IOException 하나로 해도됨
		
		Socket cs = null;
		
		try {
			cs = new Socket("localhost", 5555); // client가 접속을 시도한 컴퓨터는  localhost 여기다
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("클라이언트의 입력: ");
//		String clientLine = br.readLine(); // throws IOException 예외처리
		String clientLine = br.readLine();
		
		//설정 서버쪽으로 내보내기 위한 연결다리 설정 - pw 다리를 타고가면 어디랑 연결됬는지 알수있음
		PrintWriter pw = new PrintWriter(cs.getOutputStream()); // cs cannot be resolved -> cs 변수 바깥에 지정함

		pw.println(clientLine); // 내보내기
		
		pw.close();
		br.close(); // 모든 사용한 자원 닫겠다는 뜻
		

	}

}
