package testcases;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.net.MalformedURLException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	Logger logger;

	@BeforeClass(groups = { "Sanity", "Master", "Regresstion" })
	@Parameters({ "browser" })
	public void setup( String br) {

		logger = LogManager.getLogger(this.getClass());
		/*
		String execution_env = "remote";
		if (execution_env.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("Windows")) {

				capabilities.setPlatform(Platform.WIN11);
			}
			if (os.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);

			} else {
				System.out.println("No matching os");

			}
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			default:
				System.out.println("No matching browser");
				return;

			}

			driver = new RemoteWebDriver(new URL("http://192.168.0.121:4444/wd/hub"), capabilities);

		}
		*/

		//if (execution_env.equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-search-engine-choice-screen");
				driver = new ChromeDriver(options);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options1 = new FirefoxOptions();
				options1.addArguments("--disable-search-engine-choice-screen");
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser name");
				return;

			}
			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/index.php?route=account/logout&language=en-gb");
	
	}

	@AfterMethod
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(10);
		 driver.quit();
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
