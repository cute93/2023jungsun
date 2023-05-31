import javax.swing.JLabel;
import javax.swing.JSlider;

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
            label.setText("[]"+slide.getValue()+"]");
        }
        System.out.println("done : "+getName()+Thread.activeCount());
    }
}