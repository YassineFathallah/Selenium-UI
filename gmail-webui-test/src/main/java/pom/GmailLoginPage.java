package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebUtils;

public class GmailLoginPage {
  
  public void fillLogin(WebDriver driver){
    WebUtils.sendKeys(driver, By.id("Email"), "seleniumtest596");
    WebUtils.click(driver, By.id("next"));
  }
  
  public void fillPassword(WebDriver driver){
    WebUtils.waitForElement(driver, By.id("Passwd"));
    WebUtils.sendKeys(driver, By.id("Passwd"), "selenium2017");
  }
  
  public GmailHomePage signIn(WebDriver driver){
    WebUtils.click(driver, By.id("signIn"));
    WebUtils.waitForElement(driver, By.partialLinkText("Boîte"));
    
    return PageFactory.initElements(driver, GmailHomePage.class);
  }
  
  public boolean isAtPage(WebDriver driver){
    return WebUtils.getElementsBy(driver, By.id("Email")).size() > 0;
  }
}
