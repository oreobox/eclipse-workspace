import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex10_07_HashMap {
	public static void main(String[] args) {

		/*
		 * Map : 키(key), 값(value)의 쌍으로 저장 / 값 넣을 땐 변수.put으로 변수.add처럼 추가해줌 
		 * 키: 중복X - get자리에는 Key만 사용
		 * 값: 중복O
		 */
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		System.out.println(hm.size()); // 요소 갯수 출력 = 아직은 요소들이 없어서 0값 출력됨

		hm.put("슬기", 20);
		hm.put("조이", 30);
		hm.put("웬디", 40); // Key는 중복될 수 없음
		hm.put("아이유", 30);

		// for문 돌릴 필요 없음
		System.out.println(hm); // 중괄호로 표시함 {Key=Value, Key=Value, Key=Value, Key=Value}
		System.out.println(hm.get("조이"));
		System.out.println(hm.get("윤아")); // 값이 없기 때문에 null

		if (hm.get("윤아") == null) {
			System.out.println("해당 키는 없음");
		} // if문
		System.out.println();
		System.out.println(hm.get(30)); // get 자리에는 Key만 사용

		System.out.println(hm.containsKey("조이")); // 포함되어 있으면 true
		System.out.println(hm.containsKey("윤아")); // 포함안되어 있으면 false
		System.out.println();

		System.out.println(hm.containsValue(30)); // 포함되어 있으면 true
		System.out.println(hm.containsValue(300));// 포함안되어 있으면 false

		System.out.println();

		Set<String> ks = hm.keySet();
		System.out.println("ks: " + ks); // Key 값 4가지 불러옴

		Iterator<String> iter = ks.iterator();
		while (iter.hasNext()) {
//			System.out.println(iter.next()+":");
			String name = iter.next();
			System.out.println(name + ":" + hm.get(name));
		} // while문
		System.out.println();
		
		hm.remove("슬기"); // 슬기 뺴기
		System.out.println(hm);

	} // main

} // class
