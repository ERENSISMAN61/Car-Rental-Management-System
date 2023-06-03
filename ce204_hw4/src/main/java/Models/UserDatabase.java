/**
 * @file UserDatabase.java
 *
 * @package  Models
 *
 * @brief Represents a database of users.
 *
 * The `UserDatabase` class represents a database of users in the system. It provides methods to retrieve lists of customers
 * and admins, as well as all users. It also includes a method to retrieve the balance of the shop.
 *
 * @details The `UserDatabase` class represents a database of users in the system. It includes methods to retrieve lists of
 * customers and admins, as well as all users. The class uses the `ArrayList` data structure to store the user objects. The
 * `UserDatabase` class also includes a method to retrieve the balance of the shop, which returns a long value.
 */
package Models;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {


  /**
   *
   * @name getCustomerList
   *
     * @brief Retrieves a list of customers.
     *
     * @retval [\b customerList ] List<User> A list of customer objects.
     *
     **/
  public static List<User> getCustomerList() {
    List<User> customerList = new ArrayList<>();
    customerList.add(new Customer("Semiha", "Akbaş", "s.akbas", "akbas61",
                                  "2017-06-15"));
    customerList.add(new Customer("Ali", "Şişman", "a.sisman", "alis61",
                                  "2012-01-05"));
    customerList.add(new Customer("Bahtiyar", "Kavuk", "bahtiyar.k", "bk6161",
                                  "2014-11-24"));
    customerList.add(new Customer("Batuhan", "Kaya", "batuhan.k", "12345",
                                  "2015-03-26"));
    return customerList;
  }
  /**
   *
  * @name getAdminList
   *
   * @brief Retrieves a list of admins.
   *
   * @retval [\b adminList ] List<User> A list of admin objects.
   **/
  public static List<User> getAdminList() {
    List<User> adminList = new ArrayList<>();
    adminList.add(new Admin("Eren", "ADMIN", "admin", "0000"));
    adminList.add(new Admin("ErenS", "ADMIN1", "admin", "admin"));
    adminList.add(new Admin("Resul", "ADMIN2", "admin", "123"));
    adminList.add(new Admin("ResulB", "ADMIN3", "admin", "1234"));
    adminList.add(new Admin("ErenS", "ADMIN4", "admin", "000"));
    return adminList;
  }
  /**
   * @name getAllUserList
   *
   * @brief Retrieves a list of all users (customers and admins).
   *
   * @retval[\b userList ] List<User> A list of all user objects.
   **/
  public static List<User> getAllUserList() {
    List<User> userList = getCustomerList();
    userList.addAll(getAdminList());
    return userList;
  }
  /**
   * @name getShopBalance
   *
   * @brief Retrieves the balance of the shop.
   *
   * @retval [\b String] long The balance of the shop.
   *
   **/
  public static long getShopBalance() {
    return 0;
  }

}
