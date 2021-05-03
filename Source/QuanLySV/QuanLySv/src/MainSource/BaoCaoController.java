/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import quanly.Class.tbLopHoc;
import quanly.Class.tbbchocphi;
import quanly.Class.tbxeploai;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class BaoCaoController implements Initializable {

    @FXML
    private ComboBox cbhk;
    @FXML
    private ComboBox cbnam;
    @FXML
    private Button btnHocPhi;
    @FXML
    private Button btnXepLoai;
    @FXML
    private Button btnHocBong;
    @FXML
    private GridPane gpMain;
    @FXML
    private TableView tbmain;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reset();
        try {
            this.cbnam.getItems().addAll(Utils.countNam());
        } catch (SQLException ex) {
            Logger.getLogger(BaoCaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void namchose() throws SQLException{
        if (!this.cbnam.getSelectionModel().isEmpty()){
            this.cbhk.setDisable(false);
            this.cbhk.getItems().clear();
            this.cbhk.getItems().addAll(Utils.countHk((int)this.cbnam.getValue()));
        }
        this.btnHocBong.setDisable(false);
        this.btnHocPhi.setDisable(false);
        this.btnXepLoai.setDisable(false);
    }
    
    public void reset(){
        if (!this.cbhk.getSelectionModel().isEmpty())
            this.cbhk.getSelectionModel().clearSelection();
        if (!this.cbnam.getSelectionModel().isEmpty())
            this.cbnam.getSelectionModel().clearSelection();
        this.btnHocBong.setDisable(true);
        this.btnHocPhi.setDisable(true);
        this.btnXepLoai.setDisable(true);
        this.cbhk.setDisable(true);
        this.tbmain.getItems().clear();
        this.tbmain.getColumns().clear();
    }
    
    private void resettable(){
        this.tbmain.getColumns().clear();
        this.tbmain.getItems().clear();
    }
    
    public void baocaohocbong(){
        
    }
    public void baocaohocphi() throws SQLException{
        
        resettable();
        
        TableColumn<tbbchocphi, String> mlCol = new TableColumn<>("Mã lớp");
        mlCol.setCellValueFactory(new PropertyValueFactory<>("malop"));
        
        TableColumn<tbbchocphi, String> tmCol = new TableColumn<>("Tên môn");
        tmCol.setCellValueFactory(new PropertyValueFactory<>("tenmon"));
        
        TableColumn<tbbchocphi, String> slCol = new TableColumn<>("số lượng đk");
        slCol.setCellValueFactory(new PropertyValueFactory<>("soluongdk"));
        
        TableColumn<tbbchocphi, String> ttCol = new TableColumn<>("tong tien");
        ttCol.setCellValueFactory(new PropertyValueFactory<>("tongtien"));
        
        this.tbmain.getColumns().addAll(mlCol, tmCol, slCol, ttCol);
        
        int nam = (int)this.cbnam.getValue();
        int hk=0;
        if (!this.cbhk.getSelectionModel().isEmpty())
            hk = (int)this.cbhk.getValue();
        this.tbmain.setItems(FXCollections.observableArrayList(Utils.getbaocaohocphi(nam, hk)));
        
    }
    public void baocaoxeploai() throws SQLException{
        
        resettable();
        
        TableColumn<tbxeploai, String> mssvCol = new TableColumn<>("MSSV");
        mssvCol.setCellValueFactory(new PropertyValueFactory<>("mssv"));
        
        TableColumn<tbxeploai, String> tenSvCol = new TableColumn<>("Tên");
        tenSvCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
        
        TableColumn<tbxeploai, String> diemTBCol = new TableColumn<>("Điểm trung bình");
        diemTBCol.setCellValueFactory(new PropertyValueFactory<>("diem"));
        
        TableColumn<tbxeploai, String> xepLoaiCol = new TableColumn<>("Xếp loại");
        xepLoaiCol.setCellValueFactory(new PropertyValueFactory<>("xeploai"));
        
        this.tbmain.getColumns().addAll(mssvCol, tenSvCol, diemTBCol, xepLoaiCol);
        
        int nam = (int)this.cbnam.getValue();
        int hk=0;
        if (!this.cbhk.getSelectionModel().isEmpty())
            hk = (int)this.cbhk.getValue();
        this.tbmain.setItems(FXCollections.observableArrayList(Utils.getbaocaoxeploai(nam, hk)));
        
    }
}
