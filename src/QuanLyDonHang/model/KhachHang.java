/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.model;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author hung
 */
public class KhachHang implements Serializable{
    String MaKhachHang;
    String TenKhachHang;
    String DiaChi;
    Date NamSinh;
    String SoDienThoai;
    String GioiTinh;
    
   public void SetMaKhachHang(String MaKhachHang){
        this.MaKhachHang = MaKhachHang;
    }
    public String GetMaKhachHang(){
        return this.MaKhachHang;
    }
    public void SetTenKhachHang(String TenKhachHang){
        this.TenKhachHang = TenKhachHang;
    }
    public String GetTenKhachHang(){
        return this.TenKhachHang;
    }
    public void SetDiaChi(String DiaChi){
        this.DiaChi = DiaChi;
    }
    public String GetDiaChi(){
        return this.DiaChi;
    }
    public void SetNamSinh(Date NamSinh){
        this.NamSinh = NamSinh;
    }
    public Date GetNamSinh(){
        return this.NamSinh;
    }
    public void SetSoDienThoai(String SoDienThoai){
        this.SoDienThoai = SoDienThoai;
    }
    public String GetSoDienThoai(){
        return this.SoDienThoai;
    }
    public void SetGioiTinh(String GioiTinh){
        this.GioiTinh = GioiTinh;
    }
    public String GetGioiTinh(){
        return this.GioiTinh;
    }
    public String toString(){
        return MaKhachHang + " - " + TenKhachHang;
    }
}
