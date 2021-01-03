
public class QuizBank {

	// 문제
	String[] problems = { "네트워크 처리 패키지는?", "서버쪽 소켓 클래스 이름은?", "인터넷에서 컴퓨터를 식별하는 주소는?" };

	String[] answers = { "java.net", "서버소켓", "IP주소" }; // 클라이언트가 띄어쓰기까지 맞아야 정답

	// 현재 상태 표현

	private final int WAITING = 0; // 서버가 문제가 보내기를 기다리는 처음 상태
	private final int PROBLEM = 1; //
	private final int ANSWER = 2; // 답을 맞춰야 하는 상태
	private final int NUMPROBLEMS = 3; // 전체 문제

	private int state = WAITING; // 현재 상태를 어떻게 나타내야 할지 숫자로 나타냄
	private int current = 0; // 현재 0

	public String process(String theInput) { // 문자열을 리턴하는 process를 만듬
		// 클라이언트가 보내오는 데이터가(y or n) theInput으로 들어옴
		// theInput : y or n

		String theOutput = null;

		if (state == WAITING) { // 처음엔 WAITING 상태
			theOutput = "퀴즈를 시작합니다.(y/n)";
			state = PROBLEM; // y를 적으면 state가 PROBLEM로 바껴서 else if로 갈수있게됨

		} else if (state == PROBLEM) {
			// 문제를 보내는 작업
			if(theInput.equals("y")) {
				theOutput = problems[current]; // 0번째 문제를 theOutput을 넣어놓음
				state = ANSWER; // 다음번에는 answer상태로 가야한다고 미리 입력해둠
				
			}
			else {// "n"
				theOutput = "quit"; // 서버쪽으로 quit이 넘어가고 그게 클라이언트가 받으면 프로그램 종료되도록
			}

		} else if (state == ANSWER) {
			// 클라이언트가 보내온 답과 정답을 비교하는 작업
			if (theInput.equals(answers[current])) {
				theOutput = "정답입니다. 계속 하시겠습니까?(y/n)";
			} else { // 오답
				theOutput = "오답입니다. 계속 하시겠습니까?(y/n)";
			}
			
			state = PROBLEM;
			current = (current + 1) % NUMPROBLEMS; // 

		}

		return theOutput; // 클라이언트 쪽으로 보내는 작업
		
	} // process

} // class
