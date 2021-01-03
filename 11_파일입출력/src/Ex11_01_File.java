import java.io.File; // io 패키지 안에있음 (input,output)

public class Ex11_01_File {

	public static void main(String[] args) {

		File win = new File("c:\\windows"); // 뒤에 확장자 없으면 폴더로 취급, 있으면 파일로 취급
		System.out.println("win: " + win); // win : 참조변수 - 만 있으면 toString() 생략되어있음(자동들어감)

		/*
		 * 삼항 연산자 - 조건식?참:거짓
		 */
		String result = win.isDirectory() ? "폴더" : "파일";
		System.out.println(result);

		String[] lists = win.list();
		System.out.println(lists.length); // 배열의 방의 갯수

		for (int i = 0; i < lists.length; i++) {
			File win2 = new File(win, lists[i]); // c:\\windows(win), 밑에 있는 폴더라는 뜻 (lists) / 순서중요
			if (win2.isFile()) {
				System.out.println("파일: " + lists[i]);

			}else {
				System.out.println("폴더: " + lists[i]);
			}

		} // for문
	} // main

} // class