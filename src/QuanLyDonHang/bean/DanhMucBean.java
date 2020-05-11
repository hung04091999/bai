/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hung
 */
public class DanhMucBean {
    private String kind;
    private JPanel jpn;
    private JLabel jbl; 

    public DanhMucBean(String kind, JPanel jpn, JLabel jbl) {
        this.kind = kind;
        this.jpn = jpn;
        this.jbl = jbl;
    }

    public String getKind() {
        return kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public JLabel getJbl() {
        return jbl;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public void setJbl(JLabel jbl) {
        this.jbl = jbl;
    }
    
    
}
