// Install Package
package Utilities;

// Importing all dependencies
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Class for fetching the driver
public class DriverFetch {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    // Function to set the driver
    public static  void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    // Function to get the driver
    public static WebDriver getDriver()
    {
        return driver.get();
    }

    // Function to close the driver
    public static void closeBrowser()
    {
        driver.get().close();
        driver.remove();
    }
}
