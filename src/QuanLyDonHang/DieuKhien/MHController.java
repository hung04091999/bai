/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.DieuKhien;

import QuanLyDonHang.model.HangHoa;
import QuanLyDonHang.model.KhachHang;
import QuanLyDonHang.service.DonHangSerive;
import QuanLyDonHang.service.DonHangServiceImpl;
import QuanLyDonHang.service.MatHangServicImpl;
import QuanLyDonHang.service.MatHangService;
import QuanLyDonHang.ulity.ClassTableModel;
import QuanLyDonHang.ulity.ClassTableModel1;
import QuanLyDonHang.view.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
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
public class MHController {
    private String[] collumn = {"Mã Hàng " , "Tên Hàng" ,"Hãng Sản Xuất" ,"Giá Sản Phẩm" ,"Tình Trạng" };
    private MatHangService matHangSerive  = null;
    private JPanel jpnView;
    private JButton jbtAdd;
    private JTextField jtfSearch;
    private TableRowSorter<TableModel> rowSorter = null;
    public MHController(JPanel jpnView, JButton jbtAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jbtAdd = jbtAdd;
        this.jtfSearch = jtfSearch;
        
        this.matHangSerive = new MatHangServicImpl();
    }   
    
    public void setDateToTable(){
        List <HangHoa> listItem = matHangSerive.getList();
        
        DefaultTableModel model = new ClassTableModel1().setTableHangHoa(listItem, collumn);
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
                    
                    HangHoa hangHoa = new HangHoa();
                    hangHoa.SetMaHang((String) model.getValueAt(selectedRowIndex, 0));
                    hangHoa.SetTenHang(model.getValueAt(selectedRowIndex, 1).toString());
                    hangHoa.SetHangSx(model.getValueAt(selectedRowIndex, 2) != null ?
                                                   model.getValueAt(selectedRowIndex, 2).toString():"");
                    hangHoa.SetGiaSanPham((int) model.getValueAt(selectedRowIndex, 3));
                    hangHoa.SetTinhTrang((String) model.getValueAt(selectedRowIndex, 4));
                    MatHangJFrame frame = new MatHangJFrame (hangHoa);
                    frame.setTitle("Thông Tin Mat Hang.");
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
    public void setEvent1(){
        jbtAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                new MatHangJFrame(new HangHoa()).setVisible(true);
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
