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
		while(!answer.equals(ans3))
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
						//if balance is a string or negative
						while(!isNumeric(iniBal) || Double.parseDouble(iniBal) < 0)
						{
							System.out.println("Not valid amount.  Choose again: ");
							iniBal = in.next();
							in.nextLine();
						}
						//balance is good
						if(isNumeric(iniBal))
						{
							double bal = Double.parseDouble(iniBal);
							accounts.add(new SavingsAccount(name1, bal, RATE, MIN_BAL, MIN_BAL_FEE));
							System.out.println("Thank you.  Your account has been added.");
							//restart program
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
						//restart program
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
						System.out.println("Initial Balance: ");
						String iniBal = in.next();
						in.nextLine();
						//if balance is a string or negative
						while(!isNumeric(iniBal) || Double.parseDouble(iniBal) < 0)
						{
							System.out.println("Not valid amount.  Choose again: ");
							iniBal = in.next();
							in.nextLine();
						}
						//balance is good
						if(isNumeric(iniBal))
						{
							double bal = Double.parseDouble(iniBal);
							accounts.add(new CheckingAccount(name1, bal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
							System.out.println("Thank you.  Your account has been added.");
							//restart program
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
						accounts.add(new CheckingAccount(name2, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
						System.out.println("Thank you.  Your account has been added.");
						//restart program
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
		
			}
			
			//transaction
			while(answer.equals(ans2))
			{
				//no accounts
				if(accounts.size() == 0)
				{
					System.out.println("There are no accounts to make a transaction.  Please add an account first.");
					//restart program
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
				else
				{
					//with accounts
					System.out.println("Would you like to withdraw, deposit, transer, or get an Account Number?");
					System.out.println("Please enter Withdraw, Deposit, Transfer, or Get");
					System.out.println("Answer: ");
					String response = in.next();
					in.nextLine();
					while(!response.equals("Withdraw") && !response.equals("Deposit") && !response.equals("Transfer") && !response.equals("Get"))
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
						String num = in.next();
						in.nextLine();
						//if they enter acc# outside of # of accounts
						while(Integer.parseInt(num) > accounts.size())
						{
							System.out.println("That account does not exist.  Please try a different account: ");
							num = in.next();
							in.nextLine();
						}
						//acc #s negative or 0
						double testNum = -1;
						double testResult;
						try
						{
							testResult = Math.sqrt(Integer.parseInt(num)+testNum);
						}
						catch(IllegalArgumentException e)
						{
							System.out.println("That account does not exist.  Try again: ");
							num = in.next();
							in.nextLine();
						}
						try
						{
							testResult = Math.sqrt(Integer.parseInt(num) - accounts.size());
						}
						catch(ArrayIndexOutOfBoundsException b)
						{
							System.out.println("That account does not exist. Try again: ");
							num = in.next();
							in.nextLine();
						}
						
						
						
						
						
						//acc #s match
						while(Integer.parseInt(num) == accounts.get(Integer.parseInt(num)-1).getAccNum())
						{
							System.out.println("How much would you like to withdraw?  Enter amount: ");
							String amount = in.next();
							in.nextLine();
							//if they want to withdraw a string or negative
							while(!isNumeric(amount) || Double.parseDouble(amount) < 0)
							{
								System.out.println("Transaction not authorized. Try again: ");
								amount = in.next();
								in.nextLine();
							}
							//if withdraw amount is good
							while(isNumeric(amount))
							{
								double amt = Double.parseDouble(amount);
								//making sure account balance is not negative
								double testAmt = -1;
								
								try
								{
								testResult = Math.sqrt(accounts.get(Integer.parseInt(num)-1).getBalance());
								
								}
								catch(IllegalArgumentException e)
								{
									System.out.println("Your balance is negative.  Add funds before withdrawing.");
									amount = in.next();
									in.nextLine();
								}
								
								
						}
						}
					}	
				
				}
			}
		}
	}
	

}

}
