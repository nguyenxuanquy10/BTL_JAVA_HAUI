package com.btl.java1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	chayChuongTrinh();
	}
    
    public static void chayChuongTrinh() {
    	  Scanner sc=new Scanner(System.in); 
          QuanLyDienThoai quanly=new QuanLyDienThoai();
          quanly.quanLySanPham(sc);
    }
}