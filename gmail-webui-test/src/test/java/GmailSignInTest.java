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
import utils.WebUtils;

public class GmailSignInTest {

  public WebDriver driver;
  final By SEARCH_ICON = By.id("gbqfb");
  final By SIGN_IN = By.id("signIn");
  final By COMPOSE = By.cssSelector("div.T-I.J-J5-Ji.T-I-KE.L3");
  final By TO = By.cssSelector("textarea[name='to']");
  final By OBJET = By.cssSelector("input[name='subjectbox']");
  final By SEND_MAIL = By.xpath("//div[contains(text(),'Envoyer')]");
  final By INBOX_LINK = By.cssSelector("div.aio.UKr6le>span.nU.n1>a");
  final By SENDER_VERIF = By.cssSelector("div[class='y6'] span[id] b");
  final By OBJET_VERIF = By.cssSelector("h2[class='hP']");
  
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
    assertTrue(signOutPage.isAtPage(driver));
  
  }
  
  /*@Test(dependsOnMethods={"gmailLoginSuccessful"})
  public void gmailSendAndReceiveEmailTest(){
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
    
    //Click new Message
    wait.until(ExpectedConditions.visibilityOfElementLocated(COMPOSE));
    WebElement compose = driver.findElement(COMPOSE);
    compose.click();
    
    // Add email
    wait.until(ExpectedConditions.visibilityOfElementLocated(TO));
    WebElement to = driver.findElement(TO);
    to.sendKeys("seleniumtest596@gmail.com");
    
    //Add Objet
    WebElement objet = driver.findElement(OBJET);
    objet.sendKeys("Selenium Test");
    
    //send mail
    WebElement send = driver.findElement(SEND_MAIL);
    send.click();
    
    //Click Inbox
    wait.until(ExpectedConditions.visibilityOfElementLocated(INBOX_LINK));
    WebElement inbox = driver.findElement(INBOX_LINK);
    inbox.click();
    
    //Verif sender and object
    wait.until(ExpectedConditions.visibilityOfElementLocated(SENDER_VERIF));
    WebElement verif_sender = driver.findElement(SENDER_VERIF);
    verif_sender.click();
    WebElement verif_objet = driver.findElement(OBJET_VERIF);
    assertEquals("Selenium Test", verif_objet.getText());
  }*/
  
  @AfterMethod
  public void tearDown(){
    driver.quit();
  }
}
