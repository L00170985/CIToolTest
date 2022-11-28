package def;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
public class KeyWrdSearch{
	
	public static void main(String[] args) throws CsvValidationException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Kani/Downloads/chromedriver_win32/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    String CSVPath = System.getProperty("user.dir")+"\\src\\TestData.csv";
	    String[] csvCell;
	    CSVReader csvReader = new CSVReader(new FileReader(CSVPath));
	    csvCell = csvReader.readNext();
	    //implicit wait
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    //URL launch
	    driver.get("https://www.google.com/");
	    //implicit wait
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    //identify element
	    WebElement q= driver.findElement(By.id("L2AGLb"));
	    q.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement r = driver.findElement(By.name("q"));
	    r.sendKeys(csvCell[0]);
	    // press ENTER
	    r.sendKeys(Keys.RETURN);
	}
}