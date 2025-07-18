package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import io.cucumber.java.en.*;

public class TriangleSteps {
	private static final Logger logger = LoggerFactory.getLogger(TriangleSteps.class);
	private WebDriver driver;
	private WebDriverWait wait;

	@Given("I use Triangle Calculator")
	public void setUp() {
		logger.info("Setting up Triangle Calculator");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://do.tusur.ru/qa-test2/");
		driver.manage().window().maximize();
	}
	
    @When("I clear all default parameter from calculator")
	public void clear() {
		logger.debug("Clearing all default parameter from calculator");
		driver.findElement(By.name("a")).clear();
		driver.findElement(By.name("b")).clear();
		driver.findElement(By.name("c")).clear();

		// 2-секундная задержка
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@And("I set value {string} for side \"A\"")
	public void setA(String a) {
		logger.info("Setting A to {}", a);
		driver.findElement(By.name("a")).click();
		driver.findElement(By.name("a")).sendKeys(a);

		// 2-секундная задержка
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@And("I set value {string} for side \"B\"")
	public void setB(String b) {
		logger.info("Setting B to {}", b);
		driver.findElement(By.name("b")).click();
		driver.findElement(By.name("b")).sendKeys(b);

		// 2-секундная задержка
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@And("I set value {string} for side \"C\"")
	public void setC(String c) {
		logger.info("Setting C to {}", c);
		driver.findElement(By.name("c")).click();
		driver.findElement(By.name("c")).sendKeys(c);

		// 2-секундная задержка
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	@And("I click \"Calculate\" button")
	public void click() {
		logger.info("Clicking Calculate");
		driver.findElement(By.name("calc")).click();

		// 2-секундная задержка
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@Then("the triangle type is {string}")
	public void assertResult(String expected) throws Exception {
		logger.info("Asserting result is {}", expected);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result > div:nth-child(2)")));
		String actual = driver.findElement(By.cssSelector(".result > div:nth-child(2)")).getText();
		logger.debug("Finally result: {}", actual);
		Assertions.assertEquals(expected, actual);
		Thread.sleep(5000);
		driver.quit();
	}
}