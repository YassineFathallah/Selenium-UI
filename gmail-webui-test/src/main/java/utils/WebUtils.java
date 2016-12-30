package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.GmailLoginPage;

public class WebUtils {

  public GmailLoginPage goToLoginPage(WebDriver driver, String url){
    driver.get(url);
    driver.manage().window().maximize();
    return PageFactory.initElements(driver, GmailLoginPage.class);
  }
}
