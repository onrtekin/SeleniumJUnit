package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
    public  void test01(){
        /*
        eger test methodumuzda hicbir test yoksa, test calistiktan sonra hicbir problemle karsilasilmadigini
        raporlamak icin "test passed" yazisi cikar

        Eger testleri if else le yaparsak test faild olsa bile kodlar problemsiz calistigi icin
        ekranda test passed yazacaktir


         */

        driver.get("https://www.amazon.com");

        /*
        url in https://www.facebook.com oldugunu test edin
         */
        /*
        if(driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url Testi PASSED");
        }else{
            System.out.println("Url Testi FAILD");
        }
        */
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        /*
        Assert ile yaptigimiz testlerde assetion failed olursa kodlarin calismasi durur ve
        Assert classi bizi hata konusunda bilgilendirir.

        org.junit.ComparisonFailure: Url beklenenden farkli
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>

         */

    }

}
