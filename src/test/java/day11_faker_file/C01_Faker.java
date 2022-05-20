package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //faceebook gorevini fake isimlerle yapalim
        /*
        facebook git
        yeni kayit olustura bas
        isim kutusunu locate et
        geri kalanlari tab ile dolasarak doldur

         */
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        Faker faker=new Faker();
        driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']")).sendKeys(faker.name().firstName());
        Actions actions=new Actions(driver);


        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
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
