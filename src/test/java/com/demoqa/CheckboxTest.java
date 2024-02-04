package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CheckboxTest {
    WebDriver driver;
    String url = "https://demoqa.com/checkbox";

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
    public void setCheckbox() {
        driver.get(url);
        WebElement checkbox1 = driver.findElement(By.className("rct-checkbox"));
      //  WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkBox1']"));

        // Verifică dacă caseta de bifare 1 este bifată și dezactivează-o
        Assert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertFalse(checkbox1.isSelected());
       // sleep(900);
    }
    public static void sleep(int milisecond){
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        @AfterTest
        public void tearDown(){

        driver.close();
    }
}
