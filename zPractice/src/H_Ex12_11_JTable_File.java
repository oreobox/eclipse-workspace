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

class Sub11 extends JFrame{
	
	int cnt=1;
	
	Vector<String> columnNames;
	Vector<Vector<String>> rowData ;
	
	Sub11(){
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getFile(); // 화일에서 읽어서 JTable만들 준비
		compose(); // JTable 작성
		
		setSize(500,200);
		setVisible(true);
	}
	
	public void compose() {
		
		Container ct = getContentPane();
		JTable table = new JTable(rowData,columnNames);
		JScrollPane scroll = new JScrollPane(table);
		ct.add(scroll,BorderLayout.CENTER);
		
		JButton btn = new JButton("출력");
		ct.add(btn,BorderLayout.SOUTH);
		btn.addActionListener(new TablePrint(table));
	}
	
	public void getFile(){
		FileReader fr ;
		BufferedReader br;
		File file = new File("c:\\sun\\table.txt");
		
		try {
			br = new BufferedReader(new FileReader(file));
			String str;
			while((str = br.readLine()) != null) {
				
				tableMake(str);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // getFile
	
	public void tableMake(String str) {
		//str:이름/국어/영어/수학
		//str:써니/33/44/55
		String[] item = str.split("/");
		if(cnt == 1) { // 제목
			cnt++; // 2
			for(int i=0;i<item.length;i++) {
				columnNames.add(item[i]);
			}
		}else { // 내용
			
			Vector<String> one = new Vector<String>();
			for(int i=0;i<item.length;i++) {
				one.add(item[i]);
			}
			rowData.add(one);
		}
	}
	
} // Sub11

class TablePrint implements ActionListener{

	JTable table;
	TablePrint(JTable table){
		this.table = table;
	}
	
	// JTable의 내용을 콘솔창에 출력
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("TablePrint");
		
		int row = table.getRowCount();
		int column = table.getColumnCount();
		System.out.println(row +"," + column);
		
		for(int i=0;i<column;i++) {
			String columnName = table.getColumnName(i);
			System.out.print(columnName+"\t");
		}
		
		System.out.println();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				Object obj = table.getValueAt(i,j);
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
} //TablePrint

public class H_Ex12_11_JTable_File {

	public static void main(String[] args) {

		new Sub11();
	}

}