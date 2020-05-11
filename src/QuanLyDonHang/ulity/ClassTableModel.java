/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.ulity;

import QuanLyDonHang.model.KhachHang;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hung
 */
public class ClassTableModel {
    
    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem , String[] collumn){
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
                KhachHang khachhang = listItem.get(i);
                obj = new Object[col];
                obj[0] = khachhang.GetMaKhachHang();
                obj[1] = khachhang.GetTenKhachHang();
                obj[2] = khachhang.GetDiaChi();
                obj[3] = khachhang.GetNamSinh();
                obj[4] = khachhang.GetSoDienThoai();
                obj[5] = khachhang.GetGioiTinh();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
