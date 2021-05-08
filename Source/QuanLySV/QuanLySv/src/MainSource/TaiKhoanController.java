/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.accountService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import quanly.Class.Account;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class TaiKhoanController implements Initializable {

    
    
    @FXML
    private Text txtUser;    
    @FXML
    private Text txtPermission;    
    @FXML
    private PasswordField txtOldPas;    
    @FXML
    private PasswordField txtNewPas;    
    @FXML
    private PasswordField txtConfirm;
    @FXML
    private Button btnConfirm;
    /**
     * Initializes the controller class.
     */
    Account acc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            acc = accountService.getAccount(Login.loginid);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtUser.setText(acc.getUsername());
        this.txtPermission.setText(acc.getLoaitk());
    }    
    
    protected void canhcao(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(txt);
        alert.show();
        this.txtOldPas.clear();
        this.txtNewPas.clear();
        this.txtConfirm.clear();    
    }
    
    public void btnClicked() throws SQLException{
        if (this.txtOldPas.getText().equals(acc.getPassword())){
            if (this.txtConfirm.getText().equals(this.txtNewPas.getText())){
                accountService.updateAccount(Login.loginid, this.txtNewPas.getText());
                canhcao("Doi password thanh cong!!!");
            }
            else{
                canhcao("Mat khau nhap lai khong chinh xac!!!");
            }
        }
        else{
            canhcao("Mat khau khong chinh xac!!!");
        }
    }
    public void back(ActionEvent event) throws IOException, SQLException{
        Node node = (Node)event.getSource();
        Stage stage = new Stage();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        Account ac = accountService.getAccount(Login.loginid);
        String tmp = ac.getLoaitk();
        System.out.println(tmp);
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Menu"+tmp+".FXML")));
        //dialogStage.setTitle(resultSet.getString("tai_khoan"));
        stage.setScene(scene);
        stage.show();
    }
}
