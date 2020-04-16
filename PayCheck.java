import java.text.*;
/**
 * This class creates all of the fields necessary to determine this user's paycheck. It's methods are 
 * used to calculate the tax deductions while also figuring out gross and net pay based on the entered
 * hours worked and rate of pay.
 * 
 * @author Andrew Wood 
 * @version 2/7/17
 */
public class PayCheck
{
    private double hourlyRate;
    private double hoursWorked;
    private double grossPay;
    private double netPay;
    private double federalTaxAmount;
    private double stateTaxAmount;
    private double FICAAmount;
    private String lastName;
    private String firstName;
    
    private final double FEDERAL_TAX_RATE;
    private final double STATE_TAX_RATE;
    private final double FICA_RATE;
    

    /**
     * Constructor for objects of class PayRoll. Sets all
     * values to either 0 or unknown except for the constants
     * which are a set amount.
     */
    public PayCheck()
    {
       hourlyRate = 0;
       hoursWorked = 0;
       grossPay = 0;
       netPay = 0;
       federalTaxAmount = 0;
       stateTaxAmount = 0;
       FICAAmount = 0;
       lastName = "unknown";
       firstName = "unknown";
       
       FEDERAL_TAX_RATE = 0.15; //These constants are set amounts that are final
       STATE_TAX_RATE = 0.09;
       FICA_RATE = 0.07;
       
    }

    /**
     * This method allows the user to set the inital values of the fields
     * 
     * @param double the hourly rate that can be entered by the user
     * @param double the hours the individual has worked that they can enter
     * @param String the individual's last name
     * @param String the individual's first name
     * @param double the federal rate variable that is equal to the constant
     * @param double the state rate varialbe that is equal to the constant
     * @param double the FICA rate variable that is equal to the constant
     */
    public void PayCheck(double inHourlyRate, double inHoursWorked,  String inFirstName, String inLastName, double inFederalRate, double inStateRate, double inFICARate)
    {
        hourlyRate = inHourlyRate;
        hoursWorked = inHoursWorked;   
        
        lastName = inLastName;
        firstName = inFirstName;
        inFederalRate = FEDERAL_TAX_RATE; //Although the constants are final, you can set these variables equal to the constant
        inStateRate = STATE_TAX_RATE;
        inFICARate = FICA_RATE;
        
    }
    /**This method sets the last name equal to what the user enters
     * @param string  will be used to hold the user's last name
     */
    public void setLastName(String inLastName)
    {
        lastName = inLastName;
        
    }
     /**This method sets the first name equal to what the user enters
     * @param string  will be used to hold the user's first name
     */
     public void setFirstName(String inFirstName)
    {
        firstName = inFirstName;
        
    }
     /**This method sets the hourly rate to what the user enters
      * It also checks to make sure the entered values are within correct parameters
      * @param double used to hold the entered hourly rate value
      */
    public void setHourlyRate(double inHourlyRate)
    {
        if(inHourlyRate >= 5 || inHourlyRate <= 100)
        {
            hourlyRate = inHourlyRate;
        }
        else
        {
            hourlyRate = 0;
        }
    }
     /**This method sets the hours worked to what the user enters\
      * It also checks to make sure the entered values are within the correct parameters
      * @param double used to hold the entered hours worked value
      */
    public void setHoursWorked(double inHoursWorked)
    {
        if(inHoursWorked >=0 || inHoursWorked <=80)
        {
            hoursWorked = inHoursWorked;
        }
        else
        {
            hoursWorked = 0;
        }
    }
     /**This method will return a textual representation of the state of the object
      * Will be called in the Driver class using a print statement
      * 
      */
    public String toString()
    {
          DecimalFormat df = new DecimalFormat("$#.00");
          return "First Name: " + firstName + "\nLast Name: " + lastName +  "\nGross Pay: " + df.format(grossPay) + "\nFederal Tax: " 
          + df.format(federalTaxAmount) + "\nState Tax: " + df.format(stateTaxAmount) + "\nFICA: " + df.format(FICAAmount) + "\nNet Pay: " + df.format(netPay);
    }
     /**This method returns the last name of the user that the user has entered
      * @return String the value of the user's last name
      */
    public String getLastName()
    {
        return lastName;
    }
     /**This methods returns the first name of the user that the user has entered
      * @return String the value of the user's first name
      */
    public String getFirstName()
    {
        return firstName;
    }
     /**This method returns the hourly rate that the user has entered
      * @return double the hourly rate at which the user gets paid at
      */
    public double getHourlyRate()
    {
        return hourlyRate;
    }
     /**This method returns the hours that the user has worked that they have entered
      * @return double the number of hours that the user has worked
      */
    public double getHoursWorked()
    {
        return hoursWorked;
    }
     /**This method calculates the gross pay based on how many hours the user has worked
      * and the rate at which they are paid. Calculated by multiplying the two values
      * @return double the overall gross pay of the user based on the calculations
      */
    public double getGrossPay()
    {
        grossPay = hoursWorked * hourlyRate; //calculated by multiplying the hours the user has worked by their pay rate
        return grossPay;
    }
     /**This method returns the amount of federal tax that will be deducted from the overall gross pay
      * @return double the amount of fedral tax to be deducted from the gross pay
      */
    public double getFederalTaxAmount()
    {
        federalTaxAmount = grossPay * FEDERAL_TAX_RATE; //calculated by the gross pay multiplied by the federal tax rate constant
        return federalTaxAmount;
    }
     /**This method calculates and returns that amount of state tax that will be deducted from the gross pay
      * @return double the amount of state tax that will be deducted from gross pay after calculation
      */
    public double getStateTaxAmount()
    {
        stateTaxAmount = grossPay * STATE_TAX_RATE; //calculated by the gross pay multiplied by the state tax final rate
        return stateTaxAmount;
    }
    /**This method calculates and returns the amount of FICA that will be deducted from the gross pay
      * @return double the amount of FICA that will be deducted from the gross pay after calculation
      */
    public double getFICAAmount()
    {
        FICAAmount = grossPay * FICA_RATE;//calculated by the gross pay multiplied by the FICA rate
        return FICAAmount;
    }
     /**This method returns the net pay, which is the amount that is left after all of the tax deductions
      * @return double the final amount that the indivudal will get paid after deductions
      */
    public double getNetPay()
    {
        netPay = grossPay-(federalTaxAmount + stateTaxAmount + FICAAmount); //calculated by subtracting all of the tax amounts from the previous methods
        return netPay;
    }
    
    
    
    
    
    
}
