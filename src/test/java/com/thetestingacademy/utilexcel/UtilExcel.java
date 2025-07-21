package com.thetestingacademy.utilexcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {
//    APACHE POI
//    Read the Excel file
//    Workbook create
//    Sheet
//    Rows and columns - Cells
//    2d object create- get_Data()

    static Workbook book;
    static Sheet sheet;

    public static String Sheet_Path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";


    public static Object[][] getdatafromExcel(String sheetname) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(Sheet_Path);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetname);

        } catch (IOException e) {
            System.out.println("File not Found or Workbook not created");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) { // 0 to 20
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)// columns reading 0 to 1
            {
                // we are using i+1 to skip the header part
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

            }

        }
        return data;


    }
}
