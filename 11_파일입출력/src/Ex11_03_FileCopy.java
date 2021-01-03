// FileInputStream&FileOutputStream 스트림 사용해 데이터 입출력하기

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_03_FileCopy {

	public static void main(String[] args) {

		try { // 예외 발생할 수 있기 때문에 try,catch로 처리해줌
			FileInputStream fis = new FileInputStream("from.txt"); // 스트림 형성 = 읽어오는 용도의 클래스(연결다리) : FileInputStream - 내가만듬
			// new FileNotFoundException() - 예외 발생 객체가 자동으로 만들어짐

			FileOutputStream fos = new FileOutputStream("to.txt"); // 스트림 형성 = 쓰기위한 용도의 클래스(연결다리) : FileOutputStream - 자동으로 만들어줌
			// c:\\abc\\"to.txt" 라고 경로를 입력하지않으면 FileNotFoundException 예외 발생함

			// 연결다리 이름 : 스트림
			// to.txt,false 또는 default(아무것도넣지않음) : 파일이 없으면 생성, 덮어쓰기 형태의 파일 출력 스트림 생성
			// to.txt,ture : 파일이 없으면 생성, 있으면
			// from.txt에서 EOF (=EndOfFile) 파일의 상태

			int i;
			while (true) {
				i = fis.read(); // 읽기만 가능 - read메소드는 문자여도 int로 받을 수 있음
				System.out.println(i); // 콘솔에 출력하기 위해 넣음
				System.out.println((char)i); // 문자로 바꿔 출력하라는 뜻
				//from.txt창에 Hello~ 입력 시 콘솔에 Hello~의 아스키 코드 나타내짐
				// FileOutputStream는 1byte 스트림. 한국이나 다른 외국어 나타내고 싶을 때는 문자 스트림으로 사용해야함
				if (i == -1)
					break;
				else {
					fos.write(i);
				}
			} // while

			fis.close(); // 더이상 읽어드릴것, 쓸것도 없을 경우 연결다리 끊어냄
			fos.close();
			
			// FileNotFoundException e = new // new FileNotFoundException()
		} catch (FileNotFoundException e) { // e는  ↑ 위의 객체 받아옴
			e.printStackTrace(); // 경로를 출력하는 메소드 - 에러가 없기 때문에 발생하지 않음 / syso 쓰지 않아도 자동 출력기능있음
			// 굳이 사용 안해도됨??????

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // main

} // class

