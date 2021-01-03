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

class Sub04 extends Frame implements ItemListener,ActionListener { // Sub04 오류나면 클릭 후 미완성 메소드 생성해주기 위해 클릭함

	List list; // 다른 메소드에서도 사용할 수 있게 변수를 밖에다가 설정함
	Choice ch;
	Button btn;
	

	Sub04() { // 생성자
		setTitle("ItemEvent"); // 제목 설정
		setSize(300, 200);
		setVisible(true);

		setLayout(new FlowLayout());

		list = new List(3, true); // import java.awt.List; // true : 다중 선택 가능
		ch = new Choice();

		list.add("지리산");
		list.add("한라산");
		list.add("금강산");
		list.add("덕유산");
		list.add("속리산");

		ch.add("진달래");
		ch.add("벚꽃");
		ch.add("장미");
		ch.add("국화");
		ch.add("개나리");

		btn = new Button("빨간색");
		// Botton : 클릭하면 ActionEvent가 발생
		// List, Choice : ItemEvent 발생

		// 프레임에 부착
		add(list);
		add(ch);
		add(btn); // 버튼

		list.addItemListener(this); // new ItemEvent() - 누르면 이벤트 발생
		ch.addItemListener(this); // 현재 클래스 안에 있음
		btn.addActionListener(this); // 버튼
		

		
		
		

	} // 생성자

	@Override
	// ItemEvetn e = new ItemEvent()
	public void itemStateChanged(ItemEvent e) {
//		System.out.println("itemStateChanged");

		Object obj = e.getSource(); // 어떨때는 list 정보, 어떨때는 choice 정보 넘어옴
		if (obj == list) {
//			System.out.println("list 이벤트 발생");
			
			//다중선택 getSelectedIndexes, s를 붙여서  배열로 만들어줌
			int[] indexs = list.getSelectedIndexes(); // 지금 선택한 것 번호 가져오기
			String[] items =list.getSelectedItems(); // 지금 선택한 것 문자로 가져오기
			
			for (int i = 0; i < indexs.length; i++) {
				System.out.print(indexs[i]+"/"+items[i]+","); // index0번방과 items 0번방 - 배열로 나타냄

			} // for
			System.out.println();

		} else if (obj == ch) {
//			System.out.println("choice 이벤트 발생");
			int index = ch.getSelectedIndex(); // 선택한 항목의 번호
			String item = ch.getSelectedItem(); //선택한 항목
			System.out.println(index+":"+item);
			

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		
//		if(obj == btn) { // 버튼 하나만 만들거기 때문에 if문 쓸 필요 없음
			setBackground(Color.RED);
//		}
		
	}

} // Sub04

public class Ex12_04_ItemEvent {

	public static void main(String[] args) {

		new Sub04();

	} // main

}

// 1. Frame 생성
// 2. sub04 객체 생성
// 3. 사이즈와 창 보이게 만듬, 프레임 제목 설정
// 4. 레이아웃 설정
// 5. 변수 지정
// 6. 프레임에 부착
// 7. 

// 클래스 ActionListener 인터페이스 상속, 버튼에 리스너 부착, 자동호출되는 메서드() 완성