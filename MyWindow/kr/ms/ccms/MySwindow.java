package kr.ms.ccms;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MySwindow {
    private Frame window;
    public MySwindow(){
        this("MySecond Window!!");
    }
    public MySwindow(String title) {
        this.window = new Frame(title);
    }

    public void start(){
        this.window.setSize(400,350);
        this.window.setLocation(150, 150);
        this.window.setVisible(true);
        this.window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
