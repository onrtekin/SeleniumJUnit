package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {
/*
/*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntul
 */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public  void testtenOnce(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        Assert.assertTrue("Title Best kelimesi icermiyor",driver.getTitle().contains("Best"));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void logoTest(){
        //WebElement logo=driver.findElement(By.xpath("//img[@class='logo']"));
        WebElement helloHeading=driver.findElement(By.xpath("//div[@class='heading']"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void linkTest(){
        WebElement uLink=driver.findElement(By.xpath("//img[@alt='United States']"));
        WebElement mLink=driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(uLink));
        Assert.assertTrue(mLink.isDisplayed());

    }
}
