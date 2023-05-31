package kr.ms.ccms;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyWindow extends Frame{
    public MyWindow(){
        this("Default Title");
    }
    public MyWindow(String title) {
        super(title);
    }

    public void start(){
        setLocation(50,50);
        setSize(400,200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        } );
    }
}