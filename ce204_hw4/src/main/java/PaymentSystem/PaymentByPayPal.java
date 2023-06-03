/**
 * @file PaymentByPayPal.java
 * 
 * @brief A class representing the PayPal payment method.
 * 
 * @details The `PaymentByPayPal` class implements the `PaymentStrategy` interface and represents the PayPal payment method. It provides functionality to collect payment details,       *  validate payment details, and perform a payment using PayPal. The class also includes methods to retrieve the total balance in the PayPal account and the PayPal account details.
 * 
 * @package PaymentSystem
 */
package PaymentSystem;

import ServicesInterface.PaymentStrategy;

public class PaymentByPayPal implements PaymentStrategy {

	private PayPal payPalCard;
	private int totalBalance = 350;
	/**
	 * @name CollectPaymentDetails
	 * 
	 * @brief Collects the payment details for PayPal payment.
	 **/
	@Override
	public void CollectPaymentDetails() {
		// TODO Auto-generated method stub
		
		payPalCard = new PayPal("erenselam@gmail.com", "1234password");
	}
	/**
	 * @name ValidatePaymentDetails
	 * 
	 * @brief Validates the payment details for PayPal payment.
	 * 
	 * @retval [\b String] true if payment details are valid, false otherwise.
	 **/
	@Override
	public boolean ValidatePaymentDetails() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * @name pay
	 * 
	 * @brief Performs the PayPal payment.
	 * 
	 * @param amount The amount to be paid.
	 * 
	 **/
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Paying " + amount + " using PayPal.");
		setAmount(getAmount() - amount);
		System.out.println(getAmount() + " remanined in the card.");
		System.out.println("Car Rented");
	}
	/**
	 * @name getAmount
	 * 
	 * @brief Retrieves the total balance in the PayPal account.
	 * 
	 * @retval [\b int] The total balance in the PayPal account.
	 */
	public int getAmount() {
		// TODO Autsso-generated method stub
		return totalBalance;
	}
	/**
	 * @name setAmount
	 * 
	 * @brief Sets the total balance in the PayPal account.
	 * 
	 * @param i The new total balance to be set.
	 **/
	public void setAmount(int i) {
		// TODO Auto-generated method stub
		totalBalance = i;
	}
	/**
	 * @name getPayPalCard
	 * 
	 * @brief Retrieves the PayPal account details.
	 * 
	 * @retval [\b PayPal] The PayPal account details.
	 */
	public PayPal getPayPalCard() {
		return payPalCard;
	}

}
