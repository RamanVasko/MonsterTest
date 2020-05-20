package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DashboardPage {
    private WebDriver driver;
    private By philipsJobsLink = By.xpath("//a[contains(text(),'Philips Jobs')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage clickPhilipsJobs() {
        clickPhilipsJobsLink();
        return new SearchResultsPage(driver);
    }

    public void clickPhilipsJobsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(philipsJobsLink));
        scrollToWebElementJS(driver.findElement(philipsJobsLink)).click();
        driver.findElement(philipsJobsLink).click();
    }

    public WebElement scrollToWebElementJS(WebElement element) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}