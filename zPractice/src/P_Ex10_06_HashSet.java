import java.util.HashSet;
import java.util.Iterator;

public class P_Ex10_06_HashSet {

	public static void main(String[] args) {
		/*
		 * List : 순서가 있다. 중복허용한다.
		 * 
		 * Set : 순서가 없다. 중복허용 안한다.
		 */

		HashSet<String> hs = new HashSet<String>();
		System.out.println(hs.size());

		hs.add("aa");
		hs.add("bb");
		hs.add("cc");
		hs.add("aa");
		hs.add("dd");

		System.out.println(hs.size()); // set은 중복 허용 안하기 때문에 갯수 4개 출력
		System.out.println(hs); // 리스트 나열

//		System.out.println(hs.get(1)); // 순서가 없기 떄문에 index 사용불가

		// hs가 가지고 있는 4가지(n가지) 정보를 하나씩 가져오고 싶을 때 Iterator를 사용
		Iterator<String> iter = hs.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		} // while

		System.out.println(hs.contains("bb")); // .contains()는 Object 받음 ture/false
		System.out.println(hs.contains("xy")); // add요소에 xy값 없음

		System.out.println();

		// 1~10정수 난수 발생

//		System.out.println(Math.random());
//		System.out.println();

		HashSet<Integer> hs2 = new HashSet<Integer>();
		int i=0;
		while(true) {
			i++;
			int num = (int)(Math.random()*10) + 1;
			hs2.add(num);
			//System.out.println(num);
			if(hs2.size()==6)
				break;
		}
		System.out.println("i:"+i);
		System.out.println(hs2);

	} // main

} // class
