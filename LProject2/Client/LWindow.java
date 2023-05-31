import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LWindow extends JFrame {
    private JPanel mainPane;
    private JPanel sPane;
    private ArrayList<JLabel> labels;
    private ArrayList<Integer> nums;
    private JButton play;
    private JButton exit;
    

    public LWindow(){
        super("LClient 0.1.1");
        mainPane = new JPanel();
        sPane = new JPanel();
        labels = new ArrayList<JLabel>();
        nums = new ArrayList<Integer>();
        Font f = new Font("바탕",Font.BOLD, 30);
        for(int i=0; i<6; i++){
            JLabel temp = new JLabel("n"+(i+1));
            temp.setFont(f);
            labels.add(temp);
        }
        play = new JButton("GetNumber");
        exit = new JButton("Exit");
        setBounds(100 , 100, 400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void start(){
        
        for(JLabel l:labels) mainPane.add(l);
        sPane.add(play);

        exit.addActionListener(new ExitListener());
        sPane.add(exit);
        add(mainPane);
        add(sPane, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LWindow().start();
    }
}
