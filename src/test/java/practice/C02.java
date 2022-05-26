package practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02 extends TestBase {

    @Test
    public void test() throws IOException {
      driver.get("https://github.com/onrtekin");
     TakesScreenshot ss= (TakesScreenshot) driver;
     File myGitHub=new File("target/ekranGoruntuleri/myGithub.jpeg");
     File temp=ss.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(temp,myGitHub);






    }


}
