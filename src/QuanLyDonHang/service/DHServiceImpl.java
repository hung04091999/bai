/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;
import QuanLyDonHang.model.*;
import java.util.List;
import QuanLyDonHang.Dao.DonHangDAOSql;
import QuanLyDonHang.Dao.DonHangDAOSqlImpl;
/**
 *
 * @author hung
 */
public class DHServiceImpl implements DHService{

    private DonHangDAOSql donHangDaosql = null ;
    
    public DHServiceImpl(){
        donHangDaosql = new DonHangDAOSqlImpl();
    }
    @Override
    public List<DonHang> getList() {
        return donHangDaosql.getList();
    }

    @Override
    public int createOrUpdate(DonHang donHang) {
        return donHangDaosql.createOrUpdate(donHang);
    }
    
}
