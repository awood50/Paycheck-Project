import java.util.*;//used to import the scanner in this class
/**
 * This driver class will display and use the methods that were created in the PayCheck class
 * It will display essentially the person's paycheck and the pay before and after taxes along 
 * with the amount of taxes that are taken out, along with the name
 * 
 * @author Andrew Wood 
 * @version 2/8/17
 */
public class Driver
{
    public static void main(String[] args)
    {
        
        Scanner input = new Scanner(System.in); //creates a new scanner object
        PayCheck person;
        person = new PayCheck(); //creates the object of the PayCheck class, which will be the user
        String firstName;//holds the user's first name
        String lastName;//hold's the user's last name
        double hoursWorked;//holds the number of hours worked
        double hourlyRate;//holds the pay rate
        char choice = 'y'; //used to determine if the user would like to enter in information again
        
        
        while(choice == 'y') //set equal to y so it will run at least once
        {
        System.out.println("Enter your first name ");
        firstName = input.next();//input from user for first name
        person.setFirstName(firstName); //Calls the set method from the PayCheck class
        
        System.out.println("Enter your last name: ");
        lastName = input.next();//input from user for last name
        person.setLastName(lastName);//Calls the set method from the PayCheck class
        
        System.out.println("Enter the number of hours you have worked: ");
        hoursWorked = input.nextDouble();//input from user for their hours worked
        person.setHoursWorked(hoursWorked);//Calls the set method from the PayCheck class
        
        System.out.println("Enter your hourly pay rate: ");
        hourlyRate = input.nextDouble();//input form user for their pay rate
        person.setHourlyRate(hourlyRate);//Calls the set method from the PayCheck class
        
        person.getFirstName(); //get method from the PayCheck class for first name
        person.getLastName(); //get method from the PayCheck class for last name
        person.getGrossPay();//get method from the PayCheck class for gross pay
        person.getFederalTaxAmount();//get method from the PayCheck class for federal tax amount
        person.getStateTaxAmount();//get method from the PayCheck class for state tax amount
        person.getFICAAmount();//get method from the PayCheck class for FICA amount
        person.getNetPay();//get method from the PayCheck class for final net pay
        
        System.out.println(person.toString( ) ); //calls the toString method from PayCheck class to create a textual representation of the object
        System.out.println("Would you like to enter in your information again? Enter y for yes");
        choice = input.next().charAt(0); //takes in input from the user in order to repeat or end the loop
    }
        
    }
}
