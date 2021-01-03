import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10_08_HashMap {

	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();

		dic.put("pencil", "연필");
		dic.put("sky", "하늘");
		dic.put("desk", "책상");
		dic.put("face", "얼굴");

		System.out.println(dic);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("찾는 단어는? (q입력 시 종료) ");
			String word = sc.next();

			if (word.equals("q"))
				break;

//			if(dic.get(word) == null) {
			if (dic.containsKey(word) == false) { // 위에 dic.put에 있는 값이 없을 경우 false
				System.out.println("잘못 입력했음");
			} else { // 입력값이 dic.put 값에 해당 하면 true
				System.out.println("뜻: " + dic.get(word));

			}

		} // while

		// 여기
		System.out.println("프로그램을 종료합니다");

	} // main

} // class
