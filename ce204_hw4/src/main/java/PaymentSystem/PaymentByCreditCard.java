/**
 *
 * @file PaymentByCreditCard.java
 *
 * @package PaymentSystem
 *
 * @brief Collects the payment details for credit card payment.
 * @details This method collects the payment details for credit card payment,
 *          such as the credit card number, expiration date, and CVV.
 **/
package PaymentSystem;
import ServicesInterface.PaymentStrategy;

public class PaymentByCreditCard implements PaymentStrategy {

    private CreditCard card;
    private int totalBalance = 500;

    /**
     * @name CollectPaymentDetails
     * 
     * @brief Collects the payment details for credit card payment.
     **/
    @Override
    public void CollectPaymentDetails() {
        // TODO Auto-generated method stub
        card = new CreditCard("1111222233334444", "05/27", "123");

    }
    /**
     * @name ValidatePaymentDetails
     * 
     * @brief Validates the payment details for credit card payment.
     * 
     * @retval true if payment details are valid, false otherwise.
     * 
     **/
    @Override
    public boolean ValidatePaymentDetails() {
        // TODO Auto-generated method stub

        return true;
    }
   
    public CreditCard getCard() {
        return card;
    }
    /**
     * @name pay
     * 
     * @brief Performs the credit card payment.
     * 
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(int amount) {
        // TODO Auto-generated method stub
        System.out.println("Paying " + amount + " using Credit Card.");
        setAmount(getAmount() - amount);
        System.out.println(getAmount() +" remanined in the card.");
		System.out.println("Car Rented");


    }
    /**
     * @name getAmount
     * 
     * @brief Retrieves the total balance on the credit card.
     * 
     * @retval The total balance on the credit card.
     **/
    public int getAmount() {
        // TODO Auto-generated method stub
        return totalBalance;
    }
    /**
     * @name setAmount
     * 
     * @brief Sets the total balance on the credit card.
     * 
     * @param The new total balance to be set.
     * 
     **/
    public void setAmount(int i) {
        // TODO Auto-generated method stub
        totalBalance = i;
    }

}