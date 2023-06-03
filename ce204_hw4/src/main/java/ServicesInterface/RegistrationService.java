/**
 * @file RegistrationService.java
 *
 */
package ServicesInterface;

import Models.*;
import ServicesImpl.LoginImpl;

public interface RegistrationService {
  /**
   * @name customerRegistrationForm
   *
     * @brief Creates a customer registration form with the provided details.
     *
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param userName The username of the customer.
     * @param password The password of the customer.
     * @param licenceObtained The date when the customer obtained the license.
     *
     * @retval [\b String] The customer registration form.
     *
     **/
  Customer customerRegistrationForm (String firstName, String lastName, String userName, String password,
                                     String licenceObtained);
  /**
   * @name customerRegistration
   *
   * @brief Registers a customer.
   *
   * @param customer The customer to be registered.
   *
   **/
  void customerRegistration(Customer customer);
  /**
   * @name initiateRegistration
   *
   * @brief Initiates the registration process.
   *
   * @param loginService The login service instance.
   *
   **/
  void initiateRegistration(LoginImpl loginService);
  /**
   * @name displayRegistrationMenu
   *
   * @brief Displays the registration menu.
   *
   **/
  void displayRegistrationMenu();

}
