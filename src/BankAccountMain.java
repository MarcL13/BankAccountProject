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
	
	private static boolean isAccNum(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(IllegalArgumentException a)
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
		String answer = in.nextLine();
		while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
			{
				System.out.println("Not valid answer.  Choose again: ");
				answer = in.nextLine();
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
				String type = in.nextLine();
			
				//not either
				while(!type.equals(acc1) && !type.equals(acc2))
				{
					System.out.println("Not valid answer.  Choose again: ");
					type = in.nextLine();
				}
				//savings
				if(type.equals(acc1))
				{
					System.out.println("Do you want a starting balance? Please enter Yes or No.");
					String startBal = in.nextLine();
					//neither
					while(!startBal.equals("Yes") && !startBal.equals("No"))
					{
						System.out.println("Not valid answer.  Choose again: ");
						startBal = in.nextLine();
					}
					//with starting balance
					if(startBal.equals("Yes"))
					{
						System.out.println("Please enter Name and Initial Balance.");
						System.out.println("Name: ");
						String name1 = in.nextLine();
						System.out.println("Initial Balance:" );
						String iniBal = in.nextLine();
						//if balance is a string or negative
						while(!isNumeric(iniBal) || Double.parseDouble(iniBal) < 0)
						{
							System.out.println("Not valid amount.  Choose again: ");
							iniBal = in.nextLine();
						}
						//balance is good
						if(isNumeric(iniBal))
						{
							double bal = Double.parseDouble(iniBal);
							SavingsAccount acc = new SavingsAccount(name1, bal, RATE, MIN_BAL, MIN_BAL_FEE);
							accounts.add(acc);
							System.out.println("Thank you.  Your account has been added.");
							System.out.println(acc.toString());
							//restart program
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.nextLine();
							}
						}
																	
					}
					//without starting balance
					if(startBal.equals("No"))
					{
						System.out.println("Please enter Name.");
						System.out.println("Name: ");
						String name2 = in.nextLine();
						SavingsAccount acc = new SavingsAccount(name2, RATE, MIN_BAL, MIN_BAL_FEE);
						accounts.add(acc);
						System.out.println("Thank you.  Your account has been added.");
						System.out.println(acc.toString());
						//restart program
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.nextLine();
						}
					}
				
				}
				
				//checking
				if(type.equals(acc2))
				{
					System.out.println("Do you want a starting balance? Please enter Yes or No.");
					String startBal = in.nextLine();
					//neither
					while(!startBal.equals("Yes") && !startBal.equals("No"))
					{
						System.out.println("Not valid answer.  Choose again: ");
						startBal = in.nextLine();
					}
					//with starting balance
					if(startBal.equals("Yes"))
					{
						System.out.println("Please enter Name and Initial Balance.");
						System.out.println("Name: ");
						String name1 = in.nextLine();
						System.out.println("Initial Balance: ");
						String iniBal = in.nextLine();
						//if balance is a string or negative
						while(!isNumeric(iniBal) || Double.parseDouble(iniBal) < 0)
						{
							System.out.println("Not valid amount.  Choose again: ");
							iniBal = in.nextLine();
						}
						//balance is good
						if(isNumeric(iniBal))
						{
							double bal = Double.parseDouble(iniBal);
							CheckingAccount acc = new CheckingAccount(name1, bal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
							accounts.add(acc);
							System.out.println("Thank you.  Your account has been added.");
							System.out.println("Your account: ");
							System.out.println(acc.toString());
							//restart program
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.nextLine();
							}
						}
																	
					}
					//without starting balance
					if(startBal.equals("No"))
					{
						System.out.println("Please enter Name.");
						System.out.println("Name: ");
						String name2 = in.nextLine();
						CheckingAccount acc = new CheckingAccount(name2, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
						accounts.add(acc);
						System.out.println("Thank you.  Your account has been added.");
						System.out.println(acc);
						//restart program
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.nextLine();
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
					answer = in.nextLine();
					while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
					{
						System.out.println("Not valid answer.  Choose again: ");
						answer = in.nextLine();
					}	
				}
				else
				{
					//with accounts
					System.out.println("Would you like to withdraw, deposit, transer, or get account number(s)?");
					System.out.println("Please enter Withdraw, Deposit, Transfer, or Get");
					System.out.println("Answer: ");
					String response = in.nextLine();
					while(!response.equals("Withdraw") && !response.equals("Deposit") && !response.equals("Transfer") && !response.equals("Get"))
					{
						System.out.println("Invalid answer.  Enter again: ");
						response = in.nextLine();
					}
					switch(response)
					{
					//deposit
					case "Deposit" :
					{
						System.out.println("Which account would you like to access?  Please enter the account number.");
						System.out.println("Answer: ");
						String num = in.nextLine();
						int acctNum = Integer.parseInt(num);
						
						//if they enter acc# outside of # of accounts, negative, or 0
						while(!isAccNum(num) || Integer.parseInt(num) > accounts.size() || Integer.parseInt(num) <= 0 )
						{
							System.out.println("That account does not exist.  Please try a different account: ");
							num = in.nextLine();
						}
						//finding correct acc
						BankAccount myAcc = null;
						for(BankAccount a : accounts)
						{
							if(Integer.parseInt(num) == a.getAccNum())
							{
								myAcc = a;
							}
						}
						System.out.println("How much would you like to deposit?  Enter amount: ");
						String amount = in.nextLine();
						//if they want to deposit a string
						while(!isNumeric(amount))
						{
							System.out.println("Transaction not authorized.  Choose again: ");
							amount = in.nextLine();
						}
						//try/catch to deposit 
						double amt = Double.parseDouble(amount);
						try
						{
							myAcc.deposit(amt);
							System.out.println("Thank you.  Your money has been deposited.");
							System.out.println(myAcc.toString());
						}
						catch(IllegalArgumentException e)
						{
							System.out.println("Transaction not authorized.");
						}
						//restart program
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.nextLine();
						}	
						break;
					}
					
					
					//withdraw
					case "Withdraw" :
					{
						System.out.println("Which account would you like to access?  Please enter the account number.");
						System.out.println("Answer: ");
						String num = in.nextLine();
						int acctNum = Integer.parseInt(num);
						
						//if they enter acc# outside of # of accounts, negative, or 0
						while(!isAccNum(num) || Integer.parseInt(num) > accounts.size() || Integer.parseInt(num) <= 0 )
						{
							System.out.println("That account does not exist.  Please try a different account: ");
							num = in.nextLine();
						}
						
						//finding correct acc
						BankAccount myAcc = null;
						for(BankAccount a : accounts)
						{
							if(Integer.parseInt(num) == a.getAccNum())
							{
								myAcc = a;
							}
						}
						System.out.println("How much would you like to withdraw? Enter amount: ");
						String amount = in.nextLine();
						//if they want to withdraw a string
						while(!isNumeric(amount))
						{
							System.out.println("Transaction not authorized.  Choose again: ");
							amount = in.nextLine();
						}
						//try/catch for withdraw
						double amt = Double.parseDouble(amount);
						try
						{
							myAcc.withdraw(amt);
							System.out.println("Thank you. Your money has been withdrawn.");
							System.out.println(myAcc.toString());
						}
						catch(IllegalArgumentException e)
						{
							System.out.println("Transaction not authorized.");
						}
						//restart program
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.nextLine();
						}	
						break;
						
					}
					
					//transfer
					case "Transfer" :
					{
						BankAccount acc1 = null;
						BankAccount acc2 = null;
						System.out.println("From which account would you like to take money from? Please enter the account number.");
						System.out.println("Account 1: ");
						String transferAcc = in.nextLine();
						//if account 1 don't work
						while(!isAccNum(transferAcc) || Integer.parseInt(transferAcc) > accounts.size() || Integer.parseInt(transferAcc) <= 0)
						{
							System.out.println("The account number you entered is not valid.  Try again: ");
							transferAcc = in.nextLine();
						}
						for(BankAccount a : accounts)
						{
							if(Integer.parseInt(transferAcc) == a.getAccNum())
							{
								acc1 = a;
							}
						}
						System.out.println("Which account do you want to transfer money to?  Please enter the account number.");
						System.out.println("Account 2: ");
						String receiveAcc = in.nextLine();
						//if account 2 don't work
						while(!isAccNum(receiveAcc) || Integer.parseInt(receiveAcc) > accounts.size() || Integer.parseInt(receiveAcc) <= 0)
						{
							System.out.println("The account number you entered is not valid.  Try again: ");
							receiveAcc = in.nextLine();
						}
						for(BankAccount b : accounts)
						{
							if(Integer.parseInt(receiveAcc) == b.getAccNum())
							{
								acc2 = b;
							}
						}
						//if names of accounts do not match
						if(!acc1.getName().equals(acc2.getName()))
						{
							System.out.println("Sorry, but those account names do not match.  In order for a transfer to occur, the names must be the same.");
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.nextLine();
							}	
							
						}
						else
						{
						//actual transfer
						System.out.println("How much do you want to transfer? Enter amount: ");
						String amount = in.nextLine();
						//if amount is string or less or equal to 0
						while(!isNumeric(amount) || Double.parseDouble(amount) <= 0)
						{
							System.out.println("Invalid amount.  Try again: ");
							amount = in.nextLine();
						}
						double amt = Double.parseDouble(amount);
						try
						{
							acc1.transfer(acc2, amt);
							System.out.println("Thank you. Your money has been transfered.");
							System.out.println(acc1.toString());
							System.out.println(acc2.toString());
						}
						catch(IllegalArgumentException e)
						{
							System.out.println("Transaction not authorized.");
						}
						//restart program
						System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
						System.out.println("Please enter Add, Transaction, or Terminate.");
						System.out.println("Answer: ");
						answer = in.nextLine();
						while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
						{
							System.out.println("Not valid answer.  Choose again: ");
							answer = in.nextLine();
						}	
						
					}
						break;
					}
					
					//get
					case "Get" :
					{
						ArrayList<BankAccount> accs = new ArrayList<BankAccount>();
						System.out.println("Which account would you like get? Enter name associated with account(s): ");
						String name = in.nextLine();
						for(BankAccount a : accounts)
						{
							if(name.equals(a.getName()))
							{
								accs.add(a);
							}
						}
						//there are matches
						if(accs.size() != 0)
						{
							for(BankAccount b : accs)
							{
								if(b instanceof SavingsAccount)
								{
									System.out.println("Account Type: Savings Account	");
									System.out.println(b.toString());
								}
								else if(b instanceof CheckingAccount)
								{
									System.out.println("Account  Type: Checking Account		");
									System.out.println(b.toString());
								}
							}
							//restart program
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.nextLine();
							}	
						}
						//no matches
						else if(accs.size() == 0)
						{
							System.out.println("There are no accounts associated with that name.");
							//restart program
							System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
							System.out.println("Please enter Add, Transaction, or Terminate.");
							System.out.println("Answer: ");
							answer = in.nextLine();
							while(!answer.equals(ans1) && !answer.equals(ans2) && !answer.equals(ans3))
							{
								System.out.println("Not valid answer.  Choose again: ");
								answer = in.nextLine();
							}	
						}
						
						break;
					}
				
				}
			}
		}
	}
		
		//terminate
		if(answer.equals(ans3))
		{
			System.out.println("Thank you for your business with Lussier Inc.  We hope to see you again.");
		}
	
	}
}
