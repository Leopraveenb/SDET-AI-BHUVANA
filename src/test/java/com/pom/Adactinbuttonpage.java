package com.pom;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


	public class Adactinbuttonpage extends BaseClass {
	public Adactinbuttonpage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement selectHotel;

	@FindBy(id = "continue")
	private WebElement continueButton;


	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	}