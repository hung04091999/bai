/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;
import QuanLyDonHang.model.KhachHang;

import java.util.List;

/**
 *
 * @author hung
 */
public interface DonHangDao {
    
    public List<KhachHang> getList();
    public int createOrUpdate(KhachHang khachHang);
}
