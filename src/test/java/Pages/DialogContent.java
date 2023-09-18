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

    @FindBy(xpath = "//ms-save-button[@class= 'ng-star-inserted']//button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]")
    public WebElement successMessage;

    @FindBy (xpath = "//div[contains(text(), 'already exists')]")
    public WebElement unSuccessMessage;

    @FindBy (css = "[aria-label='Close dialog']")
    public WebElement closeButton;

    @FindBy(xpath="//ms-text-field[contains(@placeholder,'NAME')]//input[@data-placeholder='Name']")
    public WebElement searchInput;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteDialogBtn;

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
}
