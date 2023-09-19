package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strLinkList = linkler.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            WebElement linkWebElement = ln.getWebElement(strLinkList.get(i));
            ln.myClick(linkWebElement);
        }
    }

    @And("Click on the element in DialogContent")
    public void clickOnTheElementInDialogContent(DataTable linkler) {
        List<String> strLinkList = linkler.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            WebElement linkWebElement = dc.getWebElement(strLinkList.get(i));
            dc.myClick(linkWebElement);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable linkler) {
        List<List<String>> strLinkList = linkler.asLists(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            WebElement e = dc.getWebElement(strLinkList.get(i).get(0)); // 0. webelement
            String yazi = strLinkList.get(i).get(1); // 1. yazı
            dc.mySendKeys(e,yazi);
        }
    }

    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dt) {
        List<String> silinecekler = dt.asList(String.class);

        for (int i = 0; i < silinecekler.size(); i++) {
            dc.deleteItem(silinecekler.get(i));
        }
    }
}
