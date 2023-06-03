/**
 * @file LoginService.java
 *
 */
package ServicesInterface;

import Models.User;

public interface LoginService {
  /**
   * @name validateLogIn
   *
     * @brief Validates the login credentials of a user.
     *
     * @param userName The username of the user.
     * @param password The password of the user.
     *
     * @retval [\b String] The User object if the login is successful, otherwise null.
     *
     **/
  User validateLogIn(String userName, String password);
  /**
   *
   * @name doLogIn
   *
   * @brief Performs the login process for a user.
   *
   * @param userName The username of the user.
   * @param password The password of the user.
   *
   * @retval [\b String] The User object if the login is successful, otherwise null.
   **/
  User doLogIn(String userName, String password);
  /**
   *
   * @name isLoggedIn
   *
   * @brief Checks if a user is currently logged in.
   *
   * @param loggedInUser The User object representing the logged-in user.
   *
   * @retval [\b String] true if a user is logged in, false otherwise.
   **/
  boolean isLoggedIn(User loggedInUser);
  /**
   *
   * @name isLoggedInAsCustomer
   *
   * @brief Checks if a user is logged in as a customer.
   *
   * @param loggedInUser The User object representing the logged-in user.
   *
   * @retval [\b String] true if the user is logged in as a customer, false otherwise.
   *
   **/
  boolean isLoggedInAsCustomer(User loggedInUser);
  /**
   *
   * @name isLoggedInAsAdmin
   *
   * @brief Checks if a user is logged in as an admin.
   *
   * @param loggedInUser The User object representing the logged-in user.
   *
   * @retval [\b String] true if the user is logged in as an admin, false otherwise.
   *
   **/
  boolean isLoggedInAsAdmin(User loggedInUser);
  /**
   *
   * @name initiateLogIn
   *
   * @brief Initiates the login process for a user.
   *
   * @retval [\b String] The User object representing the logged-in user.
   *
   **/
  User initiateLogIn();
  /**
   *
   * @name displayLogInMenu
   *
   * @brief Displays the login menu.
   **/
  void displayLogInMenu();
  /**
   *
   * @name exitApp
   *
   * @brief Exits the application.
   **/
  void exitApp();


}
