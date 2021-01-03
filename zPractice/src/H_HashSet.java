import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class H_HashSet {

	public static void main(String[] args) {
		// HashSet 선언
		HashSet<Integer> set1 = new HashSet<Integer>();//HashSet생성
		HashSet<Integer> set2 = new HashSet<>();//new에서 타입 파라미터 생략가능
		HashSet<Integer> set3 = new HashSet<Integer>(set1);//set1의 모든 값을 가진 HashSet생성
		HashSet<Integer> set4 = new HashSet<Integer>(10);//초기 용량(capacity)지정
		HashSet<Integer> set5 = new HashSet<Integer>(10, 0.7f);//초기 capacity,load factor지정
		HashSet<Integer> set6 = new HashSet<Integer>(Arrays.asList(1,2,3));//초기값 지정
		
		// HashSet 값 추가 : add
		HashSet<Integer> setAdd = new HashSet<Integer>();//HashSet생성
		setAdd.add(1); //값 추가
		setAdd.add(2);
		setAdd.add(3);
		System.out.println(setAdd); // [1, 2, 3]
		
		// HashSet 값 삭제
		HashSet<Integer> setRemove = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
		setRemove.remove(1); // 값 1 제거
		setRemove.clear();//모든 값 제거
		System.out.println(setRemove); // []
		
		// HashSet 크기 구하기 : size()
		HashSet<Integer> setSize = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
		System.out.println(setSize.size()); // set 크기 : 3
		
		// HashSet 값 출력 : <Integer>
		HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성

		System.out.println(set); //전체출력 [1,2,3]
				
		Iterator iter = set.iterator();	// Iterator 사용
		while(iter.hasNext()) {//값이 있으면 true 없으면 false
		    System.out.println(iter.next());
		}
		
		/*
		 * Set컬렉션을 그냥 print하게 되면 대괄호 [ ]로 묶여서 set의 전체 값이 출력됩니다.
		 * Set에는 인덱스로 객체를 가져오는 get(index) 메소드가 없습니다.
		 * 대신 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자(Iterator)를 제공합니다.
		 * 반복자 이터레이터 인터페이스를 구현한 객체를 말하는데 iterator() 메소드를 호출하면 얻을 수 있습니다.
		 * Iterator에서 하나의 객체를 가져올 때는 next() 메소드를 사용합니다.
		 * next() 메소드를 사용하기 전에 먼저 가져올 객체가 있는지 확인하는 것이 좋습니다.
		 * hasNext() 메소드는 가져올 객체가 있으면 true를 리턴하고 없으면 false를 리턴합니다.
		 */
		
		// HashSet 값 검색 : contains
		HashSet<Integer> setSearch = new HashSet<Integer>(Arrays.asList(1,2,3));//HashSet생성
		System.out.println(set.contains(1)); //set내부에 값 1이 있는지 check : true
		

	} // main

} // class
