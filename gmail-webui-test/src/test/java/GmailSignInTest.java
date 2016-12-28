import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GmailSignInTest {

  public WebDriver driver;
  @Test
  public void gmailLoginSuccessful(){
    
    final By SEARCH_ICON = By.id("gbqfb");
    //create Webdriver
    driver = new FirefoxDriver();
    
    // go to gmail website
    driver.get("http://www.gmail.com");
    driver.manage().window().maximize();
    
    //Fill login and password
    driver.findElement(By.id("Email")).sendKeys("seleniumtest596");
    driver.findElement(By.id("next")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
    driver.findElement(By.id("Passwd")).sendKeys("selenium2017");
    
    //Click sign in
    driver.findElement(By.id("signIn")).click();
    
    //Verify user did sign in
    wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ICON));
    assertTrue(driver.findElement(SEARCH_ICON).isDisplayed());
    
    //Click Sign out
    WebElement icon = driver.findElement(By.cssSelector("span[class='gb_8a gbii']"));
    icon.click();
    
    WebElement signOutLink = driver.findElement(By.id("gb_71"));
    signOutLink.click();
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
  }
  
  /*@AfterTest
  public void tearDown(){
    driver.quit();
  }*/
}
