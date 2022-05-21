package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
    /*
    1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
     Iki metod icin de asagidaki adimlari test edin.
     */
    @Test
    public void implicitWaitTesti(){


//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@type='button']")).click();

//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneYazisi.isDisplayed());
//6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

//7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBack.isDisplayed());




    }
}
