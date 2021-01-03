import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] args) {

		Socket clientSocket = null; // clientSocket에 어느 서버에 연결되어있는지의 정보가 들어가있음
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader br = null;

//		clientSocket = new Socket("localhost", 7777); // 내가 실수로 없는주소나 잘못 입력할 수 있기 때문에 예외처리해줌
		try {
			clientSocket = new Socket("localhost", 7777); // clientSocket : localhost 서버에 접속했다는 변수

			//3개의 연결다리 : out, in, br
			out = new PrintWriter(clientSocket.getOutputStream(),true); // true를 써야 진짜 내보내기가됨(옵션설정)

			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// 클라이언트는 서버가 보낸 문제에 대해 자기가 생각하는 답을 키보드로 입력해야하기 때문에 키보드 연결다리 생성 해야함
			br = new BufferedReader(new InputStreamReader(System.in));

			String fromServer;
			String fromUser;

			while ((fromServer = in.readLine()) != null) { // 서버가 보내오는 데이터를 읽어올 것, 계속 여러번 받아올 것이기 때문에 while문
				System.out.println("서버: " + fromServer);
				// 서버 : 퀴즈를 시작합니다 - (y/n) 입력
				if (fromServer.equals("quit")) { // 언젠가 server가 quit을 보내면 빠져나와서 종료시킴
					break;

				} // if
				
				fromUser = br.readLine(); //클라이언트의 답(키보드) 입력 : 서버가 보내오는 문제의 답을 이것이라고 생각한다
				System.out.println("클라이언트: "+fromUser);
				out.println(fromUser);

			} // while
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //3개의 연결다리 : out, in, br 닫는 작업
//			in.close();, br.close(); // 예외발생시킴
			try {
				out.close(); // 밖으로 빠져있던 것들 다 try/catch안에 끌고들어와 예외처리해줌
				in.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // 예외발생시킴
		}

	}

}
