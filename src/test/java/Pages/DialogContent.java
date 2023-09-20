package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css = "span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip, 'ADD')]//button")
    public WebElement addButon;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname, 'name')]//input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname, 'shortName')]//input")
    public WebElement shortNameInput;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname, 'code')]//input")
    public WebElement codeInput;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]")
    public WebElement successMessage;

    @FindBy (xpath = "//div[contains(text(), 'already exists')]")
    public WebElement unSuccessMessage;

    @FindBy (css = "[aria-label='Close dialog']")
    public WebElement closeButton;

    @FindBy(xpath="//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchInput;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname, 'IntegrationCode')]//input")
    public WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[contains(@formcontrolname, 'priority')]//input")
    public WebElement priority;

    @FindBy(xpath = "(//ms-save-button[@class= 'ng-star-inserted']//button)[2]")
    public WebElement saveAndClose;

    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    public WebElement activeButton;

    @FindBy(xpath="//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;

    @FindBy(xpath="//mat-option/span")
    private WebElement academicPeriod1;

    @FindBy(xpath="(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//*[@role='option'])[4]")
    private WebElement gradeLevel2;

    @FindBy(xpath="//mat-select//span[text()='Test 2024']")
    private WebElement searchAcademicPeriod;

    public void deleteItem(String searchText){
        mySendKeys(searchInput, searchText);
        myClick(searchButton);

        // 1. Yöntem
        // dc.wait.until(ExpectedConditions.elementToBeClickable(dc.searchButton));

        // 2. Yöntem
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));

        myClick(deleteImageBtn);
        myClick(deleteDialogBtn);
    }
    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "addButon": return this.addButon;
            case "saveButton": return this.saveButton;
            case "nameInput": return this.nameInput;
            case "codeInput": return this.codeInput;
            case "integrationCode": return this.integrationCode;
            case "priority": return this.priority;
            case "saveAndClose": return this.saveAndClose;
            case "activeButton": return this.activeButton;
            case "academicPeriod": return this.academicPeriod;
            case "academicPeriod1": return this.academicPeriod1;
            case "gradeLevel": return this.gradeLevel;
            case "gradeLevel2": return this.gradeLevel2;
            case "searchAcademicPeriod": return this.searchAcademicPeriod;
        }
        return null;
    }
}
