/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.sinhvienService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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
    private DatePicker txtNgaySinh;
    @FXML
    private TextField txtQueQuan;
    @FXML
    private Button btnCapNhat;
    @FXML
    private Button btnThem;
    
    /**
     * Initializes the controller class.
     */
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
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
        this.txtMssv.setDisable(true);
        this.txtNgaySinh.setEditable(false);
        
        try {
            try {
                loadSinhVien();
            } catch (ParseException ex) {
                Logger.getLogger(QuanLySVController.class.getName()).log(Level.SEVERE, null, ex);
            }
            addButtonXoaToTable();
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
                try {
                    this.txtNgaySinh.setValue(Utils.todatetime(sv.getNgaysinh()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLySVController.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.txtQueQuan.setText(sv.getQuequan());
                this.btnCapNhat.setVisible(true);
                this.btnThem.setDisable(true);
            });
            return row;
        });
        
        if (this.tbSinhVien.isDisable()){
            this.btnCapNhat.setVisible(false);
        }
        
    }    
    
    public void timkiem() throws SQLException, ParseException{
        tbSinhVien.getItems().clear();
        loadSinhVien();
    }
    
    public void loadSinhVien() throws SQLException, ParseException{
        this.btnCapNhat.setVisible(false);
        this.txtMssv.clear();
        this.txtHo.clear();
        this.txtTen.clear();
        this.txtNgaySinh.setValue(Utils.todatetime("01/01/2000").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        this.txtQueQuan.clear();
        this.btnThem.setDisable(false);
        tbSinhVien.setItems(FXCollections.observableArrayList(sinhvienService.getSinhVien(tenSV.getText())));
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
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Are u sure ???");
                            alert.setContentText("Are u sure???");
                            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                            ButtonType cancelButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                            alert.getButtonTypes().setAll(okButton, cancelButton);
                            alert.showAndWait().ifPresent(type -> {
                                    if (type == okButton) {
                                        try {
                                            sinhvienService.delSinhVien(sv.getId(), sv.getId_acc());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuanLySVController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else if (type == ButtonType.NO) {
                                        
                                    }
                            });
                            
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
    public void  capnhat() throws SQLException, ParseException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Sinhvien sv = this.tbSinhVien.getSelectionModel().getSelectedItem();
        int check = LocalDateTime.now().getYear() - txtNgaySinh.getValue().getYear();
        if ( check >= 18 && check <60){
            String b = txtHo.getText();
            String c = txtTen.getText();
            if (c.contains(" ")){
                alert.setContentText("Tên chỉ gồm 1 từ!!!");
            }
            else{
                String d = txtNgaySinh.getValue().format(formatter);
                String e = txtQueQuan.getText();
                if (b =="" || c =="" || d =="" || e ==""){
                    alert.setContentText("Nhập thiếu thông tin!!!");
                }
                else{
                    sv.setMssv(txtMssv.getText());
                    sv.setHo(txtHo.getText());
                    sv.setTen(txtTen.getText());
                    sv.setNgaysinh(txtNgaySinh.getValue().format(formatter));
                    sv.setQuequan(txtQueQuan.getText());
                    sinhvienService.updateSV(sv);
                    this.tbSinhVien.getItems().clear();
                }
                alert.setContentText("Cap nhat thanh cong!!!");
                loadSinhVien();
            }
        }
        else{
            alert.setContentText("Năm sinh không hợp lệ!!!");
        }
        alert.show();
    }
    public void them() throws SQLException, ParseException{
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int check = LocalDateTime.now().getYear() - txtNgaySinh.getValue().getYear();
        if ( check >= 18 && check <60){
            String b = txtHo.getText();
            String c = txtTen.getText();
            if (c.contains(" ")){
                alert.setContentText("Tên chỉ gồm 1 từ!!!");
            }
            else{
                String d = txtNgaySinh.getValue().format(formatter);
                String e = txtQueQuan.getText();
                if (b =="" || c =="" || d =="" || e ==""){
                    alert.setContentText("Nhập thiếu thông tin!!!");
                }
                else{
                    sinhvienService.themSV(b,c,d,e);
                    alert.setContentText("Thêm thành công!!!");
                    loadSinhVien();
                }
                
            }
        }
        else{
            alert.setContentText("Năm sinh không hợp lệ!!!");
        }
        alert.show();
    }
    public void back(ActionEvent event) throws IOException{
        Node node = (Node)event.getSource();
        Stage stage = new Stage();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("MenuAdmin.FXML")));
        //dialogStage.setTitle(resultSet.getString("tai_khoan"));
        stage.setScene(scene);
        stage.show();
    }
}
