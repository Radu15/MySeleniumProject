package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloader {
    @Test
    public void FileDownloader(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        //1.deschide pagina File downloader
        System.out.println("deschide pagina File Downloader");
        WebDriver driver = new ChromeDriver();
        String url="https://the-internet.herokuapp.com/download";
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("descarca");
        //sleep(2000);
        WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
        downloadLink.click();
       Assert.assertTrue(downloadLink.isDisplayed());
      // driver.close();
    }
    public static void sleep(int milisecond){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
