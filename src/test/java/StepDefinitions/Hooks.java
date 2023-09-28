package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void before(){
        //System.out.println("Senaryo başladı mı?");
    }

    @After
    public void after(Scenario senaryo){

        ExcelUtility.writeInExcel("src/test/java/ApachePOI/resource/SenaryoSonuclari3.xlsx", senaryo);

        if (senaryo.isFailed()){
            TakesScreenshot ts = ((TakesScreenshot) GWD.getDriver());
            byte[] hafizadakiHali = ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }

        GWD.quitDriver();
        // System.out.println("Senaryo bitti mi?");
        // doğru çalışırsa burada quiti çağıracağım
    }
}
