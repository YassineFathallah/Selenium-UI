package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.GmailLoginPage;

import java.util.List;

public class WebUtils {
  
  final static int TIME_OUT = 30;

  public GmailLoginPage goToLoginPage(WebDriver driver, String url){
    driver.get(url);
    driver.manage().window().maximize();
    return PageFactory.initElements(driver, GmailLoginPage.class);
  }
  
  public static void click(WebDriver driver, By by){
    driver.findElement(by).click();
  }
  
  public static void sendKeys(WebDriver driver, By by, String value){
    driver.findElement(by).sendKeys(value);
  }
  
  public static void waitForElement(WebDriver driver, By by) {
    WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }
  
  public static WebElement getElementBy(WebDriver driver, By by) {
    return driver.findElement(by);
  }
  
  public static List<WebElement> getElementsBy(WebDriver driver, By by) {
    return driver.findElements(by);
  }
}
