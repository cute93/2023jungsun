package kr.ms.ccms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;

public class ResetListener implements ActionListener{
    private JButton btn_target;
    public ResetListener(JButton){
        this.ch = c;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.ch.reset();
        (JButton)(ActionListener)this.ch).getSource();
    }
    
}
