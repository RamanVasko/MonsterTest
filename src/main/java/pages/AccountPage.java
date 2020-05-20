package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AccountPage {
    private WebDriver driver;
    private By emailField = By.id("c_elem_0");
    private By passwordField = By.id("a_elem_1");
    private By rePasswordField = By.id("a_elem_2");
    private By jobCorpsCenterDropDown = By.id("elem_3");
    private By termsAndConditionsSwitch = By.xpath("//span[@class='checkbox-custom checkbox-toggle']");
    private By createAnAccountButton = By.xpath("//button[@class='btn btn-md btn-primary pull-right ng-binding']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void reEnterPassword(String password) {
        driver.findElement(rePasswordField).sendKeys(password);
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void approveTermsAndConditions() {
        driver.findElement(termsAndConditionsSwitch).click();
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(jobCorpsCenterDropDown));
    }

    public DashboardPage clickCreateAnAccount() {
        clickCreateAnAccountButton();
        return new DashboardPage(driver);
    }

    public void clickCreateAnAccountButton() {
        if (driver.findElement(createAnAccountButton).isEnabled()) {
            driver.findElement(createAnAccountButton).click();
        } else Assert.fail("Unable to click on [Create an account] button");
    }
}
