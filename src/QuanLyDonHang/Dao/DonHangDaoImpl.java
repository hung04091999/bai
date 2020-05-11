/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;
import QuanLyDonHang.model.KhachHang;

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
public class DonHangDaoImpl implements DonHangDao{

    @Override
    public List<QuanLyDonHang.model.KhachHang> getList() {
        try {
            
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `KhachHang`";
            List<QuanLyDonHang.model.KhachHang> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyDonHang.model.KhachHang khachhang = new QuanLyDonHang.model.KhachHang();
                khachhang.SetMaKhachHang(rs.getString("MaKhachHang"));
                khachhang.SetTenKhachHang(rs.getString("TenKhachHang"));
                khachhang.SetDiaChi(rs.getString("Diachi"));
                khachhang.SetNamSinh(rs.getDate("NamSinh"));
                khachhang.SetSoDienThoai(rs.getString("GioiTinh"));
                khachhang.SetGioiTinh(rs.getString("SoDienThoai"));
                list.add(khachhang);
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
        DonHangDao donHangDao = new DonHangDaoImpl();
        System.out.println(donHangDao.getList());
    }

    @Override
    public int createOrUpdate(KhachHang khachHang) {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "INSERT INTO khachhang(MaKhachHang, TenKhachHang, DiaChi, NamSinh , SoDienThoai , GioiTinh) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE MaKhachHang = VALUES(MaKhachHang), TenKhachHang = VALUES(TenKhachHang), DiaChi = VALUES(DiaChi), NamSinh = VALUES(NamSinh), GioiTinh = VALUES(GioiTinh), SoDienThoai = VALUES(SoDienThoai)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, khachHang.GetMaKhachHang());
            ps.setString(2, khachHang.GetTenKhachHang());
            ps.setString(3, khachHang.GetDiaChi());
            ps.setDate(4, new Date(khachHang.GetNamSinh().getTime()));
            ps.setString(5, khachHang.GetGioiTinh());
            ps.setString(6, khachHang.GetSoDienThoai());
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

