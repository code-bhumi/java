package com.exceldriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven_basic {

public static void main(String[] args) throws IOException {    


FileInputStream fis = new FileInputStream("/Users/meenakshipal/Documents/demo.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(fis);

int sheets = workbook.getNumberOfSheets();
for(int i=0;i<sheets;i++)  {
    
    if(workbook.getSheetName(i).equalsIgnoreCase("sample"))
    {
        XSSFSheet sheet = workbook.getSheetAt(i);

    // Identify testcases coloumn by scanning the entire 1st row

        Iterator<Row> rows = sheet.iterator();       // sheet is collection of rows
        Row firstrow = rows.next();
        Iterator<Cell> ce = firstrow.cellIterator();   // row is collection of cells
        int k = 0;
        int coloumn = 0;
        while(ce.hasNext())
            {
            Cell value = ce.next();
            if(value.getStringCellValue().equalsIgnoreCase("TestCases"))  
            {
                // to get desired coloumn
                coloumn = k;
            }
          k++;
        }

           System.out.println(coloumn);    
    
        // once coloumn is identified then scan entire testcase coloumn to identify purchase test case row
     while(rows.hasNext()) 
       {
           Row r = rows.next();
           if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("AddProfile"))  
            {
                // after you grab purchase testcase row = pull all the data of that row nd feed into test
                Iterator<Cell> cv = r.cellIterator();
            while (cv.hasNext()) 
                {
                   System.out.println(cv.next().getStringCellValue());
                }
            }
    
        }

    }

        
    }
  }
   
}



