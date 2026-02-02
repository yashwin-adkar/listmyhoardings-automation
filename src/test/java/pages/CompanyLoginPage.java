package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class CompanyLoginPage {

    private WebDriver driver;

    private By email = By.xpath("//input[@placeholder='Enter company email']");
    private By password = By.xpath("//input[@placeholder='Enter password']");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public CompanyLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        WaitUtils.waitForElement(driver, email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
