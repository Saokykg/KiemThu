/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jacky
 */
public class MenuUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void doiTrang(Node node, String s) throws IOException{
        Stage stage = new Stage();
        Scene scene;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource(s)));
        stage.setScene(scene);
        stage.show();
    }
    public void toInPhieu(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "BaoCaoHocPhi.fxml");
    }
    public void toThongTin(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "ThongtinSinhVien.fxml");
    }
    public void toTraCuu(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "TraCuuDiem.fxml");
    }
    public void toDangKy(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "DangKy.fxml");
    }
    public void toTaiKhoan(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "TaiKhoan.fxml");
    }
}
