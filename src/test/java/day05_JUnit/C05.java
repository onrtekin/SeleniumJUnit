package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05 {

    WebDriver driver;
    @Before
    public void setup(){
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
    public void test1(){
        driver.get("https:www.google.com");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Safranbolu");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Lap top");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[5]")).click();
        System.out.println(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText());


    }

}
