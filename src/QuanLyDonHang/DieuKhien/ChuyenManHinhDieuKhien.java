/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.DieuKhien;
import QuanLyDonHang.bean.DanhMucBean;
import QuanLyDonHang.view.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hung
 */
public class ChuyenManHinhDieuKhien{
    private JPanel Root;
    private String kindSelected = "";
    
    List<DanhMucBean> ListItem = null;
    
    public ChuyenManHinhDieuKhien(JPanel jpnRoot){
        this.Root = jpnRoot;
    }
    public void setView(JPanel jpnItem , JLabel jblItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96 , 100 ,191));
        jblItem.setBackground(new Color(96 , 100 ,191));
        
        Root.removeAll();
        Root.setLayout(new BorderLayout());
        Root.add(new TrangChu());
        Root.validate();
        Root.repaint();
    }

    /**
     *
     * @param ListItem
     */
    public void setEvent(List <DanhMucBean> ListItem) {
        this.ListItem = ListItem;
        for(DanhMucBean Item : ListItem){
            Item.getJbl().addMouseListener(new LabelEvent(Item.getKind(), Item.getJpn(), Item.getJbl()));
        }
    }
    class LabelEvent implements MouseListener{
        
        private JPanel note;
        private String kind;
        
        private JPanel  jpnItem;
        private JLabel  jblItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jblItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jblItem = jblItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent me) {
            switch(kind){
                case "TrangChu" : note = new TrangChu();
                                  break;
                case "KhachHang": note = new KhachHang();
                                  break;
                case "MatHang"  : note = new MatHang();
                                  break;
                case "DonHang"  : note = new DonHang();
                                  break;
                case "ThongKe"  : note = new PanelThongKe();break;
                default: note = new TrangChu();
                                    break;
            }
            Root.removeAll();
            Root.setLayout(new BorderLayout());
            Root.add(note);
            Root.validate();
            Root.repaint();
            setChangeBackGround(kind);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if(kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(96, 100, 191));
                jblItem.setBackground(new Color(96, 100, 191));
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
        
    }
    private void setChangeBackGround(String kind){
        for(DanhMucBean Item : ListItem){
            if(Item.getKind().equalsIgnoreCase(kind)){
                Item.getJpn().setBackground(new Color(96, 100, 191));
                Item.getJbl().setBackground(new Color(96, 100, 191));
            }else{
                Item.getJpn().setBackground(new Color(76, 175, 80));
                Item.getJbl().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
