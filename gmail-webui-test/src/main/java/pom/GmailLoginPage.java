package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
  
  public void fillLogin(WebDriver driver){
    driver.findElement(By.id("Email")).sendKeys("seleniumtest596");
    driver.findElement(By.id("next")).click();
  }
  
  public void fillPassword(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
    driver.findElement(By.id("Passwd")).sendKeys("selenium2017");
  }
  
  public GmailHomePage signIn(WebDriver driver){
    driver.findElement(By.id("signIn")).click();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Boîte")));
    
    return PageFactory.initElements(driver, GmailHomePage.class);
  }
  
  public boolean isAtPage(WebDriver driver){
    return driver.findElements(By.id("Email")).size() > 0;
  }
}
