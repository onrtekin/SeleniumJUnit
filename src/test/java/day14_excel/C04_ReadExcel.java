package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public  void readExcelTest() throws IOException {


        //1. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //4. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //5.ingilizce baskentler sutununu yazdiralim

        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        String satirdakiData="";


        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=C03_ReadExcel.banaDataGetir(i,3);
            System.out.println((i+1)+" : "+satirdakiData);

        }
    }
}
