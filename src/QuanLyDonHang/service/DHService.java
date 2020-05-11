/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.model.*;
import java.util.List;

/**
 *
 * @author hung
 */
public interface DHService {
    public List<DonHang> getList();
    public int createOrUpdate(DonHang donHang);
}
