package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){
        //1-amazona git
        //2-url in amazon icerdigini test et
        //3-yeni bir pencere acip bestbuy ana sayfa ya gidelim
        //4-Title bestBuy icerdigini test et
        //5-Ilk sayfaya donup sayfada java aratalim
        //6-arama sonuclarinin java icerdigini test et
        //7-yenide bestbuy in acik oldugu sayfaya gidelim
        //8-logonun gorundugunu test et
        driver.get("https://www.amazon.com");
        String ilkSayfaDegeri=driver.getWindowHandle();
        String actualUrl=driver.getCurrentUrl();
        String arananKelime="amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com/");
        String ikinciSayfaDegeri=driver.getWindowHandle();
        String actualTitle=driver.getTitle();
        String aranan="Best Buy";
        Assert.assertTrue(actualTitle.contains(aranan));
        driver.switchTo().window(ilkSayfaDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucStr=sonucYaziElementi.getText();
        String arananK="Java";
        Assert.assertTrue(sonucStr.contains(arananK));
        driver.switchTo().window(ikinciSayfaDegeri);
        WebElement logo=driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());





    }
}
