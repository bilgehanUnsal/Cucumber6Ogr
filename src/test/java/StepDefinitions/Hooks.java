package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        //System.out.println("Senaryo başladı mı?");
    }

    @After
    public void after(){
        GWD.quitDriver();
        // System.out.println("Senaryo bitti mi?");
        // doğru çalışırsa burada quiti çağıracağım
    }
}
