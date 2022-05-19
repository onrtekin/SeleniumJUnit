package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        /*
        facebook git
        yeni kayit olustura bas
        isim kutusunu locate et
        geri kalanlari tab ile dolasarak doldur

         */
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']")).sendKeys("Omer");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("Faik")
                        .sendKeys(Keys.TAB).sendKeys("05552554556")
                        .sendKeys(Keys.TAB).sendKeys("4565464")
                        .perform();
        WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select1=new Select(day);
        select1.selectByValue("26");
        WebElement mounth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select2=new Select(mounth);
        select2.selectByValue("4");
        WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select3=new Select(year);
        select3.selectByValue("1982");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_RIGHT).click().perform();
        WebElement button=driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));
        button.click();








        Thread.sleep(4000);



    }
}
