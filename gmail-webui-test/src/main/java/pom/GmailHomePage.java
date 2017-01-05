package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebUtils;

public class GmailHomePage {

  public boolean isAtPage(WebDriver driver){
    return driver.findElements(By.partialLinkText("Boîte")).size() > 0;
  }
  public GmailLoginPage signOut(WebDriver driver){
    WebUtils.click(driver, By.cssSelector("span[class='gb_8a gbii']"));
    return PageFactory.initElements(driver, GmailLoginPage.class);
  }
  
  public void composeMessage(WebDriver driver){
    WebUtils.click(driver, By.cssSelector("div[role='button'][gh='cm']"));
  }
  
  public void fillToField(WebDriver driver){
    WebUtils.waitForElement(driver, By.cssSelector("textarea[name='to']"));
    WebUtils.sendKeys(driver, By.cssSelector("textarea[name='to']"), "seleniumtest596@gmail.com");
  }
  
  public void addSubject(WebDriver driver){
    WebUtils.sendKeys(driver, By.cssSelector("input[name='subjectbox']"), "Selenium Test");
  }
  
  public void clickSend(WebDriver driver) {
    WebUtils.click(driver, By.xpath("//div[contains(text(),'Envoyer')]"));
  }
  
  public void clickInbox(WebDriver driver) {
    WebUtils.waitForElement(driver, By.linkText("Boîte de réception (1)"));
    WebUtils.click(driver, By.linkText("Boîte de réception (1)"));
  }
  
  public GmailVIewPage clickNewMail(WebDriver driver) {
    WebUtils.waitForElement(driver, By.cssSelector("div[class='y6'] span[id] b"));
    WebUtils.click( driver, By.cssSelector("div[class='y6'] span[id] b"));
    return PageFactory.initElements(driver, GmailVIewPage.class);
  }
}
