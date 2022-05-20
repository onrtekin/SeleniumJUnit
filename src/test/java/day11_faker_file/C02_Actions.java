package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        /*
        1- Bir Class olusturalim KeyboardActions2
2- https://html.com/tags/iframe/ sayfasina gidelim
3- video’yu gorecek kadar asagi inin
4- videoyu izlemek icin Play tusuna basin
5- videoyu calistirdiginizi test edin
         */
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframe= driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        WebElement youtubeLink=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLink.isDisplayed());

        Thread.sleep(5000);


    }
}
