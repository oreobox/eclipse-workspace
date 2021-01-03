import java.util.Scanner;

public class Ex03_배열 {

	public static void main(String[] args) {
		int a = 1, b = 2, c = 3, d = 4, e = 5;

		int[] arr1 = { 1, 2, 3, 4, 5 }; // 배열은 연속된 공간에 위치함. 연달아서 한 정수당 4byte씩 건너띄고 배치됨
		int[] arr2 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr3 = new int[5];
		arr3[0] = 10; // index는 0부터 카운팅
		arr3[3] = 40; // arr3 3번방에 40을 입력한다
		//		arr3[5]=0;  //5번째 배열이 없기 때문에 오류남

		System.out.println(arr1); // [I@15db9742 → 배열의 주소(위치) = 경비실과 같음 배열들을 관리
		System.out.println(arr1[0]); // 1
		//		System.out.println(arr1[5]);	// 5번째 배열이 없기 때문에 오류남

		System.out.println(arr1.length); // arr1의 길이 = 5개
		System.out.println();
		int i;
		for (i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		for (i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}

		// 확장for문
		for (int temp : arr1) {
			System.out.println(temp);

		}
		System.out.println();

		// 2차원 배열
		int[][] arr4 = { { 1, 2, 3 }, // 00 01 02
				{ 4, 5 }, // 10 11
				{ 6, 7, 8, 9 }, // 20 21 22 23
				{ 10, 11, 12, 13, 14 }, // 30 31 32 33 34

		};
		System.out.println(arr4[0][0]);
		System.out.println(arr4[1][1]);
		//		System.out.println(arr4); // 경비실에서 관리 - 방 14개의 첫뻔째 방(1)의 주소 / arr4대표 관리자
		System.out.println(arr4.length); // 행 4개
		System.out.println(arr4[0].length); // 열 3개
		System.out.println(arr4[1].length); // 열 2개
		System.out.println(arr4[2].length); // 열4개
		System.out.println(arr4[3].length); // 열 5개
		System.out.println();

		int j;
		for (i = 0; i < arr4.length; i++) { // 행은 4개임 - 4개라 4로 써도되지만 arr4.length 길이로 입력해도됨
			for (j = 0; j < arr4[i].length; j++) { // 열은 방마다 배열 갯수가 다르기 때문에 3이라고 쓰면안됨.
				System.out.print(arr4[i][j] + " ");

			}
			System.out.println(); // 하나의 열이 끝나면 엔터 치기
		}

		// 확장 for문으로 2차원 배열 - 모든 방에 접근할 수 밖에 없음

		for (int[] temp : arr4) {
			for (int x : temp) {
				System.out.print(x + " ");

			}
			System.out.println();
		}

		int[][] arr = new int [2][3];
		Scanner sc = new Scanner (System.in);

		for(i = 0; i< arr.length; i++) { // for(i=0; i<2; i++) 으로 써도됨
			for(j = 0; j<arr[i].length; j++) {
				System.out.print("수 입력: ");
			arr[i][j] = sc.nextInt();		

			}
		}

		for(i = 0; i< arr.length; i++) { // for(i=0; i<2; i++) 으로 써도됨
			for(j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}

			System.out.println();

		}
	}
}
