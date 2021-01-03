//import java.io.*; // 전체 묶음으로 import
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_05_Buffer_오류 {

	// Buffer : 임시 기억 장소
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("date.txt"); // 1차 스트림 // 연결다리 이름 fos
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // 2차 스트림 // 임시 기억장소 이름 : bos
													// (bos, 5): Buffer 사이즈 5개가 채워지면 한꺼번에 연결다리 넘어가 출력값 끌고옴
													// Buffer 사이즈 내가 지정 안하면 8192개 기본설정됨
			// 2차 스트림에는 파일이름 직접 입력 불가 - Buffer에다가 fos변수를 사용 대신 "date.txt" 직접 입력해주면 안됨

			for (int i = 1; i <= 9; i++) {
				bos.write(i); // bos.write(i)라고 쓰는 이유 : Buffer를 이용해서 fos를 사용하다는 뜻 - fos.으로 사용하면 bos. 내용 사용x
				bos.write(i+48); // 아스키코드 값으로 생각함
				//'1' : 49, '2':50
			}
			FileInputStream fis = new FileInputStream("data.txt"); // 1차 스트림 //연결다리 이름 fos
			BufferedInputStream bis = new BufferedInputStream(fis, 5);

			int i;
			while ((i = bis.read()) != -1) {
				System.out.print(i + " ");
			}

			bos.close();
			bis.close();

		} catch (FileNotFoundException e) { // 자식 - 생략가능
			e.printStackTrace();

		} catch (IOException e) { // 부모
			e.printStackTrace();
		}

	}

}
