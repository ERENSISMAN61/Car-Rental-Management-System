/**
 * @file Model_Hatchback.java
 *
 * @package CarType
 *
 * @brief A class representing a Hatchback model car.
 *
 * This class represents a specific type of car called Hatchback. It implements the CarFeaturesInterface,
 * which provides methods to access various features of a car.
 *
 * @details The `Model_Hatchback` class represents a specific type of car called Hatchback. It is initialized
 * with the provided brand, model, car year, fuel type, color, price, and number of seats. These values are
 * used to set the corresponding attributes of the `Model_Hatchback` object.
 */
package CarType;

import ServicesInterface.*;

/**
 *
 * @brief A class representing a Hatchback model car.
 *
 */
public class Model_Hatchback implements CarFeaturesInterface {

  private String brand;
  private String model;
  private int carYear;
  private String fuelType;
  private String color;
  private int price;
  private int seatsNumber;

  /**
  *
  * @name Model_Hatchback
  *
   * @brief Constructs a Hatchback model car with the given parameters.
   *
   * @param brand The brand of the car.
   * @param model The model of the car.
   * @param carYear The year of the car.
   * @param fuelType The fuel type of the car.
   * @param color The color of the car.
   * @param price The price of the car.
   * @param seatsNumber The number of seats in the car.
   *
   **/
  public  Model_Hatchback(String brand, String model, int carYear, String fuelType, String color,int price, int seatsNumber) {
    this.brand = brand;
    this.model = model;
    this.carYear = carYear;
    this.fuelType = fuelType;
    this.color = color;
    this.price = price;
    this.seatsNumber = seatsNumber;
  }

  /**
   *
   * @name getBrand
   *
     * @brief Gets the brand of the car.
     *
     * @retval [\b String ] brand. The brand of the car.
     *
     **/
  @Override
  public String getBrand() {
    // TODO Auto-generated method stub
    return brand;
  }

  /**
   *
   * @name getModel
   *
     * @brief Gets the model of the car.
     *
     * @retval [\b String ] model. The model of the car.
     *
     **/
  @Override
  public String getModel() {
    // TODO Auto-generated method stub
    return model;
  }

  /**
   *
   * @name getCarYear
   *
     * @brief Gets the year of the car.
     *
     * @retval [\b String ] carYear. The year of the car.
     *
     **/
  @Override
  public int getCarYear() {
    // TODO Auto-generated method stub
    return carYear;
  }

  /**
   *
   * @name getFuelType
   *
     * @brief Gets the fuel type of the car.
     *
     * @retval [\b String ] fuelType. The fuel type of the car.
     *
     **/
  @Override
  public String getFuelType() {
    // TODO Auto-generated method stub
    return fuelType;
  }

  /**
    *
  * @name getColor
  *
    * @brief Gets the color of the car.
    *
    * @retval [\b String ] color. The color of the car.
    *
    **/
  @Override
  public String getColor() {
    // TODO Auto-generated method stub
    return color;
  }

  /**
   *
   * @name getPrice
   *
     * @brief Gets the price of the car.
     *
     * @retval price. The price of the car.
     *
     **/
  @Override
  public int getPrice() {
    // TODO Auto-generated method stub
    return price;
  }

  /**
   *
   * @name getSeatsNumber
   *
     * @brief Gets the number of seats in the car.
     *
     * @retval The number of seats in the car.
     *
     **/
  @Override
  public int getSeatsNumber() {
    // TODO Auto-generated method stub
    return seatsNumber;
  }
}
