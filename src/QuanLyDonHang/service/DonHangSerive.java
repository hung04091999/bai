/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.model.KhachHang;
import java.util.List;

/**
 *
 * @author hung
 */
public interface DonHangSerive {
    public List<KhachHang> getList();
    public int createOrUpdate(KhachHang khachHang);
}
