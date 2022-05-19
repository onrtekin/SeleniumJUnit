package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {
    /*

Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement drogMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drogMe,dropHere).perform();
        Thread.sleep(5000);
        String expectedYazi="Dropped!";
        String actualYazi=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedYazi, actualYazi);




    }
}
