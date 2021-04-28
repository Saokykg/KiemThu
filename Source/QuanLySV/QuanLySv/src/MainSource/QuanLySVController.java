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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import quanly.Class.Sinhvien;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class QuanLySVController implements Initializable {

    
    @FXML
    private TextField tenSV;
    @FXML
    private TableView<Sinhvien> tbSinhVien;
    @FXML
    private Button btnS;
    @FXML
    private TextField txtMssv;
    @FXML
    private TextField txtHo;
    @FXML
    private TextField txtTen;
    @FXML
    private TextField txtNgaySinh;
    @FXML
    private TextField txtQueQuan;
    @FXML
    private Button btnCapNhat;
    @FXML
    private Button btnThem;
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        TableColumn<Sinhvien, String> mssvCol = new TableColumn<>("MSSV");
        mssvCol.setCellValueFactory(new PropertyValueFactory<>("mssv"));
   
        TableColumn<Sinhvien, String> hoCol  = new TableColumn("Họ");
        hoCol.setCellValueFactory(new PropertyValueFactory<>("ho"));
        
        TableColumn<Sinhvien, String> tenCol  = new TableColumn("Tên");
        tenCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
        
        tbSinhVien.getColumns().addAll(mssvCol, hoCol, tenCol);
        
        this.btnCapNhat.setVisible(false);
        
        try {
            loadSinhVien();
            System.out.println("================= loadQuestion ================");
            addButtonXoaToTable();
            System.out.println("================= addButtonToTable ================");
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.tbSinhVien.setRowFactory(et ->{
            TableRow row = new TableRow();
            row.setOnMouseClicked(r ->{
                Sinhvien sv = this.tbSinhVien.getSelectionModel().getSelectedItem();
                this.txtMssv.setText(sv.getMssv());
                this.txtHo.setText(sv.getHo());
                this.txtTen.setText(sv.getTen());
                this.txtNgaySinh.setText(sv.getNgaysinh());
                this.txtQueQuan.setText(sv.getQuequan());
                this.btnCapNhat.setVisible(true);
            });
            return row;
        });
        
        if (this.tbSinhVien.isDisable()){
            this.btnCapNhat.setVisible(false);
        }
        
    }    
    
    public void timkiem() throws SQLException{
        System.out.println("================= timkiem ================");
        tbSinhVien.getItems().clear();
        loadSinhVien();
    }
    
    public void loadSinhVien() throws SQLException{
        this.btnCapNhat.setVisible(false);
        this.txtMssv.clear();
        this.txtHo.clear();
        this.txtTen.clear();
        this.txtNgaySinh.clear();
        this.txtQueQuan.clear();
        tbSinhVien.setItems(FXCollections.observableArrayList(Utils.getSinhVien(tenSV.getText())));
    }
    private void addButtonXoaToTable() {
        TableColumn<Sinhvien, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Sinhvien, Void>, TableCell<Sinhvien, Void>> cellFactory = new Callback<TableColumn<Sinhvien, Void>, TableCell<Sinhvien, Void>>() {
            @Override
            public TableCell<Sinhvien, Void> call(final TableColumn<Sinhvien, Void> param) {
                final TableCell<Sinhvien, Void> cell = new TableCell<Sinhvien, Void>() {

                    private final Button btn = new Button("Xóa");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Sinhvien sv = getTableView().getItems().get(getIndex());
                            try {
                                Utils.delSinhVien(sv);
                            } catch (SQLException ex) {
                                Logger.getLogger(QuanLySVController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tbSinhVien.getItems().remove(sv);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tbSinhVien.getColumns().add(colBtn);
    }
    public void  capnhat() throws SQLException{
        Sinhvien sv = this.tbSinhVien.getSelectionModel().getSelectedItem();
        
        sv.setMssv(txtMssv.getText());
        sv.setHo(txtHo.getText());
        sv.setTen(txtTen.getText());
        sv.setNgaysinh(txtNgaySinh.getText());
        sv.setQuequan(txtQueQuan.getText());
        
        System.out.println("================== capnhat ================");
        Utils.updateSV(sv);
        this.tbSinhVien.getItems().clear();
        loadSinhVien();
        loadSinhVien();
    }
    public void them() throws SQLException{
        String a = txtMssv.getText();
        String b = txtHo.getText();
        String c = txtTen.getText();
        String d = txtNgaySinh.getText();
        String e = txtQueQuan.getText();
        if (a == "" || b =="" || c =="" || d =="" || e ==""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Nhap thieu thong tin!!!");
            alert.show();
        }
        else{
            System.out.println("=============== them =================");
            Utils.themSV(a,b,c,d,e);
        }
        loadSinhVien();
    }
}
