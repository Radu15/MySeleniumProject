package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.tmp.AssertEqualsTest;

public class LoginTest {


    @Test//(priority = 1,en)
    public void login(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        //1.deschide pagina Form Autentification
        System.out.println("deschide pagina From autentification");
        WebDriver driver = new ChromeDriver();
        String url="https://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();
        System.out.println("astepta 3 secunde");
        sleep(2000);


        //2.click username & enter user:tomsmith
        WebElement usernameInput= driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        sleep(2000);

        //3.click password & enter:SuprSecretPassword
        WebElement passworlInput= driver.findElement(By.id("password"));
        passworlInput.sendKeys("SuperSecretPassword!");
        sleep(2000);

        //4.Expect result: "Welcome to secure area " is displayed
        WebElement loginButon = driver.findElement(By.className("radius"));
        loginButon.click();
        sleep(2000);

        System.out.println("verificam continutul subheaderului");
        WebElement secureAreaSubheader= driver.findElement(By.className("subheader"));
        String subheaderContetn="Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertTrue(secureAreaSubheader.isDisplayed());
        Assert.assertEquals(subheaderContetn, secureAreaSubheader.getText());

        String secureUrl="https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(),secureUrl);

        WebElement succesMesage=driver.findElement(By.id("flash"));
        String succesMesageContent="You logged into a secure area!";
        Assert.assertTrue(succesMesage.getText().contains(succesMesageContent));


        //5.Inchide pagina
        System.out.println("inchide pagina");
       driver.close();
    }
    public static void sleep(int milisecond){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
