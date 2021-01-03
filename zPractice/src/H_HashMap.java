import java.util.HashMap;
import java.util.Map.Entry;

public class H_HashMap {

	public static void main(String[] args) {
		// HashMap 선언
		HashMap<String, String> map1 = new HashMap<String, String>();// HashMap생성
		HashMap<String, String> map2 = new HashMap<>();// new에서 타입 파라미터 생략가능
		HashMap<String, String> map3 = new HashMap<>(map1);// map1의 모든 값을 가진 HashMap생성
		HashMap<String, String> map4 = new HashMap<>(10);// 초기 용량(capacity)지정
		HashMap<String, String> map5 = new HashMap<>(10, 0.7f);// 초기 capacity,load factor지정
		HashMap<String, String> map6 = new HashMap<String, String>() {
			{// 초기값 지정
				put("a", "b");
			}
		};

		// HashMap 값 추가 : put
		HashMap<Integer, String> map = new HashMap<>(); // 초기값 지정 // new에서 타입 파라미터 생략가능
		map.put(1, "사과"); // HashMap에 값을 추가하려면 put(key,value) 메소드를 사용
		map.put(2, "바나나");
		map.put(3, "포도");
		System.out.println(map); // 전체 출력 : {1=사과, 2=바나나, 3=포도}
		System.out.println(map.get(1)); // key값 1의 value얻기 : 사과
		System.out.println(map.values()); // values()->저장된 모든 값 출력 : [사과, 바나나, 포도]

		// entrySet() 활용
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
		}
		// [Key]:1 [Value]:사과
		// [Key]:2 [Value]:바나나
		// [Key]:3 [Value]:포도

		// KeySet() 활용
		for (Integer i : map.keySet()) { // 저장된 key값 확인
			System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
		}
		// [Key]:1 [Value]:사과
		// [Key]:2 [Value]:바나나
		// [Key]:3 [Value]:포도

		// HashMap 값 삭제
		map.remove(1); // key값 1 제거
		map.clear(); // 모든 값 제거

	} // main

} // class
