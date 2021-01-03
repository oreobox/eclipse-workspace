import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class Sub09 extends JFrame {

	// 생성자 밖에서도 사용 가능하도록 밖으로 빼줌
	String[] text = { "사과", "배", "체리" }; // 배열사용
	JRadioButton[] radio = new JRadioButton[3]; // 라디오버튼 관리자 3개를 만듬
	
	// 이미지도 객체(배열)로 만들어 주는 작업을 해야함
	ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	
	JLabel imageLabel = new JLabel("   "); // 이미지라벨 영역지정
	
	
	Sub09(String title) {
		super(title);

		// 작업 영역에 대한 -- 가져오기
		Container contentPane = getContentPane();

		JPanel p = new JPanel();
		p.setBackground(Color.DARK_GRAY);
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // SwingConstants 인터페이스 안에 위치 설정하기

		contentPane.add(p, BorderLayout.NORTH); // contentPane 에다가 패널 올리기
		contentPane.add(imageLabel, BorderLayout.CENTER);

		// ↓ 그룹 중에 하나만 선택 가능하게 함 ButtonGroup group = new ButtonGroup(); /
		// group.add(radio[i]);
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < text.length; i++) {
			radio[i] = new JRadioButton(text[i]); // 진짜 라디오 버튼 생성 - 라디오 버튼에 3가지 패널 올라가게 설정
			// ↑ 라디오버튼 관리하는 버튼 3개 변수 만들기 - 배열로 만듬 -> 사과 라디오 버튼이 0번방에 들어감, 배는 1번방, 체리는 2번방에
			// 들어감
			group.add(radio[i]); // 그룹에 올리기
			p.add(radio[i]); // 패널에 올리기
			
			radio[i].addItemListener(new RadioButtonEvent()); // 눌렀을 때 라디오버튼 이벤트로 감  // 콘솔에 "itemStateChanged" 출력됨

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 프로그램 종료
		setSize(350, 400);
		setVisible(true);

	} // 생성자
	// 절대 다른 클래스에 의해 호출되지않고 Sub09 안에서만 사용할 예정이라면, Sub09 내에 내부 클래스로 작성 가능
	class RadioButtonEvent implements ItemListener { // 라디오 버튼 누를 때마다 이벤트 발생

		@Override
		public void itemStateChanged(ItemEvent e) { // 라디오 버튼 누를 때마다 이 곳으로 오는 메소드
//			System.out.println("itemStateChanged");
//			e.getSource();
			
			if(radio[0].isSelected()) {
//				System.out.println("사과");
				imageLabel.setIcon(image[0]); // imageLabel에 아이콘 세팅 - 0번방에 사과이미지 넣어라 
			}
			else if(radio[1].isSelected()) {
//				System.out.println("배");
				imageLabel.setIcon(image[1]);
			}
			else if(radio[2].isSelected()) {
//				System.out.println("체리");
				imageLabel.setIcon(image[2]);
			}
		}

	} // RadioButtonEvent
} // Sub09

public class Ex12_09_fruit {
	public static void main(String[] args) {
		new Sub09("라디오버튼 item Event 예제");

	}

}

// 생성자 안에 화면 구성, 화면 배치 등  첫 화면에 보여질 것들만 세팅해둠
// 버튼 누르면 
