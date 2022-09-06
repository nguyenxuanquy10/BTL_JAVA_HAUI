package com.btl.java1;

import java.sql.*;
import java.util.List;
import java.util.ArrayList ; 
public class  ThaoTacJDBC{
	
	
    public ThaoTacJDBC() {
		
	}

	// kết nối với JDBC
    Connection connection = getJDBC();
    public Connection getJDBC() {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaBtl;user=sa;password=11062002";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection demo = DriverManager.getConnection(url);
            return demo;
        } catch (Exception x) {
            x.printStackTrace();
        }
        return null;
    }

    // lấy dữ liệu từ sql
    public void LayDl(ArrayList <DienThoai> dienThoais) throws SQLException {
        Statement statement = connection.createStatement();
        String sql_LayDl = "select tendt, manhinh, camera,cpu,bonho,ketnoi,pin," +
                "                ,chatlieu,kichthuoc,hang,soluongmua,gia,id" +
                "                from dienthoai ";
        ResultSet dienThoaisSet = statement.executeQuery(sql_LayDl);
        boolean flat = true;

        while (dienThoaisSet.next()) {
            dienThoais.add(new DienThoai(
                    dienThoaisSet.getString(1),
                    dienThoaisSet.getString(2),
                    dienThoaisSet.getString(3),
                    dienThoaisSet.getString(4),
                    dienThoaisSet.getString(5),
                    dienThoaisSet.getString(6),
                    dienThoaisSet.getString(7),
                    dienThoaisSet.getString(8),
                    dienThoaisSet.getString(8),
                    dienThoaisSet.getString(10),
                    dienThoaisSet.getInt(11),
                    dienThoaisSet.getInt(12),
                    dienThoaisSet.getString(13)
                 ));
        }
    }

    //chèn dữ liệu vào sql
    public void ChenDl(ArrayList<DienThoai> dienThoais) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("insert into dienthoai values ( ?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        for (DienThoai dienthoai : dienThoais) {
            
            preparedStatement1.setString(1,dienthoai.getTendt());
            preparedStatement1.setString(2,dienthoai.getManHinh());
            preparedStatement1.setString(3, dienthoai.getCamera());
            preparedStatement1.setString(4, dienthoai.getCpu());
            preparedStatement1.setString(5, dienthoai.getBoNho());
            preparedStatement1.setString(6, dienthoai.getKetNoi());
            preparedStatement1.setString(7, dienthoai.getPin());
            preparedStatement1.setString(8, dienthoai.getChatLieu());
            preparedStatement1.setString(9, dienthoai.getKichThuoc());
            preparedStatement1.setString(10, dienthoai.getHang());
            preparedStatement1.setInt(11, dienthoai.getSoLuongMua());
            preparedStatement1.setInt(12, dienthoai.getGia()); 
            preparedStatement1.setString(13, dienthoai.getId());
            int k1 = preparedStatement1.executeUpdate();

        }
    }

    // xoá dữ liệu  trong sql
    public void XoaDl() throws SQLException {
        Statement statement = connection.createStatement();
        String delete_sql1 = "delete from dienthoai ";
       
        statement.executeUpdate(delete_sql1);
        
    }

    // update dư liệu vào sql
    public void UpdateDl(ArrayList<DienThoai> dienThoais) throws SQLException {
        XoaDl();
        ChenDl(dienThoais);
    }
}