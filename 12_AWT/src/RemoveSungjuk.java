import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveSungjuk implements ActionListener {

	JTable table;
	RemoveSungjuk(JTable table) {
		this.table = table;
	}

	// 선택한 JTable의 행을 삭제
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow(); // 내가 선택한 행이 무엇인지
		System.out.println(row);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);

	}

}
