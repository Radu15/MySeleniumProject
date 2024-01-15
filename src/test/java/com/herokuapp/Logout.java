package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {
    @Test
    public void Logout(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        //1.deschide pagina Form Autentification
        System.out.println("deschide pagina From autentification");
        WebDriver driver = new ChromeDriver();
        String url="https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("astepta 3 secunde");

        WebElement usernameInput= driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        WebElement passworlInput= driver.findElement(By.id("password"));
        passworlInput.sendKeys("SuperSecretPassword!");

        WebElement loginButon = driver.findElement(By.className("radius"));
        loginButon.click();

        WebElement logoutButon = driver.findElement(By.className("radius"));
        logoutButon.click();


        WebElement succesMesage=driver.findElement(By.id("flash"));
        String succesMesageContent="You logged out of the secure area!";
        Assert.assertTrue(succesMesage.getText().contains(succesMesageContent));
    }
}

