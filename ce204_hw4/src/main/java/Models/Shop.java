/**
 * @file Shop.java
 * @package Models
 *
 * @brief Contains the classes representing the models of the car rental shop.
 *
 * @details The Models package contains the classes that represent the core models of the car rental shop.
 * These models include the Shop class, which represents the car rental shop itself,
 * and other related classes such as User, CarFeaturesInterface, and RentalFactory.
 *
 */
package Models;

import ServicesImpl.*;
import ServicesInterface.CarFeaturesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CarType.RentalFactory;
import Observer.Customers;
import Observer.Timer;
import PaymentSystem.Bill;
import PaymentSystem.PaymentByCash;
import PaymentSystem.PaymentByCreditCard;
import PaymentSystem.PaymentByPayPal;
import PaymentSystem.PaymentService;
/**
 * @name Shop
 * @brief Represents the car rental shop and its functionality.
 *
 * The Shop class manages the car rental system and provides functionalities for registration,
 * login, and menu control for both customers and administrators.
 * It maintains a list of rental cars, handles payment services, and displays menus for different user roles.
 *
 **/
public class Shop {
  public List<CarFeaturesInterface> rentalCars = new ArrayList<>();
  public Scanner INPUT = new Scanner(System.in);
  PaymentService paymentService = new PaymentService();
  PaymentByPayPal paymentByPayPal = new PaymentByPayPal();
  PaymentByCreditCard paymentByCreditCard = new PaymentByCreditCard();
  PaymentByCash paymentByCash = new PaymentByCash();

  public final MenuImpl MENU_DISPLAY_SERVICE;


  private LoginImpl loginService;
  private RegistrationImpl registrationService;


  /**
   * @name Shop
   *
   * @brief Constructor for the Shop class.
   *
   * @param userList The list of users in the system.
   * @param MENU_DISPLAY_SERVICE An instance of MenuImpl for displaying menus.
   * @param loginService An instance of LoginImpl for user login functionality.
   * @param registrationService An instance of RegistrationImpl for user registration functionality.
   */
  public Shop(List<User> userList, MenuImpl MENU_DISPLAY_SERVICE, LoginImpl loginService,
              RegistrationImpl registrationService) {
    this.MENU_DISPLAY_SERVICE = MENU_DISPLAY_SERVICE;
    this.loginService = loginService;
    this.registrationService = registrationService;
  }
  /**
   *
   * @name mainMenuController
   *
   * @brief Main menu controller for the shop.
   *
   * The mainMenuController displays the main menu and handles user interactions based on the selected options.
   */
  public void mainMenuController() {
    do {
      System.out.println();
      MENU_DISPLAY_SERVICE.showMainMenu();
      System.out.println("If you don't have an account yet, register now for free!");
      System.out.println("Please, choose your option from down below: ");
      int option = INPUT.nextInt();

      switch (option) {
        case 1: // Registration
          registrationService.initiateRegistration(loginService);
          break;

        case 2: // Login
          loginService.initiateLogIn();

          if (loginService.isLoggedInAsAdmin(loginService.getLoggedInUser())) {
            adminMenuController();
          } else {
            customerMenuController();
          }

          break;

        case 3: // Exit app
          loginService.exitApp();
          return;

        default: // In case of picking a wrong option
          System.out.println("Wrong option. Please, try again!");
          break;
      }
    } while (!loginService.isLoggedIn(loginService.getLoggedInUser()));
  }
  /**
   *
   * @name customerMenuController
   *
   * @brief Customer menu controller for the shop.
   *
   * The customerMenuController displays the customer menu and handles user interactions based on the selected options.
   */
  public void customerMenuController() {
    do {
      System.out.println();
      MENU_DISPLAY_SERVICE.showCustomerMenu();
      System.out.println("Please, choose your option from down below: ");
      int option = INPUT.nextInt();

      switch (option) {
        case 1: // Rent a Car
          System.out.println("\nRental Cars:\n");
          int i = 0;

          if (rentalCars.isEmpty()) {
            System.out.println("No cars available.");
          } else {
            for (CarFeaturesInterface rentalCar : rentalCars) {
              i++;
              System.out.println(
                "+------Brand---------Model-------Car Year-----Fuel Type----Color----Price---Number of Seats-------+\n");
              System.out.print(i + ". =>   ");
              displayCarFeatures(rentalCar);
            }

            Scanner scanner = new Scanner(System.in);
            int index;

            while (true) {
              System.out.println("\nEnter the index of the car: ");
              index = Integer.parseInt(scanner.nextLine());

              if (index >= 0 && index < rentalCars.size() + 1) {
                paymentService.setSelectedCarIndex(index - 1);
                break;
              } else {
                System.out.println("Invalid index!");
              }
            }

            int paymentType;

            while (true) {
              System.out.println("1 - Credit Card");
              System.out.println("2 - PayPal");
              System.out.println("3 - Cash");
              System.out.println("Choose the payment type:");
              paymentType = Integer.parseInt(scanner.next());

              if (paymentType == 1) {
                paymentService.setStrategy(paymentByCreditCard);
                Bill.displayBill(rentalCars.get(index - 1), "Credit Cart");
                break;
              } else if (paymentType == 2) {
                paymentService.setStrategy(paymentByPayPal);
                Bill.displayBill(rentalCars.get(index - 1), "PayPal");
                break;
              } else if (paymentType == 3) {
                paymentService.setStrategy(paymentByCash);
                Bill.displayBill(rentalCars.get(index - 1), "Cash");
                break;
              } else {
                return;
              }
            }

            paymentService.proccessOrder();
            paymentService.removeCost(index - 1);
            rentalCars.remove(index - 1);
            System.out.println("How many after days will you rent:");
            int Rentindex = Integer.parseInt(scanner.next());
            System.out.print("If you want to receive notifications and subscribe, press '1'.");
            int selecetSubs = Integer.parseInt(scanner.next());

            if (selecetSubs == 1) {
              Timer timer = new Timer(Rentindex, 2);
              Customers customer = new Customers("observer");
              timer.addObserver(customer);

              for (int a = timer.getRemainingTime(); a >= 0; a--) {
                timer.setRemainingTime(a);
              }
            }
          }

          break;

        case 2: // Logout
          doLogOut();
          break;

        case 3: // Exit app
          loginService.exitApp();
          return;

        default: // In case of picking a wrong option
          System.out.println("Invalid choice. Please, choose only between displayed options!");
          break;
      }
    } while (loginService.isLoggedInAsCustomer(loginService.getLoggedInUser()));
  }
  /**
   *
   * @name adminMenuController
   *
   * @brief Admin menu controller for the shop.
   *
   * The adminMenuController displays the admin menu and handles user interactions based on the selected options.
   */
  public void adminMenuController() {
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println();
      MENU_DISPLAY_SERVICE.showAdminMenu();
      System.out.println("Please, choose your option from down below: ");
      int option = INPUT.nextInt();

      switch (option) {
        case 1: // List Car
          System.out.println("\nRental Cars:\n");
          int i = 0;

          if (rentalCars.isEmpty()) {
            System.out.println("No cars available.");
          } else {
            System.out.println(
              "+------Brand---------Model-------Car Year-----Fuel Type----Color----Price---Number of Seats-------+\n");

            for (CarFeaturesInterface rentalCar : rentalCars) {
              i++;
              System.out.print(i + ". =>   ");
              displayCarFeatures(rentalCar);
            }
          }

          break;

        case 2: // Add Car
          MENU_DISPLAY_SERVICE.SelectCarTypeDesign();
          String carType = "";
          int selectCarType = Integer.parseInt(scanner.nextLine());

          switch (selectCarType) {
            case 1: {
              carType = "sedan";
              break;
            }

            case 2: {
              carType = "suv";
              break;
            }

            case 3: {
              carType = "stationwagon";
              break;
            }

            case 4: {
              carType = "pickup";
              break;
            }

            case 5: {
              carType = "hatchback";
              break;
            }

            case 6: {
              carType = "cabrio";
              break;
            }

            default:
              System.out.println("Invalid choose only betwen displayed options!");
              return;
          }

          System.out.println("Enter Brand: ");
          String brand = scanner.nextLine();
          System.out.print("Enter Model: ");
          String model = scanner.nextLine();
          System.out.print("Enter Car Year: ");
          int carYear = Integer.parseInt(scanner.nextLine());
          System.out.print("Enter Fuel Type: ");
          String fuelType = scanner.nextLine();
          System.out.print("Enter Color: ");
          String color = scanner.nextLine();
          System.out.print("Enter Price: ");
          int price = Integer.parseInt(scanner.nextLine());
          System.out.print("Enter Number of Seats: ");
          int seatsNumber = Integer.parseInt(scanner.nextLine());
          CarFeaturesInterface car = RentalFactory.createCar(carType, brand, model, carYear, fuelType, color,
                                     price, seatsNumber);
          paymentService.setCost(price);
          rentalCars.add(car);
          System.out.println("\nCar added successfully!");
          break;

        case 3: // Delete Car
          System.out.print("\nEnter the index of the car to delete: ");
          int index = Integer.parseInt(scanner.nextLine());

          if (index >= 0 && index < rentalCars.size() + 1) {
            rentalCars.remove(index - 1);
            System.out.println("Car deleted successfully!");
          } else {
            System.out.println("Invalid index!");
          }

          break;

        case 4: // Logout
          doLogOut();
          break;

        case 5: // Exit app
          loginService.exitApp();
          return;

        default: // In case of picking a wrong option
          System.out.println("Invalid choice. Please, choose only between displayed options!");
          break;
      }
    } while (loginService.isLoggedInAsAdmin(loginService.getLoggedInUser()));
  }

  /**
   *
   * @name doLogOut
   *
   * @brief Logs out the current user and returns to the main menu.
   */
  public void doLogOut() {
    System.out.println("Log-out successfully!");
    mainMenuController();
  }


  /**
   * @name displayCarFeatures
   *
   * @brief Displays the features of a rental car.
   *
   * @param car The CarFeaturesInterface representing the rental car.
   */
  public void displayCarFeatures(CarFeaturesInterface car) {
    System.out.println(
      car.getBrand().toUpperCase() + "   =>   " + car.getModel().toUpperCase() + "   =>   " + car.getCarYear()
      + "   =>   " + car.getFuelType().toUpperCase() + "   =>   " + car.getColor().toUpperCase()
      + "   =>   " + car.getPrice() + "   =>   " + car.getSeatsNumber() + "\n");
  }

  /**
   *
   * @name DefaultCars
  *
  * @brief Sets up default cars for the shop.
  *
  * The DefaultCars method initializes the rentalCars list with default cars. This method is called during the initialization of the Shop class.
  *
  *
  */
  public void DefaultCars() {
    CarFeaturesInterface carOne = RentalFactory.createCar("suv", "Skoda", "Octava", 2012, "Gasolne", "Dark Red", 1967, 4);
    rentalCars.add(carOne);
    paymentService.setCost(1);
  }


}
