package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage {

  public boolean isAtPage(WebDriver driver){
    return driver.findElements(By.partialLinkText("Boîte")).size() > 0;
  }
  public GmailLoginPage signOut(WebDriver driver){
    WebElement icon = driver.findElement(By.cssSelector("span[class='gb_8a gbii']"));
    icon.click();
    return PageFactory.initElements(driver, GmailLoginPage.class);
  }
  
  public void composeMessage(WebDriver driver){
    WebElement compose = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
    compose.click();
  }
  
  public void fillToField(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
    WebElement to = driver.findElement(By.cssSelector("textarea[name='to']"));
    to.sendKeys("seleniumtest596@gmail.com");
  }
  
  public void addSubject(WebDriver driver){
    WebElement objet = driver.findElement(By.cssSelector("input[name='subjectbox']"));
    objet.sendKeys("Selenium Test");
  }
  
  public void clickSend(WebDriver driver) {
    WebElement send = driver.findElement(By.xpath("//div[contains(text(),'Envoyer')]"));
    send.click();
  }
  
  public void clickInbox(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Boîte de réception (1)")));
    WebElement inboxLinkage = driver.findElement(By.linkText("Boîte de réception (1)"));
    inboxLinkage.click();
  }
  
  public GmailVIewPage clickNewMail(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
    WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
    newEmail.click();
    return PageFactory.initElements(driver, GmailVIewPage.class);
  }
}
