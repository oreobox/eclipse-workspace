

public class P_Ex01_for {

	// 1~10 출력 // 1~10까지 합계 구하기

	public static void main(String[] args) {
		int i, j, sum = 0;
		for (i = 1; i <= 10; i++) {
			System.out.println(i);
			sum = sum + i;

		}

		System.out.println("sum: " + sum);
		System.out.println();

		// 1~100까지의 수 중에서 5의 배수이면서 7의 배수인 수 출력

		for (i = 1; i <= 100; i++) {
			if (i % 5 == 0 && i % 7 == 0) {
				System.out.println(i);

			}
		}
		System.out.println();

		// 이중포문으로 배열식 나타내기

		for (i = 1; i <= 2; i++) {
			for (j = 1; j <= 3; j++) {
				System.out.println(i + " " + j);

			}
		}

		System.out.println();

		// 1~10 출력
		for (i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 1~10 출력 - break 사용
		for (i = 1; i <= 4; i++) {
			if (i > 5) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();

		// 1~10 출력 - continue 사용
		for (i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();

		// 구구단 출력
		for (i = 2; i <= 9; i++) {
			System.out.println("---------------");
			System.out.println("***" + i + "단***");
			for (j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
		}
		System.out.println();

//		// 구구단 짝수만 나오게 하면서 2단이면 2까까지 곱한값, 4단이면 4단까지 곱한값 이런식으로 출력
//		for (i = 2; i <= 9; i += 2) {
//			System.out.println("---------------");
//			System.out.println("***" + i + "단***");
//			for (j = 1; j < i; j++) {
//				if (j % 2 == 1) {
//
//				}
//				System.out.println(i + "*" + j + "=" + i * j);
//			}
//		}
//
//		System.out.println();

		// 구구단 - break;, continue;
		for (i = 2; i <= 9; i++) {
			if (i % 2 == 1) {
				continue;
			}

			System.out.println("---------------");
			System.out.println("***" + i + "단***");
			for (j = 1; j <= 9; j++) {
				if (i < j) {
					break;
				}
				System.out.println(i + "*" + j + "=" + i * j);
			}
		}

	} // main

} // class
