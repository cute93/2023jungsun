package kr.ms.ccms;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJWindow extends JFrame {
    private JButton btn_click;
    private JButton btn_exit;
    private JButton btn_reset;
    private JPanel pane_south;
    private ChangeTextEvent chlistener;

    public MyJWindow(){
        super("JButton!");
        this.btn_click = new JButton("0");
        this.btn_click.setFont(new Font("Arial",0,20));
        this.btn_exit = new JButton("Exit");
        this.btn_reset = new JButton("Reset");
        this.pane_south = new JPanel();
        this.chlistener = new ChangeTextEvent();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,400,200);
    }
    public void start(){
        add(btn_click);
        pane_south.add(btn_reset);
        pane_south.add(btn_exit);
        add(pane_south, BorderLayout.SOUTH);
        btn_exit.addActionListener(new ExitListener());
        btn_click.addActionListener(new clickListener());
        btn_reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = "";
                name = JOptionPane.showInputDialog(rootPane, 
                "확인을 입력하세요..", 
                "초기화확인", 
                JOptionPane.QUESTION_MESSAGE);
                if(name.equals("확인")){
                    btn_click.setText("0");
                }
            }
            
        });
        setVisible(true);
    }
    class clickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            btn_click.setText(""+(Integer.parseInt(btn_click.getText())+1));
        }
        
    }
}
