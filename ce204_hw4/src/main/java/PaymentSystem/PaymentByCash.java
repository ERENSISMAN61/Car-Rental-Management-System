/**
*
* @file PaymentByCash.java
*
* @package PaymentSystem
*
* @brief This file contains the implementation of the PaymentByCash class.
*
* @details The PaymentByCash class is a concrete implementation of the PaymentStrategy interface.
*   It represents a payment method where the customer pays in cash.
*
*/
package PaymentSystem;

import ServicesInterface.PaymentStrategy;

public class PaymentByCash implements PaymentStrategy {
  /**
   * @name CollectPaymentDetails
   *
     * @brief Collects the payment details for cash payment.
     */
  @Override
  public void CollectPaymentDetails() {
    // TODO Auto-generated method stub
  }
  /**
   * @name ValidatePaymentDetails
   *
     * @brief Validates the payment details for cash payment.
     *
     * @retval [\b String]  true if payment details are valid, false otherwise.
     *
     */
  @Override
  public boolean ValidatePaymentDetails() {
    // TODO Auto-generated method stub
    return true;
  }
  /**
   * @name pay
   *
     * @brief Performs the cash payment.
     *
     * @param amount The amount to be paid.
     *
     **/
  @Override
  public void pay(int amount) {
    // TODO Auto-generated method stub
    System.out.println("Paying " + amount + " using Cash.");
    System.out.println("Car Rented");
  }

}