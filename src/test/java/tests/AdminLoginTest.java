package tests;

import base.BaseTest;
import pages.AdminLoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(utils.TestListener.class)
public class AdminLoginTest extends BaseTest {

    @Test
    public void adminLoginTest() {

        driver.get("https://listmyhoardings.com/auth/admin/login");

        AdminLoginPage admin = new AdminLoginPage(driver);
        admin.login("superadmin@hoardings.com", "SuperAdmin123");

        // ✅ Wait for dashboard redirection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("admin-dashboard"));

        // ✅ Assertion
        Assert.assertTrue(
                driver.getCurrentUrl().contains("admin-dashboard"),
                "Admin login failed or dashboard not loaded"
        );
    }
}
