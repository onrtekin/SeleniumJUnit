package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon ana sayfaya gidip dropdown menuden books secelim
    sonra sectigimiz optionu yazdiralim

    Dropdown daki optionlarin toplam sayisinin 28 oldugunu test edin

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
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        //secilen optiona ulasmak isterseniz select.getFirstSelectedOption() methodu kullanilmali
        // bu method bize WebElemet dondurur getText() yazilmali
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> optionList=select.getOptions();
        System.out.println(optionList);
        int actualOptionSayisi=optionList.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

    }
}
