package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.herokuapp.LoginTest.sleep;

public class Dropdowntest {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/dropdown";
    @Parameters({"browserP"})
        @BeforeTest
        public void setUp () {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }

        @Test
        public void selectFromDropdown(){
            WebElement dropdown=driver.findElement(By.id("dropdown"));
            Select dropdownElement= new Select(dropdown);
            dropdownElement.selectByValue("1");
            WebElement option1=driver.findElement(By.xpath( "//*[@id=\"dropdown\"]/option[2]"));
            Assert.assertTrue(option1.isSelected());
            sleep(300);

            dropdownElement.selectByVisibleText("Option 2");
            WebElement option2=driver.findElement(By.xpath( "//*[@id=\"dropdown\"]/option[3]"));
            Assert.assertTrue(option2.isSelected());
            sleep(300);
        }


            @AfterTest(alwaysRun = true)
            public void tearDown () {
                driver.close();
        }



    }

