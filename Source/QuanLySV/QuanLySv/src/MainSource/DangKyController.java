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
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import quanly.Class.Hocki;
import quanly.Class.tbDiem;
import quanly.Class.tbLopHoc;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class DangKyController implements Initializable {

    @FXML
    private TextField txtkey;
    @FXML
    private TableView<tbLopHoc> tbLop;
    @FXML
    private TableView<tbLopHoc> tbDangKy;
    
    /**
     * Initializes the controller class.
     */
    int idhk;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            idhk = Utils.getIdhkNow();
        } catch (SQLException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (idhk == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Khong co lich dang ky hk nay!!!");
            alert.show();
        }
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
        
        this.tbDangKy.getColumns().addAll(monCol, thuCol, caCol, bdCol, ktCol);
        
        TableColumn<tbLopHoc, String> monCol2 = new TableColumn<>("tên môn");
        monCol2.setCellValueFactory(new PropertyValueFactory<>("mon"));
        
        TableColumn<tbLopHoc, String> thuCol2 = new TableColumn<>("Thứ");
        thuCol2.setCellValueFactory(new PropertyValueFactory<>("thu"));
        
        TableColumn<tbLopHoc, Integer> caCol2 = new TableColumn<>("ca");
        caCol2.setCellValueFactory(new PropertyValueFactory<>("ca"));
        
        TableColumn<tbLopHoc, String> bdCol2 = new TableColumn<>("Ngày bắt đầu");
        bdCol2.setCellValueFactory(new PropertyValueFactory<>("bd"));
        
        TableColumn<tbLopHoc, String> ktCol2 = new TableColumn<>("Ngày kết thúc");
        ktCol2.setCellValueFactory(new PropertyValueFactory<>("kt"));
        
        this.tbLop.getColumns().addAll(monCol2, thuCol2, caCol2, bdCol2, ktCol2);
        
        try {
            this.tbLop.setItems(FXCollections.observableArrayList(Utils.getLH(idhk)));
        } catch (SQLException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        }       
        this.tbLop.setRowFactory(et ->{
            TableRow row = new TableRow();
            row.setOnMouseClicked(r ->{
                tbLopHoc lop = this.tbLop.getSelectionModel().getSelectedItem();
                if (lop != null){
                    tbDangKy.getItems().add(lop);
                    tbLop.getItems().remove(lop);
                } 
            });
            return row;
        });
        
        this.tbDangKy.setRowFactory(et ->{
            TableRow row = new TableRow();
            row.setOnMouseClicked(r ->{
                tbLopHoc lop = this.tbDangKy.getSelectionModel().getSelectedItem();
                if (lop != null){
                    tbLop.getItems().add(lop);
                    tbDangKy.getItems().remove(lop);
                }
            });
            return row;
        });
        
        this.txtkey.textProperty().addListener(et ->{
            try {
                this.tbLop.getItems().clear();
                List<tbLopHoc> lh = this.tbDangKy.getItems().sorted();
                List<tbLopHoc> tatca = Utils.getLH(this.txtkey.getText(),idhk);
                for (tbLopHoc a : tatca){
                    boolean kt = true;
                    for (tbLopHoc l : lh){
                        if (l.getId() == a.getId()){
                            kt=false;
                            break;
                        }
                    }
                    if (kt)
                        this.tbLop.getItems().add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    public void dangky() throws SQLException, ParseException{
        List<tbLopHoc> dk = this.tbDangKy.getItems();
        Utils.dangky(dk, Login.loginid);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Dk thanh cong!!!");
        alert.show();
        reset();
    }
    public void reset() throws SQLException, ParseException{
        this.txtkey.clear();
        this.tbDangKy.getItems().clear();
        this.tbLop.getItems().clear();
        this.tbLop.setItems(FXCollections.observableArrayList(Utils.getLH(idhk)));
    }
}