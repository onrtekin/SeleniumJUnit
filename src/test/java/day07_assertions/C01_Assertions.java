package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfa ya gidin
    3 farkli test methodu olusturarak asagidaki gorevleri yapin
       1-Url in amazon icerdigini test edin
       2-Title in facebook icermedigini test edin
       3-Sol ust kosede amazon logosunun gorundugunu test edin

     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }
  @AfterClass
    public static void tearDown(){
        driver.close();
  }


  @Test
    public  void test1(){

        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();

      Assert.assertTrue(actualUrl.contains(arananKelime));

  }
  @Test
    public void test2(){
        String istenmeyenKelime="facebook";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
  }
  @Test
    public void test3(){
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());

  }

}
