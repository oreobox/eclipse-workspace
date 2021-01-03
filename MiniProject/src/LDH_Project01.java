import java.util.Scanner;

public class LDH_Project01 {

	public static class Musical { // Musical 정보를 불러오기 위해 Getter&Setter 사용
		private String musicalName;
		private String address;
		private String time;
		private String price;
		private String casting;

		public String getMusicalName() {
			return musicalName;
		}

		public void setMusicalName(String musicalName) {
			this.musicalName = musicalName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getCasting() {
			return casting;
		}

		public void setCasting(String casting) {
			this.casting = casting;
		}

	}

	public static void main(String[] args) {
		Musical[] musicalList = new Musical[3];
		musicalList[0] = new Musical();
		musicalList[0].setMusicalName("<맨 오브 라만차>");
		musicalList[0].setAddress("샤롯데씨어터");
		musicalList[0].setTime("2020/12/19 | 19:00");
		musicalList[0].setPrice("1인 120000원");
		musicalList[0].setCasting("조승우/최수진/이훈진/김대종 등");

		musicalList[1] = new Musical();
		musicalList[1].setMusicalName("<지킬 앤 하이드>");
		musicalList[1].setAddress("LG아트센터");
		musicalList[1].setTime("2020/12/27 | 15:00");
		musicalList[1].setPrice("1인 120000원");
		musicalList[1].setCasting("조승우/윤공주/이정화/이희정 등");

		musicalList[2] = new Musical();
		musicalList[2].setMusicalName("<스위니토드>");
		musicalList[2].setAddress("홍익대아트센터대극장");
		musicalList[2].setTime("2021/01/02 | 16:00");
		musicalList[2].setPrice("1인 120000원");
		musicalList[2].setCasting("조승우/전미도/서영주/김성철 등");

		int musical;
		String reserv;
		int seat; // 좌석
		int pop; // 예약 인원 입력
		boolean confirm; // 반복문을 탈출하기 위한 변수

		Scanner sc = new Scanner(System.in);

		do {
			confirm = true; // true일 경우 계속 반복

			// -----------메인 메뉴 부분-----------
			System.out.println("★뮤지컬 티켓 예약★\n");
			System.out.println("A. 이달의 뮤지컬 리스트 (선택)");

			for (int i = 0; i < musicalList.length; i++) {
				System.out.println(" " + (i + 1) + ". " + musicalList[i].getMusicalName());
			}
			System.out.print("> ");
			musical = sc.nextInt();

			System.out.println();
			System.out.println(musicalList[musical - 1].getMusicalName());
			System.out.println("*공연장소: " + musicalList[musical - 1].getAddress());
			System.out.println("*공연날짜: " + musicalList[musical - 1].getTime());
			System.out.println("*티켓금액: " + musicalList[musical - 1].getPrice());
			System.out.println("*캐스팅정보: " + musicalList[musical - 1].getCasting());
			System.out.println();
			System.out.println("a. 예매하기 | b. 뮤지컬 다시 선택하기");
			System.out.print("> ");
			reserv = sc.next();

			if (reserv.toLowerCase().equals("a")) { // toLowerCase는 문자열을 모두 소문자로 변경

				System.out.println();
				while (true) {
					System.out.println("C. 예매하기");
					System.out.println("인원을 선택해주세요 (1인 최대 4명 예약가능)");
					System.out.print("> ");
					pop = sc.nextInt();
					if (pop <= 0 || pop >= 5) {
						System.out.println("인원을 잘못 입력했습니다. 다시 입력해주세요.");
						System.out.println();
					} else {
						break;
					}
				}

				System.out.println("인원수만큼 좌석을 선택해주세요");
				String[] list = { "A", "B", "C", "D", "E", "F", "G", "H" };
				String[] check = { "O", "O", "O", "O", "O", "O", "O", "O" };
				Scanner input = new Scanner(System.in);

				String seatStr = ""; // 값 초기화 (공백)
				int popCheck = 1;
				while (true) {
					System.out.println("--------------------------");
					for (int i = 0; i < list.length; i++)
						System.out.print(list[i] + " ");
					System.out.println();
					for (int j = 0; j < check.length; j++)
						System.out.print(check[j] + " ");

					if (pop < popCheck) { // 내가 입력한 인원수와 동일한지 체크해줌 // 한번 타고와서 보여주고 값 안맞으니까 빠져나감
						System.out.println();
						break;
					}

					System.out.println();
					System.out.println("--------------------------");
					System.out.println("좌석 번호를 선택해주세요. (1~8번째) : ");
					System.out.print("> ");
					seat = input.nextInt();

					switch (seat) {
					case 1:
						seatStr += "/ A-1";
//						musicalList[musical - 1].setSeat(musicalList[musical - 1].getSeat() + "/ A-1");
						System.out.println("좌석번호: A-1");
						check[seat - 1] = "X";
						break; //
					case 2:
						seatStr += "/ B-2";
						System.out.println("좌석번호: B-2");
						check[seat - 1] = "X";
						break;
					case 3:
						seatStr += "/ C-3";
						System.out.println("좌석번호: C-3");
						check[seat - 1] = "X";
						break;
					case 4:
						seatStr += "/ D-4";
						System.out.println("좌석번호: D-4");
						check[seat - 1] = "X";
						break;
					case 5:
						seatStr += "/ E-5";
						System.out.println("좌석번호: E-5");
						check[seat - 1] = "X";
						break;
					case 6:
						seatStr += "/ F-6";
						System.out.println("좌석번호: F-6");
						check[seat - 1] = "X";
						break;
					case 7:
						seatStr += "/ G-7";
						System.out.println("좌석번호: G-7");
						check[seat - 1] = "X";
						break;
					case 8:
						seatStr += "/ H-8";
						System.out.println("좌석번호: H-8");
						check[seat - 1] = "X";
						break;
					}
					popCheck++; // 인원 수 1명씩 추가
				}

				int price = 120000;
				int totalPrice = price * pop;

				do {
					confirm = true;
					System.out.println();
					System.out.println("C. 결제 (좌석금액을 입력하세요.)");
					System.out.println("해당 좌석 금액 : " + pop + "인 총" + totalPrice + "원");
					System.out.print("> ");
					int payment = input.nextInt();

					if (payment == totalPrice) {
						System.out.println("결제에 성공했습니다.\n");
						System.out.println("예약내역을 보시겠습니까? (Y,N)");
						String yn = input.next();
						if (yn.equals("N") || yn.equals("n")) {
							System.out.println("감사합니다!");
							confirm = false;
							break;
						} else {
							System.out.println();
							System.out.println("----------티켓 예매 정보----------");
							System.out.println("뮤지컬: " + musicalList[musical - 1].getMusicalName());
							System.out.println("*공연장소: " + musicalList[musical - 1].getAddress());
							System.out.println("*공연날짜: " + musicalList[musical - 1].getTime());
							System.out.println("*티켓금액: " + musicalList[musical - 1].getPrice());
							System.out.println("*좌석정보: " + seatStr);
							System.out.println("*캐스팅정보: " + musicalList[musical - 1].getCasting());
							System.out.println("-----------------------------");
							System.out.println("즐거운 관람되세요~~♬");
							System.out.println();
							confirm = false;
							break;
						}
					} else {
						System.out.println("금액을 잘못입력하셨습니다.\n다시 입력해주세요.");
					}

				} while (confirm);

			} else if (reserv.toLowerCase().equals("b")) {
				System.out.println();
			} else {
				System.out.println("다시 입력하세요.");

			}
		} while (confirm); // 실행 종료
	}
}

//musical 값, 좌석배열, seatStr 값 모두 초기화 하면 좌석 취소 표현 가능