import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Sub10 extends JFrame {

	Sub10() {

		String[] title = { "이름", "직업", "나이" }; // 1
		Object[][] data = { // String으로 하면 문자열만 되지만, Object로 하면 String, Int 모두 받아 줄 수 있음 // 2
				{ "성시경", "가수", 40 }, { "유재석", "개그맨", 45 }, { "김연아", "운동선수", 30 } };

		JTable table = new JTable(data, title); // 내용(data)먼저 쓰고, 제목(title) 후 기재 // 3

		JScrollPane scrollPane = new JScrollPane(table); // scrollPane에 올리기 // 4

		Container ct = getContentPane(); // 작업영역의 정보를 가지고 와서 container를 ct에 올림 //5
		ct.add(scrollPane); // 6

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);

	}

}

public class Ex12_10_JTable {
	public static void main(String[] args) {
		new Sub10();

	}

}
