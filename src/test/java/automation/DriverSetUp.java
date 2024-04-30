package automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetUp {
	
	public static  WebDriver driver;
	public void getWebDriver(String choice) {
		
		if(choice.equals("chrome")){
			driver=new ChromeDriver();}
		else if(choice.equals("edge"))
			driver=new EdgeDriver();
		
		}
		
	}
