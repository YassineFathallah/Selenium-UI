package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebUtils;

public class GmailVIewPage {

	public String getEmailSubjectText(WebDriver driver) {
	  WebElement subjectArea = WebUtils.getElementBy(driver, By.cssSelector("h2[class='hP']"));
		return subjectArea.getText();
	}
	
}
