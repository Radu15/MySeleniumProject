package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TextboxTest {
    WebDriver driver;
    String url = "https://demoqa.com/text-box";
    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void textBox(){
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        fullName.sendKeys("Chis Radu");
        email.sendKeys("raduchis@gmail.com");
        currentAddress.sendKeys("Floresti");
        permanentAddress.sendKeys("Peceiu");

        WebElement outputname = driver.findElement(By.id("userName"));
        WebElement outputEmail = driver.findElement(By.id("userEmail"));
        WebElement outputCurrentAddress = driver.findElement(By.id("currentAddress"));
        WebElement outputPermanentAddress = driver.findElement(By.id("permanentAddress"));

        Assert.assertTrue(true, outputname.getText());
        Assert.assertTrue(true, outputEmail.getText());
        Assert.assertTrue(true, outputCurrentAddress.getText());
        Assert.assertTrue(true, outputPermanentAddress.getText());


        //sleep(90000);



    }

    public static void sleep(int milisecond){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void tearDown(){
        if (driver != null) {
        driver.close();
        }
    }

}
