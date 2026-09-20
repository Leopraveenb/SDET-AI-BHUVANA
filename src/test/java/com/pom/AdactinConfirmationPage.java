package com.pom;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

	public class AdactinConfirmationPage extends BaseClass {
		public AdactinConfirmationPage() {
			PageFactory.initElements(driver,this);
		}
	    @FindBy(id = "first_name")
	    private WebElement firstName;

	    @FindBy(id = "last_name")
	    private WebElement lastName;

	    @FindBy(id = "address")
	    private WebElement address;

	    @FindBy(id = "cc_num")
	    private WebElement cardNumber;

	    @FindBy(id = "cc_type")
	    private WebElement cardType;

	    @FindBy(id = "cc_exp_month")
	    private WebElement expiryMonth;

	    @FindBy(id = "cc_exp_year")
	    private WebElement expiryYear;

	    @FindBy(id = "cc_cvv")
	    private WebElement cvv;

	    @FindBy(id = "book_now")
	    private WebElement bookNow;
	    
	    @FindBy(id ="order_no")
	    private WebElement order;
	    
	    @FindBy(id = "cc_cvv_span")
	    private WebElement cvvErrorMessage;


		public WebElement getCvvErrorMessage() {
			return cvvErrorMessage;
		}

		public WebElement getFirstName() {
			return firstName;
		}

		public WebElement getLastName() {
			return lastName;
		}

		public WebElement getAddress() {
			return address;
		}

		public WebElement getCardNumber() {
			return cardNumber;
		}

		public WebElement getCardType() {
			return cardType;
		}

		public WebElement getExpiryMonth() {
			return expiryMonth;
		}

		public WebElement getExpiryYear() {
			return expiryYear;
		}

		public WebElement getCvv() {
			return cvv;
		}

		public WebElement getBookNow() {
			return bookNow;
		}
		public WebElement getOrder() {
		    return order;

		}
}