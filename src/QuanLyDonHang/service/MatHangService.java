/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.service;

import QuanLyDonHang.model.HangHoa;
import java.util.List;

/**
 *
 * @author hung
 */
public interface MatHangService {
    public List<HangHoa> getList();
    public int createOrUpdate(HangHoa hangHoa);
}
