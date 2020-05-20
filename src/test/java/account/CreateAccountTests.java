package account;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.DashboardPage;
import pages.SearchResultsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTests extends BaseTest {

    @Test
    public void testCreateAccount() {
        AccountPage accountPage = homePage.clickCreateAccount();
        accountPage.enterEmail("dkqs3e22es33w5382@gmail.com");
        accountPage.enterPassword("SecretPassword!123");
        accountPage.reEnterPassword("SecretPassword!123");

        String option = "To edit the items in here change messages 389442-389565";
        accountPage.selectFromDropDown(option);
        var selectedOptions = accountPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        accountPage.approveTermsAndConditions();

        DashboardPage dashboardPage = accountPage.clickCreateAnAccount();
        SearchResultsPage searchResultsPage = dashboardPage.clickPhilipsJobs();
        assertEquals(searchResultsPage.getPhilipsPageTitle(), "Welder at Philips", "Page title is incorrect");

        searchResultsPage.selectSecondJob();
        searchResultsPage.saveJob();
        searchResultsPage.selectLastJob();
        searchResultsPage.saveJob();

        searchResultsPage.hoverSavedJobsFromMyJobSearch();
        searchResultsPage.selectMySavedJob();
        assertEquals(searchResultsPage.getAmountOfSavedJobs(), "2", "The amount of saved jobs is incorrect");
    }
}
