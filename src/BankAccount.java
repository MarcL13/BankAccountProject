/**
 * 
 * @author Marc Lussier
 * Period 7
 * BankAccountClass
 *
 */
public abstract class BankAccount
{
	/**
	 * fields
	 */
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	
	/**
	 * constructor w/o starting balance
	 * @param n		name
	 */
	public BankAccount(String n)
	{
		name = n;
		acctNum = nextAccNum + 1;
		nextAccNum++;
		balance = 0;
	}
	
	/**
	 * constructor w/ starting balance
	 * @param n		name
	 * @param b		balance
	 */
	public BankAccount(String n, double b)
	{
		name = n;
		acctNum = nextAccNum + 1;
		nextAccNum++;
		balance = b;
	}
	
	/**
	 * deposits amt to this bank account
	 * @param amt	funds to deposit
	 */
	public void deposit(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance + amt;
	}
	
	/**
	 * withdraws amt from this bank account
	 * @param amt	funds to withdraw 
	 */
	public void withdraw(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance - amt;
	}
	
	/**
	 * gets name of this bank account
	 * @return name of acc
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets balance of this bank account
	 * @return balance of acc
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * abstract- different in sub classes
	 */
	public abstract void endOfMonthUpdate();
	
	/**
	 * transfer amt from this account to other
	 * @param other  bank account to transfer funds to
	 * @param amt	 funds to transfer from this account
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
	 * returns this account info
	 * @return account infor- number, name, balance
	 */
	public String toString()
	{
		return "Account Number: " + acctNum + "	" + "Name: " + name + "	" + "Balance: $" + balance;
	}
	
	/**
	 * returns this account number
	 * @return # of account
	 */
	public int getAccNum()
	{
		return acctNum;
	}
	

}
