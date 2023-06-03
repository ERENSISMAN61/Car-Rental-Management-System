/**
 * @file CarFeaturesInterface.java
 * 
 */
package ServicesInterface;


public interface CarFeaturesInterface {
	/**
	 * @name getBrand
	 * 
     * @brief Gets the brand of the car.
     * 
     * @retval [\b String] The brand of the car.
     * 
     **/
	 public String getBrand();
	  /**
	   * @name getModel
	   * 
	   * @brief Gets the model of the car.
	   * 
	   * @retval [\b String] The model of the car.
	   * 
	   **/
	 public String getModel ();
	  /**
	   * @name getCarYear
	   * 
	   * @brief Gets the year of the car.
	   * 
	   * @retval [\b String] The year of the car.
	   * 
	   **/
	 public int getCarYear();
	  /**
	   * @name getFuelType
	   * 
	   * @brief Gets the fuel type of the car.
	   * 
	   * @retval [\b String] The fuel type of the car.
	   * 
	   **/
	 public String getFuelType();
	  /** 
	   * @name getColor
	   * 
	   * @brief Gets the color of the car.
	   * 
	   * @retval [\b String] The color of the car.
	   * 
	   **/
	 public String getColor();
	 /** 
	   * @name getPrice
	   * 
       * @brief Gets the price of the car.
       * 
	   * @retval [\b String] The price of the car.
	   * 
	   */
	 public int getPrice();
	 /**
	   * @name getSeatsNumber
	   * 
	   * @brief Gets the number of seats in the car.
	   * 
	   * @retval [\b int] The number of seats in the car.
	   * 
	   **/
	 public int getSeatsNumber();
	 
}
