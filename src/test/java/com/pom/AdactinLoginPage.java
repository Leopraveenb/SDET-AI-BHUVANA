package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


public class AdactinLoginPage extends BaseClass {
public AdactinLoginPage() {
	PageFactory.initElements(driver,this);
	}

@FindBy(id="username")
private WebElement username;


@FindBy(id="password")
private WebElement password;

@FindBy(id="login")
private WebElement loginbtn;

@FindBy(id = "username_span")
private WebElement usernameErrorMessage;


public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLoginbtn() {
	return loginbtn;
}

public WebElement getUsernameErrorMessage() {
	return usernameErrorMessage;
}

}