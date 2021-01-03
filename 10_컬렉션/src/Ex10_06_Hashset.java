//import java.util.HashSet;
//import java.util.Set; // Set import
//
//public class Ex10_06_Hashset {
//
//	public static void main(String[] args) {
//
//		Set<String> hs = new HashSet<String>();  Set 부모 ,  HashSet 자식으로 써도됨
//
//	}
//
//}

import java.util.HashSet;
import java.util.Iterator;

public class Ex10_06_Hashset {
	public static void main(String[] args) {
		/*
		 * List : 순서가 있다. 중복허용 한다.
		 * Set : 순서가 없다. 중복허용 안한다.
		 */

		HashSet<String> hs = new HashSet<String>(); // hs는 HashSet의 메소드의 변수
		System.out.println(hs.size());
		System.out.println(hs);
		System.out.println();

		hs.add("aa");
		hs.add("bb");
		hs.add("cc");
		hs.add("aa");
		hs.add("dd");

		System.out.println(hs.size());
		System.out.println(hs); // [aa, bb, cc, dd]

		System.out.println();

		//		System.out.println(hs.get(1)); // 오류

		// hs가 가지고 있는 4가지(n가지) 정보를 하나씩 가져오고 싶을 때 Iterator를 사용
		Iterator<String> iter = hs.iterator(); // HashSet이 가지고 있는 메소드 // 변수의 자료형이 Class 타입
		while (iter.hasNext()) { // aa,bb,cc,dd 중 하나라도 있으면 true가 됨 , 접근할 수 있는 데이터 없으면 false가 되서 빠져나옴
			System.out.println(iter.next());
		} // while
		System.out.println();

		System.out.println(hs.contains("bb")); // .contains : 포함되어있는지 확인하는 함수
		System.out.println(hs.contains("xy"));
		System.out.println();

		//		1~10 사이에서 정수 난수 발생
		//		System.out.println(Math.random()); // 실수 변수 발생

		HashSet<Integer> hs2 = new HashSet<Integer>();
		int i = 0;
		while (true) {
			i++;
			int num = (int) (Math.random() * 10) + 1;
			hs2.add(num);
			//			System.out.println(num);
			if (hs2.size() == 6) // 6개의 랜덤 수 출력
				break;
		} // while
		System.out.println("i:"+i); // 랜덤수 몇개인지 출력
		System.out.println(hs2); // 6개의 랜덤 수 출력

	} // main

} // class
