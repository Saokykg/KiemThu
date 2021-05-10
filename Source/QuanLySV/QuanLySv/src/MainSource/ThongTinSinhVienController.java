/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.hocbongService;
import Service.monhocService;
import Service.sinhvienService;
import Service.svhocbongService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import quanly.Class.Sinhvien;
import quanly.Class.tbHocBong;
import quanly.Class.twoInt;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class ThongTinSinhVienController implements Initializable {

    
    @FXML
    private Text txtTen;    
    @FXML
    private Text txtMSSV;    
    @FXML
    private Text txtQuequan;    
    @FXML
    private Text txtNgaysinh;    
    @FXML
    private Text txtTongtien;    
    @FXML
    private Text txtTongmon;    
    @FXML
    private Text txtSotinchi;    
    @FXML
    private Text txtDiem;    
    @FXML
    private TableView<tbHocBong> tbHocbong;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int idc = MainSource.Login.loginid;
        try {
            Sinhvien sv = sinhvienService.getSinhVien(idc);
            this.txtTen.setText(sv.toString());
            this.txtMSSV.setText(sv.getMssv());
            this.txtNgaysinh.setText(sv.getNgaysinh());
            this.txtQuequan.setText(sv.getQuequan());
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinSinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TableColumn<tbHocBong, String> hkCol = new TableColumn<>("Học kì");
        hkCol.setCellValueFactory(new PropertyValueFactory<>("hocki"));
        
        TableColumn<tbHocBong, String> tenCol = new TableColumn<>("Tên học bổng");
        tenCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
        
        TableColumn<tbHocBong, String> tienCol = new TableColumn<>("Giá trị");
        tienCol.setCellValueFactory(new PropertyValueFactory<>("tien"));
        
        this.tbHocbong.getColumns().addAll(hkCol, tenCol, tienCol);
        try {
            this.tbHocbong.setItems(FXCollections.observableArrayList(svhocbongService.getHocBong(idc)));
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinSinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        float tongtien=0;
        for (tbHocBong row : tbHocbong.getItems()){
            tongtien += row.getTien();
        } 
        this.txtTongtien.setText("Tổng tiền thưởng : " + tongtien);
        try {
            twoInt res = monhocService.testMonTinchiDiemTB(idc);
            this.txtTongmon.setText(txtTongmon.getText() + res.getA());
            this.txtSotinchi.setText(txtSotinchi.getText() + res.getB());
            this.txtDiem.setText(txtDiem.getText() + String.format("%.2f", res.getC()));
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinSinhVienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void back(ActionEvent event) throws IOException{
        Node node = (Node)event.getSource();
        Stage stage = new Stage();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("MenuUser.FXML")));
        //dialogStage.setTitle(resultSet.getString("tai_khoan"));
        stage.setScene(scene);
        stage.show();
    }
}
