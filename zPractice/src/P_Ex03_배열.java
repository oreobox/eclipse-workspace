import java.util.Scanner;

public class P_Ex03_배열 {

	public static void main(String[] args) {
		int a = 1, b = 2, c = 3, d = 4, e = 5;

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr3 = new int[5];
		arr3[0] = 10;
		arr3[3] = 40;

		System.out.println(arr1);
		System.out.println(arr2[3]); // 4

		System.out.println(arr1.length); // arr1의 배열 길이

		System.out.println();

		int i;
		for (i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		for (i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		System.out.println();
		// 확장 for문

		for (int temp : arr1) {
			System.out.println(temp);
		}
		System.out.println();

		// 2차원 ㅐ열
		int[][] arr4 = { { 1, 2, 3 }, { 4, 5, }, { 6, 7, 8, 9 }, { 10, 11, 12, 13, 14 } };
		System.out.println(arr4[0][0]); // 1
		System.out.println(arr4[1][0]); // 4
		System.out.println(arr4[3][4]); // 14
		System.out.println(arr4.length);
		System.out.println(arr4[0].length); // 0번쨰 열 개수 = 3
		System.out.println(arr4[1].length); // 1번쨰 열 개수 = 2
		System.out.println(arr4[2].length); // 2번쨰 열 개수 = 4
		System.out.println(arr4[3].length); // 3번쨰 열 개수 = 5
		System.out.println();

		int j = 0;
		for (i = 0; i < arr4.length; i++) {
			for (j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println(); // 하나의 열 끝나면 엔터치기
		}
		System.out.println();
		// 확장 for 문으로 배열 만들기

		for (int[] arr : arr4) {
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println();

		int[][] array = new int[2][3];
		Scanner sc = new Scanner(System.in);

		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[i].length; j++) {
				System.out.print("수 입력: ");
				array[i][j] = sc.nextInt();

			}
		}

		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	} // main

} // class
