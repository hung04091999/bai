/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.ulity;

import QuanLyDonHang.model.DonHang;
import QuanLyDonHang.model.KhachHang;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hung
 */
public class ClassTableModel2 {
    
    public DefaultTableModel setTableDonHang(List<DonHang> listItem , String[] collumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(collumn);
        int col = collumn.length;
        
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i = 0 ; i < rows ; i++){
                DonHang donHang = listItem.get(i);
                obj = new Object[col];
                obj[0] = donHang.GetMaDon();
                obj[1] = donHang.GetNgayLenDon();
                obj[2] = donHang.GetTinhTrangDon();
                obj[3] = donHang.GetNguoiMua();
                obj[4] = donHang.GetMatHang();
                obj[5] = donHang.getGia();
                obj[6] = donHang.getSoLuong();
                obj[7] = donHang.getSoLuong()* donHang.getGia();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
