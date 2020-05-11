/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.DieuKhien;

import QuanLyDonHang.model.KhachHang;
import QuanLyDonHang.service.DonHangSerive;
import QuanLyDonHang.service.DonHangServiceImpl;
import QuanLyDonHang.ulity.ClassTableModel;
import QuanLyDonHang.view.KhachHangJFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.TableRow;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hung
 */
public class DieuKhien {
    private String[] collumn = {"Mã Khách hàng " , "Tên Khách Hàng" ,"Địa Chỉ" ,"Năm Sinh" ,"Số Điên thoại" , "Giới Tính"};
    private DonHangSerive donHangSerive  = null;
    private JPanel jpnView;
    private JButton jbtAdd;
    private JTextField jtfSearch;
    private TableRowSorter<TableModel> rowSorter = null;
    public DieuKhien(JPanel jpnView, JButton jbtAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jbtAdd = jbtAdd;
        this.jtfSearch = jtfSearch;
        
        this.donHangSerive = new DonHangServiceImpl();
    }
    
    public void setDateToTable(){
        List <KhachHang> listItem = donHangSerive.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, collumn);
        JTable table = new JTable(model);
        
         rowSorter = new TableRowSorter<>(table.getModel());
         table.setRowSorter(rowSorter);
 
         jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
 
        // design
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.out.print(selectedRowIndex);
                    
                    KhachHang khachHang = new KhachHang();
                    khachHang.SetMaKhachHang((String) model.getValueAt(selectedRowIndex, 0));
                    khachHang.SetTenKhachHang(model.getValueAt(selectedRowIndex, 1).toString());
                    khachHang.SetDiaChi(model.getValueAt(selectedRowIndex, 2) != null ?
                                                   model.getValueAt(selectedRowIndex, 2).toString():"");
                    khachHang.SetNamSinh((Date) model.getValueAt(selectedRowIndex, 3));
                    khachHang.SetGioiTinh((String) model.getValueAt(selectedRowIndex, 5));
                    khachHang.SetSoDienThoai(model.getValueAt(selectedRowIndex, 4) != null ?
                                                   model.getValueAt(selectedRowIndex, 4).toString():"");
                    KhachHangJFrame frame = new KhachHangJFrame(khachHang);
                    frame.setTitle("Thông Tin Học Viên.");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
            });
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    public void setEvent(){
        jbtAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                new KhachHangJFrame(new KhachHang()).setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                jbtAdd.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                jbtAdd.setBackground(new Color(100, 221, 23));
            }
});
    }
}

