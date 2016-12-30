package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {

  public boolean isAtPage(WebDriver driver){
    return driver.findElements(By.partialLinkText("Boîte")).size() > 0;
  }
  public GmailLoginPage signOut(WebDriver driver){
    WebElement icon = driver.findElement(By.cssSelector("span[class='gb_8a gbii']"));
    icon.click();
    return PageFactory.initElements(driver, GmailLoginPage.class);
  }
}
