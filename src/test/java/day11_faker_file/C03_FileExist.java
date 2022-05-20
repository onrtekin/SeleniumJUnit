package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //icinde oldugum projenin dosya yolunu (path) verir

        System.out.println(System.getProperty("user.home"));
        //benim bilgisayarimin bana ozel kismini verir
        //C:\Users\Default\Downloads
        //homePath + "\Downloads"

        // masa ustundeki tex dosyasinin varligini test edelim
        //C:\Users\Öner\Desktop\text.txt
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);
        /*
        bir dosyanin varligini test etmek icin once o dosyaya ulasmak gerekir
        dosya yoluna ihtiyac vardir.her bilgisayari kullanici adi farkli olacagindan
        dosya yoluda farkli olacaktir
        testlerimimzin tum bilgisayarlarda calismasi icin dosya yolunun dinamik olmasi gerekir
        String farkliKisim=System.getProperty("usr.home")
         String ortakKisim="\Desktop\text.txt"
         String dosyaYolu=farkliKisim+ortakKisim;

         */
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
