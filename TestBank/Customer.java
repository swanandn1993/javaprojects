
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String name;
    private String id;
    private static int count1 = 0;
    private BankAccount myAccount;
    
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String a)
    {
        // initialise instance variables
        count1++;
        name = a;
        id="c"+count1;
        
        
    }
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public void addAccount(BankAccount obj)
    {
        myAccount = obj;
        
        
    }
    public double getAssetTotal()
    {
        return myAccount.getBalance();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
