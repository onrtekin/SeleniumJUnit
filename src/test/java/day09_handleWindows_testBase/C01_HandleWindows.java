package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
        /*
        1-amazon ana sayfaya git
        2-nutella arat
        3-ilk urunun resmini tiklayarakfarkli bir tab olarak acin
        4-yeni tab da acilan urunun title yazdir
         */
        driver.get("https://www.amazon.com");
        String ilkSayfaDegeri=driver.getWindowHandle();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("//img[@alt='Nutella Chocolate Hazelnut Spread, Perfect Topping for Easter Treats, 35.2 oz Jar']"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        BU KOMUTU KULLANDİGİMİZDA DRİVER otomatik olarak new taba gecer
        yeni tabda gorevi gerceklestirmek icin adimlari bastan almak gerekir


         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Nutella Chocolate Hazelnut Spread, Perfect Topping for Easter Treats, 35.2 oz Jar']")).click();
        WebElement urunTitled =driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitled.getText());
        System.out.println(driver.getCurrentUrl());
        //ilk sayfaya gecip url i yazdiralim
        driver.switchTo().window(ilkSayfaDegeri);
        System.out.println(driver.getCurrentUrl());

        /*
        CDwindow-C560B50D7A50ED7C62E76F3AA052E093
        acilan sayfanin unique hash kodudur
        Selenium sayfalar arsi geciste bu windowhandle degerini kullanir
        eger sayfalar arasinda driver imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfay gecmek istiyorsak
        driver.switchTo().window("CDwindow-C560B50D7A50ED7C62E76F3AA052E093");
        bu sekilde gecisi saglayabiliriz.
         */


    }
}
