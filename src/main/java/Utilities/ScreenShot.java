package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void Shot(WebDriver driver) {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {

            File dest = new File("C:\\Users\\vaibhavjain98\\Desktop\\test1\\Screenshots"  + timestamp() + ".png");

            FileUtils.copyFile(src, dest);

        } catch(IOException ex) {

            ex.printStackTrace();

        }

    }
}
