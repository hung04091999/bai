/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.model;
import java.io.Serializable;
import java.sql.*;
public class HangHoa {
    private String MaHang;
    private String TenHang;
    private String HangSx;
    private int GiaSanPham;
    private String TinhTrang;
    
    public void SetMaHang(String MaHang){
        this.MaHang = MaHang;
    }
    public String GetMaHang(){
        return this.MaHang;
    }
    public void SetTenHang(String TenHang){
        this.TenHang = TenHang;
    }
    public String GetTenHang(){
        return this.TenHang;
    }
    public void SetHangSx(String HangSx){
        this.HangSx = HangSx;
    }
    public String GetHangSx(){
        return this.HangSx;
    }
    public void SetGiaSanPham(int GiaSanPham){
        this.GiaSanPham = GiaSanPham;
    }
    public int GetGiaSanPham(){
        return this.GiaSanPham;
    }
    public void SetTinhTrang(String TinhTrang){
        this.TinhTrang = TinhTrang;
    }
    public String GetTinhTrang(){
        return this.TinhTrang;
    }
}
