/**
 * 
 * @author Marc Lussier
 * Period 7
 * BankAccountClass
 *
 */
public abstract class BankAccount
{
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	
	/**
	 * 
	 * @param name
	 * constructor w/o starting balance
	 */
	public BankAccount(String n)
	{
		name = n;
		acctNum = nextAccNum + 1;
		nextAccNum++;
		balance = 0;
	}
	
	/**
	 * 
	 * @param name
	 * @param balance
	 * constructor w/ starting balance
	 */
	public BankAccount(String n, double b)
	{
		name = n;
		acctNum = nextAccNum + 1;
		nextAccNum++;
		balance = b;
	}
	
	/**
	 * 
	 * @param amt
	 * no return, deposit $
	 */
	public void deposit(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance + amt;
	}
	
	/**
	 * 
	 * @param amt
	 * no return, withdraw $
	 */
	public void withdraw(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance - amt;
	}
	
	/**
	 * no parameter
	 * @return name of acc
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * no parameter
	 * @return balance of acc
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * abstract- in others
	 */
	public abstract void endOfMonthUpdate();
	
	/**
	 * 
	 * @param other acc
	 * @param amount they want to transfer
	 * no return
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(getBalance() >= 0)
		{
			if(amt >= 0)
			{
				this.withdraw(amt);
				other.deposit(amt);
			}
			else
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
		return;
	}
	
	/**
	 * no parameter
	 * returns info
	 */
	public String toString()
	{
		return "Account Number: " + acctNum + "	" + "Name: " + name + "	" + "Balance: $" + balance;
	}
	
	/**
	 * 
	 * @return # of account
	 */
	public int getAccNum()
	{
		return acctNum;
	}
	

}
