import java.util.Scanner;

public class Ex02_while {

	public static void main(String[] args) {

		int i = 1;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		System.out.println();

		i = 1;
		while (true) { // 조건이 무조건 참이기 때문에 무한루프
			System.out.println(i);
			i++;
			if (i == 10)
				break; // break는 가장 가까운 조건문을 빠져나감

		}
		System.out.println();
		// 입력한 수가 음수일 때까지 반복해서 입력하고, 이전 입력한 수의 합계를 더하고 끝냄
		Scanner sc = new Scanner(System.in); // System.in = 키보드입력한다는 의미
		int sum = 0;
		while (true) {
			System.out.print("수 입력: ");
			int num = sc.nextInt();
			if (num < 0)
				break;

			sum = sum + num; // sum += num; 도 가능 // 위치 어디에 오냐에 따라서 음수도 합계에 포함

		}
		System.out.println("sum = " + sum);

	}

}
