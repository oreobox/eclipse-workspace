//import java.io.*; // 전체 묶음으로 import
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_05_Buffer {

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("data.txt"); // 1차스트림 // 연결다리 이름 fos
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // 2차스트림 // 임시 기억장소 이름 : bos
											// (bos, 5): Buffer 사이즈 5개가 채워질때까지 저장해뒀다가 5개가 채워지면 한꺼번에 연결다리 넘어가 출력값 끌고옴
											// Buffer 사이즈 미 지정시  8192개(byte) 기본설정됨
			// 2차 스트림에는 파일이름 직접 입력 불가 - Buffer에다가 fos변수를 사용 대신 "date.txt" 직접 입력해주면 안됨

			for (int i = 1; i <= 9; i++) {
//				bos.write(i); // bos.write(i)라고 쓰는 이유 : Buffer를 이용해서 fos를 사용하다는 뜻 - fos.으로 사용하면 bos. 내용 사용x
				bos.write(i+48); // 아스키코드 값으로 생각함
				//'1' : 49, '2':50
			}
			bos.flush(); // Buffer에 남아있는 값 다 내보내게 하는 기능

			FileInputStream fis = new FileInputStream("data.txt"); // 1차스트림 // 연결다리 이름 fos
			BufferedInputStream bis = new BufferedInputStream(fis, 5); // 2차스트림

			int i;
			while ((i = bis.read()) != -1) {
				System.out.print((char) i + " "); 
			}

			bos.close(); // 5개까지만 콘솔에 출력하라고 했기때문에 콘솔에는 5개 값만 보임
							// 콘솔에 5개 출력하고 close로 사용 중지 해줬는데,
							// data.txt에는 9까지 돌았지만 남은 4개(6,7,8,9)가있기 때문에 Buffer에있는 값 data.txt에는 밀어냄
			bis.close();

		} catch (FileNotFoundException e) { // 자식 - 생략가능
			e.printStackTrace();

		} catch (IOException e) { // 부모
			e.printStackTrace();
		}

	}

}
