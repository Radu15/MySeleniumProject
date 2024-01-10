package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        //1.deschide pagina Form Autentification
        System.out.println("deschide pagina From autentification");
        WebDriver driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-infobars");
//        options.addArguments("--remote-allow-origins=*");
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
        passworlInput.sendKeys("SuperSecretPassword");
        sleep(2000);

        //4.Expect result: "Welcome to secure area " is displayed
        WebElement loginButon = driver.findElement(By.className("radius"));
        loginButon.click();
        sleep(2000);

        //5.Inchide pagina
        System.out.println("inchide pagina");
        driver.close();
    }
    public static void sleep(int milisecond){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
