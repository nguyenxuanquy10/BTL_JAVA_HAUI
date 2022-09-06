package com.btl.java1; 

 import java.util.ArrayList ;
 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Scanner;
 import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.sql.*;
 import java.util.List;
 import java.util.ArrayList ; 

 public class QuanLyDienThoai {
 	
 	//Khai bao thuoc tinh 
 	private  ArrayList <DienThoai> danhsach;
 	
 	// la so luong ban ghi
 	private int soluong;
 	
 	//Khao bao instance cua JDBC
 	private ThaoTacJDBC jdbc; 
 	
 	//Kha1 bao instance cua thao tac ghi file Excel
 	private ExcelWriter excelWriter; 
 	
 	// Khai bao instance cua thao tao lay du lieu tu fiel Excel 
 	private ExcelReader excelReader; 
 	
 	//Khai bao instance thao tac voi file 
 	private thaoTacFile thaotacFile;
 	public QuanLyDienThoai(){
 		// TODO Auto-generated constructor stub
 		 try {
 			danhsach = new ArrayList<DienThoai>();
 		 	jdbc=new ThaoTacJDBC();
 		 	excelWriter=new ExcelWriter();
 			excelReader=new ExcelReader();
 			thaotacFile=new thaoTacFile();
   	    }
 		catch(Exception e) {
 			System.out.println(e);
 		}
 		
 	}
 	
 	// Sinh ngau nhien 1000 cai dien thoai
 	public void generateIP(Scanner sc) {
 		
 		//khai ban so luong object va nhap tu ban phim 
 		System.out.println("Nhap so luong ban ghi du lieu");
 	    soluong=sc.nextInt();
 		// tao so luong object 
 	   String[] tendt= {"Iphone 13 Pro Max","OPPO A95","Xiomi 11T","Vivo V23e","OPPO A16K","Xiomi Redmi 10","Iphone XR","Sam Sung A12"};
 		String[] ManHinh= {"AMOLed","IPS Quantun","LED-backlit","ClearBlack","IPS LCD","TFT-LCD","Super LCD","LCD"};
 		String[] Camera= {"WideLen","Tele","MonoChrome","ToF","Macro","OFF","PQA","ART"}; 
 		String[] CPU= {"A13","Exynos","Snapdragon","Kirin","MediaTek","TTQ","ABD","NextTook"};
 		String[] BoNho= {"4GB","8GB","16GB","32GB","128GB","256GB","512GB","1024GB"};
 		String[] KetNoi= {"5G","4G","BEIDOU","GALILEO","GPS","QZSS","GLONASS","NFC"};
 		String[] Pin= {"NiCad","Ni-MH","Lithium Lon","Lithium Polymer","Li-Po","LithiumV1","Li-Pov2","LonL"}; 
 		String[] ChatLieu= {"KimLoai","Nhua","Kinh","Gom","Liquidmorphium","Go","DaBo","Thep"};
 		String[] KichThuoc= {"6.7inch","6.1inch","6.5inch","5.8inch"};
 	    String[] Hang= {"Android","GOOOGLE","SAMSUNG","SONY","NOKIA","LG","XIAOMI","VIVO"};
 		int soLuongMua; 
 	    int giaa; 
         String id="";
 		for(int i=0;i<soluong;i++) {
 			String tenDt=tendt[(int)(Math.random()*7+1)];
 			String manHinh=ManHinh[(int)(Math.random()*7+1)];
 			String camera=Camera[(int)(Math.random()*7+1)];
 			String cPU=CPU[(int)(Math.random()*7+1)];
 			String boNho=BoNho[(int)(Math.random()*7+1)];
 			String ketNoi=KetNoi[(int)(Math.random()*7+1)];
 			String pin=Pin[(int)(Math.random()*7+1)];
 			String chatLieu=ChatLieu[(int)(Math.random()*7+1)];
 			String kichThuoc=KichThuoc[(int)(Math.random()*3+1)];
 			String hang=Hang[(int)(Math.random()*7+1)]; 
 			soLuongMua=(int)(Math.random()*100); 
 			giaa=(int)(Math.random()*7);
 			id="DIENTHOAI"+i; 
 			DienThoai dienthoai=new DienThoai(tenDt,manHinh,camera,cPU,boNho,ketNoi,pin,chatLieu,kichThuoc,hang,soLuongMua,giaa,id); 
 			danhsach.add(dienthoai); 
 		}
 	}
 	
 // loc theo ten san pham 
	  public  void locTheoTen(String manHinh) {
	    	ArrayList <DienThoai> result=new ArrayList<>();
	    	for(int i=0;i<danhsach.size();i++) {
	    		if(danhsach.get(i).getManHinh().equals(manHinh)) {
	    			result.add(danhsach.get(i));
	    		}
	    	}
	    	System.out.println("---Danh sach dien thoai theo hang ---"); 
	    	result.forEach(System.out::println);
	    }
 	// loc theo man hinh 
 		  public  void locTheoManHinh(String manHinh) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getManHinh().equals(manHinh)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		// loc theo camera 
 		  public void locTheoCamera(String camera) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getCamera().equals(camera)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		// loc theo cpu 
 		  public void locTheoCPU(String CPU) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getCpu().equals(CPU)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		//loc theo pin 
 		  public  void locTheoPin(String Pin) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getPin().equals(Pin)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		// loc theo chat lieu 
 		  public  void locTheoChatLieu(String chatLieu) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getChatLieu().equals(chatLieu)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		// loc theo kich thuoc
 		  public  void locTheoKichThuoc(String kichThuoc) {
 		    	ArrayList <DienThoai> result=new ArrayList<>();
 		    	for(int i=0;i<danhsach.size();i++) {
 		    		if(danhsach.get(i).getKichThuoc().equals(kichThuoc)) {
 		    			result.add(danhsach.get(i));
 		    		}
 		    	}
 		    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 		    	result.forEach(System.out::println);
 		    }
 		// loc dien thoai theo hang 
 	    public  void locTheoHang(String hang) {
 	    	ArrayList <DienThoai> result=new ArrayList<>();
 	    	for(int i=0;i<danhsach.size();i++) {
 	    		if(danhsach.get(i).getHang().equals(hang)) {
 	    			result.add(danhsach.get(i));
 	    		}
 	    	}
 	    	System.out.println("---Danh sach dien thoai theo hang ---"); 
 	    	result.forEach(System.out::println);
 	    }
 	 // loc theo bo nho
 	    public  void locTheoBoNho(String bonho) {
 	    	ArrayList <DienThoai> result=new ArrayList<>();
 	    	for(int i=0;i<danhsach.size();i++) {
 	    		if(danhsach.get(i).getBoNho().equals(bonho)) {
 	    			result.add(danhsach.get(i));
 	    		}
 	    	}
 	    	System.out.println("---Danh sach dien thoai theo bo nho ---"); 
 	    	result.forEach(System.out::println);
 	    } 
 	 // sap xep dien thoai theo gia tang dan 
 	 	public  void sapXepTheoGiaTangDan() {
 	 		Comparator<DienThoai> sosanh = new Comparator<DienThoai>() {

 	 		    @Override
 	 		    public int compare(DienThoai o1, DienThoai o2) {
 	 		        return Integer.compare(o1.getGia(), o2.getGia());
 	 		    }
 	 		};
 	 		danhsach.sort(sosanh);
 	 		System.out.println("---Danh sach dien thoai sap xep theo gia---");
 	 		danhsach.forEach(System.out::println);
 	 	}
 	 	 // sap xep dien thoai theo gia tang dan 
 	 	public  void sapXepTheoGiaGiamDan() {
 	 		Comparator<DienThoai> sosanh = new Comparator<DienThoai>() {

 	 		    @Override
 	 		    public int compare(DienThoai o1, DienThoai o2) {
 	 		        return Integer.compare(o2.getGia(), o1.getGia());
 	 		    }
 	 		};
 	 		danhsach.sort(sosanh);
 	 		System.out.println("---Danh sach dien thoai sap xep theo gia---");
 	 		danhsach.forEach(System.out::println);
 	 	}
 		// sap xep dien thoai theo so luong mua  xem san pham nao ban chay nhat
 		public  void sapXepTheoSoLuongMua() {
 			Comparator<DienThoai> sosanh = new Comparator<DienThoai>() {

 			    @Override
 			    public int compare(DienThoai o1, DienThoai o2) {
 			        return Integer.compare(o1.getSoLuongMua(), o2.getSoLuongMua());
 			    }
 			};
 			danhsach.sort(sosanh);
 			System.out.println("---Danh sach dien thoai sap xep theo so luong mua---");
 			danhsach.forEach(System.out::println);
 		}
 		// hang ban nhieu dien thoai nhat 
 		public void hangBanNhieuNhat() {
 			 // Insert all elements in hash
 	        Map<String, Integer> hp =
 	               new HashMap<String, Integer>();
 	         
 	        for(int i = 0; i < danhsach.size(); i++)
 	        {
 	            String key = danhsach.get(i).getHang();
 	            int soluongBan=danhsach.get(i).getSoLuongMua();
 	            if(hp.containsKey(key))
 	            {
 	                int freq = hp.get(key);
 	                freq+=soluongBan; 
 	                hp.put(key, freq);
 	            }
 	            else
 	            {
 	                hp.put(key,soluongBan);
 	            }
 	        }
 	         
 	        // tim so luong ban nhieu nhat 
 	        int max_count = 0;
 	        String res ="";
 	         
 	        for(Entry<String, Integer> val : hp.entrySet())
 	        {
 	            if (max_count < val.getValue())
 	            {
 	                res = val.getKey();
 	               
 	                max_count = val.getValue();
 	            }
 	        }
 	        System.out.println("Hang ban chay nhat la : "+ res);
 	        System.out.println("So luong la : "+ max_count);
 		}
 	// top 5 san phan ban chay nhat
 		public void top5SanPhamBanChay() {
 			Comparator<DienThoai> sosanh = new Comparator<DienThoai>() {

 			    @Override
 			    public int compare(DienThoai o1, DienThoai o2) {
 			        return Integer.compare(o2.getSoLuongMua(), o1.getSoLuongMua());
 			    }
 			};
 			danhsach.sort(sosanh);
 			System.out.println("---Top 5 san pham ban chay nhat---");
 			for(int i=0;i<5;i++) {
 				System.out.print("top "+ (i+1)+ "  :"); 
 				System.out.println(danhsach.get(i));
 			}

 		}
 	// top 10 sản phẩm bán được ít hàng nhất 
 		public void top10SanPhamBanItNhat() {
 			Comparator<DienThoai> sosanh = new Comparator<DienThoai>() {

 			    @Override
 			    public int compare(DienThoai o1, DienThoai o2) {
 			        return Integer.compare(o2.getSoLuongMua(), o1.getSoLuongMua());
 			    }
 			};
 			danhsach.sort(sosanh);
 			System.out.println("---Top 10 san pham ban it hang nhat---");
 			for(int i=danhsach.size()-1;i>danhsach.size()-11;i--) {
 				System.out.print("top "+ (danhsach.size()-i)+ "  :"); 
 				System.out.println(danhsach.get(i));
 			}
 		}
 		
 // Them 1 san pham
 	 public void themMotSanPham(Scanner sc) {
 		 this.soluong++; 
 		  System.out.println("Nhap ten dien thoai ");
 		  String tendt=sc.nextLine();
 		  System.out.println("Nhap man hinh ");
 		  String manHinh=sc.nextLine();
 		  System.out.println("Nhap camera ");
 		  String camera=sc.nextLine();
 		  System.out.println("Nhap cpu ");
 		  String cpu=sc.nextLine();
 		  System.out.println("Nhap bo nho ");
 		  String boNho=sc.nextLine();
 		  System.out.println("Nhap ket noi");
 		  String ketNoi=sc.nextLine();
 		  System.out.println("Nhap pin");
 		  String pin=sc.nextLine();
 		  System.out.println("Nhap chat lieu");
 		  String chatLieu=sc.nextLine();
 		  System.out.println("Nhap kich thuoc");
 		  String kichThuoc=sc.nextLine();
 		  System.out.println("Nhap hang san xuat");
 		  String hang=sc.nextLine();
 		  int soLuongMua=0;
 		  System.out.println("Nhap gia ");
 		  int gia=sc.nextInt();
 		  String id="DIENTHOAI"+this.soluong;
 		  DienThoai dienthoai=new DienThoai(tendt,manHinh,camera,cpu,boNho,ketNoi,pin,chatLieu,kichThuoc,hang,soLuongMua,gia,id); 
 		  danhsach.add(dienthoai);
 		  
 	 }
 //Lay toan bo danh sach san pham 
 	 public void layToanBoDanhSach() {
 		 System.out.println("---Toan bo danh sach dien thoai la ---");
 		 this.danhsach.forEach(System.out::println);
 	 }
 // Lay 1 san pham qua id
 	 public void laySanPhamQuaId(Scanner sc) {
 		 System.out.println("Nhap id cua san pham");
 		 String id=sc.nextLine();
 		 for(int i=0;i<danhsach.size();i++) {
 			 if(danhsach.get(i).getId().equals(id)) {
 				 System.out.println("San pham do la : "); 
 				 System.out.println(danhsach.get(i).toString());
 				 return; 
 			 }
 		 }
 		 System.out.println("Id cua san pham khong ton tai "); 
 	 }
 // Xoa 1 san pham qua id
 	 public void xoaSanPham(Scanner sc) {
 		 System.out.println("Nhap id cua san pham can xoa "); 
 		 String id=sc.nextLine();
 		 DienThoai ketqua = danhsach.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
 		 if(ketqua!=null) {
 			   System.out.println("Xóa thành công");
 			   danhsach.remove(ketqua);
 		 }
 	 }
 //Sua 1 san pham 
     public void suaSanPHam(Scanner sc) {
     	System.out.println("Nhap id cua san pham can xoa "); 
 		String id=sc.nextLine();
 		for(int i=0;i<danhsach.size();i++) {
 			 if(danhsach.get(i).getId().equals(id)) {
 				 danhsach.remove(danhsach.get(i)); 
 				 themMotSanPham(sc); 
 				 System.out.println("Them thanh cong");
 				 return ; 
 			 }
 		 }
 		return; 
 		
     }
 // ham lay du lieu tu database 
     public void docDuLieuTuDataBase() {
    	 try {
    		 jdbc.LayDl(danhsach);
    		 System.out.println("-- Lay thanh cong --"); 
    	 }
    	 catch(SQLException e) {
    		 System.out.println(e);
    	 }
    	
     }
//Ghi du lieu  vao database 
     public void ghiDuLieuDataBase() {
    	 boolean check=true; 
    	 try {
    		 jdbc.ChenDl(danhsach);
    	 }
    	 catch(SQLException e) {
    		 check=false; 
    		 System.out.println(e);
    	 }
    	 if(check==true) {
    		 System.out.println("-- Ghi du lieu vao file Excel thanh cong --");
    	 }
    	 else {
    		 System.out.println("-- Ghi du lieu vao file Excel that bai --");
    	 }
     }
 //Doc du lieu tu file Excel 
     public void docDuLieuExcel() {
    	 boolean check=true; 
    	 try {
    		 excelReader.docFileExcel(danhsach);
    	 }
    	 catch(Exception e) {
    		 check=false; 
    		 System.out.println(e);
    	 }
    	 if(check==true) {
    		 System.out.println("-- Ghi du lieu vao file Excel thanh cong --");
    	 }
    	 else {
    		 System.out.println("-- Ghi du lieu vao file Excel that bai --");
    	 }
     }
 //Ghi du lieu vao file Excel
     public void ghiDuLieuExcel() {
    	 boolean check=true; 
    	 try {
    		 excelWriter.layDuLieu(danhsach);
    		 excelWriter.ghiFileExcel();

    	 }
    	 catch(Exception  a) {
    		 check=false; 
    		 System.out.println(a);
    	 }
    	 if(check==true) {
    		 System.out.println("-- Doc du lieu vao file Excel thanh cong --");
    	 }
    	 else {
    		 System.out.println("-- Doc du lieu vao file Excel that bai --");
    	 }
     }
 // Doc du lieu tu  file text
     public void docDuLieuFileText() {
    	 boolean check=true; 
    	 try {
    		 thaotacFile.DocFile(danhsach);
    	 }
    	catch(Exception e) {
    		 check=false; 
    		System.out.println(e);
    	}
    	 if(check==true) {
    		 System.out.println("-- Doc du lieu vao file text thanh cong --");
    	 }
    	 else {
    		 System.out.println("-- Doc du lieu vao file text that bai --");
    	 }
     }
 // Ghi du lieu  vao file text
     public void ghiDuLieuFileText() {
    	 boolean check=true; 
    	 try {
    		 thaotacFile.GhiFile(danhsach);
    	 }
    	catch(Exception e) {
    		 check=false; 
    		System.out.println(e);
    	}
    	 if(check==true) {
    		 System.out.println("-- Ghi du lieu vao file text thanh cong --");
    	 }
    	 else {
    		 System.out.println("-- Ghi du lieu vao file text that bai --");
    	 }
     }
 		//thoi gian tinh toan 
 	//ham lua chon du lieu dau vao
     public void quanLySanPham(Scanner sc) {
    	int luaChonDuLieu=10; 
	    	menuLayDuLieu();
	    	luaChonDuLieu=sc.nextInt();
	    	switch(luaChonDuLieu) {
	    	case 1:{
	    	    this.generateIP(sc);
	    		break; 
	    	}
	    	case 2:{
	    		this.docDuLieuTuDataBase();
	    		break;
	    	}
	    	case 3:{
	    		this.docDuLieuExcel();
	    		break; 
	    	}
	    	case 4:{
	    		this.docDuLieuFileText();
	    		break;
	    	}
	    	 default :{
	    		 System.out.println("-- Thoat chuong trinh --");
	    		break;
	    	}
	    }
	    	this.thaoTaoDuLieu(sc);
     }
     //
 	   public  void thaoTaoDuLieu(Scanner sc) {
 	   	int n=10; 
 	   	while(n!=13) {
 	   	QuanLyDienThoai.Menu();
     	System.out.println("Nhap lua chon cua ban: "); 
	       	n=sc.nextInt();
     		switch(n) {
 	        	case 1:{
 	        	QuanLyDienThoai.menuLocSanPham();
 	       		int n1=11;
 	       		while(n1!=10) {
 	       			System.out.println("Nhap lua chon cua ban: "); 
 	               	n1=sc.nextInt();
 	       			switch(n1) {
 	           		case 1:
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten man hinh can loc");
             			String manHinh=sc.nextLine();
	            			this.locTheoManHinh(manHinh); 	            			
	            		break; 
 	           		case 2: 
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten camera can loc ");
 	           			String camera=sc.nextLine();
 	           			this.locTheoCamera(camera);
 	           			break; 
             		case 3: 
            			sc.nextLine();
 	            		System.out.println("Nhap ten CPU can loc");
 	           			String cpu=sc.nextLine();
 	           			this.locTheoCPU(cpu);
 	           			break; 
 	           		case 4: 
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten bo nho can loc");
 	           			String bonho=sc.nextLine();
 	           			this.locTheoBoNho(bonho);
 	           		    break; 
             		case 5: 
	           			sc.nextLine();
 	           			System.out.println("Nhap ten PIN can loc");
 	           			String pin=sc.nextLine();
 	           			this.locTheoPin(pin);
 	           			break; 
             		case 6:
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten chat lieu can loc");
 	           			String chatlieu=sc.nextLine();
 	           			this.locTheoChatLieu(chatlieu);
 	           			break; 
 	           		case 7:
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten kich thuoc can loc");
 	           			String kichthuoc=sc.nextLine();
 	           			this.locTheoKichThuoc(kichthuoc);
 	           			break;
 	           		case 8:
 	           			sc.nextLine();
 	           			System.out.println("Nhap ten kich thuoc can loc");
 	           			String hang=sc.nextLine();
 	           			this.locTheoKichThuoc(hang);
 	           		case 9: 
 	           			sc.nextLine(); 
 	           			System.out.println("Nhap ten san pham can loc "); 
 	           			String tensp=sc.nextLine(); 
 	           			this.locTheoTen(tensp);
 	           			break; 
 	           		default:{
 	           			System.out.println("-- Thoai chuong trinh --"); 
 	           			break;
 	           		}
 	           		}
 	           		break;
 	       		}
 	       		
 	       		break; 
 	       	}
 	       	case 2:{
 	       		System.out.println("1.Sap xep tang dan"); 
 	       		System.out.println("2.Sap xep giam dan");
 	       		System.out.println("3.Thoat");
         	    int luachon=sc.nextInt();
                switch(luachon) {
                    case 1:{
                    	this.sapXepTheoGiaTangDan(); 
                     	break;
                     }
                    case 2:{
                    	this.sapXepTheoGiaGiamDan();
                    	break;
                    }
                    default:{
                    	break; 
                    }
                   }
 	          		break; 
 	        	}
 	        case 3:
 	       		this.sapXepTheoSoLuongMua();
 	       		break; 
 	       	case 4:
 	       		this.top5SanPhamBanChay();
 	       		break;
 	       	case 5:
 	       		this.top10SanPhamBanItNhat();
 	       		break;
 	       	case 6:
 	       		this.hangBanNhieuNhat();
 	       		break;
 	       	case 7:{
 	       		this.menuSanPham(); 
 	       		System.out.println("Nhap lua chon cua ban");
 	       		int luachon=sc.nextInt(); 
 	       		switch(luachon) {
 	       		case 1:{
 	       			sc.nextLine();
 	       			laySanPhamQuaId(sc); 
 	       			break;
 	       		}
 	       		case 2:{
 	       			sc.nextLine();
 	        		suaSanPHam(sc);
 	       			break;
 	       		}
 	       		case 3:{
 	       			sc.nextLine();
 	       			themMotSanPham(sc);
 	       			break;
 	       		}
 	        	case 4:{
 	       			sc.nextLine();
 	       			xoaSanPham(sc);
 	       			break; 
 	       		}
 	       		default:{
 	       			break; 
 	       			
 	        	}
 	     	}
 	     	break;
 	        		
 	       }
 	        case 8:{
 	       		this.layToanBoDanhSach();
 	       		break; 
 	       	}
 	       
 	       	case 9:{
         		this.ghiDuLieuDataBase();
	       		break; 
 	       	}
 	       	case 10:{
 	       		this.ghiDuLieuExcel();
 	       	
 	       		break;
 	       	}
 	       	case 11:{
 	       		this.ghiDuLieuFileText();;
 	       		break;
 	       	}
 	       	default:{
 	       		System.out.println("---Thoat khoi chuong trinh---");
 	       		return; 
 	       	} 
 	   	}
 	 }
 	   
}
 	    public static void Menu() {
 	    	System.out.println("1.Loc san pham theo truong tuy chon"); 
 	    	System.out.println("2.Sap xep theo gia");
 	    	System.out.println("3.Sap xep giam dan theo so san pham ban duoc");
 	    	System.out.println("4.Loc 5 san pham ban chay nhat, sap xep dua theo so luong ban duoc");
 	    	System.out.println("5.Loc 10 san pham ban duoc it nhat,sap xep dua theo so luong ban duoc"); 
 	    	System.out.println("6.Hang ban duoc nhieu nhat"); 
 	    	System.out.println("7.Lay/Them/Sua/Xoa san pham theo id");
 	    	System.out.println("8.Lay tat ca san pham");
 	    	System.out.println("9.Ghi du lieu vao Database "); 
 	    	System.out.println("10.Ghi du lieu vao file Excel");
 	    	System.out.println("11.Ghi du lieu vao file Text");
 	    	System.out.println("12. Thoat chuong trinh");
 	    }
 	    public static void menuLocSanPham() {
 	    	System.out.println("1.Loc theo loai man hinh");
 	    	System.out.println("2.Loc theo loai camera");
 	    	System.out.println("3.Loc theo loai CPU");
 	    	System.out.println("4.Loc theo loai bo nho");
 	    	System.out.println("5.Loc theo loai pin");
 	    	System.out.println("6.Loc theo loai chat lieu");
 	    	System.out.println("7.Loc theo loai kich thuoc");
 	    	System.out.println("8.Loc theo hang san xuat");
 	        System.out.println("9.Loc theo ten san pham");
 	    	System.out.println("10.Thoat chuong trinh");
 	    }
 	    public static void menuSanPham() {
 	    	System.out.println("1.Lay san pham qua id");
 	    	System.out.println("2.Sua san pham qua id");
 	    	System.out.println("3.Them 1 san phan moi");
 	    	System.out.println("4.Xoa san pham qua id");
 	    	System.out.println("5.Thoat");
 	    }
 	    public static void menuLayDuLieu() {
 	    	System.out.println("1.Sinh ngau nhien du lieu"); 
 	    	System.out.println("2.Lay du lieu tu database"); 
 	    	System.out.println("3.Lay du lieu tu file Excel"); 
 	    	System.out.println("4.Lay du lieu tu file ");
 	    	System.out.println("5.Thoat chuong trinh");
 	    }
 }
