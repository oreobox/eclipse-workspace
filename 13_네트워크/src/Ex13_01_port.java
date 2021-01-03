import java.io.IOException;
import java.net.ServerSocket;

public class Ex13_01_port {
	public static void main(String[] args) {

		ServerSocket ss = null;

		for (int i = 0; i < 65535; i++) {
//			ss = new ServerSocket(i); // try/catch로 예외처리해줌
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (IOException e) {
				System.out.println(i + "번 포트는 이미 사용중입니다.");

			}
		}

	} // main

} // class
