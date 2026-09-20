package com.stepdefinition;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.testng.Assert;

import com.baseclass.BaseClass;
import com.pom.AdactinConfirmationPage;
import com.pom.AdactinHotelselection;
import com.pom.AdactinLoginPage;
import com.pom.Adactinbuttonpage;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class StepDefinitionAdactin extends BaseClass {
		//Tc01
		//Launch URL
	    @Given("To launch the Url")
	    public void to_launch_the_url() {
	    LaunchUrl("https://adactinhotelapp.com/");
	   
	    System.out.println("Application launched successfully");

	    }
	    //Validate homePage
	    @Given("Validate the homepage")
	    public void validate_the_homepage() {
	   String title = driver.getTitle();
	    System.out.println("Home Page Title : " + title);
	    Assert.assertTrue(title.contains("Adactin"));
	    }
	    //Login Tc01//Tc02//Tc03//Tc04//Tc05
	  @When("Enter the {string} and {string}")
	    public void enter_the_username_and_password(String username,String password) {
		  AdactinLoginPage  loginPage = new AdactinLoginPage();
		  loginPage.EnterText(loginPage.getUsername(), username);
		  loginPage.EnterText(loginPage.getPassword(), password);
	    }
	   @Then("Click the login Button")
	    public void click_the_login_button() {
			  AdactinLoginPage  loginPage = new AdactinLoginPage();
	          loginPage.ButtonClick(loginPage.getLoginbtn());
	          
	    }
	   //HotelSearch 

	  @Then("Enter the booking fields such as {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
		public void enter_the_booking_fields_such_as(String location, String hotels, String roomtype, String numberofrooms,
				String checkindate, String checkoutdate, String adults, String children) throws InterruptedException {
		    AdactinHotelselection  hotelPage = new AdactinHotelselection();

	        // Location
		    hotelPage.Dropdownbyvisible(hotelPage.getLocation(), location);

	        // Hotel
		    hotelPage.Dropdownbyvisible(hotelPage.getHotels(), hotels);

	        // Room Type
		    hotelPage.Dropdownbyvisible(hotelPage.getRoomType(), roomtype);

	        // Number of Rooms
		    hotelPage.Dropdownbyvisible(hotelPage.getRoomNumbers(), numberofrooms);

	        // Check-in Date
	        hotelPage.getCheckInDate().clear();
	        hotelPage.EnterText(hotelPage.getCheckInDate(), checkindate);

	        // Check-out Date
	        hotelPage.getCheckOutDate().clear();
	        hotelPage.EnterText(hotelPage.getCheckOutDate(), checkoutdate);

	        // Adults
	        hotelPage.Dropdownbyvisible(hotelPage.getAdults(), adults);

	        // Children
	        hotelPage.Dropdownbyvisible(hotelPage.getChildren(), children);
	        System.out.println("Booking fields entered successfully");

	        Thread.sleep(3000);
	    }
	// Validate
	    @Then("Validate that we enter into next page")
	    public void validate_that_we_enter_into_next_page() throws InterruptedException {
		    AdactinHotelselection  hotelPage = new AdactinHotelselection();
	       hotelPage.ButtonClick(hotelPage.getSearchButton());
	       System.out.println("Search button clicked successfully");
	       Thread.sleep(1000);
	    }
	    

	   
	    @Then("Click the Continue Button")
	    public void click_the_continue_button() throws InterruptedException {

	    	Adactinbuttonpage  buttonPage = new Adactinbuttonpage();

	        // Select hotel
	    	buttonPage. ButtonClick(buttonPage.getSelectHotel());

	        // Continue
	    	buttonPage. ButtonClick(buttonPage.getContinueButton());
	    	Thread.sleep(2000);
	    }

	@Then("Successfully Validate the Select Hotel")
	    public void successfully_validate_the_select_hotel() {
	    String title = driver.getTitle();
	    System.out.println("Booking Page Title : " + title);
	    Assert.assertTrue( title.contains("Adactin"));
	    }
	    @Then("Enter the Payment Details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} for booking")
		public void enter_the_payment_details_for_booking(String firstname, String lastname, String billingAddress,
				String cardNumber, String cardType, String expMonth, String expYear, String cvv) {

	    	AdactinConfirmationPage confirmationPage = new AdactinConfirmationPage();
	       confirmationPage.EnterText(confirmationPage.getFirstName(), firstname);
	       confirmationPage.EnterText(confirmationPage.getLastName(), lastname);
	       confirmationPage.EnterText(confirmationPage.getAddress(), billingAddress);
	       confirmationPage.EnterText(confirmationPage.getCardNumber(), cardNumber);
	       confirmationPage. Dropdownbyvisible( confirmationPage.getCardType(), cardType );
	       confirmationPage.Dropdownbyvisible(confirmationPage.getExpiryMonth(), expMonth);
	       confirmationPage.Dropdownbyvisible(confirmationPage.getExpiryYear(),expYear);
	       confirmationPage. EnterText(confirmationPage.getCvv(), cvv);
	      System.out.println("Payment details entered successfully");
	    }

	    @Then("Click the Book Now Button")
	    public void click_the_book_now_button() {
	    	AdactinConfirmationPage confirmationPage = new AdactinConfirmationPage();
	       confirmationPage.ButtonClick(confirmationPage.getBookNow());
	      System.out.println("Book Now button clicked");
	    }

	    @Then("Successfully Validate the Booking")
	    public void successfully_validate_the_booking() throws InterruptedException {
	    String title = driver.getTitle();
	    System.out.println("Booking Confirmation Page Title : " + title);
	    Assert.assertTrue(title.contains("Adactin"));
	    System.out.println("Booking Successfully Completed");
	    Thread.sleep(8000);
	    }
	    @Then("Validate the orderid")
	    public void validate_the_orderid() throws InterruptedException {

	    	AdactinConfirmationPage confirmationPage = new AdactinConfirmationPage();
	        String orderId =confirmationPage.getOrder().getAttribute("value");
	        System.out.println(orderId);
	        Assert.assertFalse(orderId.isEmpty());
	        System.out.println("Order ID validated successfully");
	        Thread.sleep(8000);
	    }
	  //Tc02 Login without user name
	    @Then("Validate the username exception message")
	    public void validate_the_username_exception_message() throws InterruptedException {
	 		  AdactinLoginPage  loginPage = new AdactinLoginPage();
	       WebElement actualMessage = loginPage.getUsernameErrorMessage();
	       String text = actualMessage.getText();
	      System.out.println("Username Exception Message : " + text);
	      Thread.sleep(3000);
	    }
	    //Tc03
	    @Then("Validate the location exception message")
	    public void validate_the_location_exception_message() throws InterruptedException {
	    	
	    	AdactinHotelselection selectionPage = new AdactinHotelselection();
	    	
	    	WebElement locationErrorMessage = selectionPage.getLocationErrorMessage();
	    	String text = locationErrorMessage.getText();
	    	System.out.println("location exception message: "+text);
	    	Thread.sleep(3000);
	    	
//	    	Adactinbuttonpage  buttonPage = new Adactinbuttonpage();
//
//	        WebElement actualMessage = buttonPage.getLocationErrorMessage();
//	        String text = actualMessage.getText();
//	        System.out.println("location exception message : "+text);
//	        Thread.sleep(3000);
	    }

	//Tc04
	    @Then("Validate the CVV exception message")
	    public void validate_the_cvv_exception_message() throws InterruptedException {
	    	AdactinConfirmationPage confirmationPage = new AdactinConfirmationPage();
	    	WebElement cvvErrorMessage = confirmationPage.getCvvErrorMessage();
	    	String text = cvvErrorMessage.getText();
	    	System.out.println( text);
	    	System.out.println("CVV exception message :"+text);
	    	Thread.sleep(7000);
	    }

	//TC 05
	    @Then("Get the Order ID and store it in a List")
	    public void get_the_order_id_and_store_it_in_a_list() throws InterruptedException {
	    	AdactinConfirmationPage confirmationPage = new AdactinConfirmationPage();
	    	
	        String orderId =confirmationPage.getOrder().getAttribute("value");
	        System.out.println(orderId);
	    	System.out.println("order id : "+orderId);
	        List<String> orderIdList = new ArrayList<>();
	        orderIdList.add(orderId);
	        System.out.println("orderIdList :"+orderIdList);
	        Assert.assertFalse(orderIdList.isEmpty());

	        System.out.println("Order ID successfully stored in List");
	        Thread.sleep(3000);
	    }
	}