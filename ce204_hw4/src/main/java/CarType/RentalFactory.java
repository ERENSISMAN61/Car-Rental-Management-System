/**
 * @file RentalFactory.java
 * 
 * @package CarType
 * 
 * @brief A factory class for creating rental cars.
 * 
 * The `RentalFactory` class is responsible for creating rental cars based on the specified car type
 * and parameters. It provides a static method `createCar` that takes the car type and parameters as
 * inputs and returns an object that implements the `CarFeaturesInterface`.
 * 
 * @details The `RentalFactory` class is a factory class used for creating rental cars. It provides a
 * static method `createCar` that takes the car type, brand, model, car year, fuel type, color, price,
 * and number of seats as inputs. 
 *
 */
package CarType;

import ServicesInterface.*;

import java.util.Scanner;
/**
 * 
 * @name RentalFactory
 * 
 * @brief A factory class for creating rental cars.
 **/
public class RentalFactory {

    /**
     * 
     * @name CarFeaturesInterface
     * 
     * @brief Creates a rental car based on the specified car type and parameters.
     * @param carType The type of the car.
     * @param brand The brand of the car.
     * @param model The model of the car.
     * @param carYear The year of the car.
     * @param fuelType The fuel type of the car.
     * @param color The color of the car.
     * @param price The price of the car.
     * @param seatsNumber The number of seats in the car.
     * 
     * @retval[\b String ] The created car object implementing the CarFeaturesInterface.
     * 
     **/
	public static CarFeaturesInterface createCar(String carType,String brand, String model, int carYear, String fuelType, String color,int price, int seatsNumber) {
		switch (carType) {
		case "cabrio":
			return new Model_Cabrio(brand,model,carYear,fuelType,color,price,seatsNumber);
		case "hatchback":
			return new Model_Hatchback(brand,model,carYear,fuelType,color,price,seatsNumber);
		case "pickup":
			return new Model_PickUp(brand,model,carYear,fuelType,color,price,seatsNumber);
		case "sedan":
			return new Model_Sedan(brand,model,carYear,fuelType,color,price,seatsNumber);
		case "stationwagon":
			return new Model_StationWagon(brand,model,carYear,fuelType,color,price,seatsNumber);
		case "suv":
			return new Model_SUV(brand,model,carYear,fuelType,color,price,seatsNumber);
		}
		return null;

	}

}
