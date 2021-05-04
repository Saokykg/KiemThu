/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import quanly.Class.tbHocBong;

/**
 * FXML Controller class
 *
 * @author Hoa
 */
public class AddHBController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private ComboBox cb1;
    @FXML
    private ComboBox cb2;
    @FXML
    private ComboBox cb3;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 1;i<=50;i++){
            System.out.println("MainSource.AddHBController.initialize()");
            this.cb1.getItems().add(i);
            this.cb2.getItems().add(i);
            this.cb3.getItems().add(i);
        }
        this.cb1.getSelectionModel().select(3);
        this.cb2.getSelectionModel().select(3);
        this.cb3.getSelectionModel().select(3);
        this.check1.selectedProperty().set(true);
        this.check2.selectedProperty().set(true);
        this.check3.selectedProperty().set(true);
    }    
    
    public void settable(boolean c1, boolean c2, boolean c3,int cb1, int cb2, int cb3) throws SQLException{
        List<tbHocBong> tbhb = new ArrayList<>();
        tbhb = Utils.createHocBong(c1,c2,c3,cb1,cb2,cb3,
                Float.parseFloat(t1.getText()),Float.parseFloat(t2.getText()),Float.parseFloat(t3.getText()));
        //BaoCaoController.class
    }
    
}
