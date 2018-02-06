import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 * 
 * @author Swanand
 *Instance for running the entire code
 */
public class Instance extends JFrame{
	 private List<Card> cards;
	    private Card selectedCard;
	    private Card first;
	    private Card second;
	    private Timer t;
	    /**
	     *     Constructor which carries out all operations.
	     */
	public Instance() {
		// TODO Auto-generated constructor stub
		
        List<Card> cardsList = new ArrayList<Card>();
        List<Color> cardColors = new ArrayList<Color>();
        
            cardColors.add(Color.GREEN);
            cardColors.add(Color.GREEN);
            cardColors.add(Color.RED);
            cardColors.add(Color.RED);
            cardColors.add(Color.ORANGE);
            cardColors.add(Color.ORANGE);
            cardColors.add(Color.YELLOW);
            cardColors.add(Color.YELLOW);
            cardColors.add(Color.BLUE);
            cardColors.add(Color.BLUE);
            cardColors.add(Color.MAGENTA);
            cardColors.add(Color.MAGENTA);
                
        Collections.shuffle(cardColors);//eliminated the use of Raandomiser I was going to use according to my design
        
        for (Color a : cardColors)
        {
            Card c = new Card();
            
            c.setColor(a);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    clickClick();
                }});
            cardsList.add(c);
        }
        this.cards = cardsList;

        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkState();
            }
        });

        t.setRepeats(false);


         int pairs = 6;
         int toBeDiv = 2 * pairs;
        
         int len1 = 1;
         
         while((toBeDiv/len1 - len1)>1)
         {
        	 len1++;
         }
         
         int len2 = toBeDiv/len1;
         
        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(len1, len2));
        for (Card c : cards){
            pane.add(c);
            c.setBackground(Color.GRAY);
        }
        setTitle("Memory Match");
    }
	
	/**
	 * onclick event for card being clicked
	 */
	public void clickClick()
	{
        if (first == null && second == null){
        	first = selectedCard;
            //c1.setText(String.valueOf(c1.getId()));
        	first.setBackground(first.getColor());
        	first.setState(1);
        	
        	
        }

        if (first != null && first != selectedCard && second == null){
        	second = selectedCard;
        	second.setBackground(second.getColor());
        	second.setState(1);
        	
        	
        	t.start();
            
        	//this.waitTime();
        	//checkCards();

        }
    }
	
	/**
	 * checks for the colors being a match
	 */
    public void checkState(){
        if (first.getColor() == second.getColor()){//match condition
        	
            if (this.checkEnd()){
                JOptionPane.showMessageDialog(this, "Game Ends");
                
                System.exit(0);
                
            }
           
        }

        else{
        	
        	
        	first.setBackground(Color.GRAY);
            first.setState(0);
        	second.setBackground(Color.GRAY);
        	second.setState(0);
        }
        first = null;
        second = null;
    }

    /**
     *  
     * @return true if all matches completed, false if not
     */
    public boolean checkEnd(){
        for(Card c: this.cards){
            if (c.getState() == 0){
                return false;
            }
        }
        return true;
    }  
        
		
	}


