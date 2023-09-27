package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    // threadDriver.get() -> bulunduğum thread deki driver ı al
    // threadDriver.set(driver) -> bulunduğum thread e driver set et
    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) { // ilk kez 1 defa çalışsın

            switch (threadBrowserName.get()) {
                case "firefox": threadDriver.set(new FirefoxDriver());break; // ilgili thread e driver set ettim
                case "safari": threadDriver.set(new SafariDriver());break;
                case "edge": threadDriver.set(new EdgeDriver());break;
                default: threadDriver.set(new ChromeDriver());break;
            }
        }

        // gelen browser ismine göre chrome, edge, firefox switch üretip
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();
    }

    public static void quitDriver() {
        // test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // driver kapat
        if (threadDriver != null) { // driver var ise
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get(); // direk eşitleme yapmadığım için, içinden
            driver = null;

            threadDriver.set(driver); // kendisine null olarak, ver bu hatta bir dolu driver yok

        }
    }


}
