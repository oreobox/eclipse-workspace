import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class Sub03 extends Frame implements ActionListener {

	Button b1, b2, b3;

	// 생성자
	Sub03() {

		b1 = new Button("노란색");
		b2 = new Button("빨간색");
		b3 = new Button("파란색");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
		setSize(300, 400);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == b1) {
			setBackground(Color.yellow);
			
		}else if (obj == b2) {
			setBackground(Color.blue);
			
		}else if (obj == b3) {
			setBackground(Color.red);
		}
		

	} // Sub03

} // Sub03 class

public class H_Ex12_01_Frame {
	public static void main(String[] args) {

		new Sub03();

	} // main

} // class
