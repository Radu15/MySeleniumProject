package com.demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WaitsTest {
    WebDriver driver;
    String url = "https://demoqa.com/alerts";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButon= driver.findElement(By.xpath("//button[@aria-label=\"Consent\"]"));
        consentButon.click();
    }

    @Test
    public void waitTest() {
        driver.get(url);
        WebElement clickMe = driver.findElement(By.id("timerAlertButton"));
        clickMe.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text =alert.getText();
        System.out.println((text));
        alert.accept();

    }
    @Test
    public void confirmTest() {
        WebElement confirm = driver.findElement(By.id("confirmButton"));
        confirm.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text =alert.getText();
        System.out.println((text));
        alert.accept();
        sleep(3);


    }

    private void sleep(int second) {
    }

    @AfterTest
    public void tearDown(){
// driver.close();
    }

}
