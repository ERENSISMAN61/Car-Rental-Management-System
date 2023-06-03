/**
 * @file App.java
 * 
 * @brief The main class of the application.
 * 
 *  @package App
 *  
 *  @details  The main method initializes the necessary components of the application,
 *   such as the list of users, menu display service, registration service, and login service.
 *    It creates an instance of the Shop class and passes the required objects to it. Finally, 
 *  	it calls the mainMenuController method of the Shop class to start the application.
 * 
 */
package App;

import ServicesImpl.*;
import java.util.ArrayList;
import java.util.List;
import Models.*;

/**
 * 
 * @name App
 * 
 * @brief The main class of the application.
 * 
 */

public class App {

   /**	 
     * 
     * @name main
     * 
     * @brief The main method of the application.
     * 
     * @param args The command-line arguments passed to the application.  
     *     
     **/
	
    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.addAll(UserDatabase.getAdminList());
        users.addAll(UserDatabase.getCustomerList());

        MenuImpl menuDisplayService = new MenuImpl();
        RegistrationImpl registrationService= new RegistrationImpl(users);
        LoginImpl loginService = new LoginImpl(users);

        
        Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
        
        shop.DefaultCars();
        shop.mainMenuController();
    }
	
	
	
}
