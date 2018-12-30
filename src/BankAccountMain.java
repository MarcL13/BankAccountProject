import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Marc Lussier
 * Period 7
 *
 */

public class BankAccountMain
{
	private static boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	
	public static void main(String[] args)	
	{	
		final double OVER_DRAFT_FEE = 15;
		final double RATE = 0.0025;
		final double TRANSACTION_FEE = 1.5;
		final double MIN_BAL = 300;
		final double MIN_BAL_FEE = 10;
		final int FREE_TRANSACTIONS = 10;
		
		//making array list and scanner
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		Scanner in = new Scanner(System.in);
		
		//prompt for add, transaction, terminate
		System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
		System.out.println("Enter Add, Transaction, or Terminate");
		System.out.println("Answer: ");
		String ans1 = "Add";
		String ans2 = "Transaction";
		String ans3 = "Terminate";
		String answer = in.next();
		in.nextLine();
		while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
			{
				System.out.println("Not valid answer.  Choose again: ");
				answer = in.next();
				in.nextLine();
			}
		
		//Not terminate
		if(!answer.equals(ans3))
		{
			//add account
			while(answer.equals(ans1))
			{
				System.out.println("Do you want a savings or checking account? Please enter Savings or Checking.");
				System.out.println("Answer:");
				String acc1 = "Savings";
				String acc2 = "Checking";
				String type = in.next();
				in.nextLine();
			
				//not either
				while(!type.equals(acc1) && !type.equals(acc2))
				{
					System.out.println("Not valid answer.  Choose again: ");
					type = in.next();
					in.nextLine();
				}
				//savings
				if(type.equals(acc1))
				{
					System.out.println("Do you want a starting balance? Please enter Yes or No.");
					String startBal = in.next();
					in.nextLine();
					//neither
					while(!startBal.equals("Yes") && !startBal.equals("No"))
					{
						System.out.println("Not valid answer.  Choose again: ");
						startBal = in.next();
						in.nextLine();
					}
					//with starting balance
					if(startBal.equals("Yes"))
					{
						System.out.println("Please enter Name and Initial Balance.");
						System.out.println("Name: ");
						String name1 = in.next();
						in.nextLine();
						System.out.println("Initial Balance:" );
						String iniBal = in.next();
						in.nextLine();
						while(!isNumeric(iniBal))
						{
							System.out.println("Not valid answer.  Choose again: ");
							iniBal = in.next();
							in.nextLine();
						}
						while(isNumeric(iniBal))
						{
							double bal = Double.parseDouble(iniBal);
							accounts.add(new SavingsAccount(name1, bal, RATE, MIN_BAL, MIN_BAL_FEE));
							System.out.println("Thank you.  Your account has been added.");
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.next();
							in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.next();
								in.nextLine();
							}
						}
																	
					}
					//without starting balance
					if(startBal.equals("No"))
					{
						System.out.println("Please enter Name.");
						System.out.println("Name: ");
						String name2 = in.next();
						in.nextLine();
						accounts.add(new SavingsAccount(name2, RATE, MIN_BAL, MIN_BAL_FEE));
						System.out.println("Thank you.  Your account has been added.");
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.next();
						in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.next();
							in.nextLine();
						}
					}
				
				}
				
				//checking
				if(type.equals(acc2))
				{
					System.out.println("Do you want a starting balance? Please enter Yes or No.");
					String startBal = in.next();
					in.nextLine();
					//neither
					while(!startBal.equals("Yes") && !startBal.equals("No"))
					{
						System.out.println("Not valid answer.  Choose again: ");
						startBal = in.next();
						in.nextLine();
					}
					//with starting balance
					if(startBal.equals("Yes"))
					{
						System.out.println("Please enter Name and Initial Balance.");
						System.out.println("Name: ");
						String name1 = in.next();
						in.nextLine();
						double iniBal;
						System.out.println("Initial Balance:" );
						iniBal = in.nextDouble();
						in.nextLine();
						while(!in.hasNextDouble())
						{
							System.out.println("Not valid answer.  Choose again: ");
							iniBal = in.nextDouble();
							in.nextLine();
						}
						if(in.hasNextDouble())
						{
							accounts.add(new CheckingAccount(name1, iniBal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
							System.out.println("Thank you.  Your account has been added.");
						}
																	
					}
					//without starting balance
					if(startBal.equals("No"))
					{
						System.out.println("Please enter Name.");
						System.out.println("Name: ");
						String name2 = in.next();
						in.nextLine();
						accounts.add(new CheckingAccount(name2, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
						System.out.println("Thank you.  Your account has been added.");
					}
				
				}
		
			}
			
			//transaction
			while(answer.equals(ans2))
			{
				//no accounts
				if(accounts.size() == 0)
				{
					System.out.println("There are no accounts to make a transaction.  Please start over and add an account(s) first.");
					System.exit(0);
				}
				//with accounts
				System.out.println("Would you like to withdraw, deposit, transer, or get an Account Number?");
				System.out.println("Please enter Withdraw, Deposit, Transfer, or Get");
				System.out.println("Answer: ");
				String response = in.next();
				in.nextLine();
				if(!response.equals("Withdraw") && !response.equals("Deposit") && !response.equals("Transfer") && !response.equals("Get"))
				{
					System.out.println("Invalid answer.  Enter again: ");
					response = in.next();
					in.nextLine();
				}
				switch(response)
				{
				//withdraw
				case "Withdraw" :
				{
					System.out.println("Which account would you like to access?  Please enter the account number.");
					System.out.println("Answer: ");
					int num = in.nextInt();
					for(BankAccount a : accounts)
					{
						while(accounts.size() == 0)
						{
							
						}
					}
					
				}
				}
			}
		}
		

	}

}
