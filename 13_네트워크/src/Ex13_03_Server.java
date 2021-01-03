import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex13_03_Server { // Ex13_03_Server 먼저 실행하고 끄기 전에  Ex13_03_Client 실행
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = null;

//		ServerSocket ss = new ServerSocket(5555); // 혹시 사용중인 포트번호일 수 있기 때문에 IOException발생됨
		try {
			// 서버쪽에 메세지 주고받을 수 있는 장치를 만듬
			ss = new ServerSocket(5555); // 5555번 port를 통해서 client랑 소통을 해보겠다
		} catch (IOException e) {
			System.out.println("5555 포트 번호에 연결할 수 없습니다.");
			System.exit(1);
			; // 비정상적인 문제때문에 종료하겠다는 뜻 (0):정상종료로 써도 상관은 없음

		}
		
		Socket cs = null; // Socket은 클라이언트 쪽에 달아둠
		System.out.println("Server readdy...");
		
		// ss.accept(); 만 쓰면 오류가 나는 이유는 전역변수 선언 안해줬기 때문에 - try/catch 안에서만 사용했기때문
		// cs에 접속을 시도한 client가 담김
		try {
			cs = ss.accept(); // 받아들일 준비됐으니까 누구든 와라 
			System.out.println("서버에 연결됨");
			
		} catch (IOException e) {
			e.printStackTrace();	
		} 
		
		//서버쪽으로 접속을 시도한 Client가 보내는 데이터를 읽기 위한 연결다리
		BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		// cs.getInputStream()가 예외처리 발생함
		String line = br.readLine();
		System.out.println("클라이언트가 보내온 데이터 : " + line);
		
		br.readLine(); // client가  보내온 데이터를 읽기
		cs.close();
		ss.close();
		

	} // main

} // class
