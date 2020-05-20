package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private By createAccountButton = By.xpath("//div[@class='tab-pane ng-scope active']//div[3]//a[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage clickCreateAccount() {
        clickCreateAccountButton();
        return new AccountPage(driver);
    }

    private void clickCreateAccountButton() {
        if (driver.findElement(createAccountButton).isEnabled()) {
            driver.findElement(createAccountButton).click();
        } else
            Assert.fail("Unable to click on [CREATE ACCOUNT] button");
    }
}
