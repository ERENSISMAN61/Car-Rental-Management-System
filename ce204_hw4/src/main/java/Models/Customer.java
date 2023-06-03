/**
 * @file Customer.java
 * 
 * @package Models
 * 
 * @brief Represents a customer user.
 * 
 * The `Customer` class represents a customer user in the system. It is a subclass of the `User` class
 * and inherits its properties and methods. A customer user has additional attributes such as the date
 * when they obtained their driver's license.
 * 
 * @details The `Customer` class is a subclass of the `User` class and represents a customer user in the system.
 * It inherits the properties and methods of the `User` class. A customer user has a first name, last name,
 * username, and password. 
 *
 */
package Models;

import java.time.LocalDate;
/**
 * 
 * @name Customer
 * 
 * @brief Represents a customer user.
 * 
 **/
public class Customer extends User  {


    private LocalDate licenceObtained;
    /**
     * 
     * @name Customer
     * 
     * @brief Constructs a new Customer object with default values.
     * 
     **/
    public Customer() {

    }
    
    /**
     * 
     * @name Customer
     * 
     * @brief Constructs a new Customer object with the specified details.
     * 
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param userName The username of the customer.
     * @param password The password of the customer.
     * @param licenceObtained The date when the customer obtained their driver's licence.
     * 
     **/
    
    public Customer(String firstName, String lastName, String userName, String password, 
    		String licenceObtained) {
        super(firstName, lastName, userName, password);


        this.licenceObtained = LocalDate.parse(licenceObtained);

    }



    /**
     * 
     * @name LocalDate
     * 
     * @brief Gets the date when the customer obtained their driver's licence.
     * 
     * @retval [\b String ] The date when the customer obtained their driver's licence.
     * 
     **/
    public LocalDate getLicenceObtained() {
        return licenceObtained;
    }
    
    /**
     * 
     * @name setLicenceObtained
     * 
     * @brief Sets the date when the customer obtained their driver's licence.
     * 
     * @param licenceObtained The date when the customer obtained their driver's licence.
     * 
     **/
    public void setLicenceObtained(LocalDate licenceObtained) {
        this.licenceObtained = licenceObtained;
    }
}