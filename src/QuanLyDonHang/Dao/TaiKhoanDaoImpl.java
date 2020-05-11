/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;

/**
 *
 * @author hung
 */
import QuanLyDonHang.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class TaiKhoanDaoImpl implements TaiKhoanDao {
 
    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        Connection cons = null;
        try {
            cons = DbConnect.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM taikhoan WHERE TenTk LIKE ? AND MatKhau LIKE ?";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setMa_tai_khoan(rs.getInt("MaTk"));
                taiKhoan.setTen_dang_nhap(rs.getString("TenTk"));
                taiKhoan.setMat_khau(rs.getString("MatKhau"));
                taiKhoan.setTinh_trang(rs.getBoolean("TinhTrang"));
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }
}
