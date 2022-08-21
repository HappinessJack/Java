package jack.com;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class TrickWindows extends JFrame{
    private int i4 ;
    public TrickWindows(){
this.randomFrame();
    }
    public void randomFrame(){
       while(true){
            Random r = new Random() ;
            Random r1 = new Random() ;
      int i =      r.nextInt(1920) ;
           int i1 = r1.nextInt(1080) ;
        JFrame randomFrame = new JFrame() ;
JTextField stopInstruction = new JFormattedTextField() ;
stopInstruction.setBounds(125,5,100,20);
randomFrame.add(stopInstruction) ;
        randomFrame.setBounds(i,i1,400,200);
        randomFrame.setLayout(null);
        randomFrame.setDefaultCloseOperation(3);
        randomFrame.setAlwaysOnTop(true);
        JButton breakButton = new JButton("Stop") ;
        breakButton.setBounds(125,10,50,50);
breakButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
String i3 = stopInstruction.getText() ;
 i4 = Integer.parseInt(i3) ;

    }
});

        randomFrame.add(breakButton) ;
        if(i4>0){
            break;
        }
        randomFrame.setVisible(true);


    }
}}
public class ATrick {
    public static void main(String[] args) {
        new TrickWindows();
    }
}