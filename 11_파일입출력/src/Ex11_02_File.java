import java.io.File;
import java.io.IOException;

public class Ex11_02_File {
	public static void main(String[] args) {

		// 기본위치 : C:\ca_java_2011\11_파일입출력
		File f1 = new File("A"); // 확장자가 없음 - 폴더가 됨
		File f2 = new File("B"); // 확장자가 없음 - 폴더가 됨
		File f3 = new File("C"); // 확장자가 없음 - 폴더가 됨
		File f4 = new File(f1, "ab.txt"); // "A"또는 f1,"ab.txt" : aA\\ab/txt A폴더 밑에 파일 만들기

		if (f1.exists()) {
			System.out.println("이미 존재함");
			f1.renameTo(f2); // f1이름을 f2이름으로 바꿔라

		} else {
			f1.mkdir(); // 폴더 만듬 make
			System.out.println("폴더 생성함");

			try { // 예외처리
				f4.createNewFile();
				System.out.println("파일 생성함");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // else

		if (f3.exists()) {
			f3.delete();
		} // if문

	} // main
} // class
