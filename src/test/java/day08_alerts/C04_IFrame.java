package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    /*
     ● Bir class olusturun: IframeTest
   ● https://the-internet.herokuapp.com/iframe adresine gidin.
   ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

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
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());
        //textbox i dogru locate etmemize ragmen driver bulamadi
        //html kodlari incelendiginde texbox in bir IFrame icinde oldugunu ogrendik
        //IFrame i locate edip switchto() ile IFrame gecmeliyiz
        WebElement IFrameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(IFrameElement);
        WebElement texKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        texKutusu.clear();
        texKutusu.sendKeys("Merhaba Dunya");
       driver.switchTo().defaultContent();
        WebElement linkYazizsi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYazizsi.isDisplayed());
        System.out.println(linkYazizsi.getText());



    }
}
