/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import quanly.Class.Diem;
import quanly.Class.Hocki;
import quanly.Class.Lophoc;
import quanly.Class.Monhoc;
import quanly.Class.Sinhvien;
import quanly.Class.SvHocbong;
import quanly.Class.tbDiem;
import quanly.Class.tbLopHoc;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class TraCuuDiemController implements Initializable {

    
    @FXML
    private ComboBox<Hocki> cbHocKi;
    @FXML
    private ComboBox<tbLopHoc> cbLopHoc;
    @FXML
    private TableView<tbLopHoc> tbLop;
    @FXML
    private TableView<tbDiem> tbDiem;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbLopHoc.setDisable(true);
        
        TableColumn<tbLopHoc, String> monCol = new TableColumn<>("tên môn");
        monCol.setCellValueFactory(new PropertyValueFactory<>("mon"));
        
        TableColumn<tbLopHoc, String> thuCol = new TableColumn<>("Thứ");
        thuCol.setCellValueFactory(new PropertyValueFactory<>("thu"));
        
        TableColumn<tbLopHoc, Integer> caCol = new TableColumn<>("ca");
        caCol.setCellValueFactory(new PropertyValueFactory<>("ca"));
        
        TableColumn<tbLopHoc, String> bdCol = new TableColumn<>("Ngày bắt đầu");
        bdCol.setCellValueFactory(new PropertyValueFactory<>("bd"));
        
        TableColumn<tbLopHoc, String> ktCol = new TableColumn<>("Ngày kết thúc");
        ktCol.setCellValueFactory(new PropertyValueFactory<>("kt"));
        
        this.tbLop.getColumns().addAll(monCol, thuCol, caCol, bdCol, ktCol);
        
        TableColumn<tbDiem, String> mssvCol = new TableColumn<>("MSSV");
        mssvCol.setCellValueFactory(new PropertyValueFactory<>("mssv"));
        
        TableColumn<tbDiem, String> tensvCol = new TableColumn<>("tên sinh viên");
        tensvCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
        
        TableColumn<tbDiem, String> monCol1 = new TableColumn<>("Môn học");
        monCol1.setCellValueFactory(new PropertyValueFactory<>("mon"));
        
        TableColumn<tbDiem, String> gkCol = new TableColumn<>("Điểm giữa kì");
        gkCol.setCellValueFactory(new PropertyValueFactory<>("diem_gk"));
        
        TableColumn<tbDiem, String> ckCol = new TableColumn<>("Điểm cuối kì");
        ckCol.setCellValueFactory(new PropertyValueFactory<>("diem_ck"));
        
        TableColumn<tbDiem, String> tileCol = new TableColumn<>("Tỉ lệ");
        tileCol.setCellValueFactory(new PropertyValueFactory<>("tile"));
        
        this.tbDiem.getColumns().addAll(mssvCol, tensvCol, monCol1, gkCol, ckCol, tileCol);
        
        try {
            this.cbHocKi.getItems().addAll(Utils.getHK());
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuDiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tbLop.setRowFactory(et ->{
            TableRow row = new TableRow();
            row.setOnMouseClicked(r ->{
                tbLopHoc lop = this.tbLop.getSelectionModel().getSelectedItem();
                try {
                    this.tbDiem.setItems(FXCollections.observableArrayList(Utils.getDiem(lop.getId())));
                    if (tbDiem.getItems().isEmpty()){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Khong co bang diem trong lop nay!!!");
                        alert.show();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TraCuuDiemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return row;
        });
    }    
    public void hkchose() throws SQLException, ParseException{
        this.cbLopHoc.getItems().clear();
        this.cbLopHoc.getItems().addAll(Utils.getLH(this.cbHocKi.getValue().getId()));
        if (this.cbLopHoc.getItems().isEmpty()){
            this.cbLopHoc.setDisable(true);
            tbLop.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Khong ton tai mon hoc tuong ung!!!");
            alert.show();
        }
        else{
            this.cbLopHoc.setDisable(false);
        }
    }
    
    public void lhchose(){
        tbLop.getItems().clear();
        List<tbLopHoc> lop = this.cbLopHoc.getItems();
        tbLop.setItems(FXCollections.observableArrayList(lop));
        List<tbLopHoc> kq = new ArrayList<>();
        for (tbLopHoc l : lop){
            if (l.getMon() == this.cbLopHoc.getValue().getMon())
                kq.add(l);
        }
        tbLop.setItems(FXCollections.observableArrayList(kq));
    }
    
}
