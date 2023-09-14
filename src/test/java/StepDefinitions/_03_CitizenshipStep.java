package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
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
}
