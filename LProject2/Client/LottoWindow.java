import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LottoWindow extends JFrame {
    private LClient client;
    private JPanel mainPane;
    private JPanel southPane;
    private ArrayList<JLabel> labels;
    private JButton get;
    private JButton exit;
    private JButton reset;
    private ArrayList<Integer> nums;
    int n;

    public LottoWindow(){
        super("Lotto생성기 Ver 0.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,350,150);
        setBackground(new Color(120,45,190));

        client = new LClient();
        mainPane = new JPanel();
        southPane = new JPanel();
        labels  = new ArrayList<JLabel>();
        Font f = new Font("굴림", Font.BOLD, 20);
        for(int i=0; i<6; i++){
            JLabel temp = new JLabel("");
            temp.setFont(f);
            labels.add(temp);
        }
        get = new JButton("Get!!");
        exit = new JButton("Exit");
        reset = new JButton("Reset");
        nums = new ArrayList<Integer>();
        n = 0;
        for(JLabel l:labels){
            mainPane.add(l);
        }
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Program Terminated!!");
                client.sendRequest(-1);
                client.finish();
                System.exit(0);
            }
            
        });
        get.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.sendRequest(1);
                int res = client.getResponse();
                if(res == -1){
                    client.finish();
                    System.exit(0);
                }
                if(n<6){
                    if(nums.contains(res)){
                        JOptionPane.showMessageDialog(rootPane, "중복된 값이 있습니다..");
                    }else{
                        nums.add(res);
                        n++;
                    }
                }
                if(n==6){
                    get.setEnabled(false);
                }
                Collections.sort(nums);
                for(int i=0; i<n; i++){
                    labels.get(i).setText(""+nums.get(i));
                }
            }
            
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nums.clear();
                for(JLabel l:labels){
                    l.setText("");
                }
                n = 0;
                get.setEnabled(true);
            }
            
        });
        southPane.add(get);
        southPane.add(reset);
        southPane.add(exit);
    }
    public void start(){
        add(mainPane);
        add(southPane, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LottoWindow().start();
    }
}
