
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

public class ChromeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/downloads/");
		String actualURL = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();
		if(actualURL.contentEquals("https://www.selenium.dev/downloads/")) {
			System.out.println("Passsssss");
		} else {
			System.out.println("Fail");
		}
		
		
		
//		driver.navigate().to("https://www.selenium.dev/documentation/");
//		
//		driver.navigate().back();
//		driver.navigate().refresh();
//		driver.navigate().forward();
//		driver.manage().window().maximize();
//		Integer height = driver.manage().window().getSize().getHeight();
//		Integer width = driver.manage().window().getSize().getWidth();
//		
//		Dimension size = driver.manage().window().getSize();
//		System.out.println(size);
//		
//		driver.manage().window().setSize(new Dimension(1140, 768));
//		
//		Integer x = driver.manage().window().getPosition().getX();
//
//		driver.switchTo().newWindow(WindowType.TAB);
//		
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.close();
//	    PrintsPage printer = (PrintsPage) driver;
//
//	    PrintOptions printOptions = new PrintOptions();
//	    printOptions.setPageRanges("1-2");

		
	    PrintsPage printer = (PrintsPage) driver;

	    PrintOptions printOptions = new PrintOptions();
	    printOptions.setPageRanges("1-2");

	    Pdf pdf = printer.print(printOptions);
	    String content = pdf.getContent();
	    
        
	    try{
	        byte[] byteArray = java.util.Base64.getDecoder().decode((content));

            Path dest = Paths.get("./pdf","random.pdf");
            System.out.print(dest);
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(byteArray);
            out.close();
        }catch (Exception ex){
            System.out.println("Exception while taking screenshot "+ex.getMessage());
        }


	}

}
