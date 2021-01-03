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

	Sub05() {

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
		
		c2.add("              ");
		c1.addItemListener(this);
		c2.addItemListener(this);
		
		setTitle("초이스 이벤트");
		setSize(400, 300);
		setVisible(true);
		


	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		String result = "선택한 대륙과 나라는 : ";
		if (obj == c1) {
			c2.removeAll();
			int index = c1.getSelectedIndex();
//			System.out.println(index);
			
			for(int i = 0; i < 나라[index].length; i++) {
				c2.add(나라[index][i]);
			} // for
			
			
		} else {
			result += c1.getSelectedItem();
			result += c2.getSelectedItem();
			lb2.setText(result);
			
			
		} // else
		
	}

}

public class Ex12_05_이도흔 {

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