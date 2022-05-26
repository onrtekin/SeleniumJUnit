package practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03 extends TestBase {
    @Test

    public void test() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement dd=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dd);
        select.selectByIndex(7);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Asus Laptop"+ Keys.ENTER);
        WebElement aramaAmazon=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));


        File amazonSonuc=new File("target/ekranGoruntuleri/amazonLaptopAramaSonuc.jpeg");
        File temp1=aramaAmazon.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp1,amazonSonuc);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.trendyol.com");
        WebElement kapat=driver.findElement(By.xpath("//div[@class='modal-close']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(kapat).click().perform();
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("Asus Laptop"+Keys.ENTER);
        WebElement aramaTrendyol=driver.findElement(By.xpath("//div[@class='dscrptn']"));
        File trendyolSonuc=new File("target/ekranGoruntuleri/trendyolLaptopAramaSonuc.jpeg");
        File temp2=aramaTrendyol.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp2,trendyolSonuc);
        driver.quit();












    }

}
