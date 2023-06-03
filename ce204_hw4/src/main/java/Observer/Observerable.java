/**
 * @file Observerable.java
 *
 * @package  Observer
 *
 * @brief Represents an observable subject.
 *
 * The `Observerable` class represents an observable subject. It maintains a list of observers and provides methods to add/remove
 * observers and notify all observers in the list.
 *
 * @details The `Observerable` class includes a constructor to initialize a new `Observerable` object. It initializes the observer
 * list as an empty `ArrayList`. The class also includes methods to add an observer to the list, remove an observer from the list,
 * and notify all observers in the list. When notifying observers, the `update` method of each observer is called with the current
 * `Observerable` object as the argument.
 */
package Observer;

import java.util.ArrayList;
import java.util.List;

import ServicesInterface.Observer;

public class Observerable {
  private List<Observer> observerList;
  /**
   *
   * @name Observerable
   *
   * @brief Constructs a new Observable object.
   **/
  public Observerable() {
    observerList = new ArrayList<>();
  }
  /**
   *
   * @name addObserver
   *
   * @brief Adds an observer to the list of observers.
   *
   * @param observer The observer to be added.
   **/
  public void addObserver(Observer observer) {
    observerList.add(observer);
  }
  /**
   *
   * @name removeObserver
   *
   * @brief Removes an observer from the list of observers.
   *
   * @param observer The observer to be removed.
   **/
  public void removeObserver(Observer observer) {
    observerList.remove(observer);
  }
  /**
   *
   * @name notifyObservers
   *
   * @brief Notifies all observers in the list.
   **/
  public void notifyObservers() {
    for (Observer observer : observerList) {
      observer.update(this);
    }
  }
}

