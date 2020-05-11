/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.Dao.MatHangDao;
import QuanLyDonHang.Dao.MatHangDaoImpl;
import QuanLyDonHang.model.HangHoa;

import java.util.List;

/**
 *
 * @author hung
 */
public class MatHangServicImpl implements MatHangService{
    private MatHangDao matHangDao = null ;
    
    public MatHangServicImpl(){
        matHangDao = new MatHangDaoImpl();
    }
    @Override
    public List<HangHoa> getList() {
        return matHangDao.getList();
    }

    @Override
    public int createOrUpdate(HangHoa hangHoa) {
        return matHangDao.createOrUpdate(hangHoa);
    }
}
