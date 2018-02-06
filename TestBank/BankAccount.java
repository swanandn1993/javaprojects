
/**
 * Write a description of class BankAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankAccount
{
    // instance variables - replace the example below with your own
    private String accountNumber;
    private double balance;
    private static int count = 0;
    private BankAccount overdraft;

    /**
     * Constructor for objects of class BankAccount
     */
    public BankAccount(double bal)
    {
        // initialise instance variables
        count++;
        this.balance = bal;
        accountNumber="b"+count;
    }
    public void setOverdraftAccount(BankAccount obj)
    {
        overdraft = obj;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amt)
    {
        balance = balance + amt;
    }
    public void withdraw(double amt)
    {
        if(amt<balance)
        {
            balance = balance - amt;
        }
        else
        {
            double excess=amt - balance;
            double i =0;
            while(i<excess)
            {
                i=i+50;
            }
            balance = balance + i - amt;
            overdraft.withdraw(i);
        }
        
    }
    public void transfer(double amt, BankAccount obj)
    {
        if(balance>amt)
        {
            withdraw(amt);
            obj.deposit(amt);
            
        }
        
        
        
    }
    
}
