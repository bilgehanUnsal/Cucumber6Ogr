package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _03_CitizenshipStep {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenships")
    public void navigateToCitizenships() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenships);
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        String name = RandomStringUtils.randomAlphanumeric(8);
        String shortName = RandomStringUtils.randomNumeric(4);

        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortNameInput,shortName);
        dc.myClick(dc.saveButton);

    }

    @When("Create a citizenship name as {string} short name as {string}")
    public void createACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.myClick(dc.addButon);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortNameInput,shortName);
        dc.myClick(dc.saveButton);
        dc.myClick(dc.closeButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText_Negative(dc.unSuccessMessage,"already exists");
    }

    @When("Search created citizenship name as {string} short name as {string}")
    public void searchCreatedCitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.mySendKeys(dc.searchText,name);
        dc.myClick(dc.searchButton);
    }

    @And("Delete created citizenship")
    public void deleteCreatedCitizenship() {
        dc.myClick(dc.deleteIcon);
        dc.myClick(dc.deleteButton);
    }

    @Then("Success delete message should be displayed")
    public void successDeleteMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.successMessage, "deleted");
    }
}
