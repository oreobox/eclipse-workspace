//스윙, 파일 입출력 사용

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// 스크롤바 : 담는 크기가 작아지면 스크롤바 보이고, 아니면 보이지않음

class Sub11 extends JFrame {
	int cnt = 1;

	// 벡터 : ArrayList랑 비슷하다고 보면됨
	Vector<String> columnNames; // 문자열 여러개를 담은 백터를 만듬 - 제목 넣는 곳
	Vector<Vector<String>> rowData; // 문자열 여러개를 담은 백터를 만듬 -> 이러한 백터의 모음을 담는 더 큰 백터

	Sub11() {
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getFile(); // 파일에서 읽어서 JTable 만들 준비
		compose(); // JTable 작성

		setSize(700, 300);
		setVisible(true);

	}

	public void compose() {
		
		Container ct = getContentPane();
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scroll = new JScrollPane(table); // table을 올려놓음
		ct.add(scroll, BorderLayout.CENTER);

		JButton btn = new JButton("출력"); // J버튼 올려라
		ct.add(btn, BorderLayout.SOUTH);
		btn.addActionListener(new TablePrint(table)); // 버튼 눌렀을때 실행되게 하기 - 콘솔창에 출력되게 하기 - JTable 객체 table 넣어줌

	} // compose

	public void getFile() { // getFile메소드 정의
		FileReader fr; // 한글 데이터 읽어오기
		BufferedReader br;
		File file = new File("c:\\sun\\table.txt");// 어느 파일에서 읽어들일건지
		//글자가 깨져 나올 때 : 파일 소스  ANSI로 설정

//		br = new BufferedReader(new FileReader(file)); // 예외처리하기
		try {
			br = new BufferedReader(new FileReader(file));
			String str;
			while ((str = br.readLine()) != null) { // 한줄 읽어들이는것 반복해라 / 한줄씩 읽다가 EOF 만나면 null이 뜸

				tableMake(str); // *** tableMake로 가라 - table 만드는 메소드
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // getFile

	public void tableMake(String str) { // *** 한줄 읽을 때마다 이쪽으로 넘어와서 table만듬 - String 받아주니까 String str
		// 처음에 str 변수로 넘어온건 제목
		// str : 이름/국어/영어/수학
		// str : 써니/33/44/55

		String[] item = str.split("/"); // "/"기준으로 쪼개라 - 4개로 쪼개짐
		if (cnt == 1) { // 제목 처리
			cnt++; // 2
			for (int i = 0; i < item.length; i++) {
				columnNames.add(item[i]); // columnNames 라는 백터에 제목(이름/국어/영어/수학) 넣어둠
			}

		} else { // 내용 처리
			Vector<String> one = new Vector<String>(); // Vector를 만듬 (collection의 한 종류)
			for (int i = 0; i < item.length; i++) { // 써니 데이터다 item에 들어와있음
				one.add(item[i]);
			}
			rowData.add(one); // 내용은 rowData에 추가
		} // else

	} // tableMake

} // Sub11

class TablePrint implements ActionListener {
	JTable table;
	TablePrint(JTable table) {
		this.table = table;
	}

	// JTable의 내용을 콘솔창에 출력
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼 눌렀을 때 actionPerformed가 실행되게함
//		System.out.println("TablePrint");
		
		int row = table.getRowCount(); // 제목 빼고 내용 줄(열) 갯수 나타내고 싶을 때 
		int column = table.getColumnCount(); // 제목 빼고 내용 칸(행) 갯수 나타내고 싶을 때
		System.out.println(row + ","+column);
		
		for(int i=0;i<column;i++) {
			String columnName = table.getColumnName(i); // 문자열 리턴
			System.out.print(columnName+"\t");
			
		}
		System.out.println();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				Object obj = table.getValueAt(i,j);  // 특정한 값을 가져오라는 듯 : .getValueAt(row, column)
				System.out.print(obj+"\t");
			}
			System.out.println();
		} // for
		
	} // actionPerformed

} // TablePrint

public class Ex12_11_JTable_File {

	public static void main(String[] args) {
		new Sub11();

	} // main

} // class

// 0. 기본 J프레임들입력
// 1. 파일에서 데이터 읽어오는 작업 - 연결다리 형성 c:\\sun