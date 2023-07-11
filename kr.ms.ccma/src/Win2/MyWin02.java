package Win2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWin02 extends JFrame {
	
	private JButton b1;
	private JButton b2;
	private int click;
	
	public MyWin02() {
		this("Default Window");
	}
	public MyWin02(String string) {
		// TODO Auto-generated constructor stub
		super(string);
		click = 0;
		b1 = new JButton("click");
		b2 = new JButton("exit");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
	}

	public void go() {
		// TODO Auto-generated method stub
		add(b1);
		add(b2, BorderLayout.SOUTH);
		setVisible(true);
	}
}
