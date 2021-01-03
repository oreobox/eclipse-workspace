import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class P_Ex10_07_HashMap {

	public static void main(String[] args) {
		/*
		 * Map : 키(key), 값(value)의 쌍으로 저장 / 값 넣을 땐 변수.put으로 변수.add처럼 추가해줌 
		 * 키: 중복X - get자리에는 Key만 사용
		 * 값: 중복O
		 */
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		System.out.println(hm.size());
		
		hm.put("슬기", 20);
		hm.put("조이", 30);
		hm.put("웬디", 40); // key는 중복될 수 없음
		hm.put("아이유", 50);
		
		//for문 돌릴 필요없음
		System.out.println(hm);
		System.out.println(hm.get("조이"));
		System.out.println(hm.get("윤아"));
		
		if(hm.get("윤아") == null) {
			System.out.println("해당 키는 없음");
		}
		
		System.out.println(hm.get(30)); // get 자리에는 key만 사용
		
		System.out.println(hm.containsKey("조이"));
		System.out.println(hm.containsKey("윤아"));
		System.out.println(hm.containsValue(30));
		System.out.println(hm.containsValue(300));

		System.out.println();
		
		Set<String> ks = hm.keySet();
		System.out.println("ks:"+ks);
		
		Iterator<String> iter = ks.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name + ":" +hm.get(name));
		}
		
	}

}
