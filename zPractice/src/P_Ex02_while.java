import java.util.Scanner;

public class P_Ex02_while {

	public static void main(String[] args) {

		int i = 1;
		while (i < 10) {
			System.out.println(i);
			i++;

		} // while문

		System.out.println();

		i = 1;
		while (true) {
			System.out.println(i);
			i++;
			if (i == 10)
				break;

		} // while문
		System.out.println();

		Scanner sc = new Scanner(System.in);

		int sum = 0;
		while (true) {
			System.out.print("수 입력: ");
			int num = sc.nextInt();
			if (num < 0) 
				break;

			sum = num + sum; // 위치 중요 

			}
		System.out.println("sum : " + sum);


	} // main

} // class
