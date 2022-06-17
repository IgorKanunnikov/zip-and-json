package zip;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipReadTests {

    ClassLoader classLoader = ZipReadTests.class.getClassLoader();

    @Disabled
    @DisplayName("Read CSV file content from ZIP")
    @Test
    void readCSV() throws Exception {
        try {
            ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("sample.zip")).getFile());
            Enumeration<? extends ZipEntry> entries = file.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                try (InputStream stream = file.getInputStream(entry)) {
                    System.out.println(new String(stream.readAllBytes()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Check PDF")
    @Test
    void checkPDF() {
        try {
            ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("example.zip")).getFile());
            ZipEntry entry = file.getEntry("SamplePDF.pdf");
            PDF pdf;
            try (InputStream stream = file.getInputStream(entry)) {
                pdf = new PDF(stream);
            }
            assertThat(pdf.text).contains("A Simple PDF File");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Check CSV")
    @Test
    void checkCSV() throws Exception {
        try {
            ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("example.zip")).getFile());
            ZipEntry entry = file.getEntry("SampleCSV.csv");

            List<String[]> list;
            try (InputStream stream = file.getInputStream(entry)) {
                CSVReader reader = new CSVReader(new InputStreamReader(stream));
                list = reader.readAll();
            }
            assertThat(list).contains(
                    new String[]{"5", "Holmes HEPA Air Purifier", "Carlos Soltero", "515", "30.94", "21.78", "5.94", "Nunavut", "Appliances", "0.5"}
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Check XLS")
    @Test
    void checkXLS(){
        try {
            ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("example.zip")).getFile());
            ZipEntry entry = file.getEntry("SampleXLS.xls");
            XLS xls;
            try (InputStream stream = file.getInputStream(entry)) {
                xls = new XLS(stream);
            }
            assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).contains("Muhammed MacIntyre");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
