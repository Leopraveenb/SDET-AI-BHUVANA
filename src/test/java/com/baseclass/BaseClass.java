package com.baseclass;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
	public static WebDriver driver;

	public static void LaunchUrl (String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void EnterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void ButtonClick(WebElement element)	{
		element.click();
	}
	public void GettextDemo(WebElement element) {
		element.getText();
		
	}
	public String GetAttributeDemo(WebElement element, String attribute) {
	    return element.getAttribute(attribute);
	}
	public void MouseHover(WebElement element){
		Actions ac=new Actions(driver);
		ac.moveToElement(element).click().perform();
		
	}
	public void DoubleClick(WebElement element) {
		Actions ac=new Actions(driver);
		ac.doubleClick(element).perform();
	}
	public void ContextClick(WebElement element) {
	Actions ac =new Actions(driver);
	ac.contextClick(element).perform();
	}
	public void DragandDrop(WebElement Source,WebElement Dest) {
	Actions ac=new Actions(driver);
	ac.dragAndDrop(Source,Dest).perform();
	}
	public void Dropdownbyvisible(WebElement element,String text) {
		Select se=new Select(element);
		se.selectByVisibleText(text);
		}
	public void Dropdownbyvalue(WebElement element,String value) {
		Select se=new Select(element);
		se.selectByValue(value);
	}
	public void Dropdwnbyindex(WebElement element,int index) {
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	public void Dropdownbydeselect(WebElement element,String text) {
		Select se=new Select(element);
		se.deselectAll();
	}
	public void Dropdowndeselectbytext(WebElement element,String text) {
		Select se=new Select(element); 
		se.deSelectByContainsVisibleText(text);
	}
	public void Dropdowndeselectbyvalue(WebElement element,String value) {
		Select se=new Select(element);
		se.deselectByValue(value);
	}
	public void Dropdowndeselectbyindex(WebElement element,int index) {
		Select se=new Select(element);
		se.deselectByIndex(index);
	}
	public List<WebElement> btoptions(WebElement element){
		Select select = new Select(element);
	    return select.getOptions();
	}
	public WebElement getFirstSelectedOption(WebElement element) {
	Select select = new Select(element);
	return select.getFirstSelectedOption();
	}
	public List<WebElement> getAllSelectedOptions(WebElement element) {
	    Select select = new Select(element);
	    return select.getAllSelectedOptions();
	}
	public void SimpleAlert(WebElement element,String text) {
		Alert al=driver.switchTo().alert();
		al.getText();
		al.accept();
	}
	public void ConfirmAlert(WebElement element) {
		driver.switchTo().alert().dismiss();
	}
	public void PromptAlert(WebElement element, String text) {
		Alert al=driver.switchTo().alert();
		al.sendKeys(text);
		al.accept();
	}
	public void RobotEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void	Screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("Screenshotspath/" + name + ".png");
		FileUtils.copyFile(source, target);
	}
	public void JsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript( "arguments[0].click();", element); 
		}
	public void jsSendKeys(WebElement element, String text) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1];", element, text);
	}
	public void jsSetAttribute(WebElement element, String attribute, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].setAttribute(value, arguments[2]);",
	    		element, attribute, value );
	}
	public void jsGetAttribute(WebElement element, String attribute) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Object executeScript = js.executeScript( "return arguments[0].arguments;",  element);
		String text = executeScript.toString();
	    System.out.println(text);
	}
	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 600);");
	}
	public void ScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, -600);");
	}
	public void Scrollhorizontal() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(600,0);");
	}
	public void ScrollIntoDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView(true]);",element);
	}
	public void ScrollintoUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView(false]);",element);
	}
	public void TwoWindowHandling() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
	    	System.out.println(childWindow);
	    	if (!parentWindow.equals(childWindow)) {
	    	    driver.switchTo().window(childWindow);
	            }
	    
		}

	}
	  public void MultiHandlingDemo() {
			String parentWindow = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();
		    List<String> li=new LinkedList<>();
		    li.addAll(windowHandles);
		    driver.switchTo().window(li.get(0));
		    driver.switchTo().window(li.get(1));
		    driver.switchTo().window(parentWindow);
		    
	  }
	}