package com.btl.java1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {
	
	//Duong dan doc file excel    
    private final String SAMPLE_XLSX_FILE_PATH = "dienthoai.xlsx";
    
    //Tao instance dai dien cho SpreadSheet 
    private  Workbook workbook; 
    
    //Tao constructor khi khoi tao doi tuong ExcelReader se tao 1 Workbook tu Excel file 
    public ExcelReader() throws IOException, InvalidFormatException{
    
    		 workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

    }
    
    // Phuong thuc doc fileExcel
    public void docFileExcel(ArrayList<DienThoai> danhsach) throws IOException, InvalidFormatException{
    	 //lay sheet dau tien cua file excel 
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        // Tao DataFormatter de format va lay gia tri cua tung o nhu va tra ve gia tri la 1 string
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
      //  System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        
        // tao 1 doi tuong interator kieu row de lap row trong sheet
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        // Thuc hien lap voi while
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//
//            //tao 1 interator kieu cell de lap tat ca cac o trong 1 row 
//            Iterator<Cell> cellIterator = row.cellIterator();
//           
//            //Tao bien de luu du lieu cho doi thuong 
//            
//        	 String dienthoaiString="";
//        	 
//            //Thuc hien lap voi while
//            while (cellIterator.hasNext()) {
//            	
//            	// tao 1 instance va gan cho gia tri tiep theo cua cellIterator
//                Cell cell = cellIterator.next();
//                
//                //Su dung dataFormatter de format va lay gia tri cua tung o va tra ve gia tri la 1 string
//                String cellValue = dataFormatter.formatCellValue(cell);
//                dienthoaiString+=cellValue; 
//                dienthoaiString+="/";
//                System.out.print(cellValue + "\t");
//            }
//            System.out.println(dienthoaiString);
//            String[] dienthoaiArray=dienthoaiString.split("/");
//            danhsach.add(new DienThoai(dienthoaiArray[0], dienthoaiArray[1], dienthoaiArray[2], dienthoaiArray[3], dienthoaiArray[4],
//            		dienthoaiArray[5], dienthoaiArray[6],
//            		dienthoaiArray[7], dienthoaiArray[8], dienthoaiArray[9],  Integer.parseInt(dienthoaiArray[10]), Integer.parseInt(dienthoaiArray[11]),
//            		dienthoaiArray[12]));
//        }
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        int missFirstRow=1; 
        for (Row row: sheet) {
        	if(missFirstRow!=1) {
        		 for(Cell cell: row) {
                     String cellValue = dataFormatter.formatCellValue(cell);
                     System.out.print(cellValue + "\t");
                 }
                 System.out.println();
        	}
        	missFirstRow++;
        }
    }

}
