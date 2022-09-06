package com.btl.java1;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;




public class ExcelWriter {

    private  String[] columns = { "Ten dien thoai", "Man Hinh", "Camera","Cpu","Bo nho","Ket noi","Pin","Chat lieu","Kich thuoc","Hang","So luong mua","Gia","Id"};

    private  ArrayList<DienThoai> dienthoais ;

//    private  Workbook workbook; 
  
    
   public  ExcelWriter()throws IOException, InvalidFormatException{
//	   workbook = new XSSFWorkbook();
	   dienthoais=new ArrayList<>();
   }
   
   public void layDuLieu(ArrayList<DienThoai> ds) {
	   ds.forEach((dienthoai)->{dienthoais.add(dienthoai);});
	  
   }
   
   public void ghiFileExcel() throws IOException, InvalidFormatException{
	   Workbook workbook=new XSSFWorkbook();
	   CreationHelper createHelper = workbook.getCreationHelper();

       // Create a Sheet
       Sheet sheet = workbook.createSheet("DienThoai");

       // Create a Font for styling header cells
       Font headerFont = workbook.createFont();
       headerFont.setBold(true);
       headerFont.setFontHeightInPoints((short) 14);
       headerFont.setColor(IndexedColors.RED.getIndex());

       // Create a CellStyle with the font
       CellStyle headerCellStyle = workbook.createCellStyle();
       headerCellStyle.setFont(headerFont);

       // Create a Row
       Row headerRow = sheet.createRow(0);

       // Creating cells
       for(int i = 0; i < columns.length; i++) {
           Cell cell = headerRow.createCell(i);
           cell.setCellValue(columns[i]);
           cell.setCellStyle(headerCellStyle);
       }
       // Cell Style for formatting Date
       //CellStyle dateCellStyle = workbook.createCellStyle();
       //dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

       // Create Other rows and cells with employees data
       int rowNum = 1;
       for(DienThoai dienthoai: dienthoais) {
           Row row = sheet.createRow(rowNum++);

          
           row.createCell(0)
           .setCellValue(dienthoai.getId());
           row.createCell(1)
           .setCellValue(dienthoai.getTendt());
           row.createCell(2)
           .setCellValue(dienthoai.getManHinh());
           row.createCell(3)
           .setCellValue(dienthoai.getCamera());
           row.createCell(4)
           .setCellValue(dienthoai.getCpu());
           row.createCell(5)
           .setCellValue(dienthoai.getBoNho());
           row.createCell(6)
           .setCellValue(dienthoai.getKetNoi());
           row.createCell(7)
           .setCellValue(dienthoai.getPin());
           row.createCell(8)
           .setCellValue(dienthoai.getChatLieu());
           row.createCell(9)
           .setCellValue(dienthoai.getKichThuoc());
           row.createCell(10)
           .setCellValue(dienthoai.getHang());
           row.createCell(11)
           .setCellValue(dienthoai.getGia());
           row.createCell(12)
           .setCellValue(dienthoai.getId());
       }

       // Resize all columns to fit the content size
       for(int i= 0; i < columns.length; i++) {
           sheet.autoSizeColumn(i);
       }

       // Write the output to a file
       FileOutputStream fileOut = new FileOutputStream("dienthoai.xlsx");
       workbook.write(fileOut);
       fileOut.close();

       workbook.close();
   }
        
}


