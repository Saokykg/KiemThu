/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.hocbongService;
import Service.hockiService;
import Service.svhocbongService;
import Service.tableService;
import com.mysql.cj.xdevapi.Column;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import quanly.Class.Sinhvien;
import quanly.Class.tbHocBong;
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
    public TableView tbmain;
    @FXML
    private Button btnback;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reset();
        try {
            this.cbnam.getItems().addAll(hockiService.countNam());
        } catch (SQLException ex) {
            Logger.getLogger(BaoCaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void namchose() throws SQLException{
        if (!this.cbnam.getSelectionModel().isEmpty()){
            this.cbhk.setDisable(false);
            this.cbhk.getItems().clear();
            this.cbhk.getItems().addAll(hockiService.countHk((int)this.cbnam.getValue()));
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
    
    public void baocaohocbong() throws IOException, SQLException{
        
        resettable();
        
        TableColumn<tbHocBong, String> sttCol = new TableColumn<>("STT");
        sttCol.setCellValueFactory(new PropertyValueFactory<>("stt"));
        
        TableColumn<tbHocBong, String> tenCol = new TableColumn<>("Tên SV");
        tenCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
        
        TableColumn<tbHocBong, String> loaiCol = new TableColumn<>("Loại");
        loaiCol.setCellValueFactory(new PropertyValueFactory<>("mucdo"));
        
        TableColumn<tbHocBong, String> thuongCol = new TableColumn<>("Thưởng");
        thuongCol.setCellValueFactory(new PropertyValueFactory<>("tien"));
        
        this.tbmain.getColumns().addAll(sttCol, tenCol, loaiCol, thuongCol);
        
        
        int nam = (int)this.cbnam.getValue();
        int hk=0;
        if (!this.cbhk.getSelectionModel().isEmpty())
            hk = (int)this.cbhk.getValue();
        int hocki = hockiService.getHK(nam,hk);
        
        
        if (hocbongService.checkHk(hocki)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đã có học bổng trong học kỳ này!!!");
            alert.show();
            this.tbmain.setItems(FXCollections.observableArrayList(tableService.getDsHocBong(hocki)));
        }
        else{
        List<Integer> a = new ArrayList<>();
        for (int i=1;i<=50;i++)
            a.add(i);
        
        CheckBox check1 = new CheckBox("Xuất sắc");
        CheckBox check2 = new CheckBox("Giỏi");
        CheckBox check3 = new CheckBox("Khá");
        ComboBox cb1 = new ComboBox(FXCollections.observableArrayList(a));
        ComboBox cb2 = new ComboBox(FXCollections.observableArrayList(a)); 
        ComboBox cb3 = new ComboBox(FXCollections.observableArrayList(a));
        TextField t1 = new TextField("100000");
        TextField t2 = new TextField("200000");
        TextField t3 = new TextField("300000");
        
        check1.selectedProperty().set(true);
        check2.selectedProperty().set(true);
        check3.selectedProperty().set(true);
        
        cb1.getSelectionModel().select(3);
        cb2.getSelectionModel().select(3);
        cb3.getSelectionModel().select(3);
        
        GridPane gp = new GridPane();
        
        gp.add(new Text("Muc do HB"), 0, 0);
        gp.add(new Text("So luong"), 1, 0);
        gp.add(new Text("Tien thuong"), 2, 0);
        
        gp.add(check1, 0, 1);
        gp.add(check2, 0, 2);
        gp.add(check3, 0, 3);
        
        gp.add(cb1, 1, 1);
        gp.add(cb2, 1, 2);
        gp.add(cb3, 1, 3);
        
        gp.add(t1, 2, 1);
        gp.add(t2, 2, 2);
        gp.add(t3, 2, 3);
        
        Button btn1 = new Button("Xem trước");
        Button btn2 = new Button("Lưu");
        btn2.setDisable(true);
        
        gp.add(btn1, 1, 4);
        gp.add(btn2, 2, 4);
        
        VBox vbox = new VBox(gp);
        
        Stage stage = new Stage();
        Scene scene = new Scene(vbox,400,200);
        stage.setScene(scene);
        stage.show();
        EventHandler<ActionEvent> event1 =
                  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                btn2.setDisable(true);
            }
        };
        check1.setOnAction(event1);
        check2.setOnAction(event1);
        check3.setOnAction(event1);
        cb1.setOnAction(event1);
        cb2.setOnAction(event1);
        cb3.setOnAction(event1);
        
        t1.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    t1.setText(oldValue);
                }
            }
        });
        t2.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    t2.setText(oldValue);
                }
            }
        });
        t3.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    t3.setText(oldValue);
                }
            }
        });
        t1.textProperty().addListener(et ->{btn2.setDisable(true);});
        t2.textProperty().addListener(et ->{btn2.setDisable(true);});
        t3.textProperty().addListener(et ->{btn2.setDisable(true);});
        
        
        
        
        btn1.setOnAction((ActionEvent event) ->{
            boolean kt1,kt2,kt3;
            kt1=kt2=kt3=false;
            if (check1.isSelected()) kt1=true;
            if (check2.isSelected()) kt2=true;
            if (check3.isSelected()) kt3=true;
            try {
                List<tbHocBong> tb = hocbongService.createHocBongSvNhan(kt1, kt2, kt3, (int)cb1.getValue(), (int)cb2.getValue(), (int)cb3.getValue(),
                        Float.parseFloat(t1.getText()),Float.parseFloat(t2.getText()),Float.parseFloat(t3.getText()), hocki);
                this.tbmain.setItems(FXCollections.observableArrayList(tb));
            } catch (SQLException ex) {
                Logger.getLogger(BaoCaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            btn2.setDisable(false);
        });
        btn2.setOnAction((ActionEvent event) ->{
            try {
                hocbongService.insertHocBong(check1.isSelected(),check2.isSelected(),check3.isSelected(),
                        (int)cb1.getValue(), (int)cb2.getValue(), (int)cb3.getValue(),
                        Float.parseFloat(t1.getText()),Float.parseFloat(t2.getText()),Float.parseFloat(t3.getText()), hocki);
                svhocbongService.themSVnhanHB(this.tbmain.getItems());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Thanh cong!!!");
                alert.showAndWait();
                stage.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaoCaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
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
        this.tbmain.setItems(FXCollections.observableArrayList(tableService.getbaocaohocphi(nam, hk)));
        
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
        this.tbmain.setItems(FXCollections.observableArrayList(tableService.getbaocaoxeploai(nam, hk)));
        
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
