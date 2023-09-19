package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class _04_DataTableOrnek {
    @When("write username {string}")
    public void writeUsername(String username) {
        System.out.println("username = " + username);
    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable userlar) {
        List<String> listUserlar = userlar.asList(String.class);

        for (String user : listUserlar) {
            System.out.println("user = " + user);
        }
    }

    @And("Write username and Password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable kullaniciVeSifreler) {
        List<List<String>> listUserandPasses = kullaniciVeSifreler.asLists(String.class);

        for (int i = 0; i < listUserandPasses.size(); i++) {
            System.out.println("List Itemlerı = " + listUserandPasses.get(i).get(0) + " " + listUserandPasses.get(i).get(1));
        }
    }
}
