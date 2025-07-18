/*

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

public class IsoscelesTriangleSteps {
    private static final Logger logger = LoggerFactory.getLogger(IsoscelesTriangleSteps.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I use Triangle Calculator for Test")
    public void setUp() {
        logger.info("Setting up Triangle Calculator");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://do.tusur.ru/qa-test2/");
        driver.manage().window().maximize();
    }

    @When("I clear all default parameters from calculator")
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

    @And("Setting value {string} for side \"A\"")
    public void setA(String value) {
        logger.info("Setting A to {}", value);
        driver.findElement(By.name("a")).click();
        driver.findElement(By.name("a")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("Setting value {string} for side \"B\"")
    public void setB(String value) {
        logger.info("Setting B to {}", value);
        driver.findElement(By.name("b")).click();
        driver.findElement(By.name("b")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("Setting value {string} for side \"C\"")
    public void setC(String value) {
        logger.info("Setting C to {}", value);
        driver.findElement(By.name("c")).click();
        driver.findElement(By.name("c")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("I click \"Calculate\" button for result")
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

    @Then("Check the triangle type is {string}")
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

*/

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

import io.cucumber.java.ru.*;

public class IsoscelesTriangleSteps {
    private static final Logger logger = LoggerFactory.getLogger(IsoscelesTriangleSteps.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @Дано("Использую калькулятор треугольника для тестирования")
    public void setUp() {
        logger.info("Открывает калькулятор треугольника");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://do.tusur.ru/qa-test2/");
        driver.manage().window().maximize();
    }

    @Когда("Очищаю параметры сторон в калькуляторе")
    public void clear() {
        logger.debug("Очищаем параметры сторон");
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

    @И("Устанавливаю значение {string} для стороны \"A\"")
    public void setA(String value) {
        logger.info("Устанавливаем длину прямой 'AB' {}", value);
        driver.findElement(By.name("a")).click();
        driver.findElement(By.name("a")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @И("Устанавливаю значение {string} для стороны \"B\"")
    public void setB(String value) {
        logger.info("Устанавливаем длину прямой 'BC' {}", value);
        driver.findElement(By.name("b")).click();
        driver.findElement(By.name("b")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @И("Устанавливаю значение {string} для стороны \"C\"")
    public void setC(String value) {
        logger.info("Устанавливаем длину прямой 'AC' {}", value);
        driver.findElement(By.name("c")).click();
        driver.findElement(By.name("c")).sendKeys(value);

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @И("Нажимаю на кнопку \"Calculate\" для получения результата")
    public void click() {
        logger.info("Нажимаем 'Отправить'");
        driver.findElement(By.name("calc")).click();

        // 2-секундная задержка
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Тогда("Проверяю, что тип треугольника - {string}")
    public void assertResult(String expected) throws Exception {
        logger.info("Ожидаемый результат: {}", expected);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result > div:nth-child(2)")));
        String actual = driver.findElement(By.cssSelector(".result > div:nth-child(2)")).getText();
        logger.debug("Фактический результат: {}", actual);
        Assertions.assertEquals(expected, actual);
        Thread.sleep(5000);
        driver.quit();
    }
}