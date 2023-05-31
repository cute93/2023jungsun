package kr.ms.ccms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ExitListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("프로그램을 종료합니다!!!");
        System.exit(0);
    }    
    
}
