package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class OwnerLoginPage {

    private WebDriver driver;

    private By email = By.xpath("//input[@placeholder='Enter your email']");
    private By password = By.xpath("//input[@placeholder='Enter your password']");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public OwnerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        WaitUtils.waitForElement(driver, email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
