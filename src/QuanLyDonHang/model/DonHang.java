/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.model;
import java.sql.*;
import java.io.Serializable;
/**
 *
 * @author hung
 */
public class DonHang implements Serializable{
    private String MaDon;
    private String MatHang;
    private String NguoiMua;
    private Date NgayLenDon;  
    private String TinhTrangDon;
    private int Gia;
    private int SoLuong;
    private float ThanhTien;

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = this.Gia * this.SoLuong;
    }
    
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
 
    public void SetMaDon(String MaDon){
        this.MaDon = MaDon;
    }
    public String GetMaDon(){
        return this.MaDon;
    }
    public void SetMatHang(String MatHang){
        this.MatHang = MatHang;
    }
    public String GetMatHang(){
        return this.MatHang;
    }
    public void SetNguoiMua(String NguoiMua){
        this.NguoiMua = NguoiMua;
    }
    public String GetNguoiMua(){
        return this.NguoiMua;
    }
    public void SetNgayLenDon(Date NgayLenDon){
        this.NgayLenDon = NgayLenDon;
    }
    public Date GetNgayLenDon(){
        return this.NgayLenDon;
    }
    public void SetTinhTrangDon(String TinhTrangDon){
        this.TinhTrangDon = TinhTrangDon;
    }
    public String GetTinhTrangDon(){
        return this.TinhTrangDon;
    }
}
