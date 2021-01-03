import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null; // 변수만듬
		Socket clientSocket = null; // 클라이언트 접속 변수

//		serverSocket = new ServerSocket(7777); // 메세지 주고받을 수 있는 장치 만듬 - 미 사용중인 포트 번호를 가져와야함
		// 7777이 이미 사용중인 포트번호일 수 있기 때문에 예외 처리해줌
		try {
			serverSocket = new ServerSocket(7777); // 메세지 주고받을 수 있는 장치 만듬 - 미 사용중인 포트 번호를 가져와야함
		} catch (IOException e) {
			System.out.println("7777은 이미 사용중인 포트번호임");
			System.exit(1);

		}

		System.out.println("Server ready.."); // 클라이언트가 접속하기를 기다림
//		serverSocket.accept(); // 예외 발생 가능 - 예외처리
		try {
			clientSocket = serverSocket.accept(); // 누가 접속을 시도했는지 정보가 이쪽으로 들어옴
			System.out.println("접속됨"); // 이게 출력되면 누군가 접속을 시도했다는 뜻
		} catch (IOException e) {
			System.out.println("accept 실패");
			System.exit(1);
		}

		// 변수 out통해서는 내보내기, in 통해서는 클라이언트에서 보내는 다리를 읽어드리는 다리 만듬 - 서버, 클라이언트 양쪽 다 생성해야함
//		PrintWriter out = new PrintWriter(clientSocket.getOutputStream()); // 내보내기위한 연결다리 설정 - 예외처리(throws IOException)
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		// 서버가 클라이언트 쪽으로 내보내기위한 연결다리 설정 - 서버가 pw 다리를 타고 내보내기됨 // true를 써줘야 진짜 내보내기됨

		// 클라이언트가 보내는 데이터를 읽어들이기 위한 br 다리 형성 - 2바이트 입력으로 변경을하고 버퍼 사용
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String outputLine;
		String inputLine;

		// 문제은행에 있는거 가져와서 쓰려면 객체 만들어야함
		QuizBank bank = new QuizBank();
		outputLine = bank.process(null); // 퀴즈 뱅크에있는 것을 뱅크쪽으로 호출하는데 null값을 받음
//		outputLine : 퀴즈를 시작합니다.
		out.println(outputLine); // 다리를 타고 클라이언트로 내보내기 할 수 있음 - 클라이언트에서 받아줄 것(서버가 보내오는 데이터 읽어올것)을 또 만들어줌

		while ((inputLine = in.readLine()) != null) { // 클라이언트가 보내오는 데이터를 읽어서
			// inputLine : y or n - 클라이언트가 보낸 데이터
			// inputLine : 클라이언트가 보내온 정답

			outputLine = bank.process(inputLine);
//			outputLine : 0번방 문제
//			outputLine : 정답/오답

			out.println(outputLine);

			if (outputLine.equals("quit")) { // 언젠가 server가 quit을 보내면 빠져나와서 종료시킴
				break;

			} // while

		}

		in.close();
		out.close();

	}
}
