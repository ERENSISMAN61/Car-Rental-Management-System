/**
 * @file User.java
 *
 * @package Models
 *
 * @brief Represents a user in the system.
 *
 * The `User` class represents a user in the system. It is a superclass for other user types such as admin and customer.
 * It provides common attributes and methods that are shared by all user types.
 *
 * @details The `User` class is a superclass that represents a user in the system. It provides common attributes such as
 * first name, last name, username, and password, as well as methods to get and set these attributes.
 *
 */
package Models;

public class User {


  protected String firstName;
  protected String lastName;
  protected String userName;
  protected String password;
  /**
   * @name User
   *
   * @brief Constructs a User object with the specified details.
   *
   * @param firstName The first name of the user.
   * @param lastName The last name of the user.
   * @param userName The username of the user.
   * @param password The password of the user.
   *
   **/
  public User(String firstName, String lastName, String userName, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
  }
  /**
   * @name User
   *
   * @brief Constructs an empty User object.
   **/
  public User() {
  }
  /**
   * @name getFirstName
   *
   * @brief Retrieves the first name of the user.
   *
   * @retval [\b String ] String The first name of the user.
   **/
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @name setFirstName
   *
   * @brief Sets the first name of the user.
   *
   * @param firstName The first name of the user.
   *
   **/
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
   * @name getLastName
   *
   * @brief Retrieves the last name of the user.
   *
   * @retval [\b String ] String The last name of the user.
   *
   **/
  public String getLastName() {
    return lastName;
  }
  /**
   * @name setLastName
   *
   * @brief Sets the last name of the user.
   *
   * @param lastName The last name of the user.
   *
   **/
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
   * @brief Retrieves the username of the user.
   * @retval [\b String ] String The username of the user.
   */
  public String getUserName() {
    return userName;
  }
  /**
   *
   * @name setUserName
   *
   * @brief Sets the username of the user.
   *
   * @param userName The username of the user.
   *
   **/
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /**
   *
   * @name getPassword
   *
   * @brief Retrieves the password of the user.
   *
   * @retval [\b String ] String The password of the user.
   *
   */
  public String getPassword() {
    return password;
  }
  /**
   *
   * @name setPassword
   *
   * @brief Sets the password of the user.
   *
   * @param password The password of the user.
   *
   **/
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * @name toString
   *
   * @brief Returns a string representation of the User object.
   *
   * @retval [\b String ] String A string representation of the User object.
   *
   */
  @Override
  public String toString() {
    return "User{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", userName='" + userName + '\'' +
           ", password='" + password + '\'' +
           '}';
  }
}
