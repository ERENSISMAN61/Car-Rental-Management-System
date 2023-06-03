/**
*
*
*@file LoginImpl.java
*@package ServicesImpl
*@brief Implementation of the LoginService interface for user login functionality.
*@details The LoginImpl class implements the LoginService interface and provides methods for validating login credentials, performing the login process, checking login status, and *displaying login menu.
*
*/
package ServicesImpl;

import Models.*;
import ServicesInterface.*;
import java.util.List;
import java.util.Scanner;


public class LoginImpl implements LoginService {



  public Scanner input = new Scanner(System.in);
  private List<User> userList;
  private User loggedInUser = null;
  /**
   *
   * @name LoginImpl
   *
   * @brief Constructs a new LoginImpl instance with the given user list.
   *
   * @param userList The list of users to be used for login validation.
   *
   */
  public LoginImpl(List<User> userList) {
    this.userList = userList;
  }
  /**
   *
   * @name getLoggedInUser
   *
   * @brief Retrieves the logged-in user.
   *
   * @retval The logged-in user.
   **/
  public User getLoggedInUser() {
    return loggedInUser;
  }

  /**
   *
   * @name validateLogIn
   *
   * @brief Validates the login credentials.
   *
   * @param userName The username entered for login.
   *
   * @param password The password entered for login.
   *
   * @retval The user object if the credentials are valid, null otherwise.
   *
   **/
  public User validateLogIn(String userName, String password) {
    for (User currentUser : userList) {
      if (userName.equals(currentUser.getUserName()) && password.equals(currentUser.getPassword())) {
        return currentUser;
      }
    }

    return null;
  }

  /**
   *
   * @name doLogIn
   *
   * @brief Performs the login process.
   *
   * @param userName The username entered for login.
   *
   * @param password The password entered for login.
   *
   * @retval The logged-in user.
   *
   **/
  public User doLogIn(String userName, String password) {
    if (validateLogIn(userName, password) instanceof Customer) {
      loggedInUser = validateLogIn(userName, password);
      System.out.println("Welcome " + loggedInUser.getFirstName() +
                         " " + loggedInUser.getLastName() + "!");
    } else if (validateLogIn(userName, password) instanceof Admin) {
      loggedInUser = validateLogIn(userName, password);
      System.out.println("Welcome " + loggedInUser.getFirstName() +
                         " " + loggedInUser.getLastName() + "!");
    }

    return loggedInUser;
  }

  /**
   *
   * @name exitApp
   *
   * @brief Displays an exit message.
   *
   **/
  public void exitApp() {
    System.out.println("Hope you'll be back soon!");
  }

  /**
   *
   * @name isLoggedIn
   *
   * @brief Checks if a user is logged in.
   *
   * @param loggedInUser The user to check.
   *
   * @retval true if the user is logged in, false otherwise.
   *
   **/
  public boolean isLoggedIn(User loggedInUser) {
    return loggedInUser != null;
  }

  /**
   *
   * @name isLoggedInAsCustomer
   *
   * @brief Checks if a user is logged in as a customer.
   *
   * @param loggedInUser The user to check.
   *
   * @retval true if the user is logged in as a customer, false otherwise.
   *
   **/
  public boolean isLoggedInAsCustomer(User loggedInUser) {
    return isLoggedIn(loggedInUser) && !loggedInUser.getUserName().equals("customer");
  }

  /**
   *
   * @name isLoggedInAsAdmin
   *
   * @brief Checks if a user is logged in as an admin.
   *
   * @param loggedInUser The user to check.
   *
   * @retval true if the user is logged in as an admin, false otherwise.
   *
   **/
  public boolean isLoggedInAsAdmin(User loggedInUser) {
    return isLoggedIn(loggedInUser) && loggedInUser.getUserName().equals("admin");
  }
  /**
   *
   * @name setLoggedInUser
   *
   * @brief Sets the logged-in user.
   *
   * @param loggedInUser The user to set as logged-in.
   **/
  public void setLoggedInUser(User loggedInUser) {
    this.loggedInUser = loggedInUser;
  }



  public User initiateLogIn() {
    User loggedIn;

    do {
      System.out.println();
      displayLogInMenu();
      System.out.println("Username:");
      String userName = input.nextLine();
      System.out.println("Password:");
      String password = input.nextLine();
      loggedIn = doLogIn(userName, password);

      if (isLoggedInAsCustomer(loggedIn) || isLoggedInAsAdmin(loggedIn)) {
        System.out.println("Login successfully!!!");
      } else {
        System.out.println("Wrong credentials! Please, try again!");
      }
    } while (!isLoggedIn(loggedIn));

    return loggedIn;
  }

  /**
   *
   * @name displayLogInMenu
   *
   * @brief Displays the login menu.
   *
   */
  public void displayLogInMenu() {
    System.out.println("+----------------------------------------------+");
    System.out.println("|                     LOGIN:                   |");
    System.out.println("+----------------------------------------------+");
  }

}
