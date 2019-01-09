/**
 * 
 * @author Marc Lussier
 * Period 7
 *
 */
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions = 0;
	
	/**
	 * 
	 * @param n-name
	 * @param b-balance
	 * @param odf-overdraft fee
	 * @param tf-transaction fee
	 * @param freeTrans-# of transactions w/o additional fees
	 * constructor w/starting balance
	 */
	public CheckingAccount(String n, double b, double odf, double tf, double freeTrans)
	{
		super(n,b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;	
	}

	/**
	 * 
	 * @param n-name
	 * @param odf-overdraft fee
	 * @param tf-transaction fee
	 * @param freeTrans-# of transactions w/o additional fees
	 * constructor w/o starting balance
	 */
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	/**
	 * parameter amount of $
	 * no return, deposit $
	 */
	public void deposit(double amt)
	{
		if(amt <= 0)
			throw new IllegalArgumentException();
		else
		{
			if(numTransactions < FREE_TRANS)
			{
				super.deposit(amt);
				numTransactions ++;
			}
			else
			{
				super.deposit(amt - TRANSACTION_FEE);
				numTransactions ++;
			}
		}
	}
	
	/**
	 * parameter amount of $
	 * no return, withdraw $
	 */
	public void withdraw(double amt)
	{
		if(amt <= 0 || getBalance() < 0)
			throw new IllegalArgumentException();
		if(getBalance() > 0)
		{
			super.withdraw(amt);
			
			if(numTransactions >= FREE_TRANS)
				super.withdraw(TRANSACTION_FEE);
			if(getBalance() < 0)
				super.withdraw(OVER_DRAFT_FEE);
			numTransactions++;
		}
	}
	
	/**
	 * parameter other bank acc
	 * parameter amount of $
	 * no return, transfer $ to other bank acc
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(other.getName().equals(getName()))
		{
			if(getBalance() >= amt + TRANSACTION_FEE)
			{
				super.transfer(other, amt + TRANSACTION_FEE);
				numTransactions++;
			}
			else
				throw new IllegalArgumentException();
		}
		else
			throw new IllegalArgumentException();
		return;
	}
	
	/**
	 * resets # of transactions to 0
	 * no return value
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
		return;
	}
	
	

}
