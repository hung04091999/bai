/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.DieuKhien;
import QuanLyDonHang.model.KhachHang;
import QuanLyDonHang.service.DonHangSerive;
import QuanLyDonHang.service.DonHangServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author hung
 */
public class KhachHangController {
    private JButton btnSubmit;
    private JTextField jtfMaKhachHang;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfGioiTinh;
    private JTextField jtfSoDienThoai;
    private JTextArea  jtaDiaChi;
    private JLabel jlbMsg;
    
    private KhachHang khachHang = null;
    private DonHangSerive donHangSerive = null;

    public KhachHangController(JButton btnSubmit, JTextField jtfMaKhachHang, JTextField jtfHoTen, JDateChooser jdcNgaySinh, JTextField jtfGioiTinh, JTextField jtfSoDienThoai, JTextArea jtaDiaChi ,JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfGioiTinh = jtfGioiTinh;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jlbMsg = jlbMsg;
        this.donHangSerive = new DonHangServiceImpl();
    }



    public void setView(KhachHang khachHang){
        this.khachHang = khachHang;
        jtfMaKhachHang.setText(khachHang.GetMaKhachHang());
        jtfHoTen.setText(khachHang.GetTenKhachHang());
        jtaDiaChi.setText(khachHang.GetDiaChi());
        jdcNgaySinh.setDate(khachHang.GetNamSinh());
        jtfGioiTinh.setText(khachHang.GetGioiTinh());
        jtfSoDienThoai.setText(khachHang.GetSoDienThoai());
        jtaDiaChi.setText(khachHang.GetDiaChi());
        
        setEvent();
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(jtfMaKhachHang.getText().length()==0){
                    jlbMsg.setText("Vui Lòng Nhập lại !!!!!");
                }
                else{
                    khachHang.SetMaKhachHang(jtfMaKhachHang.getText());
                    khachHang.SetTenKhachHang(jtfHoTen.getText());
                    khachHang.SetDiaChi(jtaDiaChi.getText());
                    khachHang.SetNamSinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                    khachHang.SetGioiTinh(jtfGioiTinh.getText());
                    khachHang.SetSoDienThoai(jtfSoDienThoai.getText());
                    if (showDialog()) {
                            if (jtfMaKhachHang.getText().length()!=0) {
                                donHangSerive.createOrUpdate(khachHang);
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
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
