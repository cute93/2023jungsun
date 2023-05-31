package kr.ms.ccms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class ChangeTextEvent implements ActionListener{
    private int num;
    public ChangeTextEvent(){
        num = 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click버튼이 클릭되었습니다...");
        JButton instance = (JButton)e.getSource();
        num++;
        instance.setText(""+num+"");
    }
    public void reset(){
        this.num = 0;
    }

}
