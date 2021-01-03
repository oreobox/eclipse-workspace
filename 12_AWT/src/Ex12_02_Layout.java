import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

class Sub02 extends Frame {

	Button east = new Button("동쪽"); // 버튼 생성 했다고 해서 프레임에 올라는것 아님
	Button west = new Button("서쪽"); // 괄호 안에 글자 사용 가능
	Button south = new Button("남쪽"); //
	Button north = new Button("북쪽");
	Button center = new Button("중앙");

	Sub02(String title) { // 객체 생성한게 생성자로 넘어옴
		super(title);

		setSize(400, 300);
		setVisible(true);

//		setLayout(new FlowLayout()); // FlowLayout 배치관리자 사용 하면 아래 L21~25 나타냄
//		setLayout(new BorderLayout()); // 동서남북으로 배치 - add에다가 작업 기능 추가해야함(,BorderLayout.EAST)
		// ↑ 프레임의 기본 배치관리자(=BorderLayout)가 동서남북이기 때문에 생략해도 동서남북으로 나옴
		setLayout(new GridLayout(3, 2)); // 3행2열 - GridLayout이기 때문에 굳이 동서남북 위치 안써도됨 : add(east); - 이렇게만 사용가능

		// 프레임에 올리는 작업 add(); 사용
		add(east, BorderLayout.EAST); // 현재위치 this는 생략가능
		super.add(west, BorderLayout.WEST); // 현재위치 부모에 올린다는 뜻
		this.add(south, BorderLayout.SOUTH); // 위치는 반드시 대문자 변수로 작성
		this.add(north, BorderLayout.NORTH);
//		this.add(center,BorderLayout.CENTER);
		add("Center", center); // 위치가 따옴표로 앞에 위치 - "Center" : 첫글자만 대문자

	}

}

public class Ex12_02_Layout {

	public static void main(String[] args) {

		new Sub02("sub02제목"); // 객체 생성 // 프레임 제목

	} // main

} //
