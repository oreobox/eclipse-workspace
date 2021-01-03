import java.awt.Frame; // awt라는 패키지 안에 Frame 클래스

class HelloFrame extends Frame {

}

public class Ex12_01_Frame {

	public static void main(String[] args) {

//		Frame f = new Frame(); // 프레임 창 생성 (창은 보이지 않음)
		Frame f = new HelloFrame(); // Frame을 상속 받아서도 사용 가능
//		Frame f = new Frame("기본창 만들기"); // 문자 열 넣어주면 창 제목 설정
		f.setTitle("abc"); // f.setTitle(title); - 프레임 제목 설정

		f.setVisible(true); // 프레임 창 생성 (창 보이게 해줌)
		f.setSize(400, 300); // f.setSize(width, height); - 프레임 크기 설정
		f.setLocation(100, 300); // f.setLocation(x, y); - 프레임 위치설정 : 왼쪽상단이 0.0자리 꼭지점부터 시작
		// 프레임은 x눌러도 안닫힘. 콘솔의 빨간 네모 클릭하면 지워짐 - 네모 옆옆 xx 지워주면 이전 프레임 나오면 또 지워줌

	}

}
