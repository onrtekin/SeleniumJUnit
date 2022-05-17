package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();

    }
    @Test
    public void test01() {
        /*
        herhangi bir web sitesine gidince veya bir web sitesinde herhangi bir islem yaptigimizde ortaya cikan uyarilara
        alert diyoruz.
        Eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanilabilir
        bu tur alert lere HTML alert denir ve bunlar icin wxstra bir islem yapmaya gerek yoktur
        tum webelementler gibi locate edip islerimizi yapabiliriz
        https://the-internet.herokuapp.com/javascript_alerts
        Ancak web uygulamalarinda html in yaninda java script alert de bulunabilir.js alertler locate edilemez
        seleniumda js alert ler icin ozel bir yontem var

         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // alert te OK bas
        driver.switchTo().alert().accept();
        // result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult="You successfully clicked an alert";
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResult,actualResult);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();




    }










}
