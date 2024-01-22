package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestNegativ {

    @Parameters({"usernameP","passwordP","errorMsgP"})
    @Test(priority = 1)
    public void LogintestNegativ(String username,String password,String errorMsg){
       System.setProperty("webdriver.chrome.driver",
             "src/main/resources/chromedriver.exe");
        //1.deschide pagina Form Autentification
        System.out.println("deschide pagina From autentification");
        WebDriver driver = new ChromeDriver();
        String url="https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("astepta 3 secunde");
        //sleep(2000);


        //2.click username & enter user:tomsmith
        WebElement usernameInput= driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
        //sleep(2000);

        //3.click password & enter:SuprSecretPassword
        WebElement passworlInput= driver.findElement(By.id("password"));
        passworlInput.sendKeys(password);
        //sleep(2000);

        //4.Expect result: "Welcome to secure area " is displayed
        WebElement loginButon = driver.findElement(By.className("radius"));
        loginButon.click();
        //String errorMsg="Your username is invalid!";
        WebElement errorMsgArea = driver.findElement(By.id("flash"));

        Assert.assertTrue(errorMsgArea.getText().contains(errorMsg));
    }
    public static void sleep(int milisecond){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
