import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Login
{
    public static void main(String[] args) throws InterruptedException, IOException {

//Creating reference of Webdriver Interface
        WebDriver driver;

//Declare Facebook Credentials
        String user="Enter your Username";
        String pass="Enter your Password";

//Creating an instance of chrome level class to disable browser level notifications
        ChromeOptions coptions = new ChromeOptions();
        coptions.addArguments("--disable-notifications");

// Telling Selenium to find Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

// Initialize browser
        driver = new ChromeDriver(coptions);

// Launch Facebook
        driver.get("http://facebook.com/");

//Wait
        Thread.sleep(1000);

//Maximize Window
        driver.manage().window().maximize();

//Wait
        Thread.sleep(2000);

//Enter Username
        WebElement userTextField = driver.findElement(By.id("email"));
        userTextField.sendKeys(user);

//Wait
        Thread.sleep(2000);

//Enter Password
        WebElement PassTextField = driver.findElement(By.id("pass"));
        PassTextField.sendKeys(pass);

//Wait
        Thread.sleep(2000);

//Click on Login button
        driver.findElement(By.id("loginbutton")).click();

//Wait
        Thread.sleep(3000);

//Find the Status Text Area and enter the status message as Hello World
        WebElement TextArea = driver.findElement(By.name("xhpc_message"));
        Thread.sleep(2000);
        TextArea.click();
        TextArea.sendKeys("Hello World");

//Wait
        Thread.sleep(2000);

//Click On Post Button
        WebElement PostBtn = driver.findElement(By.cssSelector
                ("button[data-testid='react-composer-post-button']"));
        PostBtn.click();

//Wait
        Thread.sleep(4000);

// Take Screenshot for Evidence
        File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Save the screenshot in the given path by the name FbStatus.png
        FileUtils.copyFile(srce, new File("C:\\selenium\\screenshot\\FbStatus.png"));

//Wait
        Thread.sleep(2000);

//Click on Account Settings
        WebElement AccSettings = driver.findElement(By.id("userNavigationLabel"));
        AccSettings.click();

//Click on Log out button
        WebDriverWait wait = new WebDriverWait(driver, 8);
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
        logout.click();

//Wait
        Thread.sleep(2000);

// Close the browser
        driver.quit();

    }

}

}
