import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Sub05 extends Frame implements ItemListener {

	String[] 대륙 = { "아시아", "유럽", "아프리카" };
	String[][] 나라 = { { "한국", "일본", "중국" }, { "영국", "스위스", "프랑스" }, { "이집트", "콩고", "우간다" } };

	Choice c1, c2;
	Label lb1, lb2;
	Panel p;

	Sub05() { // 생성자

		// ----------------------------------------------------Label 1
		lb1 = new Label("대륙과 나라를 선택하세요");
		lb1.setBackground(Color.cyan);
//		add("North",lb1);

		// ----------------------------------------------------Panel
		p = new Panel();
		p.setBackground(Color.pink);
		// p.setLayout(new FlowLayout()); // 패널의 기본 배치 관리자 : FlowLayout - 생략가능

		c1 = new Choice();
		c2 = new Choice();

		p.add(c1); // Panel에 올리라는 뜻
		p.add(c2);

		// c1.add("아시아");
		// c1.add("유럽");
		// c1.add("아프리카");
		for (int i = 0; i < 대륙.length; i++) {
			c1.add(대륙[i]);
//
//			// for(int i = 0; i< 나라.length; i++ ) {
//			for (int j = 0; j < 나라[i].length; j++) {
//				c2.add(나라[i][j]);
//			}

		} // for

		// ----------------------------------------------------Label 2
		lb2 = new Label(); // 결과가 나오는 라벨
		lb2.setBackground(Color.yellow);

		add("North", lb1);
		add("Center", p);
		add("South", lb2);

		c2.add("              "); // 공간이 작아서 우선 어떤 것이 들어갈지 모르니까 자리라도 확보
		c1.addItemListener(this); // c1에 아이템 리스터 부착
		c2.addItemListener(this);

		setTitle("초이스 이벤트");
		setSize(300, 200);
		setVisible(true); // 모든것을 보이게 하겠다는 뜻으로 마지막에 쓰는게 안정적임

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		System.out.println("itemStateChanged");

		Object obj = e.getSource(); // 모든 컴포넌트를 받아줄 수 있는 Object 가져옴
//		Choice obj = (Choice)e.getSource(); // Choice 타입으로 받고싶으면 다운캐스팅
		String result = "선택한 대륙과 나라는 : "; // 문자열 변수에 넣어놓음 // 맨 마지막 순서
		if (obj == c1) { // c1에서 선택한 항목의 항목 번호
			c2.removeAll(); // 새로운 나라가 들어가기 전에 기존에 있던 나라의 항목이 겹치기 때문에 지워줌 - c1대륙을 선택하면 c2나라들이 중복되어나오는 것을 방지
			int index = c1.getSelectedIndex(); // index가 행 번호가 됨
//			System.out.println(index); // 콘솔에 아시아 선택하면 0번 출력

			for (int i = 0; i < 나라[index].length; i++) { // 3번에 걸쳐 for문 돌면서 c2에다가 추가해라
				c2.add(나라[index][i]); // index = 행 , i = 열 (나라)

			} // for
				// 유럽 선택: 1행 0열~2열
				// 아프리카 선택: 2행 0열~2열

		} else { // c2이벤트 발생
			result += c1.getSelectedItem() + " - "; // result 에다가 누적하기
			result += c2.getSelectedItem();
			// result: 선택한 대륙과 나라는 유럽 - 스위스
			lb2.setText(result);// 노란색 라벨에 객체 생성하여 result 값을 넣음

		} // else

	} // @Override

}

public class P_Ex12_05_이도흔_Review {

	public static void main(String[] args) {

		new Sub05();

	} // main

} // class

/*
 * choice 두개 왼쪽 리스트는 아시아,유럽,아프리카 오늘쪽에는 아무것도 없다가 왼쪽리스트 선택해야지 나라 나옴 초이스는 icon
 * event 사용 라벨클래스 이용해서 위 아래로 글자 넣기 (대륙과 나라를 선택하세요/선택한 대륙과 나라는 유럽,스위스) 패널(=컨테이너)
 * : 리스트 선택하는 창 두개 띄우기
 * 
 * 1. 라벨 2. 패널 - 분홍색 패널에 리스트 두개 3. 라벨
 */

// 1. 네임에서 우선 객체만들고
// 2. 생성자 작업 : 프레임 보이게 만들고, 사이즈 설정
// 3. 
// 4. 