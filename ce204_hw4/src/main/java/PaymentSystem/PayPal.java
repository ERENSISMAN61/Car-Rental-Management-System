/**
*
*
*@file PayPal.java
*@package PaymentSystem
*@brief A class representing a PayPal account.
*@details The PayPal class represents a PayPal account and provides functionality to retrieve the email and password associated with the account.
*
*/
package PaymentSystem;

public class PayPal {

  private String email;
  private String password;

  /**
   * @name PayPal
   *
   * @brief Constructs a new PayPal instance with the given email and password.
   *
   * @param emailInput The email associated with the PayPal account.
   * @param passwordInput The password associated with the PayPal account.
   **/
  public PayPal(String emailInput, String passwordInput) {
    // TODO Auto-generated constructor stub
    email = emailInput;
    password = passwordInput;
  }
  /**
   * @name getEmail
   *
   * @brief Retrieves the email associated with the PayPal account.
   *
   * @retval [\b String] The email associated with the PayPal account.
   **/
  public String getEmail() {
    return email;
  }
  /**
   * @name getPassword
   *
   * @brief Retrieves the password associated with the PayPal account.
   *
   * @retval [\b String]  The password associated with the PayPal account.
   **/
  public String getPassword() {
    return password;
  }
}