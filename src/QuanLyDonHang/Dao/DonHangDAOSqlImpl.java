/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;

import QuanLyDonHang.model.DonHang;
import QuanLyDonHang.model.HangHoa;
import QuanLyDonHang.model.KhachHang;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hung
 */
public class DonHangDAOSqlImpl implements DonHangDAOSql{

    public List<QuanLyDonHang.model.DonHang> getList() {
        try {
            
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `DonHang`";
            List<QuanLyDonHang.model.DonHang> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyDonHang.model.DonHang donHang = new QuanLyDonHang.model.DonHang();
                donHang.SetMaDon(rs.getString("MaDon"));
                donHang.SetNgayLenDon(rs.getDate("NgayLenDon"));
                donHang.SetTinhTrangDon(rs.getString("TinhTrangDon"));
                donHang.SetNguoiMua(rs.getString("TenKhach"));
                donHang.SetMatHang(rs.getString("TenHang"));
                donHang.setGia(rs.getInt("GiaHang"));
                donHang.setSoLuong(rs.getInt("SoLuong"));
                list.add(donHang);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        
    }

    @Override
    public int createOrUpdate(DonHang donHang) {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO donhang(MaDon, NgayLenDon, TinhTrangDon , TenKhach , TenHang, GiaHang,SoLuong,ThanhTien) VALUES(?, ?, ?, ?, ?, ? ,? , ?) ON DUPLICATE KEY UPDATE MaDon = VALUES(MaDon), NgayLenDon = VALUES(NgayLenDon), TinhTrangDon = VALUES(TinhTrangDon), TenKhach = VALUES(TenKhach), TenHang = VALUES(TenHang), GiaHang = VALUES(GiaHang),SoLuong = VALUES(SoLuong),ThanhTien = VALUES(ThanhTien)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, donHang.GetMaDon());
            ps.setDate(2, new Date(donHang.GetNgayLenDon().getTime()));
            ps.setString(3, donHang.GetTinhTrangDon());
            ps.setString(4, donHang.GetNguoiMua());
            ps.setString(5, donHang.GetMatHang());
            ps.setInt(6, donHang.getGia());
            ps.setInt(7, donHang.getSoLuong());
            ps.setFloat(8, donHang.getThanhTien());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
}
