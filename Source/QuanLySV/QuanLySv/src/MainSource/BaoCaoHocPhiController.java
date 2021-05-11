/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.hockiService;
import Service.lophocService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import quanly.Class.Hocki;
import quanly.Class.tbLopHoc;

/**
 * FXML Controller class
 *
 * @author Hoa
 */
public class BaoCaoHocPhiController implements Initializable {

    @FXML
    private ComboBox cbhk;
    @FXML
    private ComboBox cbnam;
    @FXML 
    private TableView<tbLopHoc> tbhocphi;
    @FXML
    private Text txtmon;
    @FXML
    private Text txttinchi;
    @FXML
    private Text txttongtien;
    @FXML
    private Button idback;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbhk.getItems().add(1);
        this.cbhk.getItems().add(2);
        this.cbhk.getItems().add(3);
        try {
            this.cbnam.getItems().addAll(hockiService.countNam());
        } catch (SQLException ex) {
            Logger.getLogger(BaoCaoHocPhiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableColumn<tbLopHoc, String> monCol = new TableColumn<>("tên môn");
        monCol.setCellValueFactory(new PropertyValueFactory<>("mon"));
        
        TableColumn<tbLopHoc, String> maCol = new TableColumn<>("Mã môn học");
        maCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<tbLopHoc, String> tcCol = new TableColumn<>("Tín chí");
        tcCol.setCellValueFactory(new PropertyValueFactory<>("tinchi"));
        
        TableColumn<tbLopHoc, String> hpCol = new TableColumn<>("Học phí");
        hpCol.setCellValueFactory(new PropertyValueFactory<>("hocphi"));
        
        this.tbhocphi.getColumns().addAll(monCol, maCol, tcCol, hpCol);
    }
    
    boolean hk = false;
    boolean nam = false;
    
    public void hkchose() throws SQLException, ParseException{
        hk=true;
        this.txtmon.setText("");
        this.txttinchi.setText("");
        this.txttongtien.setText("");
        if (nam){
            int hocki = hockiService.getIdhk((int)this.cbhk.getValue(), (int)this.cbnam.getValue());;
            if (hocki == -1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Học kỳ này không tồn tại!!!");
                alert.show();
            }
            else{
                this.tbhocphi.setItems(FXCollections.observableArrayList(lophocService.getLH(hocki, Login.loginid)));
                int tc = 0, mon =0;
                float hp = 0;
                for (tbLopHoc lh : this.tbhocphi.getItems()){
                    tc += lh.getTinchi();
                    mon += 1;
                    hp += lh.getHocphi();
                }
                this.txtmon.setText(String.format("%s", mon));
                this.txttinchi.setText(String.format("%s", tc));
                this.txttongtien.setText(String.format("%s", hp));
            }
        }
    }
    public void namchose() throws SQLException, ParseException{
        nam=true;
        this.txtmon.setText("");
        this.txttinchi.setText("");
        this.txttongtien.setText("");
        if (hk){
            int hocki = hockiService.getIdhk((int)this.cbhk.getValue(), (int)this.cbnam.getValue());
            if (hocki == -1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Học kỳ không tồn tại!!!");
                alert.show();
            }
            else{
                this.tbhocphi.setItems(FXCollections.observableArrayList(lophocService.getLH(hocki, Login.loginid)));
                int tc = 0, mon =0;
                float hp = 0;
                for (tbLopHoc lh : this.tbhocphi.getItems()){
                    tc += lh.getTinchi();
                    mon += 1;
                    hp += lh.getHocphi();
                }
                this.txtmon.setText(String.format("%s", mon));
                this.txttinchi.setText(String.format("%s", tc));
                this.txttongtien.setText(String.format("%s", hp));
            }
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
