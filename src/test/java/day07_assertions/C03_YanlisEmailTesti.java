package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C03_YanlisEmailTesti {
    /*
    Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("oner.gmail.com"+ Keys.ENTER);
        WebElement uyariYazisiElementi= driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());


    }
}
