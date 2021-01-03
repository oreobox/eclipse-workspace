import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Sub04 extends Frame implements ItemListener, ActionListener {

	List list;
	Choice ch;
	Button btn;

	// 생성자
	Sub04() {
		setTitle("프레임연습");
		setSize(500, 300);
		setVisible(true);

		setLayout(new FlowLayout());

		list = new List(3, true);
		ch = new Choice();

		list.add("지리산");
		list.add("한라산");
		list.add("금강산");

		ch.add("진달래");
		ch.add("벚꽃");
		ch.add("장미");

		btn = new Button("파란색");

		add(list);
		add(ch);
		add(btn);

		list.addItemListener(this);
		ch.addItemListener(this);
		btn.addActionListener(this);

	} // Sub04

	@Override
	public void itemStateChanged(ItemEvent e) {

		setBackground(Color.blue);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

public class H_Ex12_03_ActionEvent {

	public static void main(String[] args) {

		new Sub04();

	} // main

} // class

//1. Frame 생성
//2. sub04 객체 생성
//3. 사이즈와 창 보이게 만듬, 프레임 제목 설정
//4. 레이아웃 설정
//5. 변수 지정
//6. 프레임에 부착
//7. 

//클래스 ActionListener 인터페이스 상속, 버튼에 리스너 부착, 자동호출되는 메서드() 완성
