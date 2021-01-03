import java.util.ArrayList;

public class Ex10_02_ArrayList {

	public static void main(String[] args) {
//		Object // Object를 상속받음
//			:

		ArrayList<String> list = new ArrayList<String>(); // <String> 추가하면 경고 오류 뜨지 않음
		int size = list.size();
		System.out.println("size:" + size); // 아직 list 값 없기 때문에 갯수 0 나타냄

		list.add("태연");
		list.add("수영");
		list.add("윤아");
		list.add("수영");
		list.add("써니");

		size = list.size();
		System.out.println("size: " + size); // list 갯수 5개
		System.out.println("list: " + list.toString()); // list 안의 문자열 나타냄
		System.out.println("list: " + list); // list 객체는 ArrayList<String> 받아줌

		String get1 = list.get(1); // 첫번째 위치 가지고옴 (=index 0)
		System.out.println("get1:" + get1);

		list.add(1, "유리"); // 유리가 1번 자리에 가고 다른 것들은 하나씩 밀려남
		System.out.println("list: " + list);

		list.remove(1); // 위에서 1번 자리에 삽입했던 '유리'가 삭제됨
		System.out.println("list: " + list);

		list.remove("윤아"); // Object (index, String) 아무거나 넣어도됨
		System.out.println("list: " + list);

		int pos1 = list.indexOf("수영"); // 어디있는지 위치 찾기
		System.out.println("pos1: " + pos1);

		System.out.println(list.indexOf("효리")); // 해당 값이 없으면 -1이 나옴

		System.out.println(list.contains("수영")); // 해당 값이 있으면 true, 없으면 false

		list.set(1, "티파니"); // 1번위치의 수영이 티파니로 변경 - 덮어쓰기
		System.out.println("list: " + list);

	}

}
