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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Ex12_12_JTable extends JFrame implements ActionListener {

	int cnt = 1;

	// 벡터 : ArrayList랑 비슷하다고 보면됨
	Vector<String> columnNames; // 문자열 여러개를 담은 백터를 만듬 - 제목 넣는 곳
	Vector<Vector<String>> rowData; // 문자열 여러개를 담은 백터를 만듬 -> 이러한 백터의 모음을 담는 더 큰 백터
	
	JButton btnAdd, btnRemove, btnFout, btnExit; // 버튼 4개를 관리하는 관리자 (추가,삭제,파일에출력,종료 버튼)

	Ex12_12_JTable(String str) {
		super(str);

		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		getFile(); // 파일에서 읽어서 JTable 만들 준비
		compose(); // JTable 작성

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,300);
		setVisible(true);
	} // 생성자


	public void compose() { // 화면구성

		Container ct = getContentPane();

		ct.setLayout(null);//레이아웃 설정 - 기본 배치관리자(보더레이아웃)인데 어떤 레이아웃(배치관리자)도 사용안하겠다 : null
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scroll = new JScrollPane(table); // table을 올려놓음
		ct.add(scroll); // 컨테이너에 스크롤 갖는 부분 올려라

		// 스크롤 바를 갖는 패널에 가로 세로 위치 설정하기
		scroll.setBounds(250, 30, 400, 200); // .setBounds(x, y, width, height); : 내가 원하는 위치 설정(스크롤됨)

		JTextField[] tf = new JTextField[4]; // 관리자 - 관리자 변수는 소괄호 없이 []로 사용 
		
		//라벨 위치, 사이즈 설정, TextField 위치, 사이즈 설정
		String [] title = {"이름:","국어:","영어:","수학:"}; // 라벨 배열로 설정
		for(int i=0; i<4;i++) {
			JLabel lb = new JLabel(title[i]);
			lb.setText(title[i]);
			lb.setBounds(10, (i+1)*30, 50, 20); // 4개 라벨 위치 설정
			
			ct.add(lb); // 각각의 라벨을 올려라
			
			//TextFild 만들기
			tf[i] = new JTextField(); // 4개의 JTextField를 관리할 수 있는 관리자를 배열로 만듬-각각 어떤거를 쓸지 모르니까 // 똑같은 객체를 배열로 만들어서 사용
			tf[i].setBounds(80,(i+1)*30,90,20); // 라벨이랑 위치만 조금 다르고 똑같이 배열로 사용해서 위치시킴
			ct.add(tf[i]); // tf[i] 부분 올려라
			
		} // for
		
		// 4개 버튼 구성 설정
		btnAdd = new JButton("추가"); // 버튼사용
		btnAdd.addActionListener(new AddSungjuk(table,tf)); // tf를 보내면 4개의 JTextField 넘어옴
		btnAdd.setBounds(10,160,100,20);
		ct.add(btnAdd);
		
		btnRemove = new JButton("삭제"); // 버튼사용
		btnRemove.addActionListener(new RemoveSungjuk(table));
		btnRemove.setBounds(120,160,100,20);
		ct.add(btnRemove);
		
		btnFout = new JButton("파일출력"); // 버튼사용
		btnFout.addActionListener (new FilePrint(table));
		btnFout.setBounds(10,190,100,20);
		ct.add(btnFout);
		
		btnExit = new JButton("종료"); // 버튼사용
		btnExit.addActionListener(this);
		btnExit.setBounds(120,190,100,20);
		ct.add(btnExit);
		

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

	public static void main(String[] args) {
		new Ex12_12_JTable("JTable 프로그램");//현제클래스 객체 만들기	

	}

	@Override
	public void actionPerformed(ActionEvent e) { //종료 버튼 눌렀을떄 
		System.exit(0);
		
		
	}

}
