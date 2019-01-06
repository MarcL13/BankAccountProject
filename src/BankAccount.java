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
	
	public BankAccount(String n)
	{
		name = n;
		acctNum = nextAccNum + 1;
		nextAccNum++;
		balance = 0;
	}
	
	public BankAccount(String n, double b)
	{
		name = n;
		acctNum = nextAccNum + 1;
		balance = b;
	}
	
	public void deposit(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance + amt;
	}
	
	public void withdraw(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException();
		else
			balance = balance - amt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
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
	
	public String toString()
	{
		return "Account Number: " + acctNum + "	" + "Name: " + name + "	" + "Balance: $" + balance;
	}
	
	public int getAccNum()
	{
		return acctNum;
	}
	

}
