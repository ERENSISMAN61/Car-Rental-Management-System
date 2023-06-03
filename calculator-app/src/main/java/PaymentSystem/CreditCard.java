/**
 * @file CreditCard.java
 * 
 * @package PaymentSystem
 * 
 * @brief Represents a credit card used for payment.
 * 
 * The `CreditCard` class represents a credit card used for payment. It includes methods to retrieve the card number,
 * expiry date, and CVV of the credit card.
 *
 * @details The `CreditCard` constructor initializes the `cardNumber`, `expiryDate`, and `cvv` member variables
 *          with the provided input values.
 */
package PaymentSystem;

public class CreditCard {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    /**
     * 
     * @name CreditCard
     * 
     * @brief Constructs a new CreditCard object with the specified card number, expiry date, and CVV.
     * 
     * @param cardNumberInput The card number of the credit card.
     * @param expiryDateInput The expiry date of the credit card.
     * @param cvvInput The CVV (Card Verification Value) of the credit card.
     * 
     **/
    public CreditCard(String cardNumberInput, String expiryDateInput, String cvvInput) {
        // TODO Auto-generated constructor stub
        cardNumber = cardNumberInput;
        expiryDate = expiryDateInput;
        cvv = cvvInput;
    }
    
    /**
     * @name getCardNumber
     * 
     * @brief Gets the card number of the credit card.
     * 
     * @retval [\b String] The card number of the credit card.
     **/
    public String getCardNumber() {
        return cardNumber;
    }
    /**
     * @name getExpiryDate
     * 
     * @brief Gets the expiry date of the credit card.
     * 
     * @retval [\b String]  The expiry date of the credit card.
     **/
    public String getExpiryDate() {
        return expiryDate;
    }
    /**
     * 
     * @name getCvv
     * 
     * @brief Gets the CVV (Card Verification Value) of the credit card.
     * 
     * @retval [\b String] The CVV of the credit card.
     * 
     **/
    public String getCvv() {
        return cvv;
    }
    
 
}