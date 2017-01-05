import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pom.GmailHomePage;
import pom.GmailLoginPage;
import pom.GmailVIewPage;
import utils.WebUtils;

public class GmailSignInTest {

  public WebDriver driver;
  
  @Test
  public void gmailLoginSuccessful(){
    
    //create Webdriver
    driver = new FirefoxDriver();
    
    WebUtils util = new WebUtils();
    GmailLoginPage loginPage = util.goToLoginPage(driver, "http://www.gmail.com");
    assertTrue(loginPage.isAtPage(driver));
    loginPage.fillLogin(driver);
    loginPage.fillPassword(driver);
    
    GmailHomePage homePage = loginPage.signIn(driver);
    assertTrue(homePage.isAtPage(driver));
    
    GmailLoginPage signOutPage = homePage.signOut(driver);
    assertFalse(signOutPage.isAtPage(driver));
  
  }
  
  @Test(dependsOnMethods={"gmailLoginSuccessful"})
  public void gmailSendAndReceiveEmailTest(){
    //create Webdriver
    driver = new FirefoxDriver();
    
    WebUtils util = new WebUtils();
    GmailLoginPage loginPage = util.goToLoginPage(driver, "http://www.gmail.com");
    assertTrue(loginPage.isAtPage(driver));
    loginPage.fillLogin(driver);
    loginPage.fillPassword(driver);
    
    GmailHomePage homePage = loginPage.signIn(driver);
    assertTrue(homePage.isAtPage(driver));
    
    //Click new Message
    homePage.composeMessage(driver);
    
    // Add email
    homePage.fillToField(driver);
    
    //Add Subjet
    homePage.addSubject(driver);
    
    //send mail
    homePage.clickSend(driver);
    
    //Click Inbox
    homePage.clickInbox(driver);
    
    //Verif sender and subject
    GmailVIewPage viewPage = homePage.clickNewMail(driver);
    assertEquals(viewPage.getEmailSubjectText(driver), "Selenium Test");
  }
  
  @AfterMethod
  public void tearDown(){
    driver.quit();
  }
}
