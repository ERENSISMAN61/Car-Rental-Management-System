/**
 * @file Customers.java
 * 
 * @package  Observer 
 *
 * @brief Represents a customer as an observer.
 * 
 * The `Customers` class implements the `Observer` interface and represents a customer as an observer. It provides methods to update the customer with the remaining time for delivery and retrieve the number of notifications received by the customer.
 * 
 * @details The `Customers` class implements the `Observer` interface and represents a customer as an observer. It includes a
 * constructor to initialize the customer with the given name and a notification count of 0. The class also implements the `update`
 * method from the `Observer` interface, which updates the customer with the remaining time for delivery. The remaining time is
 * retrieved from the observable object, which is cast to a `Timer` object. The `update` method prints a message to the console
 * indicating the remaining time for delivery and increments the notification count. The class includes a method to retrieve the
 * number of notifications received by the customer.
 */
package Observer;

import ServicesInterface.Observer;

public class Customers implements Observer {
    private String name;
    private int notificationCount;
    /**
     * @name Customers
     * 
     * @brief Constructs a new Customers object with the given name.
     * 
     * @param name The name of the customer.
     **/
    public Customers(String name) {
        this.name = name;
        this.notificationCount = 0;

    }
    /**
     * @name update
     * 
     * @brief Updates the customer with the remaining time for delivery.
     * 
     * @param observable The observable object.
     **/
    @Override
    public void update(Observerable observable) {
        Timer timer = (Timer) observable;
        System.out.println("Hello " + name + ", " + timer.getRemainingTime() + " days left for your delivery");
        notificationCount++;
    }
    /**
     * @name getNotificationCount
     * 
     * @brief Retrieves the number of notifications received by the customer.
     * 
     * @retval[\b int] int The number of notifications.
     **/
    public int getNotificationCount() {
        return notificationCount;
    }
}