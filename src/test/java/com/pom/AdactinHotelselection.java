package com.pom;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

	public class AdactinHotelselection extends BaseClass {
		public AdactinHotelselection() {
			PageFactory.initElements(driver,this);
			}
		
		@FindBy(id = "location")
	    private WebElement location;
		
	    @FindBy(id = "location_span")
	    private WebElement locationErrorMessage;


	    @FindBy(id = "hotels")
	    private WebElement hotels;

	    @FindBy(id = "room_type")
	    private WebElement roomType;

	    @FindBy(id = "room_nos")
	    private WebElement roomNumbers;

	    @FindBy(id = "datepick_in")
	    private WebElement checkInDate;

	    @FindBy(id = "datepick_out")
	    private WebElement checkOutDate;

	    @FindBy(id = "adult_room")
	    private WebElement adults;

	    @FindBy(id = "child_room")
	    private WebElement children;

	    @FindBy(id = "Submit")
	    private WebElement searchButton;
	    


		public void setLocationErrorMessage(WebElement locationErrorMessage) {
			this.locationErrorMessage = locationErrorMessage;
		}

		public WebElement getLocation() {
			return location;
		}

		public WebElement getHotels() {
			return hotels;
		}

		public WebElement getRoomType() {
			return roomType;
		}

		public WebElement getRoomNumbers() {
			return roomNumbers;
		}

		public WebElement getCheckInDate() {
			return checkInDate;
		}

		public WebElement getCheckOutDate() {
			return checkOutDate;
		}

		public WebElement getAdults() {
			return adults;
		}

		public WebElement getChildren() {
			return children;
		}

		public WebElement getSearchButton() {
			return searchButton;
		}

		public WebElement getLocationErrorMessage() {
			// TODO Auto-generated method stub
			return null;
		}
			
		}