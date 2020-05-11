
package QuanLyDonHang.DieuKhien;
import QuanLyDonHang.model.HangHoa;
import QuanLyDonHang.service.MatHangService;
import QuanLyDonHang.service.MatHangServicImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author hung
 */
public class ManHinhController {
    private JButton btnSubmit;
    private JTextField jtfMaHang;
    private JTextField jtfTenHang;
    private JTextField jtfNhaSanXuat;
    private JTextField jtfGiaSanPham;
    private JTextField jtfTinhTrang;
    private JLabel jblMsg;
    
    private HangHoa hangHoa = null;
    private MatHangService matHangService = null;

    public ManHinhController(JButton btnSubmit, JTextField jtfMaHang, JTextField jtfTenHang, JTextField jtfNhaSanXuat, JTextField jtfGiaSanPham, JTextField jtfTinhTrang,JLabel jblMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHang = jtfMaHang;
        this.jtfTenHang = jtfTenHang;
        this.jtfNhaSanXuat = jtfNhaSanXuat;
        this.jtfGiaSanPham = jtfGiaSanPham;
        this.jtfTinhTrang = jtfTinhTrang;
        this.jblMsg = jblMsg;
        this.matHangService = new MatHangServicImpl();
    }
    public void setView(HangHoa hangHoa){
        this.hangHoa = hangHoa;
        jtfMaHang.setText(hangHoa.GetMaHang()); 
        jtfTenHang.setText(hangHoa.GetTenHang());
        jtfNhaSanXuat.setText(hangHoa.GetHangSx());
        String a = String.valueOf(hangHoa.GetGiaSanPham());
        jtfGiaSanPham.setText(a);
        jtfTinhTrang.setText(hangHoa.GetTinhTrang());
        
        setEvent();
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(jtfMaHang.getText().length()==0){
                    jblMsg.setText("Vui Lòng Nhập lại !!!!!");
                }
                else{
                    hangHoa.SetMaHang(jtfMaHang.getText());
                    hangHoa.SetTenHang(jtfTenHang.getText());
                    hangHoa.SetHangSx(jtfNhaSanXuat.getText());
                    hangHoa.SetGiaSanPham(Integer.parseInt(jtfGiaSanPham.getText()));
                    hangHoa.SetTinhTrang(jtfTinhTrang.getText());
                    if (showDialog()) {
                            if (jtfMaHang.getText().length()!=0) {
                                matHangService.createOrUpdate(hangHoa);
                                jblMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jblMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
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
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
}
