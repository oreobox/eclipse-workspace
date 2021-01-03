
public class Ex10_String {

	public static void main(String[] args) {
//		Object
//			:
		String s1 = "Hello";
		String s2 = new String("Hello");

		boolean result1 = s1.equals(s2); // equals는  대소문자 구분 o
		System.out.println("result1: " + result1);

		System.out.println(s1 == s2);

		boolean result2 = s1.equalsIgnoreCase(s2); // equalsIgnoreCase 은 대소문자 구분 x
		System.out.println("result2: " + result2);
		System.out.println();

		int len = s1.length(); // 문자열 길이 - Hello 문자 5개
		System.out.println("len: " + len);
		System.out.println();

		System.out.println(s1.toString()); // s1에 넣어놓은 문자열 출력
		// 부모인 Object가 물려주지만 그게 싫어서 문자열을 리턴하는 기능으로 자기가 새로 만듬 - 오버라이딩
		System.out.println();
		
		//----------------------------------------------------------------------------------
		//20.12.03
		
		String s3 = "apple,banana/orange,melon#pear";
		String[] s=s3.split(","); // ,라는 문자 기준으로 쪼개기
		System.out.println(s.length); // 쪼개진 갯수 출력
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}

	}

}
