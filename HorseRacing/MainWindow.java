import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.xml.stream.events.StartDocument;

public class MainWindow extends JFrame {
    private JPanel racingPanel;    
    private JPanel controPanel;

    private JLabel name1;
    private JLabel name2;
    private JLabel name3;
    private JSlider sl1Slider;
    private JSlider sl2Slider;
    private JSlider sl3Slider;
    private JLabel lvalue1;
    private JLabel lvalue2;
    private JLabel lvalue3;
    private JLabel result;
    
    private JButton starButton;
    private JButton exiButton;

    public MainWindow(){
        super("Racing Horse!");
        racingPanel = new JPanel();
        name1 = new JLabel("Racing");
        name2 = new JLabel("School");
        name3 = new JLabel("Kingen");
        sl1Slider = new JSlider(0,100,0);
        sl2Slider = new JSlider(0,100,0);
        sl3Slider = new JSlider(0,100,0);
        lvalue1 = new JLabel("  0");
        lvalue2 = new JLabel("  0");
        lvalue3 = new JLabel("  0");
        racingPanel.add(name1);
        racingPanel.add(sl1Slider);
        racingPanel.add(lvalue1);
        racingPanel.add(name2);
        racingPanel.add(sl2Slider);
        racingPanel.add(lvalue2);
        racingPanel.add(name3);
        racingPanel.add(sl3Slider);
        racingPanel.add(lvalue3);
        result = new JLabel("                  ");
        racingPanel.add(result);
        add(racingPanel);

        controPanel = new JPanel();
        starButton = new JButton("Start");
        exiButton = new JButton("Exit");
        starButton.setSize(100, 70);
        exiButton.setSize(100, 70);
        controPanel.add(starButton);
        controPanel.add(exiButton);
        add(controPanel, BorderLayout.SOUTH);
    }
    public void display(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        exiButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                sl1Slider.setValue(0);
                sl2Slider.setValue(0);
                sl3Slider.setValue(0);
                result.setText("                  ");
                new Horse(name1.getText(), sl1Slider, lvalue1).start();
                new Horse(name2.getText(), sl2Slider, lvalue2).start();
                new Horse(name3.getText(), sl3Slider, lvalue3).start();
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainWindow().display();
    }

    

    public class Horse extends Thread{
        private JSlider slide;
        private JLabel label;
        public Horse(String n, JSlider s, JLabel l){
            super(n);
            slide = s;
            label = l;
        }
        public void run(){
            while(slide.getValue()<slide.getMaximum()){
                slide.setValue(slide.getValue()+1);
                label.setText(+slide.getValue()+"");
                try {
                    Thread.sleep((int)(Math.random()*300));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("done : "+getName()+Thread.activeCount());
            if(Thread.activeCount()==5){
                result.setText(getName()+" Win!!!!");
            }
        }
    }
}
