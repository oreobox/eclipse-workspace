import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub07 extends Frame {
	/*
	 * Sub07() { setSize(300, 200); setVisible(true);
	 * 
	 * this.addWindowListener(new MyWindow()); // MyWindow객체를 만듬 . MyWindow 라는 클래스
	 * 안에 처리하고 싶은 것이있다 }
	 * 
	 * class MyWindow extends WindowAdapter { // WindowListener 상속받으면 7가지 미완성 메소드
	 * 발생되는것 싫어서 WindowAdapter 사용 public void windowClosing(WindowEvent e) { // 내용없는
	 * 필요없는 것 빼고 필요한 것만 골라서 출력가능 System.exit(0); }
	 * 
	 * } // MyWindow
	 */
	// 위의 주석의 또다른 형태로 사용 가능 (내부 클래스 형태)
	Sub07() {
		setSize(300, 200);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		});
	}

} 

public class Ex12_07_WindowAdapter {

	public static void main(String[] args) {
		new Sub07();

	}

}
