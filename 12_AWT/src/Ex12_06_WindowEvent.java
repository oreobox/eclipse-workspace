import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Sub06 extends Frame implements WindowListener { // WindowListener 인터페이스 넣어주기 - 7가지 미완성 메소드 생성됨 (@Override)

	// 생성자
	Sub06() {

		this.addWindowListener(this); // 윈도우창에 변화가 생겼을 때 현재 클래스 안에 메소드 호출하겠다

		setSize(400, 300);
		setVisible(true);

	}

//미완성 메소드  7가지 생성됨 - 필요없어도 비어있는 형태로라도 미완성 메소드 정의해놔야함 , 지우면 안됨
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("x버튼 클릭"); // x버튼 눌렀을 떄 콘솔에 해당 메세지 호출됨
		System.exit(0); // x버튼 누르면 프로그램 강제종료(비활성화됨)

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("창이 활성화 됨"); // 창을 최소화했다가 다시 켰을때 콘솔에 해당 메세지 호출됨

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}

public class Ex12_06_WindowEvent {

	public static void main(String[] args) {
		new Sub06();

	}

}
