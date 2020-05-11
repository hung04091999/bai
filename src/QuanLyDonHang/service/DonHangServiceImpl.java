/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.Dao.DonHangDao;
import QuanLyDonHang.Dao.DonHangDaoImpl;
import QuanLyDonHang.model.KhachHang;
import java.util.List;

/**
 *
 * @author hung
 */
public class DonHangServiceImpl implements DonHangSerive{
    private DonHangDao donHangDao = null ;
    
    public DonHangServiceImpl(){
        donHangDao = new DonHangDaoImpl();
    }
    @Override
    public List<KhachHang> getList() {
        return donHangDao.getList();
    }

    @Override
    public int createOrUpdate(KhachHang khachHang) {
        return donHangDao.createOrUpdate(khachHang);
    }
    
}
