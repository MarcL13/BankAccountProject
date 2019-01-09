/**
 * 
 * @author Marc Lussier
 * Period 7
 *
 */
public class CheckingAccount extends BankAccount
{
	/**
	 * fields
	 */
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions = 0;
	
	/**
	 * constructor w/starting balance
	 * @param n			name
	 * @param b			balance
	 * @param odf		overdraft fee
	 * @param tf		transaction fee
	 * @param freeTrans	# of transactions w/o additional fees
	 */
	public CheckingAccount(String n, double b, double odf, double tf, double freeTrans)
	{
		super(n,b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;	
	}

	/**
	 * constructor w/o starting balance
	 * @param n				name
	 * @param odf			overdraft fee
	 * @param tf			transaction fee
	 * @param freeTrans		# of transactions w/o additional fees
	 */
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	
	/**
	 * deposits funds into this bank account
	 * @param amt	 amount of $ to deposit
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
	 * withdraws funds from this bank account
	 * @param amt	 amount of $ to withdraw
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
	 * transfer amt from this account to other
	 * @param other bank acc to tansfer funds to
	 * @param amt   amount to transfer
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
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
		return;
	}
	
	

}
