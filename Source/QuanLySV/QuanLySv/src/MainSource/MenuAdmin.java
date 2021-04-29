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
public class MenuAdmin implements Initializable {
    
    
    Stage stage = new Stage();
    Scene scene;
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
    public void toQuanLy(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "QuanLySV.fxml");
    }
    public void toTraCuu(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "TraCuuDiem.fxml");
    }
    public void toBaoCao(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "BaoCao.fxml");
    }
    public void toTaiKhoan(ActionEvent event) throws IOException{
        doiTrang((Node)event.getSource(), "TaiKhoan.fxml");
    }
}
