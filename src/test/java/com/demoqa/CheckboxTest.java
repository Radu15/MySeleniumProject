package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    }

    @Test
    public void setCheckbox() {
        driver.get(url);
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBox']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkBox1']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='checkBox2']"));

        // Verifică dacă caseta de bifare 1 este bifată și dezactivează-o
        Assert.assertTrue(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertFalse(checkbox1.isSelected());

        // Verifică dacă caseta de bifare 2 nu este bifată și activează-o
        Assert.assertFalse(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertTrue(checkbox2.isSelected());

        // Verifică dacă caseta de bifare 3 este bifată și dezactivează-o
        Assert.assertTrue(checkbox3.isSelected());
        checkbox3.click();
        Assert.assertFalse(checkbox3.isSelected());
    }

}
