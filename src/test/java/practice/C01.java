package practice;

import net.bytebuddy.asm.Advice;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01 {
    @Test
    public void writetest() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1")
                .getRow(0)
                .createCell(4)
                .setCellValue("GSMH");
        int gsmh=500;

        for (int i = 1; i < 190; i++) {
            workbook.getSheet("Sayfa1")
                    .getRow(i)
                    .createCell(4)
                    .setCellValue(gsmh+"$");
            gsmh+=25;
        }

        FileOutputStream fs=new FileOutputStream(dosyaYolu);
        workbook.write(fs);







    }
}
