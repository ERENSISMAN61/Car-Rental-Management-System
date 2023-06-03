/**
*
*
*@file PaymentService.java
*@package PaymentSystem
*@brief A class representing the payment service for processing payment orders.
*@details The PaymentService class provides functionality for processing payment orders using a selected payment strategy. It allows setting and removing the cost of a car, *retrieving the total cost of the selected car, setting the index of the selected car, setting the payment strategy, and retrieving the list of costs.
*
*/
package PaymentSystem;

import java.util.ArrayList;
import java.util.List;

import ServicesInterface.CarFeaturesInterface;
import ServicesInterface.PaymentStrategy;

public class PaymentService {

	private List<Integer> costs = new ArrayList<>();
	private int carIndex;
	private PaymentStrategy strategy;
	/**
	 * 
	 * @name proccessOrder
	 * 
	 * @brief Processes the payment order using the selected payment strategy.
	 * 
	 **/
	public void proccessOrder() {
		strategy.CollectPaymentDetails();
		if (strategy.ValidatePaymentDetails()) {
			strategy.pay(getTotal());
		}

	}
	/**
	 * 
	 * @name setCost
	 * 
	 * @brief Sets the cost of a car.
	 * 
	 * @param costInput The cost to be added.
	 * 
	 **/
	public void setCost(int costInput) {
		costs.add(costInput);
	}
	/**
	 * 
	 * @name removeCost
	 * 
	 * @brief Removes the cost of a car.
	 * 
	 * @param costInput The cost to be removed.
	 * 
	 **/
	public void removeCost(int costInput) {
		costs.remove(costInput);

	}
	/**
	 * 
	 * @name getTotal
	 * 
	 * @brief Retrieves the total cost of the selected car.
	 * 
	 * @retval [\b String] The total cost of the selected car.
	 * 
	 **/
	public int getTotal() {
        return costs.get(carIndex); 
    }
	
	/**
	 * 
	 * @name setSelectedCarIndex
	 * 
	 * @brief Sets the index of the selected car.
	 * 
	 * @param carIndexInput The index of the selected car.
	 **/
	public void setSelectedCarIndex(int carIndexInput) {

		carIndex = carIndexInput;

	}
	/**
	 * 
	 * @name setStrategy
	 * 
	 * @brief Sets the payment strategy.
	 * 
	 * @param strategySelected The selected payment strategy.
	 * 
	 **/
	public void setStrategy(PaymentStrategy strategySelected) {
		// TODO Auto-generated method stub
		strategy = strategySelected;
	}
	/**
	 * 
	 * @name getCosts
	 * 
	 * @brief Retrieves the list of costs.
	 * 
	 * @retval [\b String] The list of costs.
	 **/
	public List<Integer> getCosts() {
        return costs;
    }

}
