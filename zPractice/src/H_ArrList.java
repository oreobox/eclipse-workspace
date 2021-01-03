import java.util.*;

public class H_ArrList {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		// add() 메소드를 이용한 요소의 저장
		arrList.add(40);
		arrList.add(20);
		arrList.add(30);
		arrList.add(10);

		// for문과 get() 메소드를 이용한 요소의 출력
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		} // for

		System.out.println("------------------");
		// remove() 메소드를 이용한 요소의 제거
		arrList.remove(1);
		System.out.println(arrList);

		// 향상된 for 문과 get() 메소드를 이용한 요소의 출력
		System.out.println("------------------");
		for (int e : arrList) {
			System.out.println(e + " ");
		} // for

		// Collections.sort() 메소드를 이용한 요소의 정렬 - 오름차순 정렬
		System.out.println("------------------");
		Collections.sort(arrList);
		System.out.println(arrList);

		// iterator() 메소드와 get() 메소드를 이용한 요소의 출력
		System.out.println("------------------");
		Iterator<Integer> iter = arrList.iterator(); // iter의 요소들을 하나씩 가져오고 싶을 때
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		} // while

		// set() 메소드를 이용한 요소의 변경
		System.out.println();
		System.out.println("------------------");
		arrList.set(0, 20); // 0번째를 20으로 바꾸기

		for (int e : arrList) { // 향상된 for문으로 출력
			System.out.println(e + " ");
		}

		// size() 메소드를 이용한 요소의 총 개수
		System.out.println("------------------");
		System.out.println("리스트의 크기: " + arrList.size());

	} // main

} // class