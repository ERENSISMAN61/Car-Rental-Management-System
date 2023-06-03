/**
 * @file PaymentStrategy.java
 *
 */
package ServicesInterface;

public interface PaymentStrategy {
  /**
  * @name CollectPaymentDetails
   * @brief Collects the payment details from the user.
   */
  void CollectPaymentDetails();
  /**
   * @name ValidatePaymentDetails
   * @brief Validates the payment details.
   * @retval [\b String] true if the payment details are valid, false otherwise.
   */
  boolean ValidatePaymentDetails();
  /**
   * @name pay
   * @brief Performs the payment for a given amount.
   * @param amount The amount to be paid.
   */
  void pay(int amount);

}