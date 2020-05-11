/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDonHang.main;

import QuanLyDonHang.view.*;

/**
 *
 * @author hung
 */
public class Main {
    public static void main(String[] args) {
        NewJDialog dialog =  new NewJDialog(null, true);
        dialog.setTitle("Đăng nhập hệ thống .");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
    }
}
