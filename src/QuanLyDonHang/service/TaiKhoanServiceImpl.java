/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.Dao.TaiKhoanDao;
import QuanLyDonHang.Dao.TaiKhoanDaoImpl;
import QuanLyDonHang.model.TaiKhoan;

/**
 *
 * @author hung
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private TaiKhoanDao taiKhoanDao = null;
 
    public TaiKhoanServiceImpl() {
        taiKhoanDao = new TaiKhoanDaoImpl();
    }
    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDao.login(tenDangNhap, matKhau);
    }
    
}
