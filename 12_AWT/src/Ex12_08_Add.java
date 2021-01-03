import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; // swing 안에있음
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Sub08 extends JFrame { // JFrame으로 만들면 closing 안만들어도 창이 닫힘 but 프로그램 종료는x

	Sub08(String title) { // 부모생성자로 한번은 가게되어있는데 title을 가져가라
		super(title);
		// setSize(400, 300); // pack() 메소드 있으면 사이즈 조절 필요없음

		Container contentPane = getContentPane(); // 작업영역(ContentPane)에 대한 정보를 가져와라

		// 패널 생성
		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);

		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);

		contentPane.add(p1, BorderLayout.CENTER); // BorderLayout에 위치 설정
		contentPane.add(p2, BorderLayout.SOUTH);

		// 텍스트 입력 창 생성
		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField text3 = new JTextField(5);

		// 5개 컴포넌트 생성
		p1.add(text1);
		p1.add(new JLabel("+"));
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);

		// 버튼 생성
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("취소");

		p2.add(btn1);
		p2.add(btn2);

		// 객체 생성
		OkButton ok = new OkButton(text1, text2, text3);
		CancelButton cancel = new CancelButton(text1, text2, text3);
		// 버튼 누르면 이벤트 실행 : addActionListener
		btn1.addActionListener(ok); // 확인버튼
		btn2.addActionListener(cancel); // 취소버튼

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 누르면 창도 닫히고 프로그램도 종료시킴
		pack(); // pack 메서드 - 컴포넌트 크기에 맞춰서 나옴 - 사이즈 설정 필요없음
		setVisible(true);

	} // 생성자

	// 화면 구성은 생성자까지만 하고, 버튼 구성은 새로운 클래스로 만들어주는 방법

	class OkButton implements ActionListener { // OkButton이 ActionListener를 상속
		JTextField text1, text2, text3;

		OkButton(JTextField text1, JTextField text2, JTextField text3) { // JTextField text1 = new JTextField(5);에 입력한
																			// 것을 끌어옴

			this.text1 = text1;
			this.text2 = text2;
			this.text3 = text3; // testField를 sub08에서 만든 textField (매개변수) 3가지를 사용할 수 있도록 넘겨줌. 매개변수 3가지를 넘겨받을 수
								// 있는 멤버변수
		}

		@Override // 확인 눌렀을때 할 작업 - 우선 생성자에서 OkButton 객체 만들어주고 옴
		public void actionPerformed(ActionEvent e) {
//			System.out.println("OkButton"); // 확인 버튼 누르면 콘솔에 출력

			try {
//			Integer.parseInt("123"); // "123" -> 123 : 문자를 숫자로 바꿔줌
//			text1.getText(); // 입력한 숫자를 문자(String)로 생각함 : String ->int
				int num1 = Integer.parseInt(text1.getText()); // String("12") // 숫자로 바꿀 수 없는 문자를 넣었을 경우
																// NumberFormatException 발생
				int num2 = Integer.parseInt(text2.getText()); // String("34")
				int sum = num1 + num2;

				// 3번째 텍스트 필드때 넣을때
				String strsum = String.valueOf(sum); // int -> String
//			text3.setText(strSum); // 뭔가 입력하고 싶을 때 setText 사용
				text3.setText(sum + "");

			} catch (NumberFormatException e2) { // 숫자
				JOptionPane.showMessageDialog(null, "숫자만 입력가능"); // 창을 띄우는 메소드

				text1.setText("");
				text2.setText("");
				text3.setText(""); // text1~3까지 입력되어있던 내용 지워주는 것

			}
		}

	} // OkButton

	class CancelButton implements ActionListener {
		
		// cancel 버튼 눌렀을 떄 다 지워지게 설정
		JTextField text1, text2, text3;

		CancelButton(JTextField text1, JTextField text2, JTextField text3) {
			this.text1 = text1;
			this.text2 = text2;
			this.text3 = text3;
		}

		@Override // 취소 눌렀을때 할 작업
		public void actionPerformed(ActionEvent e) {
//			System.out.println("CancelButton"); // 취소 버튼 누르면 콘솔에 출력

			// cancel 버튼 눌렀을 떄 다 지워지게 설정
			text1.setText("");
			text2.setText("");
			text3.setText("");

		}

	} // CancelButton

} // Sub08

public class Ex12_08_Add {

	public static void main(String[] args) {
		new Sub08("덧셈 프로그램"); // 제목 입력

	}

}
