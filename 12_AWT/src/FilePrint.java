import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

public class FilePrint implements ActionListener {

	JTable table;
	BufferedWriter bw = null; // 아직은 어느 파일과도 연결되지 않을 땐 null , 연결다리 형성되면 null값 안갖고 bw로 지정됨

	FilePrint(JTable table) {
		this.table = table;
	}

	// JTable의 내용을 화일에 출력
	@Override
	public void actionPerformed(ActionEvent e) {
		File file = new File("c:\\sun\\table.txt");
		// ,false : 위 폴더에 들어간 기존 내용 싹 지우고 새로운 내용으로 출력 // 기본 값은 false
		// ,true

		try { // 예외발생하면 catch로 감
			bw = new BufferedWriter(new FileWriter(file)); // 연결다리형성 // 안쓰면 ,false가 기본값

			int rowNum = table.getRowCount(); // 행(row)의 개수 몇개인지?
			int columnNum = table.getColumnCount(); // column의 갯수 몇개인지?
			System.out.println(rowNum + "," + columnNum); // 제목 빼고 몇줄에 몇칸 있는지 콘솔에 출력됨

			// 제목만 파일에 출력하기
			for (int i = 0; i < columnNum; i++) {
				String title = table.getColumnName(i); // 0번째 Column이름 가져와라 - 문자열 리턴
				System.out.print(title + "\t"); // 콘솔창에 출력

				// 마지막 데이터면 / 넣고
				if (i != columnNum - 1) {// 마지막 데이터 (4개중에 3개에 접근했다는 뜻)
					bw.write(title + "/"); // 파일에 출력
				}
				// 마지막 데이터가 아니면 / 넣지않는다
				else {
					bw.write(title);
					bw.newLine(); // 엔터 삽입하기
				}

			} // 제목 출력 for문
			System.out.println();
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < columnNum; j++) {
					Object obj = table.getValueAt(i, j); // 0.0자리 가져옴

					System.out.print(obj + "\t");
					if (j != columnNum - 1) {
						bw.write((String) obj + "/"); // 다운캐스팅-obj를 바로 받을수없음

					} else {
						bw.write((String) obj);
						bw.newLine();

					}
				}
				System.out.println();
			} // for

		} catch (IOException e1) { // 예외발생 시 작업 실행
			e1.printStackTrace();

		} finally { // 예외발생 여부와 상관없이 반드시 해야하는 작업 사용 시
			if (bw != null) { // bw연결다리 형성되면 bw는 null이 아닌 값을 가지게됨
				try {
					bw.close(); // 연결다리 닫아주기 - 닫을 때도 예외 발생하기 때문에 try/catch 사용
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

} // class

/*
이름/국어/영어/수학
써니/33/44/55
윤아/77/88/99
 */
