package tests;

import base.BaseTest;
import pages.OwnerLoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(utils.TestListener.class)
public class OwnerLoginTest extends BaseTest {

    @Test
    public void ownerLoginTest() {

        driver.get("https://listmyhoardings.com/auth/owner/login");

        OwnerLoginPage owner = new OwnerLoginPage(driver);
        owner.login("ashirbadprusty2@gmail.com", "1234567");

        // ✅ Wait for dashboard redirection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("owner-dashboard"));

        // ✅ Assertion
        Assert.assertTrue(
                driver.getCurrentUrl().contains("owner-dashboard"),
                "Owner login failed or dashboard not loaded"
        );
    }
}
