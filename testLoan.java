import java.util.*;

public class testLoan{

	
	
	public static void main(String[] args){
	Loan loan = new Loan();
	boolean check = true;
	Scanner input = new Scanner(System.in);
	
	do{
		try{
			System.out.print("Please enter the number of years: ");
			int years = input.nextInt();
		
			loan.setNumberOfYears(years);
			check = false;
		}
		catch (IllegalArgumentException ex){
			System.out.print(ex);
			System.out.println();
		}
	}while(check);
	
	check = true;
	
	do{
		try{
			System.out.print("Please enter the loan amount: ");
			double loanAmount = input.nextDouble();
			
			loan.setLoanAmount(loanAmount);
			check = false;
		}
		catch (IllegalArgumentException ex){
			System.out.print(ex);
			System.out.println();
		}
	}while(check);
	
	check = true;
	
	do{
		try{
			System.out.print("Please enter the annual interest rate: ");
			double annualInterestRate = input.nextDouble();
			
			loan.setAnnualInterestRate(annualInterestRate);
			check = false;
		}
		catch (IllegalArgumentException ex){
			System.out.print(ex);
			System.out.println();
		}
	}while(check);
	
	System.out.println("Your monthly payment is " + loan.getMonthlyPayment());
	System.out.println("Your total payment is " + loan.getTotalPayment());
	System.out.println(loan.getLoanDate());
	}
}



class Loan {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years and loan amount 
    */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate(){
	
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException  {
    if(annualInterestRate > 0)
		this.annualInterestRate = annualInterestRate;
	else
		throw new IllegalArgumentException("annual interest rate can not be negative");
  }

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears */
  public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException  {
    if(numberOfYears > 0)
		this.numberOfYears = numberOfYears;
	else
		throw new IllegalArgumentException("number of years can not be negative"); 
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) throws IllegalArgumentException  {
    if(loanAmount > 0)
		this.loanAmount = loanAmount;
	else
		 throw new IllegalArgumentException("loan amount can not be negative"); 
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    return monthlyPayment;    
  }

  /** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}
