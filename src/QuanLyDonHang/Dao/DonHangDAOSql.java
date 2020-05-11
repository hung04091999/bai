/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.Dao;

import QuanLyDonHang.model.*;
import java.util.List;

/**
 *
 * @author hung
 */
public interface DonHangDAOSql {
    public List<DonHang> getList();
    public int createOrUpdate(DonHang donHang);
}
