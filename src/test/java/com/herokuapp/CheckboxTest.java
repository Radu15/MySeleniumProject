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

public class CheckboxTest {


        WebDriver driver;
        String url = "https://the-internet.herokuapp.com/checkboxes";

        @BeforeTest
        public void setup() {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }

        @Test
        public void checkAll() {

            WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
            if(!checkbox1.isSelected()){
                checkbox1.click();
            }
            Assert.assertTrue(checkbox1.isSelected());
            sleep(300);

            WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
            if (!checkbox2.isSelected()){
                checkbox2.click();
            }
            Assert.assertTrue(checkbox2.isSelected());

            sleep(300);
        }
        @Test
        public void uncheckAll() {

            WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
            if(checkbox1.isSelected()){
                checkbox1.click();
            }
            Assert.assertFalse(checkbox1.isSelected());
            sleep(300);

            WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
            if (checkbox2.isSelected()){
                checkbox2.click();
            }
            Assert.assertFalse(checkbox2.isSelected());

            sleep(300);
        }


        @AfterTest(alwaysRun = true)
        public void tearDown() {
            driver.close();
        }


    }



