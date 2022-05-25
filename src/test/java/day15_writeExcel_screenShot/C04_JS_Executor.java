package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {

    @Test

    public void JSExecutorTest() throws InterruptedException {

        //amazona git
        driver.get("https://www.amazon.com");
        //sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        //sig in clik yapalim
        jse.executeScript("arguments[0].click();",signInButonu);

    }
}
