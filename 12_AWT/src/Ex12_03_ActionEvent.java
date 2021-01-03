import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub03 extends Frame implements ActionListener {
	// Sub03이 ActionLister를 상속받도록 해야함
	// ActionListener 라는 인터페이스 = 미완성된 인터페이스를 상속받으면서 그것(Override영역=미완성 메소드)을 완성시키지
	// 않으면 Sub03 부분에 오류남

	Button b1;
	Button b2, b3;

	// 생성자
	Sub03() {

		setVisible(true);
		setSize(400, 300);

		b1 = new Button("노란색");
		b2 = new Button("빨간색");
		b3 = new Button("파란색");

//		Button : ActionEvent 가 발생 - 버튼을 누르면 실행되도록 하는것 (ActionEvent 가 발생)
		b1.addActionListener(this); // this : 현재클래스
		b2.addActionListener(this); // new ActionEvent() - 예외나 이벤트가 발생하면 Event 관련 객체가 자동으로 만들어짐
		b3.addActionListener(this);
//		this: 

		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);

		// x버튼 누르면 종료 될 수 있도록 하는 기능
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		} // WindowAdapter

		); // addWindowListener

	} // Sub03

	@Override // 부모의 미완성 메소드 완성시킴
	// ActionEvent e = new ActionEvent()
	public void actionPerformed(ActionEvent e) {
//		System.out.println("actionPerformed");

		Object obj = e.getSource(); // Event가 발생한 컴포턴트 : Event Source - b1이나 b2를 가져옴
		// 어떤 컴포넌트를 만들든 다 받아줄 수 있도록 Object로 받아줌

		if (obj == b1) {
			setBackground(Color.yellow);

		}
		if (obj == b3) {
			setBackground(Color.BLUE);

		} else if (obj == b2) {
			setBackground(Color.RED);

		}

	}
}

public class Ex12_03_ActionEvent {

	public static void main(String[] args) {

		new Sub03();

	} // main

} // class

//노란색 누르면 노란색, 빨간색 누르면 빨간색

// 1. frame을 만든다
// 2. 버튼 3개 생성
// 3. 배치관리자 설정
// 버튼 누르면 배경 색 변경하게 하고싶을 떄
// 4. 버튼 이벤트 -> ActionEvent
// 5. 클래스 ActionListener 상속, 버튼에 리스너 부착, 자동호출되는 메서드 () 완성
// 6. 자동호출되는 메서드에서 기능 구현
