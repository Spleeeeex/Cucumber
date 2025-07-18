package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import io.cucumber.java.en.*;

public class Steps {
    private static final Logger logger = LoggerFactory.getLogger(Steps.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I use the calculator")
    public void setUp() {
        logger.info("Setting up Calculator");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.calculator.net/math-calculator.html");
    }

    @When("I enter {string} into the calculator")
    public void enterValue(String value) {
        logger.info("Entering value: {}", value);

        // Очистка поля
        driver.findElement(By.cssSelector(".scieq:nth-child(3)")).click();

        // Клик по "1"
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(1)")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I add {string}")
    public void add(String value) {
        logger.info("Adding {}", value);

        // Знак сложения
        driver.findElement(By.cssSelector("div:nth-child(1) > .sciop:nth-child(4)")).click();

        // Добавляем "200"
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I subtract {string}")
    public void subtract(String value) {
        logger.info("Subtracting {}", value);

        // Знак вычитания
        driver.findElement(By.cssSelector("div:nth-child(2) > .sciop:nth-child(4)")).click();

        // Вычитаем "200"
        driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I divide by {string}")
    public void divideBy(String value) {
        logger.info("Dividing by {}", value);

        // Знак деления
        driver.findElement(By.cssSelector("div:nth-child(4) > .sciop:nth-child(4)")).click();

        // Делим на "555"
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I multiply by {string}")
    public void multiplyBy(String value) {
        logger.info("Multiplying by {}", value);

        // Знак умножения
        driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();

        // Умножаем на "555"
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();

        // Знак равенства, получение результата вычислений
        driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    @Then("the calculated result is {string}")
    public void verifyResult(String expected) {
        logger.info("Verifying result is {}", expected);

        // 5-секундная задержка
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Явное ожидание появление результата
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sciOutPut")));
        String actual = resultElement.getText().trim();
        logger.debug("Actual result: {}", actual);
        Assertions.assertEquals(expected, actual);
        driver.quit();
    }
}