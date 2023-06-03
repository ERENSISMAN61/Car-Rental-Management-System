/**
 * @file Observer.java
 *
 */
package ServicesInterface;


import Observer.Observerable;

public interface Observer {
  /**
   *
   * @name update
   *
     * @brief Update the observer with new information from the observable.
     *
     * @param observable The observable object.
     **/
  void update(Observerable observable);
}


