package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    public By philipsPageTitle = By.xpath("//h1[@class='title']");
    public By secondJob = By.cssSelector(".card-content:nth-child(2)");
    public By saveJobIcon = By.id("SaveJob");
    public By allJobsItems = By.cssSelector("section.card-content");
    private By myJobSearchDropDown = By.id("dropdown-My-job-search");
    private By mySavedJob = By.xpath("//a[contains(text(),'Saved Jobs')]");
    private By amountOfSavedJobs = By.xpath("//strong[@class='ng-binding ng-scope']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPhilipsPageTitle() {
        return driver.findElement(philipsPageTitle).getText();
    }

    public void selectSecondJob() {
        driver.findElement(secondJob).click();
    }

    public void saveJob() {
        driver.findElement(saveJobIcon).click();
    }

    public void selectLastJob() {
        List<WebElement> allJobs = driver.findElements(allJobsItems);
        if (!allJobs.isEmpty()) {
            WebElement lastElement = allJobs.get(allJobs.size() - 1);
            lastElement.click();
        }
    }

    public void hoverSavedJobsFromMyJobSearch() {
        WebElement element = driver.findElement(myJobSearchDropDown);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void selectMySavedJob() {
        driver.findElement(mySavedJob).click();
    }

    public String getAmountOfSavedJobs() {
        return driver.findElement(amountOfSavedJobs).getText();
    }
}
