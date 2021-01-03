import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex11_09_wordcount_Review {

	public static void main(String[] args) throws IOException { // IOExceptio이 FileNotFoundException의 부모이기 때문에
																// FileNotFoundException 생략가능

		// 예외처리 FileNotFoundException
		BufferedReader br = new BufferedReader(new FileReader("lyrics.txt")); // 파일 읽기위해 연결다리 형성

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String line;
		int count;

		while (true) {
			if ((line = br.readLine()) != null) { // 파일 한줄 읽어오기 위해 // 파일끝까지 읽기 위해
//				System.out.println(line); // line 변수
				// line : When I find myself
				String[] tokens = line.split(" "); // 우선 첫번째 줄 가지고 공백을 기준으로 쪼갠것들 = tokens 4개
//				tokens[0]:When
//				tokens[1]:I

				for (int i = 0; i < tokens.length; i++) {
					if (hm.containsKey(tokens[i])) { // key중에 tokens가 포함되어있나 확인
//						count = hm.get(tokens[i]); // 0번방에 있는 i의 값(갯수) 카운팅 = tokens 방 별로 해당 단어 몇개있는지 확인
//						hm.put(tokens[i], count + 1); //값이 있으면 1개씩 추가 
						// ↑ 위에 주석 단 두줄을 ↓ 밑에 한줄로 변경 가능
						hm.put(tokens[i], hm.get(tokens[i] + 1)); // 값이 있으면 1개씩 추가

					} else {
						hm.put(tokens[i], 1);
					}

					hm.put(tokens[i], 1); // 단어 별로 몇개씩 사용됬는지 입력하는것

				} // for

			} // if
			else {
				break; // null 만나면 while 문을 빠져나가라

			}

		} // while
		System.out.println(hm); // {} 중괄호로 묶여서 값들이 가로로 나열됨

		// 반복문 사용해서 가로로 나열되는 것들이 직렬로 나오게 표시하는 방법
		Set<String> keys = hm.keySet(); // key들의 모음은 set타입으로 들어가야함
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) { // iter에 데이터가 있는지 확인
			String key = iter.next();
			System.out.println(key + ":" + hm.get(key));
		}

	} // main

} // class

//lyrics.txt.파일에서 데이터를 읽어서
//단어별 빈도수 출력

// 1. 파일에서 읽어오기 위해서 파일과의 연결다리 형성
// 2. 우선 한줄 읽기 , 한줄읽기를 반복해야함 (for, while - 가사가 몇줄일 지 모르니까 while문이 더 적합)
// 3. 공백기준 잘나내기  -> 단어별 구분
// 4. 단어와 빈도수를 쌍으로 처리 -> HashMap (key-단어/중복안됨,value-빈도수)
// 5. HashMap에 있는 단어는 기존 단어의 value를 1로 설정
//	  HashMap에 있는 단어는 기존 단어의 value+1로 설정

//sound:1
//Shine:1
//hearted:1
//yeah:3
//when:2
//She:1
//that:2
//wake:1
//music:1
//There:4
//find:1
//me:4
//let:25
//up:1
//darkness:1
//they:2
//still:2
//in:4
//myself:1
//night:1
//For:1
//tomorrow:1
//is:4
//it:36
//agree:1
//my:1
//an:4
//light:1
//And:3
//shines:1
//be:41
//Ah:1
//comes:2
//I:2
//wisdom:7
//Whisper:4
//times:1
//see:1
//world:1
//Mother:2
//hour:1
//of:11
//trouble:1
//Mary:2
//on:2
//broken:1
//a:2
//chance:1
//though:1
//may:1
//will:5
//Living:1
//words:7
//right:1
//people:1
//Speaking:3
//the:4
//standing:1
//cloudy:1
//When:1
//answer:4
//there:2
//parted:1
//Oh:1
//Let:11
//Yeah:1
//until:1
//to:3
//front:1
