package Win1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MyWin01 extends Frame {
	public MyWin01() {
		setTitle("First Window");
		setResizable(true);
		setBounds(100, 100, 800, 600);
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
}
