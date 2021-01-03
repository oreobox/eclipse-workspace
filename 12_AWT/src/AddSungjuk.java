import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddSungjuk implements ActionListener {

	JTable table; // table에 대한 정보가 넘어와있음
	JTextField[] tf = new JTextField[4]; // 4개의 JTextField 관리할 수 있는 ~~~~~~~
	String[] data = new String[4]; // 문자열을 담을 수 있는 방 4개짜리 배열 만듬
	// ↑ tf 0번방에있는 것을 String 0번방에 넣음

	AddSungjuk(JTable table, JTextField[] tf) {
		this.table = table;

//		this.tf = tf;
		for (int i = 0; i < tf.length; i++) {
			this.tf[i] = tf[i]; // 주소가 들어가있는 배열
		}

	}

	// JTextField에 입력한 내용을 JTable에 추가
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("AddSungjuk");

//		TableModel
//			:
//		DefaultTableModel

		// 다운캐스팅 // getModel은 TableModel을 리턴함
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < data.length; i++) {
			data[i] = tf[i].getText();
		}
		// textField에 입력하는것은모두 문자임

		model.addRow(data); // addRow : 내가 입력한 것 4가지를 한줄로 만들어 추가하겠다
		
		for(int i=0;i<tf.length;i++) {
			tf[i].setText(""); // textField를 빈 공백으로 지워라
			
		}

	}

}
