package automation;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{
        public static void TakeScreenshot(WebDriver driver, String Name) throws IOException
        {
        	File fileobj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(fileobj, new File("C:\\Users\\2303926\\eclipse-workspace\\workspace\\seleniumproject\\Shots\\"+Name+".png"));
        }
}


