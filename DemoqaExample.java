

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoqaExample {

	public static void main(String[] args)  {
		
		System.setProperty("webdriver.chrome.driver", "/Users/rama/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.demoqa.com");
		WebElement w = driver.findElement(By.partialLinkText("Registration"));
		//WebElement w = driver.findElement(By.
		w.click();
		if(driver.getCurrentUrl().contains("registration")){
			
			System.out.println("We made it!!");
			
			
		}
		
		
		//Fill first name
		
		driver.findElement(By.id("name_3_firstname")).sendKeys("Rama");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Kelkar");
		
		
		
		//Fill in Dropdown
		
		Select country= new Select (driver.findElement(By.id("dropdown_7")));
		country.selectByValue("United States");
		
		// Fill in DOB
		
		Select month= new Select(driver.findElement(By.id("mm_date_8")));
		month.selectByValue("8");
		
		Select date= new Select(driver.findElement(By.id("dd_date_8")));
		date.selectByValue("31");
		
		Select year= new Select(driver.findElement(By.id("yy_date_8")));
		year.selectByValue("1986");
		
		driver.findElement(By.id("phone_9")).sendKeys("12134794174");
		driver.findElement(By.id("username")).sendKeys("rama.kelkar");
		driver.findElement(By.id("email_1")).sendKeys("rama.a.kelkar@gmail.com");
		driver.findElement(By.id("description")).sendKeys("Hi ! I am passionate about software tetsing and QA");
		driver.findElement(By.id("password_2")).sendKeys("Redmond98052!!");
		driver.findElement(By.id("confirm_password_password_2")).sendKeys("Redmond98052!!");
		
		/*WebElement uploadDoc1 = driver.findElement(By.id("profile_pic_10"));
		uploadDoc1.click();
       uploadDoc1.sendKeys("/Users/rama/Desktop/Flower.jpg");
        //open upload window
		

       /* //put path to your image in a clipboard
        StringSelection ss = new StringSelection("/Users/rama/Desktop/Flower.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
         
		// Marital status radio button
		List<WebElement> status= driver.findElements(By.name("radio_4[]"));
		
		for(WebElement wb: status)
		{
			if(wb.getAttribute("value").equals("married"))
			{
				wb.click();
			}
		}
		
		//Hobby checkbox
		
		List<WebElement> hobby= driver.findElements(By.name("checkbox_5[]"));
		
		for(WebElement wb_hobby : hobby)
		{
			if(wb_hobby.getAttribute("value").equals("dance"))
			{
				wb_hobby.click();
			}
			
		}
		
		// take screenshot
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(srcFile, new File("/Users/rama/Desktop/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		driver.quit();
		
		
		
		

	}

}
