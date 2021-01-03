public class Ex01_for {

	public static void main(String[] args) {
		// 1~ 10 출력 // 합계구하기

		int i, sum = 0;
		for (i = 1; i < 11; i++) {
			System.out.println(i);
			sum = sum + i;

		}
		System.out.println("sum: " + sum);

		// 1~100까지의 수 중에서 5의 배수이면서 7의 배수인 수 출력

		for (i = 1; i < 101; i++) {
			if (i % 5 == 0 && i % 7 == 0) { // 동시에 만족하는 &&
				System.out.println(i);

			}
		}
		int k = 0;
		for (i = 1; i < 3; i++) { // i<=2;
			for (k = 1; k < 4; k++) { // i<=3;
				System.out.println(i + " " + k);

			}

		}
		System.out.println();

		for (i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}

		System.out.println();
		// 1~10까지 출력

		for (i = 1; i <= 10; i++) {
			if (i == 5) {
				break; // 반복문 빠져나감
			}
			System.out.print(i + " "); // 반복문 빠져나간 후 실행이기 때문에 4까지만 출력됨
		}
		System.out.println();

		for (i = 1; i <= 10; i++) {
			if (i == 5) { // 5일 경우, ↓
				continue; // 밑에있는 문장 실행하지말고, 증감식으로 올라가 continue 하라는 뜻
			}
			System.out.print(i + " ");
		}

		System.out.println();

		for (i = 2; i <= 9; i++) {
			System.out.println("---------------");
			System.out.println("***" + i + "단***");
			for (k = 1; k <= 9; k++) {
				System.out.println(i + "*" + k + "=" + i * k);

			}
		}
		System.out.println();
		System.out.println();
		for (i = 2; i <= 9; i++) {
			if (i % 2 == 1) { // 홀수면 false
				continue;
//				break; // break 쓰면 2단까지밖에 안나옴
			}

			System.out.println("***" + i + "단***");
			for (k = 1; k <= 9; k++) {
				if (i < k) { // i가 k보다 크면 밑의 실행문 출력되지 않도록
					continue; // ↓ 아래의 실행문 출력되지 않도록
				}
				System.out.println(i + "*" + k + "=" + i * k);
			}
			System.out.println("---------------");
			System.out.println();
			System.out.println();
			System.out.println();
			// 지혜쓰

			for (i = 2; i <= 9; i++) {
				if (i % 2 == 0) {
					System.out.println("***" + i + "단***");
					for (int j = 1; j <= i; j++) {
						System.out.println(i + "*" + j + "=" + (j * i));
						continue;
					}
					System.out.println("-----------------");

				}

			}

		}
	}
}
