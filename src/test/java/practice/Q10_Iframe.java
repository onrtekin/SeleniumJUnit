package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10_Iframe  extends TestBase {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    // web sitesini maximize yapin
    // ikinci emojiye tıklayın
    // tüm ikinci emoji öğelerini tıklayın
    // parent iframe e geri donun
    // formu doldurun,(Formu istediğiniz metinlerle doldurun)
    //  apply button a basin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

       List<WebElement> emoojiler=driver.findElements(By.xpath("//div[@id='nature']"));
       emoojiler.stream().forEach(t->t.click());
       Thread.sleep(2000);

       driver.switchTo().parentFrame();

       List<WebElement> textList=driver.findElements(By.xpath("//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded']"));
       List<String> text=new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        for (int i = 0; i <textList.size() ; i++) {
            textList.get(i).sendKeys(text.get(i));
        }
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }
}
