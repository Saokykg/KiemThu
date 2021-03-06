/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.diemService;
import static Service.diemService.checkSLdk;
import Service.hockiService;
import Service.lophocService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
            idhk = hockiService.getIdhkNow();
        } catch (SQLException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (idhk == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Không có lịch đăng ký học kỳ này!!!");
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
            this.tbLop.setItems(FXCollections.observableArrayList(lophocService.getLH(idhk)));
            if (this.tbLop.getItems().size() <= 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("HK nay ko co mon!!!");
                alert.show();
            }
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
                List<tbLopHoc> tatca = lophocService.getLH(this.txtkey.getText(),idhk);
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            if (tbDangKy.getItems().size() != 0) {
                boolean kt = true;
                List<tbLopHoc> lh = tbDangKy.getItems();
                boolean kt2= true;
                for (int i = 0; i < lh.size(); i++) {
                    if (checkSLdk(lh.get(i).getId())) {
                        alert.setContentText("Mon hoc " + lh.get(i).getMon() + " đã vượt quá số lương đăng ký!!!!");
                        kt2=false;
                    }
                }
                for (int i = 0; i < lh.size() - 1; i++) {
                    tbLopHoc lopi = lh.get(i);
                    for (int j = i + 1; j < lh.size(); j++) {
                        tbLopHoc lopj = lh.get(j);
                        if (Utils.todatetime(lopi.getBd()).before(Utils.todatetime(lopj.getKt())) && lopi.getThu().equals(lopj.getThu()) && lopi.getCa() == lopj.getCa()) {
                            alert.setContentText("Đăng ký bị trung thời khóa biểu!!!\n(" + lopi.getMon() + ", " + lopj.getMon() + ")");
                            kt = false;
                            break;
                        }
                    }
                    if (!kt) {
                        break;
                    }
                }
                if (kt && kt2) {
                    List<tbLopHoc> dk = this.tbDangKy.getItems();
                    diemService.dangky(dk, Login.loginid);
                    alert.setContentText("Đăng ký thanh công!!!");
                    reset();
                }
            } else {
                alert.setContentText("Đăng ký thất bại, vui lòng chọn môn cần đăng ký!!!");
            }
        } catch (Exception ex){
            alert.setContentText("Có môn học đã đăng ký !!!");
        } 
        alert.show();
    }
    public void reset() throws SQLException, ParseException{
        this.txtkey.clear();
        this.tbDangKy.getItems().clear();
        this.tbLop.getItems().clear();
        this.tbLop.setItems(FXCollections.observableArrayList(lophocService.getLH(idhk)));
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