package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C05 {
    /*
1) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
testleri yapin

○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
○ logoTest => BestBuy logosunun görüntülendigini test edin
○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
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
       // driver.close();
    }
    @Test
    public void test() {
        driver.get("https://www.bestbuy.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertNotEquals(expectedTitle,actualTitle);
        String actualLogo=driver.getPageSource();
        String expectedLogo="BestBuy";










    }

}
