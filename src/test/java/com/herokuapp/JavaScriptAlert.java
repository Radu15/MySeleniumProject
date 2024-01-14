package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import static org.testng.Assert.*;

public class JavaScriptAlert {
    @Test
    public void JavaScriptAlert(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        //1.deschide pagina JavaScriptAlert
        System.out.println("deschide pagina JavaScriptAlert");
        WebDriver driver = new ChromeDriver();
        String url="https://the-internet.herokuapp.com/javascript_alerts";
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Alerte");
        //sleep(2000);
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertButton.click();
       Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
        assertTrue(jsAlertButton.isEnabled());
       // driver.close();


    }
}
