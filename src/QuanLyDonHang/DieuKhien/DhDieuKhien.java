/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.DieuKhien;
import QuanLyDonHang.model.*;
import QuanLyDonHang.service.*;
import QuanLyDonHang.service.DonHangServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author hung
 */
public class DhDieuKhien {
    private JButton btnSubmit;
    private JTextField jtfMaDon;
    private JDateChooser jdcNgayLenDon;
    private JTextField jtfTinhTrang;
    private JTextField jtfNguoiMua;
    private JTextField jtfMatHang;
    private JSpinner jpnSoLuong;
    private JLabel jlbThanhTien;
    private JTextField jtfGia;
    private DonHang donHang = null;
    private DHService dHService = null;

    public DhDieuKhien(JButton btnSubmit, JTextField jtfMaDon, JDateChooser jdcNgayLenDon, JTextField jtfTinhTrang, JTextField jtfNguoiMua, JTextField jtfMatHang, JSpinner jpnSoLuong, JLabel jlbThanhTien,JTextField jtfGia) {
        this.btnSubmit = btnSubmit;
        this.jtfMaDon = jtfMaDon;
        this.jdcNgayLenDon = jdcNgayLenDon;
        this.jtfTinhTrang = jtfTinhTrang;
        this.jtfNguoiMua = jtfNguoiMua;
        this.jtfMatHang = jtfMatHang;
        this.jpnSoLuong = jpnSoLuong;
        this.jlbThanhTien = jlbThanhTien;
        this.jtfGia      = jtfGia;
        this.dHService = new DHServiceImpl();
    }
    public void setView(DonHang donHang){
        this.donHang = donHang;
        jtfMaDon.setText(donHang.GetMaDon());
        jdcNgayLenDon.setDate(donHang.GetNgayLenDon());
        jtfTinhTrang.setText(donHang.GetTinhTrangDon());
        jtfNguoiMua.setText(donHang.GetNguoiMua());
        jtfMatHang.setText(donHang.GetMatHang());
        jpnSoLuong.setValue(donHang.getSoLuong());
            String s = String.valueOf(donHang.getGia());
            jtfGia.setText(s);
        
        jlbThanhTien.setText(String.valueOf(donHang.getGia()*this.donHang.getSoLuong()));
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(jtfMaDon.getText().length()==0){
                }
                else{
                    donHang.SetMaDon(jtfMaDon.getText());
                    donHang.SetNgayLenDon(covertDateToDateSql(jdcNgayLenDon.getDate()));
                    donHang.SetTinhTrangDon(jtfTinhTrang.getText());
                    donHang.SetNguoiMua(jtfNguoiMua.getText());
                    donHang.SetMatHang(jtfMatHang.getText());
                    String s = String.valueOf(jpnSoLuong.getValue());
                    donHang.setSoLuong(Integer.parseInt(s));
                    String t = jtfGia.getText();
                    donHang.setGia(Integer.valueOf(t));
                    if (showDialog()) {
                            if (jtfMaDon.getText().length()!=0) {
                                dHService.createOrUpdate(donHang);
                            } 
                        }
                    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
});
    }
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

}
