package com.btl.java1;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;




public class ExcelWriter {

	// Tao ten cac cot trong file excel 
    private  String[] columns = { "Ten dien thoai", "Man Hinh", "Camera","Cpu","Bo nho","Ket noi","Pin","Chat lieu","Kich thuoc","Hang","So luong mua","Gia","Id"};

    // Tao ArrayList de luu danh sach dien thoai
    private  ArrayList<DienThoai> dienthoais ;

    
   public  ExcelWriter()throws IOException, InvalidFormatException{
//	   workbook = new XSSFWorkbook();
	   dienthoais=new ArrayList<>();
   }
   
   //Phuong thuc truyen tat ca du lieu vao arraylist trong class 
   public void layDuLieu(ArrayList<DienThoai> ds) {
	   ds.forEach((dienthoai)->{dienthoais.add(dienthoai);});
	  
   }
   
   // Phuong thuc ghi vao file excel 
   public void ghiFileExcel() throws IOException, InvalidFormatException{
	   Workbook workbook=new XSSFWorkbook();
	   CreationHelper createHelper = workbook.getCreationHelper();

       // Tao sheet trong file excel 
       Sheet sheet = workbook.createSheet("DienThoai");

       // tao style cho ten cot trong sheet 
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
   

       // Create Other rows and cells with employees data
       // Tao hang va o khac voi du lieu la dienthoai 
       int rowNum = 1;
       for(DienThoai dienthoai: dienthoais) {
           Row row = sheet.createRow(rowNum++);   
           row.createCell(0)
           .setCellValue(dienthoai.getTendt());
           row.createCell(1)
           .setCellValue(dienthoai.getManHinh());
           row.createCell(2)
           .setCellValue(dienthoai.getCamera());
           row.createCell(3)
           .setCellValue(dienthoai.getCpu());
           row.createCell(4)
           .setCellValue(dienthoai.getBoNho());
           row.createCell(5)
           .setCellValue(dienthoai.getKetNoi());
           row.createCell(6)
           .setCellValue(dienthoai.getPin());
           row.createCell(7)
           .setCellValue(dienthoai.getChatLieu());
           row.createCell(8)
           .setCellValue(dienthoai.getKichThuoc());
           row.createCell(9)
           .setCellValue(dienthoai.getHang());
           row.createCell(10)
           .setCellValue(dienthoai.getSoLuongMua());
           row.createCell(11)
           .setCellValue(dienthoai.getGia());
           row.createCell(12)
           .setCellValue(dienthoai.getId());
       }


       // thay doi tat ca kich cua hang cho vua content size 
       for(int i= 0; i < columns.length; i++) {
           sheet.autoSizeColumn(i);
       }

 
       // viet output vao file 
       FileOutputStream fileOut = new FileOutputStream("dienthoai.xlsx");
       workbook.write(fileOut);
       fileOut.close();

       workbook.close();
   }
        
}


