package com.btl.java1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class thaoTacFile {

    private  final String NameFile = "dienthoai.txt";

    public  void DocFile(ArrayList<DienThoai> result) {
        try {
            FileReader fr = new FileReader(NameFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                String[] SubResult = line.split("//");
                // for(String o: SubResult) System.out.println(o);
                result.add(new DienThoai(SubResult[0], SubResult[1], SubResult[2], SubResult[3], SubResult[4],
                        SubResult[5], SubResult[6],
                        SubResult[7], SubResult[8], SubResult[9],  Integer.parseInt(SubResult[10]), Integer.parseInt(SubResult[11]),
                        SubResult[12]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void GhiFile(ArrayList<DienThoai> result) throws Exception {
        if (result.isEmpty()) {
            System.out.println("-- Khong co du lieu trong file --");
            return;
        }
        try {
            FileWriter fw = new FileWriter(NameFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (DienThoai o : result) {
                // System.out.println(o.toString());
                bw.write(o.toStringFile());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void UpdateFile(ArrayList<DienThoai> result) {
        if (result.isEmpty()) {
            System.out.println("KHONG CO SIINH VIEN TRONG FILE");
            return;
        }
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (DienThoai o : result) {
                // System.out.println(o.toString());
                bw.write(o.toStringFile());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}