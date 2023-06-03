/**
 * @file Timer.java
 *
 * @package  Observer
 *
 * @brief Represents a timer with remaining and reservation time.
 *
 * The `Timer` class represents a timer with remaining and reservation time. It extends the `Observerable` class and can notify
 * observers when the remaining time reaches the reservation time.
 *
 * @details The `Timer` class includes a constructor to initialize a new `Timer` object with the specified remaining and reservation
 * time. It also includes methods to get and set the remaining time of the timer.
 *
 */
package Observer;

public class Timer extends Observerable {
  private int remainingTime;
  private int reservationTime;
  /**
   * @name Timer
   *
   * @brief Constructs a new Timer object with the specified remaining time and reservation time.
   *
   * @param remainingTime The remaining time for the timer.
   *
   * @param reservationTime The reservation time for the timer.
   *
   **/
  public Timer(int remainingTime, int reservationTime) {
    this.remainingTime = remainingTime;
    this.reservationTime = reservationTime;
  }
  /**
   *
   * @name getRemainingTime
   *
   * @brief Gets the remaining time of the timer.
   *
   * @retval [\b int] The remaining time of the timer.
   **/
  public int getRemainingTime() {
    return remainingTime;
  }
  /**
   * @name setRemainingTime
   *
   * @brief Sets the remaining time of the timer and checks if it reaches zero or the reservation time.
   *
   * @param remainingTime The new remaining time for the timer.
   *
   **/
  public void setRemainingTime(int remainingTime) {
    this.remainingTime = remainingTime;

    if (remainingTime == 0) {
    } else {
      System.out.println(remainingTime);
    }

    checkRemainingTime();
  }

  private void checkRemainingTime() {
    if (remainingTime == 0) {
      System.out.println("You can take your car");
    } else if (remainingTime - reservationTime == 0) {
      notifyObservers();
    }
  }
}