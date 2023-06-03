/**
 * @file Bill.java
 *
 * @package PaymentSystem
 * 
 * @brief Represents a bill for car purchase.
 * 
 * The `Bill` class represents a bill for car purchase. It includes a static method to display the bill with the car details
 * and payment type.
 * 
 * @details The `Bill` class includes a static method `displayBill` to display the bill with the specified car features and
 * payment type. It prints the car brand, model, year, fuel type, color, price, seats number, and the payment type in a formatted
 * manner.
 */
package PaymentSystem;

import ServicesInterface.CarFeaturesInterface;

public class Bill {

	private String paymentType;
	private CarFeaturesInterface carFeatures;
	
	/**
	 * @name displayBill
	 * 
	 * @brief Displays the bill with car details and payment type.
	 * 
	 * This static method displays the bill with the specified car features and payment type. It prints the car brand, model, year, fuel type, 
	 * color, price, seats number, and the payment type in a formatted manner.
	 * 
	 * @param car The car features interface representing the car details.
	 * @param paymentType The type of payment used for the car purchase.
	 **/
	public static void displayBill(CarFeaturesInterface car, String paymentType) {
		System.out.print("+---------------------------------------------+\n" +
                "|             	     BILL  	                  |\n" +
                "+---------------------------------------------+\n\n" +
                "Car Brand: " + car.getBrand().toUpperCase() + "\n" +
                "Car Model: " + car.getModel().toUpperCase() + "\n" +
                "Car Year: " + car.getCarYear() + "\n" +
                "Car Year: " + car.getFuelType().toUpperCase() + "\n" +
                "Car Year: " + car.getColor().toUpperCase() + "\n" +
                "Car Year: " + car.getPrice() + "\n" +
                "Car Year: " + car.getSeatsNumber() + "\n" +
                "Paymet Type: " + paymentType + "\n\n" +
                "+---------------------------------------------+\n" +
                "+---------------------------------------------+\n\n");
	}
}
