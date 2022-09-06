package com.btl.java1;


public class DienThoai {

	private String tendt; 
	private String manHinh; 
	private String camera; 
	private String cpu; 
	private String boNho;
	private String ketNoi; 
	private String pin; 
	private String chatLieu; 
	private String kichThuoc; 
	private String Hang; 
	private int soLuongMua; 
	private int gia; 
	private String id;
	public DienThoai(String tendt, String manHinh, String camera, String cpu, String boNho, String ketNoi, String pin,
			String chatLieu, String kichThuoc, String hang, int soLuongMua, int gia, String id) {
		super();
		this.tendt = tendt;
		this.manHinh = manHinh;
		this.camera = camera;
		this.cpu = cpu;
		this.boNho = boNho;
		this.ketNoi = ketNoi;
		this.pin = pin;
		this.chatLieu = chatLieu;
		this.kichThuoc = kichThuoc;
		Hang = hang;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.id = id;
	}
	public DienThoai() {
		super();
	}
	public String getTendt() {
		return tendt;
	}
	public void setTendt(String tendt) {
		this.tendt = tendt;
	}
	public String getManHinh() {
		return manHinh;
	}
	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getBoNho() {
		return boNho;
	}
	public void setBoNho(String boNho) {
		this.boNho = boNho;
	}
	public String getKetNoi() {
		return ketNoi;
	}
	public void setKetNoi(String ketNoi) {
		this.ketNoi = ketNoi;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public String getHang() {
		return Hang;
	}
	public void setHang(String hang) {
		Hang = hang;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "DienThoai [tendt=" + tendt + ", manHinh=" + manHinh + ", camera=" + camera + ", cpu=" + cpu + ", boNho="
				+ boNho + ", ketNoi=" + ketNoi + ", pin=" + pin + ", chatLieu=" + chatLieu + ", kichThuoc=" + kichThuoc
				+ ", Hang=" + Hang + ", soLuongMua=" + soLuongMua + ", gia=" + gia + ", id=" + id + "]";
	} 
	   public String toStringFile() {
	        return this.tendt + "//" + this.manHinh + "//" + this.camera + "//" + this.cpu+ "//" + this.boNho + "//" + this.ketNoi+ "//" +this.pin + "//" +this.chatLieu + "//" + this.kichThuoc+ "//" +  this.Hang+ "//" +
	                this.soLuongMua + "//" + this.gia + "//" + this.id ;
	    }
}