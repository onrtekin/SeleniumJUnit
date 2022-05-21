package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test

    public void test() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        //3. dummy.txt dosyasını indirelim
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='text.txt']")).click();
        Thread.sleep(5000);
        //dosya downloads a indirilir
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\text.txt";
        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
