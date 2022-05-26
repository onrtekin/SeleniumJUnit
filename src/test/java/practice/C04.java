package practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class C04 extends TestBase {

    @Test
    public void test() throws IOException, InterruptedException {

        driver.get("https://github.com/onrtekin");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement inButon=driver.findElement(By.xpath("(//img[@align='center'])[1]"));
        String gitHubWindowHandleDegeri=driver.getWindowHandle();

        js.executeScript("arguments[0].scrollIntoView(true);",inButon);
        js.executeScript("arguments[0].click();",inButon);
        Set<String> windowHandleSet=driver.getWindowHandles();
        String inWindowHandleDegeri="";

        for (String each:windowHandleSet) {
            if (!each.equals(gitHubWindowHandleDegeri)) {
                inWindowHandleDegeri = each;

            }
        }
        driver.switchTo().window(inWindowHandleDegeri);
        TakesScreenshot ss= (TakesScreenshot) driver;
        File in=new File("target/ekranGoruntuleri/inProfilFoto.jpeg");
        File temp=ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,in);

        driver.switchTo().window(gitHubWindowHandleDegeri);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);

        LocalDateTime date= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmm");
        String tarih=date.format(dtf);
        TakesScreenshot ss2= (TakesScreenshot) driver;
        File gh=new File("target/ekranGoruntuleri/"+tarih+".jpeg");
        File temp2=ss2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp2,gh);
        driver.quit();




    }

}
