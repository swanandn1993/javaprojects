import java.awt.Color;
import javax.swing.JButton;

/**
 * 
 * @author Swanand
 *Card class which stores the info about the cards
 */
public class Card extends JButton{
    
    private Color newColor;
    private int state = 0;
    


    
    /**
     * Sets color of the card
     * @param currentColor is passed from constructor of Instance
     */
    public void setColor(Color currentColor)
    {
    	this.newColor = currentColor;
    }
    
    /**
     * sets State on condition of card facing up or down
     * @param a is passed to state. 1 if up 0 if down
     */
    public void setState(int a)
    {
    	state = a;
    }
    
    /**
     * Returns the current condition of card
     * @return state as 1 or 0
     */
    public int getState()
    {
    	return state;
    }
    
    /**
     * returns the color of the card
     * @return newColor 
     */
    public Color getColor(){
    	return this.newColor;
    }

   
}