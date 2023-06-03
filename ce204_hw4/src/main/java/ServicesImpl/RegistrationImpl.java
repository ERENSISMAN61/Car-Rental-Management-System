/**
*
*
*@file RegistrationImpl.java
*@package ServicesImpl
*@brief Implementation of the RegistrationService interface for handling registration in the car rental service.
*@details Initializes the RegistrationImpl object with the provided user list.
*
*
*/
package ServicesImpl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Models.*;
import ServicesInterface.RegistrationService;

public class RegistrationImpl implements RegistrationService {

	public Scanner input = new Scanner(System.in);
	private List<User> userList;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public double diff;

	public RegistrationImpl(List<User> userList) {
		this.userList = userList;
	}
	/**
	 * @name customerRegistrationForm
	 * 
     * @brief Creates a new Customer object with the provided details.
     * 
     * @param firstName     The first name of the customer.
     * @param lastName      The last name of the customer.
     * @param userName      The username of the customer.
     * @param password      The password of the customer.    
     * @param licenceObtained The date when the customer obtained their license.
     * 
     * @retval The created Customer object.
     * 
     **/
	@Override
	public Customer customerRegistrationForm(String firstName, String lastName, String userName, String password,
			String licenceObtained) {
		return new Customer(firstName, lastName, userName, password, licenceObtained);
	}
	/**
	 * 
	 * @name customerRegistration
	 * 
     * @brief Performs the registration process for a customer.
     * 
     * @param customer The Customer object to be registered.
     * 
     **/
	@Override
	public void customerRegistration(Customer customer) {
		System.out.println("Registration complete!");
		userList.add(customer);
	}
	 /**
	  * 
     * @brief Initiates the registration process by taking user input.
     * 
     * @param loginService The LoginImpl object to be used for login functionality.
     * 
     **/
	@Override
	public void initiateRegistration(LoginImpl loginService) {

		System.out.println();
		displayRegistrationMenu();
		System.out.println("First Name:");
		String firstName = input.next();
		System.out.println("Last Name:");
		String lastName = input.next();
		System.out.println("Username:");
		String userName = input.next();
		System.out.println("Password:");
		String password = input.next();
		System.out.println("Licence obtained date:  Format: [yyyy-MM-dd]");
		System.out.println("(Must be at least 2 years)");
		String licenceObtained = input.next();
		try {
			Date date = dateFormat.parse(String.valueOf(licenceObtained));
			dateFormat = new SimpleDateFormat("EEE, yyyy MMM d");
			Date currentDate = new Date();
			DecimalFormat df = new DecimalFormat("#.##");
			long diffInMillies = Math.abs(currentDate.getTime() - date.getTime());
			diff = (double) (diffInMillies / (1000 * 60 * 60 * 24 * 365.25));
			System.out.println("Licence usage time: " + df.format(diff) + " year");

		} catch (ParseException e) {
			System.out.println("Parse Exception");
		}
		if (diff < 2) {
			System.out.println("License usage time is not enough");

		} else {
			customerRegistration(customerRegistrationForm(firstName, lastName, userName, password, licenceObtained));
		}
	}
	/**
     * @name displayRegistrationMenu
     * 
     * @brief Displays the registration menu.
     **/
	@Override
	public void displayRegistrationMenu() {
		System.out.println("+----------------------------------------------+");
		System.out.println("|                   REGISTER                   |");
		System.out.println("+----------------------------------------------+");
	}


}
