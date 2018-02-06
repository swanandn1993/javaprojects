import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * @author Swanand
 *Eliminated Randomizer instead took this as main class because I found a method to 
 *randomise elements with an inbuilt method
 */
public class Game{
    public static void main(String[] args){
        Instance i = new Instance();
        i.setPreferredSize(new Dimension(1000,600));
        i.setLocation(50, 50);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i.pack();
        i.setVisible(true);
    }   
}