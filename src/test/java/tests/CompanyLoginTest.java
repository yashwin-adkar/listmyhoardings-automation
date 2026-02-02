package tests;

import base.BaseTest;
import pages.CompanyLoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(utils.TestListener.class)
public class CompanyLoginTest extends BaseTest {

    @Test
    public void companyLoginTest() {

        driver.get("https://listmyhoardings.com/auth/company/login");

        CompanyLoginPage company = new CompanyLoginPage(driver);
        company.login("trainee.metromindz@gmail.com", "1234567");

        // ✅ Wait for dashboard redirection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("company-dashboard"));

        // ✅ Assertion
        Assert.assertTrue(
                driver.getCurrentUrl().contains("company-dashboard"),
                "Company login failed or dashboard not loaded"
        );
    }
}
