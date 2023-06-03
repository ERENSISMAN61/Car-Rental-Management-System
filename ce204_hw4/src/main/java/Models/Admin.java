/**
 * @file Admin.java
 *
 * @package Models
 *
 * @brief Represents an admin user.
 *
 * The `Admin` class represents an admin user in the system. It is a subclass of the `User` class
 * and inherits its properties and methods. An admin user has additional privileges and can perform
 * administrative tasks in the system.
 *
 * @details The `Admin` class is a subclass of the `User` class and represents an admin user in the system.
 * It inherits the properties and methods of the `User` class.
 *
 */
package Models;

/**
 *
 * @name Admin
 *
 * @brief Represents an admin user.
 **/
public class Admin extends User {
  /**
   *
   * @name Admin
   *
     * @brief Constructs a new Admin object with the specified details.
     * @param firstName The first name of the admin.
     * @param lastName The last name of the admin.
     * @param userName The username of the admin.
     * @param password The password of the admin.
     *
     **/
  public Admin(String firstName, String lastName, String userName, String password) {
    super(firstName, lastName, userName, password);
  }

}
