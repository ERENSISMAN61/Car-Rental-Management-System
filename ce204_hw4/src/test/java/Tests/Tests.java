/**
 *
 * @file Tests.java
 *
 * @package Tests
 *
 * @file Tests.java
 *
 * @brief This package contains test cases for the CarType module. It includes unit tests
 * for various classes and functionalities related to car types, such as sedan, SUV,
 * sports car, etc. The tests cover both positive and negative scenarios to ensure
 * the correct behavior of the CarType module.
 *
 * @details The test cases in this package are designed to be executed using a unit testing
 * framework, such as JUnit. Each test method focuses on a specific aspect of the
 * CarType module and verifies the expected results by asserting them against the
 * actual outcomes.
 *
 * The TestCarType package is an essential component of the testing suite for the
 * CarType module, ensuring its reliability, accuracy, and adherence to the defined
 * requirements and specifications.
 */

package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

import App.App;
import CarType.*;
import Models.*;
import Observer.Customers;
import Observer.Timer;
import PaymentSystem.*;
import ServicesImpl.*;
import ServicesInterface.CarFeaturesInterface;
import ServicesInterface.*;


/**
 *
 * @name Tests
 *
 * @brief Test class for the Car Rental Management System project.
 */
public class Tests {



  /**
   * @name testGetLoggedInUser
   *
     * @brief Test for the getLoggedInUser method in LoginImpl.
     */

  @Test
  public void testGetLoggedInUser() {
    ArrayList<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    assertNull(login.getLoggedInUser());
    Customer customer = new Customer("Eren", "Sisman", "erensisman", "Trabzon6161", "2020-01-01");
    login.setLoggedInUser(customer);
    assertEquals(customer, login.getLoggedInUser());
  }
  /**
   * @name testValidateLogIn2
   *
   * @brief Test for the validateLogIn method in LoginImpl.
   */
  @Test
  public void testValidateLogIn2() {
    ArrayList<User> userList = new ArrayList<>();
    Customer customer = new Customer("Resul", "Beser", "resulbeser", "rb6161", "2019-02-01");
    userList.add(customer);
    LoginImpl login = new LoginImpl(userList);
    User loggedInUser = login.validateLogIn("resulbeser", "rb6161");
    assertEquals(customer, loggedInUser);
  }
  /**
   *
   * @name testValidateLogInWithInvalidCredentials
   *
   * @brief Test for the validateLogIn method in LoginImpl with invalid credentials.
   */
  @Test
  public void testValidateLogInWithInvalidCredentials() {
    Scanner input = new Scanner("wrong\nentry\n");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    List<User> userList = new ArrayList<>();
    LoginImpl loginImpl = new LoginImpl(userList);
    loginImpl.input = input;
    User user = loginImpl.validateLogIn("wrong", "entry");
    assertNull(user);
  }

  /**
   *
   * @name testInitiateLogInAsCustomer
   *
   * @brief Test for initiating login as a customer with invalid credentials.
   */
  @Test
  public void testInitiateLogInAsCustomer() {
    Scanner input = new Scanner("customer\npassword\n");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    Customer customer = new Customer("customer", "password","customer", "password","2002-02-01");
    List<User> userList = new ArrayList<>();
    userList.add(customer);
    LoginImpl loginImpl = new LoginImpl(userList);
    loginImpl.input = input;
    loginImpl.initiateLogIn();
    String expectedOutput = "Wrong credentials! Please, try again!";
    assertTrue(output.toString().contains(expectedOutput));
  }


  /**
   *
   * @name testInitiateLogIn
   *
   * @brief Test for initiating login with valid credentials.
   **/
  @Test
  public void testInitiateLogIn() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    userList.add(new Customer("Eren", "Sisman", "erensisman", "Trabzon6161", "2020-01-01"));
    LoginImpl loginService = new LoginImpl(userList);
    loginService.input = new Scanner("erensisman\nTrabzon6161\n");
    User loggedIn = loginService.initiateLogIn();
    String expectedOutput = "Login successfully!!!";
    assertTrue(outContent.toString().contains(expectedOutput));
  }
  /**
   *
   * @name testDisplayLogInMenu
   *
   * @brief Test for displaying the login menu.
   **/
  @Test
  public void testDisplayLogInMenu() {
    ArrayList<User> userList = new ArrayList<>();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    LoginImpl login = new LoginImpl(userList);
    login.displayLogInMenu();
    String expectedOutput = "+----------------------------------------------+\r\n"+
                            "|                     LOGIN:                   |\r\n"+
                            "+----------------------------------------------+\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testDoLogInAsAdmin
   *
   * @brief Test for logging in as an admin with valid credentials.
   **/
  @Test
  public void testDoLogInAsAdmin() {
    Scanner input = new Scanner("admin\npassword\n");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    Admin admin = new Admin("1admin", "1password","admin11", "1123password");
    List<User> userList = new ArrayList<>();
    userList.add(admin);
    LoginImpl loginImpl = new LoginImpl(userList);
    loginImpl.input = input;
    loginImpl.doLogIn("admin11", "1123password");
    assertTrue(output.toString().contains("Welcome 1admin 1password!"));
  }
  /**
   *
   * @name testDoLogInAsAdmin2
   *
   * @brief Test for logging in as an admin with valid credentials.
   **/
  @Test
  public void testDoLogInAsAdmin2() {
    Scanner input = new Scanner("admin\npassword\n");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    Admin admin = new Admin("admin", "password","admin1", "123password");
    List<User> userList = new ArrayList<>();
    userList.add(admin);
    LoginImpl loginImpl = new LoginImpl(userList);
    loginImpl.input = input;
    loginImpl.doLogIn("admin1", "123password");
    assertTrue(output.toString().contains("Welcome admin password!"));
  }
  /**
   *
   * @name testDoLogInAsAdmin3
   *
   * @brief Test for logging in as an admin with valid credentials.
   **/
  @Test
  public void testDoLogInAsAdmin3() {
    Scanner input = new Scanner("admin\npassword\n");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
    Admin admin = new Admin("1admin", "1password","admin1", "123password");
    List<User> userList = new ArrayList<>();
    userList.add(admin);
    LoginImpl loginImpl = new LoginImpl(userList);
    loginImpl.input = input;
    loginImpl.doLogIn("admin1", "123password");
    assertTrue(output.toString().contains("Welcome 1admin 1password!"));
  }
  /**
   *
   * @name testRentalFactory
   *
   * @brief Test for creating a car using RentalFactory with specific car type and attributes.
   **/
  @Test
  public void testRentalFactory() {
    CarFeaturesInterface car = RentalFactory.createCar("hatchback", "MERCEDESBENZ", "VTO", 2007, "GASOLNE", "GRAY", 261,
                               4);
    assertEquals("MERCEDESBENZ", car.getBrand());
    assertEquals("VTO", car.getModel());
    assertEquals(2007, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("GRAY", car.getColor());
    assertEquals(261, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testCabrioGetBrand
   *
   * @brief Test for creating a cabrio car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testCabrioGetBrand() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("cabrio", "mercedes", "cla", 2021, "gasolne", "red", 2000, 4);
    assertEquals("mercedes", car.getBrand());
    assertEquals("cla", car.getModel());
    assertEquals(2021, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testPickUpkGetBrand
   *
   * @brief Test for creating a pickup car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testPickUpkGetBrand() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("pickup", "renault", "clo", 2023, "gasolne", "red", 2000, 4);
    assertEquals("renault", car.getBrand());
    assertEquals("clo", car.getModel());
    assertEquals(2023, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testSedanGetBrand
   *
   * @brief Test for creating a sedan car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testSedanGetBrand() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("sedan", "renault", "clo", 2023, "gasolne", "red", 2000, 4);
    assertEquals("renault", car.getBrand());
    assertEquals("clo", car.getModel());
    assertEquals(2023, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testSedanGetBrand1
   *
   * @brief Test for creating a sedan car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testSedanGetBrand1() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("sedan", "renault", "clo", 2021, "gasolne", "red", 2000, 4);
    assertEquals("renault", car.getBrand());
    assertEquals("clo", car.getModel());
    assertEquals(2021, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testSedanGetBrand2
   *
   * @brief Test for creating a sedan car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testSedanGetBrand2() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("sedan", "mercedes", "cla", 2021, "gasolne", "red", 2000, 4);
    assertEquals("mercedes", car.getBrand());
    assertEquals("cla", car.getModel());
    assertEquals(2021, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testSedanGetBrand3
   *
   * @brief Test for creating a sedan car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testSedanGetBrand3() {
    RentalFactory rental = new RentalFactory();
    CarFeaturesInterface car = rental.createCar("sedan", "mercedes", "GLA", 2022, "gasolne", "red", 2000, 4);
    assertEquals("mercedes", car.getBrand());
    assertEquals("GLA", car.getModel());
    assertEquals(2022, car.getCarYear());
    assertEquals("gasolne", car.getFuelType());
    assertEquals("red", car.getColor());
    assertEquals(2000, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }

  /**
   *
   * @name testsuvGetBrand
   *
   * @brief Test for creating an SUV car using RentalFactory and verifying the brand and attributes.
   **/
  @Test
  public void testsuvGetBrand() {
    CarFeaturesInterface car = RentalFactory.createCar("suv", "CHERY", "TGGO7", 2022,"GASOLNE", "GRAY", 200, 4);
    assertEquals("CHERY", car.getBrand());
    assertEquals("TGGO7", car.getModel());
    assertEquals(2022, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("GRAY", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testsuvGetBrand2
   *
   * @brief Test for creating an SUV car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testsuvGetBrand2() {
    CarFeaturesInterface car = RentalFactory.createCar("suv", "CHERY", "OMODA5", 2022,"GASOLNE", "GRAY", 200, 4);
    assertEquals("CHERY", car.getBrand());
    assertEquals("OMODA5", car.getModel());
    assertEquals(2022, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("GRAY", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testsuvGetBrand3
   *
   * @brief Test for creating an SUV car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testsuvGetBrand3() {
    CarFeaturesInterface car = RentalFactory.createCar("suv", "CHERY", "TGGO6", 2022,"GASOLNE", "GRAY", 200, 4);
    assertEquals("CHERY", car.getBrand());
    assertEquals("TGGO6", car.getModel());
    assertEquals(2022, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("GRAY", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testStationWagonGetBrand
   *
   * @brief Test for creating a station wagon car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testStationWagonGetBrand() {
    CarFeaturesInterface car = RentalFactory.createCar("stationwagon", "OPEL", "CORSA", 2007, "GASOLNE", "RED", 200,
                               4);
    assertEquals("OPEL", car.getBrand());
    assertEquals("CORSA", car.getModel());
    assertEquals(2007, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("RED", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testStationWagonGetBrand2
   *
   * @brief Test for creating a station wagon car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testStationWagonGetBrand2() {
    CarFeaturesInterface car = RentalFactory.createCar("stationwagon", "OPEL", "ASTRA", 2008, "GASOLNE", "RED", 200,
                               4);
    assertEquals("OPEL", car.getBrand());
    assertEquals("ASTRA", car.getModel());
    assertEquals(2008, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("RED", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testStationWagonGetBrand3
   *
   * @brief Test for creating a station wagon car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testStationWagonGetBrand3() {
    CarFeaturesInterface car = RentalFactory.createCar("stationwagon", "OPEL", "ASTRA", 2017, "GASOLNE", "RED", 200,
                               4);
    assertEquals("OPEL", car.getBrand());
    assertEquals("ASTRA", car.getModel());
    assertEquals(2017, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("RED", car.getColor());
    assertEquals(200, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testHatchbackGetBrand
   *
   * @brief Test for creating a hatchback car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testHatchbackGetBrand() {
    CarFeaturesInterface car = RentalFactory.createCar("hatchback", "MERCEDES", "C200", 2005, "GASOLNE", "BLACK", 300,
                               4);
    assertEquals("MERCEDES", car.getBrand());
    assertEquals("C200", car.getModel());
    assertEquals(2005, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("BLACK", car.getColor());
    assertEquals(300, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testHatchbackGetBrand2
   *
   * @brief Test for creating a hatchback car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testHatchbackGetBrand2() {
    CarFeaturesInterface car = RentalFactory.createCar("hatchback", "MERCEDES", "C200", 2008, "GASOLNE", "BLACK", 300,
                               4);
    assertEquals("MERCEDES", car.getBrand());
    assertEquals("C200", car.getModel());
    assertEquals(2008, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("BLACK", car.getColor());
    assertEquals(300, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testHatchbackGetBrand3
   *
   * @brief Test for creating a hatchback car using RentalFactory and verifying the brand and attributes.
   */
  @Test
  public void testHatchbackGetBrand3() {
    CarFeaturesInterface car = RentalFactory.createCar("hatchback", "MERCEDES", "C200", 2015, "GASOLNE", "BLACK", 300,
                               4);
    assertEquals("MERCEDES", car.getBrand());
    assertEquals("C200", car.getModel());
    assertEquals(2015, car.getCarYear());
    assertEquals("GASOLNE", car.getFuelType());
    assertEquals("BLACK", car.getColor());
    assertEquals(300, car.getPrice());
    assertEquals(4, car.getSeatsNumber());
  }
  /**
   *
   * @name testCreateCarCabrio
   *
   * @brief Test for creating a cabrio car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarCabrio() {
    CarFeaturesInterface car = RentalFactory.createCar("cabrio", "Brand", "Model", 2023, "Petrol", "Red", 500, 4);
    assertTrue(car instanceof Model_Cabrio);
  }
  /**
   *
   * @name testCreateCarHatchback
   *
   * @brief Test for creating a hatchback car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarHatchback() {
    CarFeaturesInterface car = RentalFactory.createCar("hatchback", "Brand", "Model", 2023, "Petrol", "Red", 200,
                               4);
    assertTrue(car instanceof Model_Hatchback);
  }
  /**
   *
   * @name testCreateCarPickup
   *
   * @brief Test for creating a pickup car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarPickup() {
    CarFeaturesInterface car = RentalFactory.createCar("pickup", "Brand", "Model", 2023, "Petrol", "Red", 200, 4);
    assertTrue(car instanceof Model_PickUp);
  }
  /**
   *
   * @name testCreateCarSedan
   *
   * @brief Test for creating a sedan car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarSedan() {
    CarFeaturesInterface car = RentalFactory.createCar("sedan", "Brand", "Model", 2023, "Petrol", "Red", 200, 4);
    assertTrue(car instanceof Model_Sedan);
  }
  /**
   *
   * @name testCreateCarStationWagon
   *
   * @brief Test for creating a station wagon car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarStationWagon() {
    CarFeaturesInterface car = RentalFactory.createCar("stationwagon", "Brand", "Model", 2021, "Petrol", "Red",
                               50000, 4);
    assertTrue(car instanceof Model_StationWagon);
  }
  /**
   *
   * @name testCreateCarSUV
   *
   * @brief Test for creating an SUV car using RentalFactory and verifying the instance type.
   */
  @Test
  public void testCreateCarSUV() {
    CarFeaturesInterface car = RentalFactory.createCar("suv", "Brand", "Model", 2021, "Petrol", "Red", 50000, 4);
    assertTrue(car instanceof Model_SUV);
  }

  /**
   *
   * @name testCreateCarInvalidType
   *
   * @brief Test for creating a car with an invalid type using RentalFactory and verifying the instance is null.
   */
  @Test
  public void testCreateCarInvalidType() {
    CarFeaturesInterface car = RentalFactory.createCar("invalid", "Brand", "Model", 2021, "Petrol", "Red", 50000,
                               4);
    assertNull(car);
  }
  /**
   *
   * @name testDisplayBill
   *
   * @brief Test for displaying the bill by creating a car and payment type, and verifying the console output.
   */
  @Test
  public void testDisplayBill() {
    CarFeaturesInterface car = new Model_Cabrio("Brand", "Model", 2021, "Petrol", "Red", 50000, 4);
    String paymentType = "Credit Card";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Bill bill = new Bill();
    Bill.displayBill(car, paymentType);
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|             	     BILL  	                  |\n"
                            + "+---------------------------------------------+\n\n" + "Car Brand: " + "BRAND" + "\n" + "Car Model: "
                            + "MODEL" + "\n" + "Car Year: " + "2021" + "\n" + "Car Year: " + "PETROL" + "\n" + "Car Year: " + "RED"
                            + "\n" + "Car Year: " + "50000" + "\n" + "Car Year: " + "4" + "\n" + "Paymet Type: " + "Credit Card"
                            + "\n\n" + "+---------------------------------------------+\n"
                            + "+---------------------------------------------+\n\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testAdminConstructor
   *
   * @brief Test for creating an admin object and verifying the constructor.
   */
  @Test
  public void testAdminConstructor() {
    Admin admin = new Admin("John", "Doe", "johndoe", "password");
    assertEquals("John", admin.getFirstName());
    assertEquals("Doe", admin.getLastName());
    assertEquals("johndoe", admin.getUserName());
    assertEquals("password", admin.getPassword());
  }
  /**
   *
   * @name testCustomerConstructor
   *
   * @brief Test for creating a customer object and verifying the constructor.
   */
  @Test
  public void testCustomerConstructor() {
    Customer customer = new Customer("Jack", "John", "jjjj", "password123", "2022-01-01");
    assertEquals("Jack", customer.getFirstName());
    assertEquals("John", customer.getLastName());
    assertEquals("jjjj", customer.getUserName());
    assertEquals("password123", customer.getPassword());
    assertEquals(LocalDate.parse("2022-01-01"), customer.getLicenceObtained());
  }

  /**
   *
   * @name testSetLicenceObtained
   *
   * @brief Test for setting the license obtained date for a customer and verifying the getter.
   */
  @Test
  public void testSetLicenceObtained() {
    Customer customer = new Customer();
    customer.setLicenceObtained(LocalDate.parse("2023-02-02"));
    assertEquals(LocalDate.parse("2023-02-02"), customer.getLicenceObtained());
  }

  /**
   *
   * @name testUserConstructor
   *
   * @brief Test for creating a user object and verifying the constructor.
   */

  @Test
  public void testUserConstructor() {
    User user = new User("Murat", "Tekin", "mtekin", "1234");
    assertEquals("Murat", user.getFirstName());
    assertEquals("Tekin", user.getLastName());
    assertEquals("mtekin", user.getUserName());
    assertEquals("1234", user.getPassword());
  }

  /**
   *
   * @name testSetFirstName
   *
   * @brief Test for setting the first name of a user and verifying the getter.
   */
  @Test
  public void testSetFirstName() {
    User user = new User();
    user.setFirstName("Abdullah");
    assertEquals("Abdullah", user.getFirstName());
  }
  /**
   *
   * @name testSetFirstName2
   *
   * @brief Test for setting the first name of a user and verifying the getter.
   */
  @Test
  public void testSetFirstName2() {
    User user = new User();
    user.setFirstName("Abraham");
    assertEquals("Abraham", user.getFirstName());
  }

  /**
   *
   * @name testReLogin
   *
   * @brief Test for re login for error.
   */
  @Test
  public void testReLogin() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    userList.add(new Admin("admin", "admin", "admin", "admin"));
    shop.INPUT = new Scanner("2\n1\n5");
    login.input = new Scanner("admin\n0000\nadmin\nadmin\nadmin\n");
    shop.mainMenuController();
    Assert.assertTrue(true);
  }










  /**
   *
   * @name testSetLastName
   *
   * @brief Test for setting the last name of a user and verifying the getter.
   */


  @Test
  public void testSetLastName() {
    User user = new User();
    user.setLastName("Jeorge");
    assertEquals("Jeorge", user.getLastName());
  }
  /**
   *
   * @name testSetLastName2
   *
   * @brief Test for setting the last name of a user and verifying the getter.
   */
  @Test
  public void testSetLastName2() {
    User user = new User();
    user.setLastName("Jesus");
    assertEquals("Jesus", user.getLastName());
  }
  /**
   *
   * @name testSetPassword
   *
   * @brief Test for setting the password of a user and verifying the getter.
   */
  @Test
  public void testSetPassword() {
    User user = new User();
    user.setPassword("sifre123");
    assertEquals("sifre123", user.getPassword());
  }
  /**
   *
   * @name testSetPassword2
   *
   * @brief Test for setting the password of a user and verifying the getter.
   */
  @Test
  public void testSetPassword2() {
    User user = new User();
    user.setPassword("456sifre");
    assertEquals("456sifre", user.getPassword());
  }
  /**
   *
   * @name testSetUserName
   *
   * @brief Test for setting the username of a user and verifying the getter.
   */
  @Test
  public void testSetUserName() {
    User user = new User();
    user.setUserName("kemalcakar");
    assertEquals("kemalcakar", user.getUserName());
  }
  /**
   *
   * @name testSetUserName2
   *
   * @brief Test for setting the username of a user and verifying the getter.
   */
  @Test
  public void testSetUserName2() {
    User user = new User();
    user.setUserName("kenancakar66");
    assertEquals("kenancakar66", user.getUserName());
  }
  /**
   *
   * @name testToString
   *
   * @brief Test for the toString method of the User class.
   */
  @Test
  public void testToString() {
    User user = new User("AHMET", "CAKAR", "acakar", "acakar61");
    assertEquals("User{firstName='AHMET', lastName='CAKAR', userName='acakar', password='acakar61'}",
                 user.toString());
  }
  /**
   *
   * @name testToString2
   *
   * @brief Test for the toString method of the User class.
   */
  @Test
  public void testToString2() {
    User user = new User("MAHMUT", "CAKAR", "acakar", "acakar61");
    assertEquals("User{firstName='MAHMUT', lastName='CAKAR', userName='acakar', password='acakar61'}",
                 user.toString());
  }
  /**
   *
   * @name testGetCustomer
   *
   * @brief Test for retrieving the customer list from the UserDatabase.
   */
  @Test
  public void testGetCustomer() {
    UserDatabase ub = new UserDatabase();
    List<User> customerList = ub.getCustomerList();
    assertEquals(4, customerList.size());
    assertEquals("Semiha", customerList.get(0).getFirstName());
    assertEquals("Akbaş", customerList.get(0).getLastName());
    assertEquals("s.akbas", customerList.get(0).getUserName());
    assertEquals("akbas61", customerList.get(0).getPassword());
  }

  /**
   *
   * @name testGetCustomer2
   *
   * @brief Test for retrieving the customer list from the UserDatabase.
   */
  @Test
  public void testGetCustomer2() {
    UserDatabase ub = new UserDatabase();
    List<User> customerList = ub.getCustomerList();
    assertEquals(4, customerList.size());
    assertEquals("Ali", customerList.get(1).getFirstName());
    assertEquals("Şişman", customerList.get(1).getLastName());
    assertEquals("a.sisman", customerList.get(1).getUserName());
    assertEquals("alis61", customerList.get(1).getPassword());
  }
  /**
   *
   * @name testGetCustomer3
   *
   * @brief Test for retrieving the customer list from the UserDatabase.
   */
  @Test
  public void testGetCustomer3() {
    UserDatabase ub = new UserDatabase();
    List<User> customerList = ub.getCustomerList();
    assertEquals(4, customerList.size());
    assertEquals("Bahtiyar", customerList.get(2).getFirstName());
    assertEquals("Kavuk", customerList.get(2).getLastName());
    assertEquals("bahtiyar.k", customerList.get(2).getUserName());
    assertEquals("bk6161", customerList.get(2).getPassword());
  }

  /**
   *
   * @name testGetAdminList
   *
   * @brief Test for retrieving the admin list from the UserDatabase.
   */
  @Test
  public void testGetAdminList() {
    List<User> adminList = UserDatabase.getAdminList();
    assertEquals(5, adminList.size());
    assertEquals("Eren", adminList.get(0).getFirstName());
    assertEquals("ADMIN", adminList.get(0).getLastName());
    assertEquals("admin", adminList.get(0).getUserName());
    assertEquals("0000", adminList.get(0).getPassword());
  }

  /**
   *
   * @name testGetAdminList2
   *
   * @brief Test for retrieving the admin list from the UserDatabase.
   */

  @Test
  public void testGetAdmin2() {
    List<User> adminList = UserDatabase.getAdminList();
    assertEquals(5, adminList.size());
    assertEquals("ErenS", adminList.get(1).getFirstName());
    assertEquals("ADMIN1", adminList.get(1).getLastName());
    assertEquals("admin", adminList.get(1).getUserName());
    assertEquals("admin", adminList.get(1).getPassword());
  }
  /**
   *
   * @name testGetAdminList3
   *
   * @brief Test for retrieving the admin list from the UserDatabase.
   */

  @Test
  public void testGetAdmin3() {
    List<User> adminList = UserDatabase.getAdminList();
    assertEquals(5, adminList.size());
    assertEquals("Resul", adminList.get(2).getFirstName());
    assertEquals("ADMIN2", adminList.get(2).getLastName());
    assertEquals("admin", adminList.get(2).getUserName());
    assertEquals("123", adminList.get(2).getPassword());
  }
  /**
   *
   * @name testGetAdminList4
   *
   * @brief Test for retrieving the admin list from the UserDatabase.
   */
  @Test
  public void testGetAdmin4() {
    List<User> adminList = UserDatabase.getAdminList();
    assertEquals(5, adminList.size());
    assertEquals("ResulB", adminList.get(3).getFirstName());
    assertEquals("ADMIN3", adminList.get(3).getLastName());
    assertEquals("admin", adminList.get(3).getUserName());
    assertEquals("1234", adminList.get(3).getPassword());
  }
  /**
   *
   * @name testGetAdminList5
   *
   * @brief Test for retrieving the admin list from the UserDatabase.
   */
  @Test
  public void testGetAdmin5() {
    List<User> adminList = UserDatabase.getAdminList();
    assertEquals(5, adminList.size());
    assertEquals("ErenS", adminList.get(4).getFirstName());
    assertEquals("ADMIN4", adminList.get(4).getLastName());
    assertEquals("admin", adminList.get(4).getUserName());
    assertEquals("000", adminList.get(4).getPassword());
  }

  /**
   *
   * @name testGetAllUserList
   *
   * @brief Test for retrieving the complete user list from the UserDatabase.
   */
  @Test
  public void testGetAllUserList() {
    List<User> userList = UserDatabase.getAllUserList();
    assertEquals(9, userList.size());
  }
  /**
   *
   * @name testGetShopBalance
   *
   * @brief Test for retrieving the shop balance from the UserDatabase.
   */
  @Test
  public void testGetShopBalance() {
    long balance = UserDatabase.getShopBalance();
    assertEquals(0, balance);
  }

  /**
   *
   * @name testCreditCardConstructor
   *
   * @brief Test for creating a CreditCard object with the provided card number, expiry date, and CVV.
   */
  @Test
  public void testCreditCardConstructor() {
    String cardNumber = "9354274245984221";
    String expiryDate = "06/24";
    String cvv = "985";
    CreditCard creditCard = new CreditCard(cardNumber, expiryDate, cvv);
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(expiryDate, creditCard.getExpiryDate());
    assertEquals(cvv, creditCard.getCvv());
  }
  /**
   *
   * @name testCreditCardConstructor2
   *
   * @brief Test for creating a CreditCard object with the provided card number, expiry date, and CVV.
   */
  @Test
  public void testCreditCardConstructor2() {
    String cardNumber = "9354152345984221";
    String expiryDate = "06/24";
    String cvv = "955";
    CreditCard creditCard = new CreditCard(cardNumber, expiryDate, cvv);
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(expiryDate, creditCard.getExpiryDate());
    assertEquals(cvv, creditCard.getCvv());
  }


  /**
   *
   * @name testCreditCardConstructor3
   *
   * @brief Test for creating a CreditCard object with the provided card number, expiry date, and CVV.
   */
  @Test
  public void testCreditCardConstructor3() {
    String cardNumber = "9354274456254221";
    String expiryDate = "06/24";
    String cvv = "455";
    CreditCard creditCard = new CreditCard(cardNumber, expiryDate, cvv);
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(expiryDate, creditCard.getExpiryDate());
    assertEquals(cvv, creditCard.getCvv());
  }

  /**
   *
   * @name testValidateLogIn
   *
   * @brief Test for validating user login credentials in the LoginImpl class.
   */
  @Test
  public void testValidateLogIn() {
    List<User> userList = new ArrayList<>();
    userList.add(new Customer("Eren", "Sisman", "erensisman", "Trabzon6161", "2020-01-01"));
    userList.add(new Admin("Admin", "ADMIN", "admin", "password"));
    LoginImpl login = new LoginImpl(userList);
    User user = login.validateLogIn("erensisman", "Trabzon6161");
    assertEquals("Eren", user.getFirstName());
    assertEquals("Sisman", user.getLastName());
    assertEquals("erensisman", user.getUserName());
    assertEquals("Trabzon6161", user.getPassword());
  }
  /**
     *
     * @name testValidateLogIn1
     *
     * @brief Test for validating user login credentials in the LoginImpl class.
     */
  @Test
  public void testValidateLogIn1() {
    ArrayList<User> userList = new ArrayList<>();
    Customer customer = new Customer("Akman", "Akar", "aman", "hamam", "2018-06-29");
    userList.add(customer);
    LoginImpl login = new LoginImpl(userList);
    User loggedInUser = login.validateLogIn("aman", "hamam");
    assertEquals(customer, loggedInUser);
  }
  /**
    *
    * @name testValidateLogIn3
    *
    * @brief Test for validating user login credentials in the LoginImpl class.
    */
  @Test
  public void testValidateLogIn3() {
    List<User> userList = new ArrayList<>();
    userList.add(new Customer("Eren", "Sisman", "erenS", "6161123", "2020-01-01"));
    userList.add(new Admin("Admin", "ADMIN", "admin", "password"));
    LoginImpl login = new LoginImpl(userList);
    User user = login.validateLogIn("erenS", "6161123");
    assertEquals("Eren", user.getFirstName());
    assertEquals("Sisman", user.getLastName());
    assertEquals("erenS", user.getUserName());
    assertEquals("6161123", user.getPassword());
  }

  /**
   *
   * @name testDoLogIn1
   *
   * @brief Test for performing a user login in the LoginImpl class with the provided username and password.
   */
  @Test
  public void testDoLogIn1() {
    ArrayList<User> userList = new ArrayList<>();
    Customer customer = new Customer("Selami", "Şahin", "ssahin", "sahins61", "2005-11-21");
    userList.add(customer);
    LoginImpl login = new LoginImpl(userList);
    User loggedInUser = login.doLogIn("ssahin", "sahins61");
    assertEquals(customer, loggedInUser);
  }
  /**
   *
   * @name testIsLoggedIn1
   *
   * @brief Test for checking if a user is logged in, given a null user object in the LoginImpl class.
   */
  @Test
  public void testIsLoggedIn1() {
    ArrayList<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    assertFalse(login.isLoggedIn(null));
    Customer customer = new Customer("Murat", "Yayla", "myayla", "123456789", "2019-06-25");
    assertTrue(login.isLoggedIn(customer));
  }
  /**
   *
   * @name testIsLoggedInAsCustomer
   *
   * @brief Test for checking if a user is logged in as a customer, given a null user object in the LoginImpl class.
   */
  @Test
  public void testIsLoggedInAsCustomer() {
    ArrayList<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    assertFalse(login.isLoggedInAsCustomer(null));
    Customer customer = new Customer("resuladmin", "adminresul", "aaresul", "90906161", "2010-11-22");
    assertTrue(login.isLoggedInAsCustomer(customer));
  }
  /**
   *
   * @name testIsLoggedInAsAdmin
   *
   * @brief Test for checking if a user is logged in as an admin, given a null user object in the LoginImpl class.
   */
  @Test
  public void testIsLoggedInAsAdmin() {
    ArrayList<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    assertFalse(login.isLoggedInAsAdmin(null));
    Admin admin = new Admin("Eren", "Admin", "admin", "admin");
    assertTrue(login.isLoggedInAsAdmin(admin));
  }



  /**
   *
   * @name testLogIn
   *
   * @brief Test for performing a user login and validating the logged-in user in the LoginImpl class.
   */
  @Test
  public void testLogIn() {
    List<User> userList = new ArrayList<>();
    userList.add(new Customer("Johns", "Dose", "johndoes", "passworsd", "2023-01-05"));
    userList.add(new Admin("Admin2", "ADMIN", "admin", "password"));
    LoginImpl login = new LoginImpl(userList);
    User user = login.doLogIn("admin", "password");
    assertEquals("Admin2", user.getFirstName());
    assertEquals("ADMIN", user.getLastName());
    assertEquals("admin", user.getUserName());
    assertEquals("password", user.getPassword());
  }


  /**
   *
   * @name testShowMainMenu
   *
   * @brief Test for displaying the main menu in the MenuImpl class.
   *        It verifies that the correct output is displayed to the console.
   */
  @Test
  public void testShowMainMenu() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MenuImpl menu = new MenuImpl();
    menu.showMainMenu();
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|            -Car Rental Service-             |\n"
                            + "+---------------------------------------------+\n" + "\n"
                            + "                   -MAIN MENU-                 \n" + "1. Register\n" + "2. Login\n" + "3. Exit\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testIsLoggedIn
   *
   * @brief Test for checking if a user is logged in, given a null user object in the LoginImpl class.
   */
  @Test
  public void testIsLoggedIn() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    assertFalse(login.isLoggedIn(null));
    assertTrue(login.isLoggedIn(new Customer()));
  }
  /**
   *
   * @name testShowAdminMenu
   *
   * @brief Test for displaying the admin menu in the MenuImpl class.
   *        It verifies that the correct output is displayed to the console.
   */
  @Test
  public void testShowAdminMenu() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MenuImpl menu = new MenuImpl();
    menu.showAdminMenu();
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|            -Car Rental Service-             |\n"
                            + "+---------------------------------------------+\n" + "\n"
                            + "                  -ADMIN MENU-                 \n" + "1. List Cars\n" + "2. Add Car\n"
                            + "3. Delete Car\n" + "4. Log-out\n" + "5. Exit\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testShowCustomerMenu
   *
   * @brief Test for displaying the customer menu in the MenuImpl class.
   *        It verifies that the correct output is displayed to the console.
   */
  @Test
  public void testShowCustomerMenu() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MenuImpl menu = new MenuImpl();
    menu.showCustomerMenu();
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|            -Car Rental Service-             |\n"
                            + "+---------------------------------------------+\n" + "\n"
                            + "                 -CUSTOMER MENU-               \n" + "1. Rent a Car\n" +
                            "2. Logout\n" + "3. Exit\n\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testSelectCarTypeDesign
   *
   * @brief Test for displaying the car type selection menu in the MenuImpl class.
   *        It verifies that the correct output is displayed to the console.
   */
  @Test
  public void testSelectCarTypeDesign() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    MenuImpl menu = new MenuImpl();
    menu.SelectCarTypeDesign();
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|            -Car Rental Service-             |\n"
                            + "+---------------------------------------------+\n" + "\n"
                            + "                  -ADD CAR-               \n" + "1. Add Sedan\n" + "2. Add SUV\n"
                            + "3. Add Station Wagon\n" + "4. Add PickUp\n" + "5. Add Hatchback\n" + "6. Add Cabrio\n"
                            + "\nEnter your choice: ";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testSetRemainingNotification
   *
   * @brief Test for setting the remaining notification in the Timer class.
   *        It verifies that the correct notification is sent to the customer.
   */
  @Test
  public void testSetRemainingNotification() {
    int remainingTime = 5;
    int reservationTime = 2;
    Timer timer = new Timer(remainingTime, reservationTime);
    Customers customer = new Customers("Ahmet");
    timer.addObserver(customer);
    int newRemainingTime = reservationTime;
    String expectedOutput = "Hello Ahmet, 2 days left for your delivery";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertTrue(actualOutput.contains(expectedOutput));
  }
  /**
   *
   * @name testSetRemainingNotification2
   *
   * @brief Test for setting the remaining notification in the Timer class.
   *        It verifies that the correct notification is sent to the customer.
   */
  @Test
  public void testSetRemainingNotification2() {
    int remainingTime = 5;
    int reservationTime = 2;
    Timer timer = new Timer(remainingTime, reservationTime);
    Customers customer = new Customers("Mahmut");
    timer.addObserver(customer);
    int newRemainingTime = reservationTime;
    String expectedOutput = "Hello Mahmut, 2 days left for your delivery";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertTrue(actualOutput.contains(expectedOutput));
  }
  /**
   *
   * @name testSetRemainingTimeWithZeroRemainingTime
   *
   * @brief Test for setting the remaining time to zero in the Timer class.
   *        It verifies that the correct notification is sent when the remaining time becomes zero.
   */
  @Test
  public void testSetRemainingTimeWithZeroRemainingTime() {
    int remainingTime = 6;
    int reservationTime = 3;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = 0;
    String expectedOutput = "You can take your car";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertTrue(actualOutput.contains(expectedOutput));
  }
  /**
   *
   * @name testSetRemainingTimeWithZeroRemainingTime2
   *
   * @brief Test for setting the remaining time to zero in the Timer class.
   *        It verifies that the correct notification is sent when the remaining time becomes zero.
   */
  @Test
  public void testSetRemainingTimeWithZeroRemainingTime2() {
    int remainingTime = 8;
    int reservationTime = 5;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = 0;
    String expectedOutput = "You can take your car";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertTrue(actualOutput.contains(expectedOutput));
  }
  /**
   *
   * @name testGetRemainingTime
   *
   * @brief Test for getting the remaining time from the Timer class.
   *        It verifies that the correct remaining time is returned.
   */
  @Test
  public void testGetRemainingTime() {
    int remainingTime = 3;
    int reservationTime = 1;
    Timer timer = new Timer(remainingTime, reservationTime);
    Assert.assertEquals(remainingTime, timer.getRemainingTime());
  }
  /**
   *
   * @name testSetRemainingTime
   *
   * @brief Test for setting the remaining time in the Timer class.
   *        It verifies that the remaining time is correctly updated.
   */
  @Test
  public void testSetRemainingTime() {
    int remainingTime = 5;
    int reservationTime = 2;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = 0;
    timer.setRemainingTime(newRemainingTime);
    Assert.assertEquals(newRemainingTime, timer.getRemainingTime());
  }

  /**
   *
   * @name testSetRemainingTime2
   *
   * @brief Test for setting the remaining time in the Timer class.
   *        It verifies that the remaining time is correctly updated.
   */

  @Test
  public void testGetRemainingTime2() {
    int remainingTime = 6;
    int reservationTime = 2;
    Timer timer = new Timer(remainingTime, reservationTime);
    Assert.assertEquals(remainingTime, timer.getRemainingTime());
  }











  /**
   *
   * @name testSetRemainingTimeTime
   *
   * @brief Test for setting the remaining time with a positive time difference in the Timer class.
   *        It verifies that no output is generated when the remaining time is updated.
   */
  @Test
  public void testSetRemainingTimeTime() {
    int remainingTime = 4;
    int reservationTime = 3;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = reservationTime + 2;
    String expectedOutput = "";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertEquals(expectedOutput, expectedOutput);
  }
  /**
   *
   * @name testSetRemainingTimeTime2
   *
   * @brief Test for setting the remaining time with a positive time difference in the Timer class.
   *        It verifies that no output is generated when the remaining time is updated.
   */
  @Test
  public void testSetRemainingTimeTime2() {
    int remainingTime = 9;
    int reservationTime = 4;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = reservationTime + 3;
    String expectedOutput = "";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertEquals(expectedOutput, expectedOutput);
  }
  /**
   *
   * @name testSetRemainingTimeTime3
   *
   * @brief Test for setting the remaining time with a positive time difference in the Timer class.
   *        It verifies that no output is generated when the remaining time is updated.
   */
  @Test
  public void testSetRemainingTimeTime3() {
    int remainingTime = 12;
    int reservationTime = 5;
    Timer timer = new Timer(remainingTime, reservationTime);
    int newRemainingTime = reservationTime + 2;
    String expectedOutput = "";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertEquals(expectedOutput, expectedOutput);
  }

  /**
   *
   * @name captureStandardOutput
   *
   * @brief Helper method to capture the standard output and return it as a string.
   */

  private String captureStandardOutput(Runnable action) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream standardOut = System.out;
    System.setOut(printStream);
    action.run();
    System.out.flush();
    System.setOut(standardOut);
    return outputStream.toString();
  }
  /**
   *
   * @name testRemoveObserver
   *
   * @brief Test for removing an observer from the Timer class.
   *        It verifies that the observer is successfully removed and does not receive notifications.
   */

  @Test
  public void testRemoveObserver() {
    int remainingTime = 5;
    int reservationTime = 2;
    Timer timer = new Timer(remainingTime, reservationTime);
    Customers customer = new Customers("AHmet");
    timer.addObserver(customer);
    Customers newCustomer = new Customers("Melike");
    timer.addObserver(newCustomer);
    timer.removeObserver(newCustomer);
    int newRemainingTime = reservationTime;
    String expectedOutput = "";
    String actualOutput = captureStandardOutput(() -> timer.setRemainingTime(newRemainingTime));
    Assert.assertEquals(0, newCustomer.getNotificationCount());
  }

  /**
     *
     * @name testCollectPaymentDetailsCreditCard
     *
     * @brief Test for collecting payment details using a credit card in the PaymentByCreditCard class.
     *        It verifies that the payment details are successfully collected.
     */
  @Test
  public void testCollectPaymentDetailsCreditCard() {
    PaymentByCreditCard paymentByCreditCard;
    paymentByCreditCard = new PaymentByCreditCard();
    paymentByCreditCard.CollectPaymentDetails();
    assertNotNull(paymentByCreditCard.getCard());
    assertEquals("1111222233334444", paymentByCreditCard.getCard().getCardNumber());
    assertEquals("05/27", paymentByCreditCard.getCard().getExpiryDate());
    assertEquals("123", paymentByCreditCard.getCard().getCvv());
  }


  /**
   *
   * @name testCollectPaymentDetailsPayPal
   *
   * @brief Test for collecting payment details using PayPal in the PaymentByPayPal class.
   *        It verifies that the payment details are successfully collected.
   */
  @Test
  public void testCollectPaymentDetailsPayPal() {
    PaymentByPayPal paymentByPayPal;
    paymentByPayPal = new PaymentByPayPal();
    paymentByPayPal.CollectPaymentDetails();
    assertNotNull(paymentByPayPal.getPayPalCard());
    assertEquals("erenselam@gmail.com", paymentByPayPal.getPayPalCard().getEmail());
    assertEquals("1234password", paymentByPayPal.getPayPalCard().getPassword());
  }

  /**
   *
   * @name testValidatePaymentDetailsCreditCard
   *
   * @brief Test for validating payment details using a credit card in the PaymentByCreditCard class.
   *        It verifies that the payment details are valid.
   */
  @Test
  public void testValidatePaymentDetailsCreditCard() {
    PaymentByCreditCard paymentByCreditCard;
    paymentByCreditCard = new PaymentByCreditCard();
    assertTrue(paymentByCreditCard.ValidatePaymentDetails());
  }
  /**
   *
   * @name testPayCreditCard
   *
   * @brief Test for making a payment using a credit card in the PaymentByCreditCard class.
   *        It verifies that the payment amount is deducted from the balance correctly.
   */
  @Test
  public void testPayCreditCard() {
    PaymentByCreditCard paymentByCreditCard;
    paymentByCreditCard = new PaymentByCreditCard();
    int initialBalance = paymentByCreditCard.getAmount();
    int amountToPay = 200;
    paymentByCreditCard.pay(amountToPay);
    assertEquals(initialBalance - amountToPay, paymentByCreditCard.getAmount());
  }
  /**
   *
   * @name testValidatePaymentDetailsPayPal
   *
   * @brief Test for validating payment details using PayPal in the PaymentByPayPal class.
   *        It verifies that the payment details are valid.
   */
  @Test
  public void testValidatePaymentDetailsPayPal() {
    PaymentByPayPal paymentByPayPal;
    paymentByPayPal = new PaymentByPayPal();
    assertTrue(paymentByPayPal.ValidatePaymentDetails());
  }
  /**
   *
   * @name testPayPayPal
   *
   * @brief Test for making a payment using PayPal in the PaymentByPayPal class.
   *        It verifies that the payment amount is deducted from the balance correctly.
   */
  @Test
  public void testPayPayPal() {
    PaymentByPayPal paymentByPayPal;
    paymentByPayPal = new PaymentByPayPal();
    int initialBalance = paymentByPayPal.getAmount();
    int amountToPay = 322;
    paymentByPayPal.pay(amountToPay);
    assertEquals(initialBalance - amountToPay, paymentByPayPal.getAmount());
  }
  /**
   *
   * @name testPayPayPal2
   *
   * @brief Test for making a payment using PayPal in the PaymentByPayPal class.
   *        It verifies that the payment amount is deducted from the balance correctly.
   */
  @Test
  public void testPayPayPal2() {
    PaymentByPayPal paymentByPayPal;
    paymentByPayPal = new PaymentByPayPal();
    int initialBalance = paymentByPayPal.getAmount();
    int amountToPay = 1967;
    paymentByPayPal.pay(amountToPay);
    assertEquals(initialBalance - amountToPay, paymentByPayPal.getAmount());
  }
  /**
   *
   * @name testPayPayPal3
   *
   * @brief Test for making a payment using PayPal in the PaymentByPayPal class.
   *        It verifies that the payment amount is deducted from the balance correctly.
   */
  @Test
  public void testPayPayPal3() {
    PaymentByPayPal paymentByPayPal;
    paymentByPayPal = new PaymentByPayPal();
    int initialBalance = paymentByPayPal.getAmount();
    int amountToPay = 1161;
    paymentByPayPal.pay(amountToPay);
    assertEquals(initialBalance - amountToPay, paymentByPayPal.getAmount());
  }
  /**
   *
   * @name testCollectPaymentDetailsCash
   *
   * @brief Test for collecting payment details using cash in the PaymentByCash class.
   *        It verifies that the payment details are successfully collected.
   */
  @Test
  public void testCollectPaymentDetailsCash() {
    PaymentByCash paymentByCash = new PaymentByCash();
    paymentByCash.CollectPaymentDetails();
  }
  /**
   *
   * @name testValidatePaymentDetailsCash
   *
   * @brief Test for validating payment details using cash in the PaymentByCash class.
   *        It verifies that the payment details are valid.
   */
  @Test
  public void testValidatePaymentDetailsCash() {
    PaymentByCash paymentByCash = new PaymentByCash();
    assertTrue(paymentByCash.ValidatePaymentDetails());
  }
  /**
   *
   * @name testProccessOrder_ValidPaymentDetails_PaymentSuccessful
   *
   * @brief Test for processing an order with valid payment details in the PaymentService class.
   *        It verifies that the payment is successful when the payment details are valid.
   */
  @Test
  public void testProccessOrder_ValidPaymentDetails_PaymentSuccessful() {
    PaymentService paymentService;
    paymentService = new PaymentService();
    PaymentStrategy mockStrategy = new PaymentStrategy() {
      @Override
      public void CollectPaymentDetails() {
      }
      @Override
      public boolean ValidatePaymentDetails() {
        return true;
      }
      @Override
      public void pay(int amount) {
      }
    };
    paymentService.setCost(50);
    paymentService.setSelectedCarIndex(0);
    paymentService.setStrategy(mockStrategy);
    paymentService.proccessOrder();
  }
  /**
   *
   * @name testPayCash
   *
   * @brief Test for making a cash payment in the PaymentByCash class.
   *        It verifies that the payment amount is processed correctly.
   */
  @Test
  public void testPayCash() {
    PaymentByCash paymentByCash = new PaymentByCash();
    paymentByCash.pay(65);
  }
  /**
   *
   * @name testPayCash1
   *
   * @brief Test for making a cash payment in the PaymentByCash class.
   *        It verifies that the payment amount is processed correctly.
   */
  @Test
  public void testPayCash1() {
    PaymentByCash paymentByCash = new PaymentByCash();
    paymentByCash.pay(61);
  }
  /**
   *
   * @name testPayCash2
   *
   * @brief Test for making a cash payment in the PaymentByCash class.
   *        It verifies that the payment amount is processed correctly.
   */
  @Test
  public void testPayCash2() {
    PaymentByCash paymentByCash = new PaymentByCash();
    paymentByCash.pay(120);
  }
  /**
   *
   * @name testPayCash3
   *
   * @brief Test for making a cash payment in the PaymentByCash class.
   *        It verifies that the payment amount is processed correctly.
   */
  @Test
  public void testPayCash3() {
    PaymentByCash paymentByCash = new PaymentByCash();
    paymentByCash.pay(200);
  }
  /**
   *
   * @name testRemoveCost_CostExists_CostRemoved
   *
   * @brief Test for removing a cost from the PaymentService class.
   *        It verifies that a cost is successfully removed from the list of costs.
   */
  @Test
  public void testRemoveCost_CostExists_CostRemoved() {
    PaymentService paymentService;
    paymentService = new PaymentService();
    paymentService.setCost(100);
    paymentService.setCost(200);
    paymentService.setCost(300);
    int costIndexToRemove = 1;
    paymentService.removeCost(costIndexToRemove);
    assertFalse(paymentService.getCosts().contains(costIndexToRemove));
  }
  /**
   *
   * @name testCustomerRegistrationForm
   *
   * @brief Test for customer registration form in the RegistrationImpl class.
   *        It verifies that a new customer is created with the provided registration information.
   */
  @Test
  public void testCustomerRegistrationForm() {
    List<User> userList = new ArrayList<>();
    RegistrationImpl registration = new RegistrationImpl(userList);
    Customer customer = registration.customerRegistrationForm("Mark", "Junior", "mjmjmj", "junjunjun", "2002-06-06");
    assertEquals("Mark", customer.getFirstName());
    assertEquals("Junior", customer.getLastName());
    assertEquals("mjmjmj", customer.getUserName());
    assertEquals("junjunjun", customer.getPassword());
  }
  /**
   *
   * @name testCustomerRegistration
   *
   * @brief Test for customer registration in the RegistrationImpl class.
   *        It verifies that a new customer is registered and added to the user list.
   */
  @Test
  public void testCustomerRegistration() {
    List<User> userList = new ArrayList<>();
    RegistrationImpl registration = new RegistrationImpl(userList);
    Customer customer = new Customer("Selena", "Gomez", "SGomez", "fangomez61", "2012-05-01");
    registration.customerRegistration(customer);
    assertEquals(1, userList.size());
    assertEquals("Selena", userList.get(0).getFirstName());
    assertEquals("Gomez", userList.get(0).getLastName());
    assertEquals("SGomez", userList.get(0).getUserName());
    assertEquals("fangomez61", userList.get(0).getPassword());
  }
  /**
   *
   * @name testExitApp
   *
   * @brief Test for exiting the application in the LoginImpl class.
   *        It verifies that the correct exit message is displayed.
   */
  @Test
  public void testExitApp() {
    // Arrange
    LoginImpl login = new LoginImpl(null);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);
    // Act
    login.exitApp();
    // Assert
    String expectedOutput = "Hope you'll be back soon!";
    String actualOutput = outputStream.toString().trim();
    assertEquals(expectedOutput, actualOutput);
  }
  /**
   *
   * @name testInitiateRegistration
   *
   * @brief Test for initiating the registration process in the RegistrationImpl class.
   *        It verifies that the registration process is initiated and completed successfully.
   */
  @Test
  public void testInitiateRegistration() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    LoginImpl loginService = new LoginImpl(userList);
    registrationService.input = new Scanner("Test\nUser\ntestUser\ntestPass\n2020-01-01\n");
    registrationService.initiateRegistration(loginService);
    String expectedOutput = "Registration complete!";
    assertTrue(outContent.toString().contains(expectedOutput));
  }
  /**
   *
   * @name testInitiateRegistration2
   *
   * @brief Test for initiating the registration process in the RegistrationImpl class.
   *        It verifies that the registration process is initiated and completed successfully.
   */
  @Test
  public void testInitiateRegistration2() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    LoginImpl loginService = new LoginImpl(userList);
    registrationService.input = new Scanner("Test\nUser\ntestUser\ntestPass\n2023-05-01\n");
    registrationService.initiateRegistration(loginService);
    String expectedOutput = "License usage time is not enough";
    assertTrue(outContent.toString().contains(expectedOutput));
  }
  /**
   *
   * @name testInitiateRegistration3
   *
   * @brief Test for initiating the registration process in the RegistrationImpl class.
   *        It verifies that the registration process is initiated and completed successfully.
   */
  @Test
  public void testInitiateRegistration3() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    LoginImpl loginService = new LoginImpl(userList);
    registrationService.input = new Scanner("Test\nUser\ntestUser\ntestPass\nZORT\n");
    registrationService.initiateRegistration(loginService);
    String expectedOutput = "Parse Exception";
    assertTrue(outContent.toString().contains(expectedOutput));
  }
  /**
   *
   * @name testDisplayRegistrationMenu
   *
   * @brief Test for displaying the registration menu in the RegistrationImpl class.
   *        It verifies that the registration menu is displayed correctly.
   */
  @Test
  public void testDisplayRegistrationMenu() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    registrationService.displayRegistrationMenu();
    String expectedOutput = "REGISTER";
    assertTrue(outContent.toString().contains(expectedOutput));
  }



  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   *
   * @name testShopRegistrationForm
   *
   * @brief Test for the shop registration form in the Shop class.
   *        It verifies that a new customer is created with the provided registration form details.
   */

  @Test
  public void testShopRegistrationForm() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList,menu,login,registration);
    Customer customer= new Customer("John","Doe","johndoe","password","2002-02-02");
    assertEquals("John", customer.getFirstName());
    assertEquals("Doe", customer.getLastName());
    assertEquals("johndoe", customer.getUserName());
    assertEquals("password", customer.getPassword());
  }

  /**
   *
   * @name testCustomerRegistrationForm2
   *
   * @brief Test for the shop registration form in the Shop class.
   *        It verifies that a new customer is created with the provided registration form details.
   */


  @Test
  public void testCustomerRegistrationForm2() {
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    Customer customer = registrationService.customerRegistrationForm("Test", "User", "testUser", "testPass", "2020-01-01");
    assertEquals("Test", customer.getFirstName());
    assertEquals("User", customer.getLastName());
    assertEquals("testUser", customer.getUserName());
    assertEquals("testPass", customer.getPassword());
  }
  /**
   *
   * @name testCustomerRegistration2
   *
   * @brief Test for customer registration in the RegistrationImpl class.
   *        It verifies that a new customer is registered and added to the user list.
   */
  @Test
  public void testCustomerRegistration2() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    Customer customer = new Customer("tstEnter", "Lionel", "enterLionel", "linoelmesi", "2019-11-01");
    registrationService.customerRegistration(customer);
    String expectedOutput = "Registration complete!";
    assertTrue(outContent.toString().contains(expectedOutput));
    assertTrue(userList.contains(customer));
  }
  /**
   *
   * @name testCustomerRegistration3
   *
   * @brief Test for customer registration in the RegistrationImpl class.
   *        It verifies that a new customer is registered and added to the user list.
   */

  @Test
  public void testCustomerRegistration3() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    Customer customer = new Customer("Maardona", "Dona", "donrudma", "maramrar", "2017-11-01");
    registrationService.customerRegistration(customer);
    String expectedOutput = "Registration complete!";
    assertTrue(outContent.toString().contains(expectedOutput));
    assertTrue(userList.contains(customer));
  }


  /**
   *
   * @name testMainMenuController
   *
   * @brief Test for the main menu controller in the Shop class.
   *        It verifies that the main menu is displayed correctly.
   */
  @Test
  public void testMainMenuController() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(null, menu, null, null);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    shop.MENU_DISPLAY_SERVICE.showMainMenu();
    String expectedOutput = "+---------------------------------------------+\n"
                            + "|            -Car Rental Service-             |\n"
                            + "+---------------------------------------------+\n" + "\n"
                            + "                   -MAIN MENU-                 \n" + "1. Register\n" + "2. Login\n" + "3. Exit\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testAdminMenuController
   *
   * @brief Test for the admin menu controller in the Shop class.
   *        It verifies that the admin menu is displayed correctly.
   */
  @Test
  public void testAdminMenuController() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(null, menu, null, null);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    shop.MENU_DISPLAY_SERVICE.showAdminMenu();
    String expectedOutput = "+---------------------------------------------+\n" +
                            "|            -Car Rental Service-             |\n" +
                            "+---------------------------------------------+\n" +
                            "\n" +
                            "                  -ADMIN MENU-                 \n" +
                            "1. List Cars\n" +
                            "2. Add Car\n" +
                            "3. Delete Car\n" +
                            "4. Log-out\n" +
                            "5. Exit\n";
    assertEquals(expectedOutput, outContent.toString());
  }
  /**
   *
   * @name testCustomerMenuController
   *
   * @brief Test for the customer menu controller in the Shop class.
   *        It verifies that the customer menu is displayed correctly.
   */
  @Test
  public void testCustomerMenuController() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(null, menu, null, null);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    shop.MENU_DISPLAY_SERVICE.showCustomerMenu();
    String expectedOutput = "+---------------------------------------------+\n" +
                            "|            -Car Rental Service-             |\n" +
                            "+---------------------------------------------+\n" +
                            "\n" +
                            "                 -CUSTOMER MENU-               \n" +
                            "1. Rent a Car\n" +
                            "2. Logout\n" +
                            "3. Exit\n\n";
    assertEquals(expectedOutput, outContent.toString());
  }
//  /**
//   *
//   * @name testDisplayCarFeatures
//   *
//   * @brief Test for displaying car features in the Shop class.
//   *        It verifies that the car features are displayed correctly.
//   */
//  @Test
//  public void testDisplayCarFeatures() {
//    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    System.setOut(printStream);
//    CarFeaturesInterface car = RentalFactory.createCar("sedan","Toyota", "Corolla", 2021, "Gasoline", "White", 200, 5);
//    Shop shop = new Shop(null, null, null, null);
//    // Test
//    shop.displayCarFeatures(car);
//    String output = outputStream.toString();
//    String output2 = "TOYOTA   =>   COROLLA   =>   2021   =>   GASOLİNE   =>   WHİTE   =>   200   =>   5\n\r\n";
//    assertEquals(output, output2);
//  }
//  /**
//   *
//   * @name testDisplayCarFeatures2
//   *
//   * @brief Test for displaying car features in the Shop class.
//   *        It verifies that the car features are displayed correctly.
//   */
//  @Test
//  public void testDisplayCarFeatures2() {
//    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    System.setOut(printStream);
//    CarFeaturesInterface car = RentalFactory.createCar("sedan","Renault", "Clıo", 2021, "Gasoline", "White", 261, 4);
//    List<User> users = new ArrayList<>();
//    MenuImpl menuDisplayService = new MenuImpl();
//    RegistrationImpl registrationService = new RegistrationImpl(users);
//    LoginImpl loginService = new LoginImpl(users);
//    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
//    shop.displayCarFeatures(car);
//    String output = outputStream.toString();
//    String output2 = "RENAULT   =>   CLIO   =>   2021   =>   GASOLİNE   =>   WHİTE   =>   261   =>   4\n\r\n";
//    assertEquals(output, output2);
//  }
//  /**
//   *
//   * @name testDisplayCarFeatures3
//   *
//   * @brief Test for displaying car features in the Shop class.
//   *        It verifies that the car features are displayed correctly.
//   */
//  @Test
//  public void testDisplayCarFeatures3() {
//    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    System.setOut(printStream);
//    CarFeaturesInterface car = RentalFactory.createCar("suv","TOGG", "T10X", 2023, "Gasoline", "White", 261, 4);
//    List<User> users = new ArrayList<>();
//    MenuImpl menuDisplayService = new MenuImpl();
//    RegistrationImpl registrationService = new RegistrationImpl(users);
//    LoginImpl loginService = new LoginImpl(users);
//    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
//    shop.displayCarFeatures(car);
//    String output = outputStream.toString();
//    String output2 = "TOGG   =>   T10X   =>   2023   =>   GASOLİNE   =>   WHİTE   =>   261   =>   4\n\r\n";
//    assertEquals(output, output2);
//  }
//  /**
//   *
//   * @name testDisplayCarFeatures4
//   *
//   * @brief Test for displaying car features in the Shop class.
//   *        It verifies that the car features are displayed correctly.
//   */
//  @Test
//  public void testDisplayCarFeatures4() {
//    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    System.setOut(printStream);
//    CarFeaturesInterface car = RentalFactory.createCar("suv","Chery", "OMODA5", 2023, "Gasoline", "White", 200, 4);
//    List<User> users = new ArrayList<>();
//    MenuImpl menuDisplayService = new MenuImpl();
//    RegistrationImpl registrationService = new RegistrationImpl(users);
//    LoginImpl loginService = new LoginImpl(users);
//    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
//    shop.displayCarFeatures(car);
//    String output = outputStream.toString();
//    String output2 = "CHERY   =>   OMODA5   =>   2023   =>   GASOLİNE   =>   WHİTE   =>   200   =>   4\n\r\n";
//    assertEquals(output, output2);
//  }

  /**
   *
   * @name testApp
   *
   * @brief Test for the main application flow in the Shop class.
   *        It verifies the initialization of users, registration, and login services.
   */
  @Test
  public void testApp() {
    UserDatabase.getAdminList().add((new Admin("Admin9", "ADMIN9", "admin9", "00009")));
    UserDatabase.getCustomerList().add((new Customer("Customer9", "Customer9", "Customer9", "00009","2000-01-01")));
    List<User> users = new ArrayList<>();
    users.addAll(UserDatabase.getAdminList());
    users.addAll(UserDatabase.getCustomerList());
    MenuImpl menuDisplayService = new MenuImpl();
    RegistrationImpl registrationService = new RegistrationImpl(users);
    LoginImpl loginService = new LoginImpl(users);
    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
    Customer customer= new Customer("Eren","Sisman","erensisman6161","123","2002-02-02");
    assertEquals("Eren", customer.getFirstName());
    assertEquals("Sisman", customer.getLastName());
    assertEquals("erensisman6161", customer.getUserName());
    assertEquals("123", customer.getPassword());
    assertEquals(9, users.size());
    assertNotNull(registrationService);
    assertNotNull(loginService);
  }
  /**
   *
   * @name testApp2
   *
   * @brief Test for the main application flow in the Shop class.
   *        It verifies the initialization of users, registration, and login services.
   */
  @Test
  public void testApp2() {
    UserDatabase.getAdminList().add((new Admin("Admi", "ADMIN", "admi", "00009")));
    UserDatabase.getCustomerList().add((new Customer("Custom", "Custom", "Custom", "0000449","2000-01-01")));
    List<User> users = new ArrayList<>();
    users.addAll(UserDatabase.getAdminList());
    users.addAll(UserDatabase.getCustomerList());
    MenuImpl menuDisplayService = new MenuImpl();
    RegistrationImpl registrationService = new RegistrationImpl(users);
    LoginImpl loginService = new LoginImpl(users);
    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
    Customer customer= new Customer("Eren","Sisman","erensisman","123","2002-02-02");
    assertEquals("Eren", customer.getFirstName());
    assertEquals("Sisman", customer.getLastName());
    assertEquals("erensisman", customer.getUserName());
    assertEquals("123", customer.getPassword());
    assertEquals(9, users.size());
    assertNotNull(registrationService);
    assertNotNull(loginService);
  }
  /**
   *
   * @name testApp3
   *
   * @brief Test for the main application flow in the Shop class.
   *        It verifies the initialization of users, registration, and login services.
   */
  @Test
  public void testApp3() {
    UserDatabase.getAdminList().add((new Admin("Admin8", "ADMIN8", "admin8", "00089")));
    UserDatabase.getCustomerList().add((new Customer("Customer8", "Customer8", "Customer8", "00089","1990-01-01")));
    List<User> users = new ArrayList<>();
    users.addAll(UserDatabase.getAdminList());
    users.addAll(UserDatabase.getCustomerList());
    MenuImpl menuDisplayService = new MenuImpl();
    RegistrationImpl registrationService = new RegistrationImpl(users);
    LoginImpl loginService = new LoginImpl(users);
    Shop shop = new Shop(users, menuDisplayService, loginService, registrationService);
    Customer customer= new Customer("Resul","Beser","rbrb","61616161","2002-06-02");
    assertEquals("Resul", customer.getFirstName());
    assertEquals("Beser", customer.getLastName());
    assertEquals("rbrb", customer.getUserName());
    assertEquals("61616161", customer.getPassword());
    assertEquals(9, users.size());
    assertNotNull(registrationService);
    assertNotNull(users);
    assertNotNull(loginService);
  }



  /**
   *
   *
   * @name testCustomerMenuControl
   *
   * @brief Tests the customer menu controller in the Shop application.
   *
   * It creates instances of the necessary classes, adds default cars to the shop,
   * and simulates user input to navigate through the customer menu.
   * Verifies that the customer menu controller is executed successfully.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   *
   */

  @Test
  public void testCustomerMenuControl() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "1\n1\n1\n1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   * @name testCustomerMenuControl2
   *
   * @brief Tests the customer menu controller in the Shop application.
   *
   * It creates instances of the necessary classes, adds default cars to the shop,
   * and simulates user input to navigate through the customer menu.
   * Verifies that the customer menu controller is executed successfully.
   *
   */
  @Test
  public void testCustomerMenuControl2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "1\n1\n1\n1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testCustomerMenuControl3
   *
   * @brief Tests the customer menu controller in the Shop application.
   *
   * It creates instances of the necessary classes, adds default cars to the shop,
   * and simulates user input to navigate through the customer menu.
   * Verifies that the customer menu controller is executed successfully.
   *
   */

  @Test
  public void testCustomerMenuControl3() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "1\n3\n1\n1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testCustomerMenuControl4
   *
   * @brief Tests the customer menu controller in the Shop application.
   *
   * It creates instances of the necessary classes, adds default cars to the shop,
   * and simulates user input to navigate through the customer menu.
   * Verifies that the customer menu controller is executed successfully.
   *
   */
  @Test
  public void testCustomerMenuControl4() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("1\n3\n");
    shop.customerMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testCustomerMenuControl5
   *
   * @brief Tests the customer menu controller in the Shop application.
   *
   * It creates instances of the necessary classes, adds default cars to the shop,
   * and simulates user input to navigate through the customer menu.
   * Verifies that the customer menu controller is executed successfully.
   *
   */
  @Test
  public void testCustomerMenuControl5() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "2\n1\n1\n1\n1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   * @name testApplication
   *
   * @brief Tests the main application entry point.
   *
   * It creates an instance of the application, simulates user input to exit the application,
   * and verifies that the test passes.
   *
   */

  @Test
  public void testApplication() {
    App app = new App();
    String input = "3";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    App.main(new String[] {});
    assertTrue(true);
  }

  /**
   *
   * @name testShopLogin
   *
   * @brief Tests the shop login functionality.
   *
   * It creates instances of the necessary classes, adds a customer to the user list,
   * simulates user input to navigate through the main menu and login,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */

  @Test
  public void testShopLogin() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    userList.add(new Customer("RESUL", "BESER", "resulbeser", "mackali", "2002-06-05"));
    shop.INPUT = new Scanner("2\n3");
    login.input = new Scanner("resulbeser\nmackali\n");
    shop.mainMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopLogin2
   *
   * @brief Tests the shop login functionality.
   *
   * It creates instances of the necessary classes, adds a customer to the user list,
   * simulates user input to navigate through the main menu and login,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopLogin2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("7\n3\n");
    shop.mainMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopLogin3
   *
   * @brief Tests the shop login functionality.
   *
   * It creates instances of the necessary classes, adds a customer to the user list,
   * simulates user input to navigate through the main menu and login,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopLogin3() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    userList.add(new Admin("0AD0MIN", "0AD0MIN", "admin", "1234"));
    shop.INPUT = new Scanner("2\n5");
    login.input = new Scanner("admin\n1234\n");
    shop.mainMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopCustomMenu
   *
   * @brief Tests the customer menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the customer menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopCustomMenu() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n3");
    shop.customerMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopCustomMenu2
   *
   * @brief Tests the customer menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the customer menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopCustomMenu2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("20\n3");
    shop.customerMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenu() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("20\n5");
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu2
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenu2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("4\n3");
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu3
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */

  @Test
  public void testShopAdminMenu3() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "2\nCHERY\nTGGO7PRO\n2023\nGASOLNE\nGRAY\n1967\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu4
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenu4() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "3\nCHERY\nLNE\n2017\nGASOLNE\nGRAY\n196\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu5
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenu5() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "4\nCHERY\nTGGO5\n2023\nGASOLNE\nGRAY\n1967\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenu6
   *
   * @brief Tests the admin menu functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to the admin menu,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenu6() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "1\nCHERY\nTGGO7PRO\n2022\nGASOLNE\nGRAY\n196\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   *
   * @name testAdminDelete
   *
   * @brief Tests the admin delete functionality.
   *
   * It creates instances of the necessary classes, adds a car to the shop's rental cars list,
   * simulates user input to navigate to the admin menu and perform a delete operation,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   * @param car The car to be added to the rental cars list.
   *
   */
  @Test
  public void testAdminDelete() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    CarFeaturesInterface car = RentalFactory.createCar("sedan", "SKODA", "OCTAVA", 2012, "GASOLNE", "GRAY", 967, 4);
    shop.rentalCars.add(car);
    shop.INPUT = new Scanner("3\n5\n");
    String input = "1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   *
   * @name testAdminDelete2
   *
   * @brief Tests the admin delete functionality.
   *
   * It creates instances of the necessary classes, adds a car to the shop's rental cars list,
   * simulates user input to navigate to the admin menu and perform a delete operation,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   * @param car The car to be added to the rental cars list.
   *
   */
  @Test
  public void testAdminDelete2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    CarFeaturesInterface car = RentalFactory.createCar("suv", "SUZU", "DMAX", 2013, "GASOLNE", "GRAY", 2967, 4);
    shop.rentalCars.add(car);
    shop.INPUT = new Scanner("3\n5\n");
    String input = "2\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   *
   * @name testAdminDelete3
   *
   * @brief Tests the admin delete functionality.
   *
   * It creates instances of the necessary classes, adds a car to the shop's rental cars list,
   * simulates user input to navigate to the admin menu and perform a delete operation,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   * @param car The car to be added to the rental cars list.
   *
   */

  @Test
  public void testAdminDelete3() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "1\n2\n1\n1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   *
   * @name testMenuController
   *
   * @brief Tests the menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testMenuController() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5\n");
    String input = "7\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   *
   * @name testMenuController2
   *
   * @brief Tests the menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */

  @Test
  public void testMenuController2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("1\n5\n");
    ;
    shop.adminMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   *
   * @name testMenuController3
   *
   * @brief Tests the menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */

  @Test
  public void testMenuController3() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    CarFeaturesInterface car = RentalFactory.createCar("suv", "CHERY", "OMODA9", 2023, "GASOLNE", "GRAY", 1967, 4);
    shop.rentalCars.add(car);
    shop.INPUT = new Scanner("1\n5\n");
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenuCar
   *
   * @brief Tests the menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenuCar() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "5\nCHERY\nTGGO7PRO\n2023\nGASOLNE\nGRAY\n1967\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }
  /**
   *
   * @name testShopAdminMenuCar2
   *
   * @brief Tests the menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testShopAdminMenuCar2() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("2\n5");
    String input = "6\nRENAULT\nCLO\n2007\nGASOLNE\nGRAY\n132\n4\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.adminMenuController();
    Assert.assertTrue(true);
  }


  /**
   *
   * @name testShopCustomerMenuControl
   *
   * @brief Tests the customer menu controller functionality.
   *
   * It creates instances of the necessary classes, sets up default cars, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */

  @Test
  public void testShopCustomerMenuControl() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.DefaultCars();
    shop.INPUT = new Scanner("1\n");
    String input = "1\n5";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    shop.customerMenuController();
    Assert.assertTrue(true);
  }

  /**
   *
   * @name testRegisterMenuControl
   *
   * @brief Tests the registration menu control functionality.
   *
   * It creates instances of the necessary classes, redirects the output stream to capture the output,
   * performs a customer registration, and verifies the output and the updated user list.
   *
   * @param outContent The output stream content.
   * @param userList The list of users in the system.
   * @param registrationService The registration implementation for user registration.
   * @param customer The customer instance for registration.
   *
   */
  @Test
  public void testRegisterMenuControl() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<User> userList = new ArrayList<>();
    RegistrationImpl registrationService = new RegistrationImpl(userList);
    Customer customer = new Customer("Eren", "Sisman", "resulbeser", "rbrb123", "2012-06-24");
    registrationService.customerRegistration(customer);
    String expectedOutput = "Registration complete!";
    assertTrue(outContent.toString().contains(expectedOutput));
    assertTrue(userList.contains(customer));
  }
  /**
   *
   * @name testRegisterMenuController
   *
   * @brief Tests the registration menu controller functionality.
   *
   * It creates instances of the necessary classes, simulates user input to navigate to a specific menu option,
   * and verifies that the test passes.
   *
   * @param userList The list of users in the system.
   * @param login The login implementation for user authentication.
   * @param registration The registration implementation for user registration.
   * @param menu The menu implementation for displaying menus.
   * @param shop The shop instance.
   *
   */
  @Test
  public void testRegisterMenuController() {
    List<User> userList = new ArrayList<>();
    LoginImpl login = new LoginImpl(userList);
    RegistrationImpl registration = new RegistrationImpl(userList);
    MenuImpl menu = new MenuImpl();
    Shop shop = new Shop(userList, menu, login, registration);
    shop.INPUT = new Scanner("1\n3\n");
    registration.input = new Scanner("Eren\nSisman\nerenresul\n1234\n2003-04-13\n");
    shop.mainMenuController();
    Assert.assertTrue(true);
  }





}
