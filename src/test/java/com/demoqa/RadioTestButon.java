package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioTestButon {
        WebDriver driver;
        String url = "https://demoqa.com/radio-button";

        @BeforeTest
        public void setup() {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }

        @Test
        public void testRadiobuttonFunctionality() {
            // Deschide pagina web
            driver.get(url);

            // Identifică elementele radio button
            WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
            WebElement impressiveRadio = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
            WebElement noRadio = driver.findElement(By.xpath("//label[@for='noRadio']"));

            // Verifică dacă opțiunea "Yes" este bifată și dezactivează-o
            Assert.assertFalse(yesRadio.isSelected());
            yesRadio.click();
            Assert.assertFalse(yesRadio.isSelected());

            // Verifică dacă opțiunea "Impressive" nu este bifată și activează-o
            Assert.assertFalse(impressiveRadio.isSelected());
            impressiveRadio.click();
            Assert.assertFalse(impressiveRadio.isSelected());

            Assert.assertFalse(noRadio.isSelected());
            noRadio.click();
            Assert.assertFalse(noRadio.isSelected());
            //sleep(5);
        }

    private void sleep(int second) {
        sleep(5);
    }

   // @AfterTest
    public void tearDown() {
        // Închide browser-ul la sfârșitul testului
        if (driver != null) {
            driver.close();
        }
    }
}
