package automation;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PeppperFry extends DriverSetUp{
	
     public static List<String>Category=new ArrayList<String>();
     public static List<String>Count=new ArrayList<String>();
		//timeouts
		public void Timeouts() {
			   driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		//openurl	
		public void OpenURL(String baseURL) throws IOException {
			driver.get(baseURL);
			TakesScreenshot ts = (TakesScreenshot)driver;				
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg = new File("C:\\Users\\2318881\\eclipse-workspace\\2318881automation\\screenshots\\1.png");
			FileUtils.copyFile(src, trg);
			
		}

		public void Close() {
			driver.quit();
		}
         //Validating Title
		public void ValidateTitle() {
			String orgTitle="Online Furniture Shopping Store";
			int orgLen=orgTitle.length();
			String title = driver.getTitle();
			if(orgTitle.equals(title.substring(0,orgLen))) {
				System.out.println("Title validated");
			}
		}
		
		//Hovering over furniture
		public void HoverOnFurniture() 
		{
			
			WebElement furniture  = driver.findElement(By.linkText("Furniture"));
			Actions action = new Actions(driver);
			action.moveToElement(furniture).click().perform();
			System.out.println("Successful click on Furniture.\n");
			

		}
		//click on settees&benches
		
		public void ClickOnSetteesAndbenches()  
		{
			WebElement Settees = driver.findElement(By.xpath("//*[@id=\"meta-Furniture\"]/div/div/div/div/div[2]/ul[3]/li[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(Settees).click().perform();
			System.out.println("Successful click on Settees&Benches");
		}
		
		//Display the count
		public void DisplayCount() throws InterruptedException 
		{
			Thread.sleep(5000);
			System.out.println("Count Of");
			List<WebElement>count1=driver.findElements(By.xpath("//div[@class=\"clip-catg-content text-xs font-medium color-secondary ng-star-inserted\"]"));
			List<WebElement>cat1 =driver.findElements(By.xpath("//div[@class=\"clip-catg-title text-sm font-medium text-truncate-2 ctg-white-space paddingTop-8\"]"));
			for(int i=1;i<cat1.size();i++) {
			Category.add(cat1.get(i).getText());
			Count.add(count1.get(i).getText());
			System.out.println(cat1.get(i).getText()+"==="+count1.get(i).getText());
			}
			System.out.println();
		}
		
          //click on material
		 public void ClickOnMaterial()  
		 {
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 WebElement Material = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='Material' and@name='Button']"))); 
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Material);
			 System.out.println("Successful click on Material.\n");
		 }
		 //click on metal 
		public  void ClickOnMetal() throws IOException 
		{
				//Count of metal benches
				String countString=driver.findElement(By.xpath("(//span[@class='text-md filter-checkList-count'])[3]")).getText();
				String c=countString.substring(1,countString.length()-1);
				
				System.out.println("Metal Benches === "+c);
				
				//click on metal
				driver.findElement(By.xpath("(//*[@class='checkbox-label'])[3]")).click();
				
				//click on apply
				driver.findElement(By.xpath("//button[@class='button-container button-size--base button-primary ng-star-inserted'] [@id='Button']")).click();
				
				Category.add("Metal Benches");
		
	    }
        public static void main(String[] args) throws InterruptedException, IOException 
        {
        		PeppperFry obj = new PeppperFry();
        		String baseURL = "https://www.pepperfry.com/.";
        		System.out.println("Press 1 for Chrome ");
        		System.out.println("press 2 for Edge");
        		System.out.print("Enter your choice :");
        		Scanner sc=new Scanner(System.in);
        		int choice =sc.nextInt();
        		sc.close();
        		switch(choice) {
        		case 1:obj.getWebDriver("chrome");
        		break;
        		case 2:obj.getWebDriver("edge");
        		break;
        		default:System.out.println("Enter correct choice");  } 
        		obj.OpenURL(baseURL);
	     		obj.Timeouts();
        		System.out.println(driver.getTitle());
        		obj.ValidateTitle();
	     	    obj.HoverOnFurniture();
	     	    Screenshot.TakeScreenshot(driver,"funiture");
	     	    obj.ClickOnSetteesAndbenches();
	     		obj.DisplayCount();
	     		Screenshot.TakeScreenshot(driver,"displaycount");
        		obj.ClickOnMaterial();
        		Screenshot.TakeScreenshot(driver,"material");
        		obj.ClickOnMetal();
        		Screenshot.TakeScreenshot(driver,"metal");
        		obj.Close();
        		System.out.println(Category);
        		System.out.println(Count);
        		
        		
       }
}

		

