/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;

import QuanLyDonHang.model.HangHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hung
 */
public class MatHangDaoImpl implements MatHangDao{
    @Override
    public List<QuanLyDonHang.model.HangHoa> getList() {
        try {
            Connection cons = DbConnect.getConnection();
            String sql = "SELECT * FROM `hanghoa`";
            List<QuanLyDonHang.model.HangHoa> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyDonHang.model.HangHoa hangHoa = new QuanLyDonHang.model.HangHoa();
                hangHoa.SetMaHang(rs.getString("MaHang"));
                hangHoa.SetTenHang(rs.getString("TenHang"));
                hangHoa.SetHangSx(rs.getString("HangSx"));
                hangHoa.SetTinhTrang(rs.getString("TinhTrang"));
                hangHoa.SetGiaSanPham(rs.getInt("GiaSanPham"));
                list.add(hangHoa);
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
        MatHangDao matHangDao = new MatHangDaoImpl();
        System.out.println(matHangDao.getList());
    }
    @Override
    public int createOrUpdate(HangHoa hangHoa) {
        try {
            Connection cons;
            cons = DbConnect.getConnection();
            String sql = "INSERT INTO hanghoa(MaHang, TenHang, HangSx, GiaSanPham, TinhTrang) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE MaHang = VALUES(MaHang), TenHang = VALUES(TenHang), HangSx = VALUES(HangSx), GiaSanPham = VALUES(GiaSanPham), TinhTrang = VALUES(TinhTrang)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, hangHoa.GetMaHang());
            ps.setString(2, hangHoa.GetTenHang());
            ps.setString(3, hangHoa.GetHangSx());
            ps.setInt(4, hangHoa.GetGiaSanPham());
            ps.setString(5,hangHoa.GetTinhTrang());
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

